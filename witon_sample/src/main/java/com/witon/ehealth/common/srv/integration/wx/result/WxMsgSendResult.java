/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.result;

import com.witon.ehealth.common.base.BaseResult;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgSendResult.java, v 0.1 2015年1月22日 下午4:16:59 song.li@witontek.com Exp $
 */
public class WxMsgSendResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = 6978519372635522647L;

    private Object            retMsg;

    /**
     * Getter method for property <tt>retMsg</tt>.
     * 
     * @return property value of retMsg
     */
    public Object getRetMsg() {
        return retMsg;
    }

    /**
     * Setter method for property <tt>retMsg</tt>.
     * 
     * @param retMsg value to be assigned to property retMsg
     */
    public void setRetMsg(Object retMsg) {
        this.retMsg = retMsg;
    }

}
