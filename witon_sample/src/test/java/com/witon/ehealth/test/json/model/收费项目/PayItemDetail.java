/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemDetail.java, v 0.1 2016年7月19日 下午5:15:13 song.li@witontek.com Exp $
 */
public class PayItemDetail extends BaseModel {

    /**  */
    private static final long serialVersionUID = -651560667263551481L;

    private String            idType;

    private String            idNo;

    private String            amount;

    /**
     * Getter method for property <tt>idType</tt>.
     * 
     * @return property value of idType
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Setter method for property <tt>idType</tt>.
     * 
     * @param idType value to be assigned to property idType
     */
    public void setIdType(String idType) {
        this.idType = idType;
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
