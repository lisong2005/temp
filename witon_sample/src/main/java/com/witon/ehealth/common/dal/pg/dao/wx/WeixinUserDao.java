/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dao.wx;

import java.util.List;

import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinUserDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WexinUserDao.java, v 0.1 2015年1月8日 上午11:04:25 song.li@witontek.com Exp $
 */
public interface WeixinUserDao {

    public long add(WeixinUserDo wexinUserDo);

    public WeixinUserDo getById(long id);

    public WeixinUserDo lockById(long id);

    public WeixinUserDo getByOpenId(String openId, String appId);

    public int deleteByUnionId(String unionId);

    public List<WeixinUserDo> getByUnionId(String unionId);
}
