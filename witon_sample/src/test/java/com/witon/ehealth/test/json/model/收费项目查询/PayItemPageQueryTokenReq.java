/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目查询;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemPageQueryFrReq.java, v 0.1 2016年7月20日 上午11:13:47 song.li@witontek.com Exp $
 */
public class PayItemPageQueryTokenReq extends AbstractPayItemPageQueryReq {

    /**  */
    private static final long serialVersionUID = -3998873516078606991L;

    private String            token;

    /**
     * Getter method for property <tt>token</tt>.
     * 
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     * 
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

}
