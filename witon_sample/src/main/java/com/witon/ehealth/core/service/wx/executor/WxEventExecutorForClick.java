/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.witon.ehealth.core.model.wx.WxAppConfigRepository;
import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;
import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxEventExecutorForClick.java, v 0.1 2015年1月13日 下午1:31:55 song.li@witontek.com Exp $
 */
public class WxEventExecutorForClick extends AbstractWxEventExecutor implements WxEventExecutor {

    /**  */
    @Autowired
    protected WxAppConfigRepository wxAppConfigRepository;

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxEventExecutor#getEventType()
     */
    @Override
    public EventTypeEnum getEventType() {
        return EventTypeEnum.CLICK;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.AbstractWxEventExecutor#process(WxMsgExeRequest, WeixinEvent)
     */
    @Override
    protected WxRetMsg process(WxMsgExeRequest req, WeixinEvent weixinEvent) {
        logger.info("【点击事件】event={}", weixinEvent);

        Assert.isTrue(weixinEvent.getEventType() == getEventType(), String.format(
            "类型不匹配 eventType={},executeType={}", weixinEvent.getWxEventType(), getEventType()));

        WxRetMsg result = new WxRetMsg();
        result.setToUser(weixinEvent.getFromUser());
        result.setFromUser(weixinEvent.getToUser());
        result.setCreateTime(new Date());

        result.setSuccess(true);
        result.setRetType(WxRetMsgTypeEnum.TEXT);
        result.setContent("暂未开放");

        return result;
    }

}
