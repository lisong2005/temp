/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemNewDetail.java, v 0.1 2016年7月20日 上午8:58:50 song.li@witontek.com Exp $
 */
public class CibPayItemNewDetail extends BaseModel {

    /**  */
    private static final long serialVersionUID = 8064993901891007095L;

    private String            idNo;

    private String            amount;

    private String            memo;

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * Getter method for property <tt>idNo</tt>.
     * 
     * @return property value of idNo
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * Setter method for property <tt>idNo</tt>.
     * 
     * @param idNo value to be assigned to property idNo
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

}
