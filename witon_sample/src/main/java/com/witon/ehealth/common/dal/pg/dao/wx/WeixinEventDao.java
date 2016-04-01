/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dao.wx;

import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinEventDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinEventDao.java, v 0.1 2015年1月9日 上午9:43:23 song.li@witontek.com Exp $
 */
public interface WeixinEventDao {

    public long add(WeixinEventDo weixinEventDo);

    public WeixinEventDo getById(long id);

    public WeixinEventDo lockById(long id);

}
