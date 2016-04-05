/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxRetMsgTypeEnum.java, v 0.1 2015年1月13日 下午2:30:17 song.li@witontek.com Exp $
 */
public enum WxRetMsgTypeEnum {

    TEXT("text", "文本消息"),

    IMAGE("image", "图片消息"),

    VOICE("voice", "语音消息"),

    VIDEO("video", "视频消息"),

    MUSIC("music", "音乐消息"),

    NEWS("news", "图文消息"),

    TRANSFER_CUSTOMER_SERVICE("transfer_customer_service", "多客服"),

    TEMPLATE("template", "模板消息"),

    ;

    private WxRetMsgTypeEnum(String code, String desc) {
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

    public static WxRetMsgTypeEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (WxRetMsgTypeEnum item : values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }
}
