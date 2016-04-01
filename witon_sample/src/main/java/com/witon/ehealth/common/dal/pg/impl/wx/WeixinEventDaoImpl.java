/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.wx;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dao.wx.WeixinEventDao;
import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinEventDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinEventDaoImpl.java, v 0.1 2015年1月9日 上午9:44:58 song.li@witontek.com Exp $
 */
public class WeixinEventDaoImpl extends SqlSessionDaoSupport implements WeixinEventDao {

    /**
     * Logger for this class
     */
    private static final Logger logger    = LoggerFactory.getLogger(WeixinEventDaoImpl.class);

    /** NAMESPACE */
    private static final String NAMESPACE = WeixinEventDao.class.getName();

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinEventDao#add(com.witon.ehealth.common.dal.dbo.WeixinEventDo)
     */
    @Override
    public long add(WeixinEventDo weixinEventDo) {
        int size = getSqlSession().insert(NAMESPACE + ".add", weixinEventDo);
        logger.debug("insert result size={}", size);
        return weixinEventDo.getId();
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinEventDao#getById(long)
     */
    @Override
    public WeixinEventDo getById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".getById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinEventDao#lockById(long)
     */
    @Override
    public WeixinEventDo lockById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".lockById", id);
    }

}
