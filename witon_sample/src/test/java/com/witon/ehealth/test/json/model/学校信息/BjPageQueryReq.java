/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校信息;

import com.witon.ehealth.test.json.BasePageQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: BjPageQueryReq.java, v 0.1 2016年7月20日 下午1:46:19 song.li@witontek.com Exp $
 */
public class BjPageQueryReq extends BasePageQueryReq {
    /**  */
    private static final long serialVersionUID = -7870074850521458369L;

    private String            name;

    private String            instituteId;

    private String            majorId;

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

    /**
     * Getter method for property <tt>instituteId</tt>.
     * 
     * @return property value of instituteId
     */
    public String getInstituteId() {
        return instituteId;
    }

    /**
     * Setter method for property <tt>instituteId</tt>.
     * 
     * @param instituteId value to be assigned to property instituteId
     */
    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    /**
     * Getter method for property <tt>majorId</tt>.
     * 
     * @return property value of majorId
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * Setter method for property <tt>majorId</tt>.
     * 
     * @param majorId value to be assigned to property majorId
     */
    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

}
