/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.artificer.ui.server.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.artificer.atom.err.ArtificerAtomException;
import org.artificer.common.ArtificerConstants;
import org.artificer.ui.server.i18n.Messages;
import org.artificer.ui.server.util.ExceptionUtils;
import org.artificer.ui.server.api.ArtificerApiClientAccessor;
import org.w3._1999._02._22_rdf_syntax_ns_.RDF;

/**
 * A standard servlet that ontology content is POSTed to in order to add new ontologies
 * to the s-ramp repository.
 *
 * @author eric.wittmann@redhat.com
 */
public class OntologyUploadServlet extends AbstractUploadServlet {

	private static final long serialVersionUID = OntologyUploadServlet.class.hashCode();

	/**
	 * Constructor.
	 */
	public OntologyUploadServlet() {
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// Extract the relevant content from the POST'd form
		if (ServletFileUpload.isMultipartContent(req)) {
			Map<String, String> responseMap;
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			String fileName = null;
			InputStream ontologyContent = null;
			try {
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem item : items) {
					if (item.isFormField()) {
					    // No form fields to process.
					} else {
						fileName = item.getName();
						if (fileName != null)
							fileName = FilenameUtils.getName(fileName);
						ontologyContent = item.getInputStream();
					}
				}

				// Now that the content has been extracted, process it (upload the ontology to the s-ramp repo).
				responseMap = uploadOntology(ontologyContent);
			} catch (ArtificerAtomException e) {
				responseMap = new HashMap<String, String>();
				responseMap.put("exception", "true");
				responseMap.put("exception-message", e.getMessage());
				responseMap.put("exception-stack", ExceptionUtils.getRootStackTrace(e));
			} catch (Throwable e) {
				responseMap = new HashMap<String, String>();
				responseMap.put("exception", "true");
				responseMap.put("exception-message", e.getMessage());
				responseMap.put("exception-stack", ExceptionUtils.getRootStackTrace(e));
			} finally {
				IOUtils.closeQuietly(ontologyContent);
			}
			writeToResponse(responseMap, response);
		} else {
			response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
			        Messages.i18n.format("UploadServlet.ContentTypeNotSupported"));
		}
	}

	/**
	 * Upload the ontology to the S-RAMP repository.
	 * @param ontologyContent the content of the ontology
	 * @throws Exception
	 */
    private Map<String, String> uploadOntology(InputStream ontologyContent) throws Exception {
		File tempFile = stashResourceContent(ontologyContent);
		Map<String, String> responseParams = new HashMap<String, String>();

		try {
		    uploadSingleOntology(tempFile, responseParams);
        } finally {
            FileUtils.deleteQuietly(tempFile);
        }

		return responseParams;
	}

    /**
     * Uploads a single ontology to the S-RAMP repository.
     * @param tempFile
     * @param responseParams
     * @throws Exception
     */
    private void uploadSingleOntology(File tempFile, Map<String, String> responseParams)
            throws Exception {
        InputStream contentStream = null;
		try {
			contentStream = FileUtils.openInputStream(tempFile);
			RDF ontology = ArtificerApiClientAccessor.getClient().uploadOntology(contentStream);

            if (ontology.getOtherAttributes() != null) {
                responseParams
                        .put("namespace", ontology.getOtherAttributes().get(new QName("http://www.w3.org/XML/1998/namespace", "base")));
                QName uuid = new QName(ArtificerConstants.SRAMP_NS, "uuid");
                if (ontology.getOtherAttributes().get(uuid) != null) {
                    responseParams.put("uuid", ontology.getOtherAttributes().get(uuid));
                }
            }

            responseParams.put("id", ontology.getOntology().getID());
            responseParams.put("label", ontology.getOntology().getLabel());
            responseParams.put("comment", ontology.getOntology().getComment());
		} finally {
			IOUtils.closeQuietly(contentStream);
		}
    }
}
