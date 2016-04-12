/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AbstractWxMsgExecutor.java, v 0.1 2015年1月13日 下午1:18:29 song.li@witontek.com Exp $
 */
public abstract class AbstractWxMsgExecutor implements WxMsgExecutor {
    /**
    * Logger for this class
    */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxMsgExecutor#execute(WxMsgExeRequest)
     */
    @Override
    public WxRetMsg execute(WxMsgExeRequest req) {
        logger.info("req = {}", req);
        return null;
    }
}
