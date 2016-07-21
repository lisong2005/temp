/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校信息;

import com.witon.ehealth.test.json.BasePageQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XyPageQueryReq.java, v 0.1 2016年7月20日 下午12:45:04 song.li@witontek.com Exp $
 */
public class XyPageQueryReq extends BasePageQueryReq {

    /**  */
    private static final long serialVersionUID = 8032366654741797496L;

    private String            name;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

}
