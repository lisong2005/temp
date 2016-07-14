/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.test;

import javax.xml.bind.annotation.XmlRootElement;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Person.java, v 0.1 2014年8月15日 上午9:46:55 song.li@witontek.com Exp $
 */
@XmlRootElement(name = "xml")
public class Customer extends BaseModel {

    /**  */
    private static final long serialVersionUID = -1938498743847393403L;

    private long              id;
    private String            name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
