/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import com.witon.ehealth.core.service.wx.enums.WxMsgTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgExecutor.java, v 0.1 2015年1月13日 上午11:20:32 song.li@witontek.com Exp $
 */
public interface WxMsgExecutor {

    public WxMsgTypeEnum getMsgType();

    public WxRetMsg execute(WxMsgExeRequest req);
}
