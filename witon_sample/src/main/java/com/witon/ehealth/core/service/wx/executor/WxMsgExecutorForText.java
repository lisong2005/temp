/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import com.witon.ehealth.core.service.wx.enums.WxMsgTypeEnum;
import com.witon.ehealth.core.service.wx.enums.WxRetMsgTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;
import com.witon.ehealth.util.wx.EhWxConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgExecutorForText.java, v 0.1 2015年1月13日 下午8:54:50 song.li@witontek.com Exp $
 */
public class WxMsgExecutorForText extends AbstractWxMsgExecutor {

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxMsgExecutor#getMsgType()
     */
    @Override
    public WxMsgTypeEnum getMsgType() {
        return WxMsgTypeEnum.TEXT;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.AbstractWxMsgExecutor#execute(com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest)
     */
    @Override
    public WxRetMsg execute(WxMsgExeRequest req) {
        logger.info("{}", req);
        WxRetMsg ret = new WxRetMsg();
        ret.setSuccess(true);
        ret.setFromUser(req.getParams().get(EhWxConstants.KEY_TO_USER));
        ret.setToUser(req.getParams().get(EhWxConstants.KEY_FROM_USER));
        ret.setRetType(WxRetMsgTypeEnum.TEXT);
        ret.setContent("正在努力开发中，请稍等。。。");
        return ret;
    }

}
