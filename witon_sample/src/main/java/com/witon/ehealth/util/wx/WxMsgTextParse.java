/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.wx;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;
import com.witon.ehealth.util.wx.model.WxNewsArticle;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgTextParse.java, v 0.1 2015年1月13日 下午2:54:47 song.li@witontek.com Exp $
 */
public class WxMsgTextParse {

    public static String TEMPALTE           = "<xml>"
                                              // =============================================
                                              + "<ToUserName><![CDATA[%s]]></ToUserName>"
                                              + "<FromUserName><![CDATA[%s]]></FromUserName>"
                                              + "<CreateTime>%s</CreateTime>"
                                              + "<MsgType><![CDATA[%s]]></MsgType>"
                                              // =============================================
                                              + "%s"
                                              // =============================================
                                              + "</xml>";

    public static String TEXT_TEMPLATE      = "<Content><![CDATA[%s]]></Content>";

    public static String IMAGE_TEMPLATE     = "<Image> <MediaId><![CDATA[%s]]></MediaId> </Image>";

    public static String VOICE_TEMPLATE     = "<Voice> <MediaId><![CDATA[%s]]></MediaId> </Voice>";

    public static String VIDEO_TEMPLATE     = "<Video>"
                                              // =============================================
                                              + "<MediaId><![CDATA[%s]]></MediaId>"
                                              + "<Title><![CDATA[%s]]></Title>"
                                              + "<Description><![CDATA[%s]]></Description>"
                                              // =============================================
                                              + "</Video> ";

    public static String NEWS_TEMPLATE      = "<ArticleCount>%s</ArticleCount> <Articles>%s</Articles>";

    public static String NEWS_ITEM_TEMPLATE = "<item>"
                                              // =============================================
                                              + "<Title><![CDATA[%s]]></Title>"
                                              + "<Description><![CDATA[%s]]></Description>"
                                              + "<PicUrl><![CDATA[%s]]></PicUrl>"
                                              + "<Url><![CDATA[%s]]></Url>"
                                              // =============================================
                                              + "</item>";

    /**
     * 
     * @param params
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String parse(WxRetMsg retMsg) {
        if (retMsg == null || !retMsg.isSuccess() || retMsg.getRetType() == null) {
            return StringUtils.EMPTY;
        }
        String toUser = retMsg.getToUser();
        String fromUser = retMsg.getFromUser();
        long createTime = retMsg.getCreateTime().getTime() / 1000L;

        WxRetMsgTypeEnum retTypeEnum = retMsg.getRetType();

        String body = null;
        switch (retTypeEnum) {
            case TEXT:
                body = String.format(TEXT_TEMPLATE, retMsg.getContent());
                break;
            case NEWS:
                Object c = retMsg.getContent();
                if (c instanceof List) {
                    List<WxNewsArticle> list = (List<WxNewsArticle>) retMsg.getContent();
                    int count = list.size();
                    StringBuilder sb = new StringBuilder();
                    for (WxNewsArticle item : list) {
                        sb.append(String.format(NEWS_ITEM_TEMPLATE, item.getTitle(),
                            item.getDescription(), item.getPicUrl(), item.getUrl()));
                    }
                    body = String.format(NEWS_TEMPLATE, count, sb.toString());
                }
                break;
            case TRANSFER_CUSTOMER_SERVICE:
                body = StringUtils.EMPTY;
                break;
            case IMAGE:
                break;
            case MUSIC:
                break;
            case VIDEO:
                break;
            case VOICE:
                break;
            default:
                break;
        }

        if (body != null) {
            return String.format(TEMPALTE, toUser, fromUser, createTime, retTypeEnum.getCode(),
                body);
        }
        return StringUtils.EMPTY;
    }
}
