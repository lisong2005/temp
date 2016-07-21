/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校信息;

import java.util.List;

import com.witon.ehealth.test.json.BasePageQueryResp;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: XyPageQueryResp.java, v 0.1 2016年7月20日 下午1:23:01 song.li@witontek.com Exp $
 */
public class XyPageQueryResp extends BasePageQueryResp {

    /**  */
    private static final long serialVersionUID = 601039547268367830L;

    private List<XyInfo>      list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<XyInfo> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<XyInfo> list) {
        this.list = list;
    }

}
