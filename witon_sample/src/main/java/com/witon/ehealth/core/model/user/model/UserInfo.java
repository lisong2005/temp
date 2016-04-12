/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.model.user.model;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author Administrator
 * @version $Id: UserInfo.java, v 0.1 2016年4月12日 下午2:56:34 Administrator Exp $
 */
public class UserInfo extends BaseModel {

    /**  */
    private static final long serialVersionUID = 9021306906958334705L;

    private long              id;

    private String            uid;

    private String            name;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>uid</tt>.
     * 
     * @return property value of uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * Setter method for property <tt>uid</tt>.
     * 
     * @param uid value to be assigned to property uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

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
