/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.json.model.学校账号;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SchoolAccount.java, v 0.1 2016年7月20日 上午9:59:08 song.li@witontek.com Exp $
 */
public class SchoolAccount extends BaseModel {

    /**  */
    private static final long serialVersionUID = 2067666768497766676L;

    private String            id;

    private String            accName;

    private String            accId;

    private String            accType;

    private String            wxAppId;

    private String            ztcAppId;

    private String            status;

    /**
     * Getter method for property <tt>accType</tt>.
     * 
     * @return property value of accType
     */
    public String getAccType() {
        return accType;
    }

    /**
     * Setter method for property <tt>accType</tt>.
     * 
     * @param accType value to be assigned to property accType
     */
    public void setAccType(String accType) {
        this.accType = accType;
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * Getter method for property <tt>wxAppId</tt>.
     * 
     * @return property value of wxAppId
     */
    public String getWxAppId() {
        return wxAppId;
    }

    /**
     * Setter method for property <tt>wxAppId</tt>.
     * 
     * @param wxAppId value to be assigned to property wxAppId
     */
    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    /**
     * Getter method for property <tt>ztcAppId</tt>.
     * 
     * @return property value of ztcAppId
     */
    public String getZtcAppId() {
        return ztcAppId;
    }

    /**
     * Setter method for property <tt>ztcAppId</tt>.
     * 
     * @param ztcAppId value to be assigned to property ztcAppId
     */
    public void setZtcAppId(String ztcAppId) {
        this.ztcAppId = ztcAppId;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
