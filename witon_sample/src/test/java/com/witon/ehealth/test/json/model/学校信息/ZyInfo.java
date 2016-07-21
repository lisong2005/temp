/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校信息;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ZyInfo.java, v 0.1 2016年7月20日 下午1:19:33 song.li@witontek.com Exp $
 */
public class ZyInfo extends BaseModel {

    /**  */
    private static final long serialVersionUID = -6876195685753658001L;

    private String            id;

    private String            name;

    private String            instituteId;

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
