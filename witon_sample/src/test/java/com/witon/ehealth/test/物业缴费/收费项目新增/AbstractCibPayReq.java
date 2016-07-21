/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

import com.witon.ehealth.test.json.BaseReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AbstractCibPayReq.java, v 0.1 2016年7月21日 下午2:31:53 song.li@witontek.com Exp $
 */
public class AbstractCibPayReq extends BaseReq {

    /**  */
    private static final long serialVersionUID = 1719065733400112097L;

    private String            itemName;

    /** 支付方式：按月支付，一次性支付 */
    private String            payType;

    /** 项目类别 */
    private String            payTypeId;

    private String            startDate;

    private String            endDate;

    private String            merchAccId;

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
     * Getter method for property <tt>payType</tt>.
     * 
     * @return property value of payType
     */
    public String getPayType() {
        return payType;
    }

    /**
     * Setter method for property <tt>payType</tt>.
     * 
     * @param payType value to be assigned to property payType
     */
    public void setPayType(String payType) {
        this.payType = payType;
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

}
