/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx;

import com.witon.ehealth.core.service.wx.req.WxMsgReq;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgComponent.java, v 0.1 2015年1月13日 上午11:09:55 song.li@witontek.com Exp $
 */
public interface WxMsgComponent {

    /**
     * 
     * @param wxMsgReq 
     * @return
     */
    public WxRetMsg process(WxMsgReq wxMsgReq);
}
