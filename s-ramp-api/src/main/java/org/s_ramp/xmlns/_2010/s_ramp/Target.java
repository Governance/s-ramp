/*
 * Copyright 2011 JBoss Inc
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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.05 at 05:25:27 PM EDT 
//


package org.s_ramp.xmlns._2010.s_ramp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;


/**
 * <p>Java class for target complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="target">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}href use="required""/>
 *       &lt;anyAttribute/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "target", propOrder = {
    "value"
})
@XmlSeeAlso({
    OrchestrationProcessTarget.class,
    ElementTarget.class,
    PolicySubjectTarget.class,
    ServiceOperationTarget.class,
    BindingOperationOutputTarget.class,
    BindingOperationInputTarget.class,
    OperationTarget.class,
    ActorTarget.class,
    InformationTypeTarget.class,
    ServiceContractTarget.class,
    DerivedArtifactTarget.class,
    PortTarget.class,
    EventTarget.class,
    PolicyTarget.class,
    OrchestrationTarget.class,
    ServiceImplementationModelTarget.class,
    XsdDocumentTarget.class,
    PartTarget.class,
    OperationOutputTarget.class,
    WsdlDocumentTarget.class,
    OperationInputTarget.class,
    BindingOperationTarget.class,
    BaseArtifactTarget.class,
    PolicyExpressionTarget.class,
    EffectTarget.class,
    XsdTypeTarget.class,
    DocumentArtifactTarget.class,
    ServiceInterfaceTarget.class,
    BindingTarget.class,
    WsdlExtensionTarget.class,
    ServiceInstanceTarget.class,
    ServiceTarget.class,
    MessageTarget.class,
    TaskTarget.class,
    FaultTarget.class,
    BindingOperationFaultTarget.class,
    PortTypeTarget.class
})
public class Target
    implements Serializable
{

    private static final long serialVersionUID = 6934150349682958700L;
    @XmlValue
    protected String value;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String href;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
