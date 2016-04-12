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
 * @version $Id: WxEventExecutorForScan.java, v 0.1 2015年1月13日 下午1:45:51 song.li@witontek.com Exp $
 */
public class WxEventExecutorForScan extends AbstractWxEventExecutor {

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxEventExecutor#getEventType()
     */
    @Override
    public EventTypeEnum getEventType() {
        return EventTypeEnum.SCAN;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.AbstractWxEventExecutor#process(WxMsgExeRequest, WeixinEvent)
     */
    @Override
    protected WxRetMsg process(WxMsgExeRequest req, WeixinEvent weixinEvent) {
        logger.info("【点击事件】req={}, event={}", req, weixinEvent);

        Assert.isTrue(weixinEvent.getEventType() == getEventType(), String.format(
            "类型不匹配 eventType={},executeType={}", weixinEvent.getWxEventType(), getEventType()));

        WxRetMsg result = new WxRetMsg();
        result.setToUser(weixinEvent.getFromUser());
        result.setFromUser(weixinEvent.getToUser());
        result.setCreateTime(new Date());

        result.setRetType(WxRetMsgTypeEnum.TEXT);
        result.setContent("扫码成功");
        result.setSuccess(true);
        return result;
    }

}
