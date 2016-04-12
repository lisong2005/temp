/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxEventExecutor.java, v 0.1 2015年1月13日 下午1:26:35 song.li@witontek.com Exp $
 */
public interface WxEventExecutor {

    public WeixinEvent.EventTypeEnum getEventType();

    public WxRetMsg execute(WxMsgExeRequest req);
}
