/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费类别;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayType.java, v 0.1 2016年7月19日 下午4:14:03 song.li@witontek.com Exp $
 */
public class PayType extends BaseModel {

    /**  */
    private static final long serialVersionUID = -2422459140009424867L;

    private String            id;

    private String            name;

    private String            code;

    private String            status;

    private String            schoolId;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     * 
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>schoolId</tt>.
     * 
     * @return property value of schoolId
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * Setter method for property <tt>schoolId</tt>.
     * 
     * @param schoolId value to be assigned to property schoolId
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

}
