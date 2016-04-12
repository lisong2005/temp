/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import com.witon.ehealth.core.service.wx.enums.WxMsgTypeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgExecutorForVoice.java, v 0.1 2015年1月29日 下午3:51:05 song.li@witontek.com Exp $
 */
public class WxMsgExecutorForVoice extends AbstractWxMsgExecutor {

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxMsgExecutor#getMsgType()
     */
    @Override
    public WxMsgTypeEnum getMsgType() {
        return WxMsgTypeEnum.VOICE;
    }

}
