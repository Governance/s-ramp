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
package org.overlord.sramp.ui.client.views;

import org.overlord.sramp.ui.client.activities.IBrowseActivity;
import org.overlord.sramp.ui.client.places.ArtifactPlace;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Concrete implementation of the browse view.
 *
 * @author eric.wittmann@redhat.com
 */
public class BrowseView extends AbstractView<IBrowseActivity> implements IBrowseView {

	/**
	 * Constructor.
	 */
	public BrowseView() {
		VerticalPanel vpanel = new VerticalPanel();
		vpanel.add(new Label("-- Browse Artifacts --"));
		Anchor link = new Anchor("Go to 'Artifact Details'");
		link.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getActivity().goTo(new ArtifactPlace("aaa-bb-ccc-dddd"));
			}
		});
		vpanel.add(link);
		this.initWidget(vpanel);
	}

}