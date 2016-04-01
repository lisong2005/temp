/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.model;

import java.util.Date;

import org.codehaus.jettison.json.JSONObject;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WexinUser.java, v 0.1 2015年1月8日 下午1:19:25 song.li@witontek.com Exp $
 */
public class WeixinUser extends BaseModel {

    /**  */
    private static final long serialVersionUID = 9096599561751320829L;

    private long              id               = -1;

    private String            appId;

    private String            openId;

    private String            unionId;

    private JSONObject        props;

    private Date              gmtCreate;

    private Date              gmtModify;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>appId</tt>.
     * 
     * @return property value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Setter method for property <tt>appId</tt>.
     * 
     * @param appId value to be assigned to property appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Getter method for property <tt>openId</tt>.
     * 
     * @return property value of openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * Setter method for property <tt>openId</tt>.
     * 
     * @param openId value to be assigned to property openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * Getter method for property <tt>unionId</tt>.
     * 
     * @return property value of unionId
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * Setter method for property <tt>unionId</tt>.
     * 
     * @param unionId value to be assigned to property unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * Getter method for property <tt>props</tt>.
     * 
     * @return property value of props
     */
    public JSONObject getProps() {
        return props;
    }

    /**
     * Setter method for property <tt>props</tt>.
     * 
     * @param props value to be assigned to property props
     */
    public void setProps(JSONObject props) {
        this.props = props;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModify</tt>.
     * 
     * @return property value of gmtModify
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * Setter method for property <tt>gmtModify</tt>.
     * 
     * @param gmtModify value to be assigned to property gmtModify
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

}
