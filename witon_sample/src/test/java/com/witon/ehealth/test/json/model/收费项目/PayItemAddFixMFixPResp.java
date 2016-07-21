/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目;

import com.witon.ehealth.test.json.BaseResp;

/**
 * 固定金额+自定义人群
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemAddFixMFixPResp.java, v 0.1 2016年7月19日 下午4:13:19 song.li@witontek.com Exp $
 */
public class PayItemAddFixMFixPResp extends BaseResp {

    /**  */
    private static final long serialVersionUID = -2192236090661780490L;

    private PayItem           payItem;

    /**
     * Getter method for property <tt>payItem</tt>.
     * 
     * @return property value of payItem
     */
    public PayItem getPayItem() {
        return payItem;
    }

    /**
     * Setter method for property <tt>payItem</tt>.
     * 
     * @param payItem value to be assigned to property payItem
     */
    public void setPayItem(PayItem payItem) {
        this.payItem = payItem;
    }

}
