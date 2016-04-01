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
 * @version $Id: WexinEventDo.java, v 0.1 2015年1月8日 上午10:36:33 song.li@witontek.com Exp $
 */
public class WeixinEventDo extends BaseDo {

    /**  */
    private static final long serialVersionUID = -7363756914466421888L;

    private long              id;

    private String            toUser;

    private String            fromUser;

    private String            eventType;

    private String            eventKey;

    private String            eventProps;

    private Date              gmtUpload;

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
     * Getter method for property <tt>toUser</tt>.
     * 
     * @return property value of toUser
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * Setter method for property <tt>toUser</tt>.
     * 
     * @param toUser value to be assigned to property toUser
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * Getter method for property <tt>fromUser</tt>.
     * 
     * @return property value of fromUser
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * Setter method for property <tt>fromUser</tt>.
     * 
     * @param fromUser value to be assigned to property fromUser
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * Getter method for property <tt>eventType</tt>.
     * 
     * @return property value of eventType
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Setter method for property <tt>eventType</tt>.
     * 
     * @param eventType value to be assigned to property eventType
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Getter method for property <tt>eventKey</tt>.
     * 
     * @return property value of eventKey
     */
    public String getEventKey() {
        return eventKey;
    }

    /**
     * Setter method for property <tt>eventKey</tt>.
     * 
     * @param eventKey value to be assigned to property eventKey
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    /**
     * Getter method for property <tt>eventProps</tt>.
     * 
     * @return property value of eventProps
     */
    public String getEventProps() {
        return eventProps;
    }

    /**
     * Setter method for property <tt>eventProps</tt>.
     * 
     * @param eventProps value to be assigned to property eventProps
     */
    public void setEventProps(String eventProps) {
        this.eventProps = eventProps;
    }

    /**
     * Getter method for property <tt>gmtUpload</tt>.
     * 
     * @return property value of gmtUpload
     */
    public Date getGmtUpload() {
        return gmtUpload;
    }

    /**
     * Setter method for property <tt>gmtUpload</tt>.
     * 
     * @param gmtUpload value to be assigned to property gmtUpload
     */
    public void setGmtUpload(Date gmtUpload) {
        this.gmtUpload = gmtUpload;
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
