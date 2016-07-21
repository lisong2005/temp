/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

/**
 * 固定金额+选择缴费人群
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemAddFixMFixPReq.java, v 0.1 2016年7月19日 下午3:51:25 song.li@witontek.com Exp $
 */
public class CibPayItemAddFixMFixPReq extends AbstractCibPayReq {

    /**  */
    private static final long serialVersionUID = 3583815742978289040L;

    private long              amount;

    /** 金额类型：总金额，单价金额 */
    private String            amountType;

    private String            merchOrgId;

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
     * Getter method for property <tt>merchOrgId</tt>.
     * 
     * @return property value of merchOrgId
     */
    public String getMerchOrgId() {
        return merchOrgId;
    }

    /**
     * Setter method for property <tt>merchOrgId</tt>.
     * 
     * @param merchOrgId value to be assigned to property merchOrgId
     */
    public void setMerchOrgId(String merchOrgId) {
        this.merchOrgId = merchOrgId;
    }

    /**
     * Getter method for property <tt>amountType</tt>.
     * 
     * @return property value of amountType
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * Setter method for property <tt>amountType</tt>.
     * 
     * @param amountType value to be assigned to property amountType
     */
    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

}
