/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目查询;

import com.witon.ehealth.test.json.BasePageQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemPageQueryFixMFixPReq.java, v 0.1 2016年7月20日 上午10:20:42 song.li@witontek.com Exp $
 */
public class AbstractPayItemPageQueryReq extends BasePageQueryReq {

    /**  */
    private static final long serialVersionUID = 6516972529432434917L;

    private String            itemId;

    private String            itemName;

    private String            payTypeId;

    private String            startDate;

    private String            endDate;

    private String            merchAccId;

    private boolean           statistics;

    private String            status;

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
     * Getter method for property <tt>itemId</tt>.
     * 
     * @return property value of itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Setter method for property <tt>itemId</tt>.
     * 
     * @param itemId value to be assigned to property itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

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
     * Getter method for property <tt>merchAccId</tt>.
     * 
     * @return property value of merchAccId
     */
    public String getMerchAccId() {
        return merchAccId;
    }

    /**
     * Setter method for property <tt>merchAccId</tt>.
     * 
     * @param merchAccId value to be assigned to property merchAccId
     */
    public void setMerchAccId(String merchAccId) {
        this.merchAccId = merchAccId;
    }

    /**
     * Getter method for property <tt>statistics</tt>.
     * 
     * @return property value of statistics
     */
    public boolean isStatistics() {
        return statistics;
    }

    /**
     * Setter method for property <tt>statistics</tt>.
     * 
     * @param statistics value to be assigned to property statistics
     */
    public void setStatistics(boolean statistics) {
        this.statistics = statistics;
    }

}
