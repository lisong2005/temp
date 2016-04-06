/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.result;

import com.witon.ehealth.common.base.BaseResult;
import com.witon.ehealth.core.model.wx.model.OpenToken;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxOpenTokenResult.java, v 0.1 2015年1月16日 上午11:18:01 song.li@witontek.com Exp $
 */
public class WxOpenTokenResult extends BaseResult {

    /**  */
    private static final long serialVersionUID = -4653518231555381240L;

    private OpenToken         openToken;

    /**
     * Getter method for property <tt>openToken</tt>.
     * 
     * @return property value of openToken
     */
    public OpenToken getOpenToken() {
        return openToken;
    }

    /**
     * Setter method for property <tt>openToken</tt>.
     * 
     * @param openToken value to be assigned to property openToken
     */
    public void setOpenToken(OpenToken openToken) {
        this.openToken = openToken;
    }

}
