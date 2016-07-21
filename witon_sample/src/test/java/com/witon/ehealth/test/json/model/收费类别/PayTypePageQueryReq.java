/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费类别;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.witon.ehealth.test.json.BasePageQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayTypeQueryReq.java, v 0.1 2016年7月19日 下午2:48:10 song.li@witontek.com Exp $
 */
@XmlRootElement
public class PayTypePageQueryReq extends BasePageQueryReq {

    /**  */
    private static final long serialVersionUID = -6705909817805047737L;

    @XmlElement(name = "type_code")
    private String            typeCode;

    @XmlElement(name = "type_name")
    private String            typeName;

    /**
     * Getter method for property <tt>typeCode</tt>.
     * 
     * @return property value of typeCode
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Setter method for property <tt>typeCode</tt>.
     * 
     * @param typeCode value to be assigned to property typeCode
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Getter method for property <tt>typeName</tt>.
     * 
     * @return property value of typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Setter method for property <tt>typeName</tt>.
     * 
     * @param typeName value to be assigned to property typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
