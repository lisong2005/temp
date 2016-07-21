/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.物业缴费.收费项目新增;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PayItemAddFMFPReq.java, v 0.1 2016年7月20日 上午8:38:13 song.li@witontek.com Exp $
 */
public class CibPayItemAddFreeMFreePReq extends AbstractCibPayReq {

    /**  */
    private static final long  serialVersionUID = 6038952953039250518L;

    private CibPayItemDetail[] list;

    /**
     * Getter method for property <tt>list</tt>.
     * 
     * @return property value of list
     */
    public CibPayItemDetail[] getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(CibPayItemDetail[] list) {
        this.list = list;
    }

}
