/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目;

import com.witon.ehealth.test.json.BaseReq;

/**
 * 固定金额+选择缴费人群
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemAddFixMFixPReq.java, v 0.1 2016年7月19日 下午3:51:25 song.li@witontek.com Exp $
 */
public class PayItemAddFixMFixPReq extends BaseReq {

    /**  */
    private static final long serialVersionUID = 3583815742978289040L;

    private String            itemName;

    private String            payTypeId;

    private long              amount;

    private String            instituteId;

    private String            majorId;

    private String            classId;

    private String            startDate;

    private String            endDate;

    private String            schoolAccId;

    /**
     * Getter method for property <tt>itemName</tt>.
     * 
     * @return property value of itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setter method for property <tt>itemName</tt>.
     * 
     * @param itemName value to be assigned to property itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Getter method for property <tt>payTypeId</tt>.
     * 
     * @return property value of payTypeId
     */
    public String getPayTypeId() {
        return payTypeId;
    }

    /**
     * Setter method for property <tt>payTypeId</tt>.
     * 
     * @param payTypeId value to be assigned to property payTypeId
     */
    public void setPayTypeId(String payTypeId) {
        this.payTypeId = payTypeId;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
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

    /**
     * Getter method for property <tt>startDate</tt>.
     * 
     * @return property value of startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Setter method for property <tt>startDate</tt>.
     * 
     * @param startDate value to be assigned to property startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter method for property <tt>endDate</tt>.
     * 
     * @return property value of endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Setter method for property <tt>endDate</tt>.
     * 
     * @param endDate value to be assigned to property endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Getter method for property <tt>schoolAccId</tt>.
     * 
     * @return property value of schoolAccId
     */
    public String getSchoolAccId() {
        return schoolAccId;
    }

    /**
     * Setter method for property <tt>schoolAccId</tt>.
     * 
     * @param schoolAccId value to be assigned to property schoolAccId
     */
    public void setSchoolAccId(String schoolAccId) {
        this.schoolAccId = schoolAccId;
    }

}
