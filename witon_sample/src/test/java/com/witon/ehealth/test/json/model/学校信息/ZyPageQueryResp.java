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
 * @version $Id: ZyPageQueryResp.java, v 0.1 2016年7月20日 下午1:41:54 song.li@witontek.com Exp $
 */
public class ZyPageQueryResp extends BasePageQueryResp {

    /**  */
    private static final long serialVersionUID = 4839262840646534746L;

    private List<ZyInfo>      list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<ZyInfo> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<ZyInfo> list) {
        this.list = list;
    }

}
