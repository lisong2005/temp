/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校账号;

import java.util.List;

import com.witon.ehealth.test.json.BasePageQueryResp;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SchoolAccPageQueryResp.java, v 0.1 2016年7月20日 上午9:58:31 song.li@witontek.com Exp $
 */
public class SchoolAccPageQueryResp extends BasePageQueryResp {

    /**  */
    private static final long   serialVersionUID = 4651446545311116506L;

    private List<SchoolAccount> list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public List<SchoolAccount> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<SchoolAccount> list) {
        this.list = list;
    }

}
