/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.comm;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AbstractRestResult.java, v 0.1 2014年12月10日 下午2:38:14 song.li@witontek.com Exp $
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AbstractRestResponse implements Serializable {

    /**  */
    private static final long serialVersionUID = 4157893994450088026L;

    /**  */
    private String            resultCode;

    /**
     * Getter method for property <tt>resultCode</tt>.
     * 
     * @return property value of resultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Setter method for property <tt>resultCode</tt>.
     * 
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
