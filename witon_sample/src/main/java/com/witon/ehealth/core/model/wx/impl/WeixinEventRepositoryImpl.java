/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.witon.ehealth.common.dal.pg.dao.wx.WeixinEventDao;
import com.witon.ehealth.core.model.wx.WeixinEventRepository;
import com.witon.ehealth.core.model.wx.convertor.WeixinEventConvertor;
import com.witon.ehealth.core.model.wx.model.WeixinEvent;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinEventRepositoryImpl.java, v 0.1 2015年1月9日 下午1:38:20 song.li@witontek.com Exp $
 */
public class WeixinEventRepositoryImpl implements WeixinEventRepository {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WeixinEventRepositoryImpl.class);

    /**  */
    @Autowired
    private WeixinEventDao      weixinEventDao;

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinEventRepository#add(com.witon.ehealth.core.model.wx.model.WeixinEvent)
     */
    @Override
    public long add(WeixinEvent weixinEvent) {
        logger.info("{}", weixinEvent);
        return weixinEventDao.add(WeixinEventConvertor.convert(weixinEvent));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinEventRepository#getById(long)
     */
    @Override
    public WeixinEvent getById(long id) {
        logger.info("{}", id);
        return WeixinEventConvertor.convert(this.weixinEventDao.getById(id));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinEventRepository#lockById(long)
     */
    @Override
    public WeixinEvent lockById(long id) {
        logger.info("{}", id);
        return WeixinEventConvertor.convert(this.weixinEventDao.lockById(id));
    }

}
