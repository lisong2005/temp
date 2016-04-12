/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxEventExecutorForLocation.java, v 0.1 2015年1月14日 下午1:22:27 song.li@witontek.com Exp $
 */
public class WxEventExecutorForLocation extends AbstractWxEventExecutor {

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxEventExecutor#getEventType()
     */
    @Override
    public EventTypeEnum getEventType() {
        return EventTypeEnum.LOCATION;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.AbstractWxEventExecutor#process(com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest, com.witon.ehealth.core.model.wx.model.WeixinEvent)
     */
    @Override
    protected WxRetMsg process(WxMsgExeRequest req, WeixinEvent weixinEvent) {
        return null;
    }

}
