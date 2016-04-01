/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dao.wx;

import java.util.Date;
import java.util.List;

import com.witon.ehealth.common.dal.pg.dbo.wx.OpenTokenDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenDao.java, v 0.1 2015年1月8日 下午3:09:12 song.li@witontek.com Exp $
 */
public interface OpenTokenDao {

    public long add(OpenTokenDo openTokenDo);

    public OpenTokenDo getById(long id);

    public int update(OpenTokenDo openTokenDo);

    public OpenTokenDo lockById(long id);

    public List<OpenTokenDo> getByCond(String appType, String appId, Date gmtExpire);

    public List<OpenTokenDo> getAllByCond(String appType, String appId, Date gmtExpire);
}
