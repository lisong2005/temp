/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx;

import com.witon.ehealth.core.model.wx.model.WeixinEvent;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinEventRepository.java, v 0.1 2015年1月9日 下午1:37:23 song.li@witontek.com Exp $
 */
public interface WeixinEventRepository {

    public long add(WeixinEvent weixinEvent);

    public WeixinEvent getById(long id);

    public WeixinEvent lockById(long id);

}
