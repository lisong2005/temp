/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgType.java, v 0.1 2015年1月13日 上午11:21:01 song.li@witontek.com Exp $
 */
public enum WxMsgTypeEnum {

    TEXT("text", "文本消息"),

    IMAGE("image", "图片消息"),

    VOICE("voice", "语音消息"),

    VIDEO("video", "视频消息"),

    LOCATION("location", "地理位置消息"),

    LINK("link", "链接消息"),

    EVENT("event", "事件"),

    ;

    private WxMsgTypeEnum(String code, String desc) {
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

    public static WxMsgTypeEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (WxMsgTypeEnum item : values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }
}
