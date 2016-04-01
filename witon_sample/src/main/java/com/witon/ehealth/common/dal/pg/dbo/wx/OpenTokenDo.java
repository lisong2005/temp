/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dbo.wx;

import java.util.Date;

import com.witon.ehealth.common.dal.pg.dbo.comm.BaseDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenDo.java, v 0.1 2015年1月8日 上午10:32:21 song.li@witontek.com Exp $
 */
public class OpenTokenDo extends BaseDo {

    /**  */
    private static final long serialVersionUID = 8629831509084377908L;

    private long              id;

    private String            appType;

    private String            appId;

    private String            accessToken;

    private String            refreshToken;

    private String            props;

    private String            memo;

    private Date              gmtCreate;

    private Date              gmtModify;

    private Date              gmtEffect;

    private Date              gmtExpire;

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
     * Getter method for property <tt>appType</tt>.
     * 
     * @return property value of appType
     */
    public String getAppType() {
        return appType;
    }

    /**
     * Setter method for property <tt>appType</tt>.
     * 
     * @param appType value to be assigned to property appType
     */
    public void setAppType(String appType) {
        this.appType = appType;
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
     * Getter method for property <tt>accessToken</tt>.
     * 
     * @return property value of accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Setter method for property <tt>accessToken</tt>.
     * 
     * @param accessToken value to be assigned to property accessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Getter method for property <tt>refreshToken</tt>.
     * 
     * @return property value of refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Setter method for property <tt>refreshToken</tt>.
     * 
     * @param refreshToken value to be assigned to property refreshToken
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Getter method for property <tt>props</tt>.
     * 
     * @return property value of props
     */
    public String getProps() {
        return props;
    }

    /**
     * Setter method for property <tt>props</tt>.
     * 
     * @param props value to be assigned to property props
     */
    public void setProps(String props) {
        this.props = props;
    }

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
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

    /**
     * Getter method for property <tt>gmtEffect</tt>.
     * 
     * @return property value of gmtEffect
     */
    public Date getGmtEffect() {
        return gmtEffect;
    }

    /**
     * Setter method for property <tt>gmtEffect</tt>.
     * 
     * @param gmtEffect value to be assigned to property gmtEffect
     */
    public void setGmtEffect(Date gmtEffect) {
        this.gmtEffect = gmtEffect;
    }

    /**
     * Getter method for property <tt>gmtExpire</tt>.
     * 
     * @return property value of gmtExpire
     */
    public Date getGmtExpire() {
        return gmtExpire;
    }

    /**
     * Setter method for property <tt>gmtExpire</tt>.
     * 
     * @param gmtExpire value to be assigned to property gmtExpire
     */
    public void setGmtExpire(Date gmtExpire) {
        this.gmtExpire = gmtExpire;
    }

}
