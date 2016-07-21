/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BaseReq.java, v 0.1 2016年7月19日 下午2:45:19 song.li@witontek.com Exp $
 */
public class BaseReq implements Serializable {

    /**  */
    private static final long serialVersionUID = -8275367708713105736L;

    // @=XmlElement(name = "access_token")
    private String            access_token;

    /**
     * Getter method for property <tt>access_token</tt>.
     * 
     * @return property value of access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * Setter method for property <tt>access_token</tt>.
     * 
     * @param access_token value to be assigned to property access_token
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
