/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目明细;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemDetailPageQueryTokenReq.java, v 0.1 2016年7月20日 下午2:51:33 song.li@witontek.com Exp $
 */
public class PayItemDetailPageQueryTokenReq extends AbstractPayItemDetailPageQueryReq {

    /**  */
    private static final long serialVersionUID = 6997248402831340427L;

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
