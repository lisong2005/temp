/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinEvent.java, v 0.1 2015年1月9日 下午1:13:25 song.li@witontek.com Exp $
 */
public class WeixinEvent extends BaseModel {

    /**  */
    private static final long serialVersionUID = -831753644346928999L;

    private long              id;

    private String            toUser;

    private String            fromUser;

    private String            wxEventType;

    private EventTypeEnum     eventType;

    private String            eventKey;

    private JSONObject        eventProps;

    private Date              gmtUpload;

    private Date              gmtCreate;

    private Date              gmtModify;

    /**
     * Getter method for property <tt>wxEventType</tt>.
     * 
     * @return property value of wxEventType
     */
    public String getWxEventType() {
        return wxEventType;
    }

    /**
     * Setter method for property <tt>wxEventType</tt>.
     * 
     * @param wxEventType value to be assigned to property wxEventType
     */
    public void setWxEventType(String wxEventType) {
        this.wxEventType = wxEventType;
    }

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
    public EventTypeEnum getEventType() {
        return eventType;
    }

    /**
     * Setter method for property <tt>eventType</tt>.
     * 
     * @param eventType value to be assigned to property eventType
     */
    public void setEventType(EventTypeEnum eventType) {
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
    public JSONObject getEventProps() {
        return eventProps;
    }

    /**
     * Setter method for property <tt>eventProps</tt>.
     * 
     * @param eventProps value to be assigned to property eventProps
     */
    public void setEventProps(JSONObject eventProps) {
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

    // ------------------------------------------
    // ------------------------------------------
    // ------------------------------------------
    // ------------------------------------------

    /** EventTypeEnum */
    public static enum EventTypeEnum {

        /** 订阅 */
        subscribe("subscribe", "订阅"),

        /** 取消订阅 */
        unsubscribe("unsubscribe", "取消订阅"),

        /** 扫描带参数二维码事件 */
        SCAN("SCAN", "扫描带参数二维码事件"),

        /** 上报地理位置事件 */
        LOCATION("LOCATION", "上报地理位置事件"),

        /** 点击菜单拉取消息时的事件推送 */
        CLICK("CLICK", "点击菜单拉取消息时的事件推送"),

        /** 点击菜单跳转链接时的事件推送 */
        VIEW("VIEW", "点击菜单跳转链接时的事件推送"),

        /** 扫码推事件的事件推送 */
        scancode_push("scancode_push", "扫码推事件的事件推送"),

        /** 扫码推事件且弹出“消息接收中”提示框的事件推送 */
        scancode_waitmsg("scancode_waitmsg", "扫码推事件且弹出“消息接收中”提示框的事件推送"),

        /** 弹出系统拍照发图的事件推送 */
        pic_sysphoto("pic_sysphoto", "弹出系统拍照发图的事件推送"),

        /** 弹出拍照或者相册发图的事件推送 */
        pic_photo_or_album("pic_photo_or_album", "弹出拍照或者相册发图的事件推送"),

        /** 弹出微信相册发图器的事件推送 */
        pic_weixin("pic_weixin", "弹出微信相册发图器的事件推送"),

        /** 弹出地理位置选择器的事件推送 */
        location_select("location_select", "弹出地理位置选择器的事件推送"),

        // ... new 

        ;

        private EventTypeEnum(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /** code */
        private String code;

        /** desc */
        private String desc;

        /**
         * Getter method for property <tt>code</tt>.
         * 
         * @return property value of code
         */
        public String getCode() {
            return code;
        }

        /**
         * Getter method for property <tt>desc</tt>.
         * 
         * @return property value of desc
         */
        public String getDesc() {
            return desc;
        }

        public static EventTypeEnum getByCode(String code) {
            if (StringUtils.isBlank(code)) {
                return null;
            }
            for (EventTypeEnum item : values()) {
                if (StringUtils.equals(item.getCode(), code)) {
                    return item;
                }
            }
            return null;
        }
    }

}
