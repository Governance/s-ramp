/*
 * Copyright 2014 JBoss Inc
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
package org.artificer.ui.client.shared.beans;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Brett Meyer.
 */
@Portable
public class RelationshipTreeBean implements Serializable {

    private static final long serialVersionUID = RelationshipTreeBean.class.hashCode();

    private ArtifactSummaryBean artifact;

    private List<RelationshipTreeBean> children = new ArrayList<>();

    private String relationshipType;

    private boolean isRelationshipReverse;

    public ArtifactSummaryBean getArtifact() {
        return artifact;
    }

    public void setArtifact(ArtifactSummaryBean artifact) {
        this.artifact = artifact;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public boolean isRelationshipReverse() {
        return isRelationshipReverse;
    }

    public void setRelationshipReverse(boolean isRelationshipReverse) {
        this.isRelationshipReverse = isRelationshipReverse;
    }

    public List<RelationshipTreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<RelationshipTreeBean> children) {
        this.children = children;
    }
}
