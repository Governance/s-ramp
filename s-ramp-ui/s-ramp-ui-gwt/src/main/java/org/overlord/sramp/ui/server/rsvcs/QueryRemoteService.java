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
package org.overlord.sramp.ui.server.rsvcs;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.plugins.providers.atom.Entry;
import org.jboss.resteasy.plugins.providers.atom.Feed;
import org.overlord.sramp.ui.server.api.SrampAtomApiClient;
import org.overlord.sramp.ui.shared.beans.ArtifactSummary;
import org.overlord.sramp.ui.shared.beans.PageInfo;
import org.overlord.sramp.ui.shared.rsvcs.IQueryRemoteService;
import org.overlord.sramp.ui.shared.rsvcs.RemoteServiceException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Implementation of the query remote service.
 *
 * @author eric.wittmann@redhat.com
 */
public class QueryRemoteService extends RemoteServiceServlet implements IQueryRemoteService {

	private static final long serialVersionUID = QueryRemoteService.class.hashCode();

	/**
	 * Constructor.
	 */
	public QueryRemoteService() {
	}

	/**
	 * @see org.overlord.sramp.ui.shared.rsvcs.IQueryRemoteService#findArtifacts(org.overlord.sramp.ui.shared.beans.PageInfo)
	 */
	@Override
	public List<ArtifactSummary> findArtifacts(final PageInfo page) throws RemoteServiceException {
		try {
			Feed feed = SrampAtomApiClient.getInstance().query("/s-ramp/xsd/XsdDocument", page.getPage(), page.getPageSize(), page.getOrderBy(), page.isAscending());
			List<ArtifactSummary> rval = new ArrayList<ArtifactSummary>();
			for (Entry entry : feed.getEntries()) {
				String author = null;
				if (entry.getAuthors() != null && entry.getAuthors().size() > 0)
					author = entry.getAuthors().get(0).getName();
				ArtifactSummary arty = new ArtifactSummary();
				arty.setUuid(entry.getId().toString());
				arty.setName(entry.getTitle());
				arty.setDescription(entry.getSummary());
				arty.setCreatedBy(author);
				arty.setCreatedOn(entry.getPublished());
				arty.setUpdatedOn(entry.getUpdated());
				rval.add(arty);
			}
			return rval;
		} catch (Throwable t) {
			throw new RemoteServiceException(t);
		}
	}

}