/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目明细;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemDetailPageQueryFPReq.java, v 0.1 2016年7月20日 下午2:49:47 song.li@witontek.com Exp $
 */
public class PayItemDetailPageQueryFPReq extends AbstractPayItemDetailPageQueryReq {

    /**  */
    private static final long serialVersionUID = -841532510446147376L;

    private String            payerDesc;

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

}
