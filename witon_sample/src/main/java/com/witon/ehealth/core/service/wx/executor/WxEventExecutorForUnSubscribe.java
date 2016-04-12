/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import org.springframework.util.Assert;

import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxEventExecutorForUnSubscribe.java, v 0.1 2015年1月13日 下午1:53:34 song.li@witontek.com Exp $
 */
public class WxEventExecutorForUnSubscribe extends AbstractWxEventExecutor {

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxEventExecutor#getEventType()
     */
    @Override
    public EventTypeEnum getEventType() {
        return EventTypeEnum.unsubscribe;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.AbstractWxEventExecutor#process(WxMsgExeRequest, WeixinEvent)
     */
    @Override
    protected WxRetMsg process(WxMsgExeRequest req, WeixinEvent weixinEvent) {
        logger.info("【取消订阅事件】req={}, weixinEvent={}", req, weixinEvent);
        Assert.isTrue(weixinEvent.getEventType() == getEventType(), String.format(
            "类型不匹配 eventType={},executeType={}", weixinEvent.getWxEventType(), getEventType()));

        return null;
    }

}
