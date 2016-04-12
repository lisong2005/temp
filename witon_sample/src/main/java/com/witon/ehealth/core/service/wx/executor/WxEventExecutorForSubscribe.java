/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import java.util.Date;

import org.springframework.util.Assert;

import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;
import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxEventExecutorForSubscribe.java, v 0.1 2015年1月13日 下午1:52:49 song.li@witontek.com Exp $
 */
public class WxEventExecutorForSubscribe extends AbstractWxEventExecutor {

    public static final String QR_SCENE_PRE = "qrscene_";

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxEventExecutor#getEventType()
     */
    @Override
    public EventTypeEnum getEventType() {
        return EventTypeEnum.subscribe;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.AbstractWxEventExecutor#process(WxMsgExeRequest, WeixinEvent)
     */
    @Override
    protected WxRetMsg process(WxMsgExeRequest req, WeixinEvent weixinEvent) {
        logger.info("【订阅事件】req={}, weixinEvent={}", req, weixinEvent);
        Assert.isTrue(weixinEvent.getEventType() == getEventType(), String.format(
            "类型不匹配 eventType={},executeType={}", weixinEvent.getWxEventType(), getEventType()));

        WxRetMsg result = new WxRetMsg();

        result.setToUser(weixinEvent.getFromUser());
        result.setFromUser(weixinEvent.getToUser());
        result.setCreateTime(new Date());
        setResult(result, WxRetMsgTypeEnum.TEXT, "感谢您关注睿博健康吧", true, null);

        return result;
    }

    public void setResult(WxRetMsg result, WxRetMsgTypeEnum retType, Object content,
                          boolean success, String resultCode) {
        result.setRetType(retType);
        result.setContent(content);
        result.setSuccess(success);
        result.setResultCode(resultCode);
    }

}
