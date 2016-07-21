/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目;

import com.witon.ehealth.test.json.BaseReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemAddFreeMReq.java, v 0.1 2016年7月20日 上午8:47:41 song.li@witontek.com Exp $
 */
public class PayItemAddFreeMReq extends BaseReq {

    /**  */
    private static final long serialVersionUID = -3595633510710362820L;

    private String            itemName;

    private String            payTypeId;

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
