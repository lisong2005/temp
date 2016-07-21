/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.收费项目明细;

import java.util.List;

import com.witon.ehealth.test.json.BasePageQueryResp;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemDetailPageQueryResp.java, v 0.1 2016年7月20日 下午3:37:44 song.li@witontek.com Exp $
 */
public class PayItemDetailPageQueryResp extends BasePageQueryResp {

    /**  */
    private static final long serialVersionUID = 7073205989399406534L;

    private List<ItemDetail>  list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<ItemDetail> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<ItemDetail> list) {
        this.list = list;
    }

}
