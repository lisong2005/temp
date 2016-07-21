/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

import com.witon.ehealth.test.json.BaseResp;
import com.witon.ehealth.test.物业缴费.收费项目查询.CibPayItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CibResp.java, v 0.1 2016年7月21日 下午2:48:25 song.li@witontek.com Exp $
 */
public class CibResp extends BaseResp {

    /**  */
    private static final long serialVersionUID = 570264221435883684L;

    private CibPayItem        payItem;

    /**
     * Getter method for property <tt>payItem</tt>.
     * 
     * @return property value of payItem
     */
    public CibPayItem getPayItem() {
        return payItem;
    }

    /**
     * Setter method for property <tt>payItem</tt>.
     * 
     * @param payItem value to be assigned to property payItem
     */
    public void setPayItem(CibPayItem payItem) {
        this.payItem = payItem;
    }

}
