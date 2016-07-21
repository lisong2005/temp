/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目查询;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemPageQueryFPReq.java, v 0.1 2016年7月20日 上午10:59:55 song.li@witontek.com Exp $
 */
public class PayItemPageQueryFPReq extends AbstractPayItemPageQueryReq {

    /**  */
    private static final long serialVersionUID = 4051491583626750904L;

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
