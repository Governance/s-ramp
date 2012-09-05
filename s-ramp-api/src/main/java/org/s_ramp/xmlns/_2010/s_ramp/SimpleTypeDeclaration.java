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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for SimpleTypeDeclaration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleTypeDeclaration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://s-ramp.org/xmlns/2010/s-ramp}XsdType">
 *       &lt;attribute name="NCName" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="namespace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleTypeDeclaration")
public class SimpleTypeDeclaration
    extends XsdType
    implements Serializable
{

    private static final long serialVersionUID = 7136779794925530209L;
    @XmlAttribute(name = "NCName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String ncName;
    @XmlAttribute
    @XmlSchemaType(name = "anyURI")
    protected String namespace;

    /**
     * Gets the value of the ncName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNCName() {
        return ncName;
    }

    /**
     * Sets the value of the ncName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNCName(String value) {
        this.ncName = value;
    }

    /**
     * Gets the value of the namespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

}
