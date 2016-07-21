/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目查询;

import java.util.List;

import com.witon.ehealth.test.json.BasePageQueryResp;
import com.witon.ehealth.test.json.model.收费项目.PayItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemPageQueryResp.java, v 0.1 2016年7月20日 上午10:44:16 song.li@witontek.com Exp $
 */
public class PayItemPageQueryResp extends BasePageQueryResp {

    /**  */
    private static final long serialVersionUID = 3170637305859252579L;

    private List<PayItem>     list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<PayItem> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<PayItem> list) {
        this.list = list;
    }

}
