/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目查询;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemPageQueryFixMFixPReq.java, v 0.1 2016年7月20日 上午10:39:41 song.li@witontek.com Exp $
 */
public class PayItemPageQueryFixMFixPReq extends AbstractPayItemPageQueryReq {

    /**  */
    private static final long serialVersionUID = 2467331360303681862L;

    private String            instituteId;

    private String            majorId;

    private String            classId;

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

    /**
     * Getter method for property <tt>classId</tt>.
     * 
     * @return property value of classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * Setter method for property <tt>classId</tt>.
     * 
     * @param classId value to be assigned to property classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

}
