/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemAddFixMFreePReq.java, v 0.1 2016年7月19日 下午5:10:54 song.li@witontek.com Exp $
 */
public class CibPayItemAddFixMFreePReq extends AbstractCibPayReq {

    /**  */
    private static final long  serialVersionUID = -156640359781473460L;

    private long               amount;

    /** 金额类型：总金额，单价金额 */
    private String             amountType;

    private String             payerDesc;

    private CibPayItemDetail[] list;

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

    /**
     * Getter method for property <tt>payerDesc</tt>.
     * 
     * @return property value of payerDesc
     */
    public String getPayerDesc() {
        return payerDesc;
    }

    /**
     * Setter method for property <tt>payerDesc</tt>.
     * 
     * @param payerDesc value to be assigned to property payerDesc
     */
    public void setPayerDesc(String payerDesc) {
        this.payerDesc = payerDesc;
    }

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public CibPayItemDetail[] getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(CibPayItemDetail[] list) {
        this.list = list;
    }

    /**
     * Getter method for property <tt>serialversionuid</tt>.
     * 
     * @return property value of serialVersionUID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
