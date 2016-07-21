/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校账号;

import com.witon.ehealth.test.json.BasePageQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SchoolAccPageQueryReq.java, v 0.1 2016年7月20日 上午9:34:40 song.li@witontek.com Exp $
 */
public class SchoolAccPageQueryReq extends BasePageQueryReq {

    /**  */
    private static final long serialVersionUID = -6149048668852601619L;

    private String            accName;

    private String            accId;

    /**
     * Getter method for property <tt>accName</tt>.
     * 
     * @return property value of accName
     */
    public String getAccName() {
        return accName;
    }

    /**
     * Setter method for property <tt>accName</tt>.
     * 
     * @param accName value to be assigned to property accName
     */
    public void setAccName(String accName) {
        this.accName = accName;
    }

    /**
     * Getter method for property <tt>accId</tt>.
     * 
     * @return property value of accId
     */
    public String getAccId() {
        return accId;
    }

    /**
     * Setter method for property <tt>accId</tt>.
     * 
     * @param accId value to be assigned to property accId
     */
    public void setAccId(String accId) {
        this.accId = accId;
    }

}
