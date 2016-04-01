/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.wx;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dao.wx.OpenTokenDao;
import com.witon.ehealth.common.dal.pg.dbo.wx.OpenTokenDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenDaoImpl.java, v 0.1 2015年1月8日 下午3:10:50 song.li@witontek.com Exp $
 */
public class OpenTokenDaoImpl extends SqlSessionDaoSupport implements OpenTokenDao {
    /**
     * Logger for this class
     */
    private static final Logger logger    = LoggerFactory.getLogger(OpenTokenDaoImpl.class);

    /** NAMESPACE */
    private static final String NAMESPACE = OpenTokenDao.class.getName();

    /** 
     * @see com.witon.ehealth.common.dal.dao.OpenTokenDao#add(com.witon.ehealth.common.dal.dbo.OpenTokenDo)
     */
    @Override
    public long add(OpenTokenDo openTokenDo) {
        int size = getSqlSession().insert(NAMESPACE + ".add", openTokenDo);
        logger.debug("insert result size={}", size);
        return openTokenDo.getId();
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.OpenTokenDao#getById(long)
     */
    @Override
    public OpenTokenDo getById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".getById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.OpenTokenDao#update(com.witon.ehealth.common.dal.dbo.OpenTokenDo)
     */
    @Override
    public int update(OpenTokenDo openTokenDo) {
        int size = getSqlSession().update(NAMESPACE + ".update", openTokenDo);
        logger.debug("update result size={}", size);
        return size;
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.OpenTokenDao#lockById(long)
     */
    @Override
    public OpenTokenDo lockById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".lockById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.OpenTokenDao#getAllByCond(java.lang.String, java.lang.String, java.util.Date)
     */
    @Override
    public List<OpenTokenDo> getAllByCond(String appType, String appId, Date gmtExpire) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appType", appType);
        params.put("appId", appId);
        params.put("gmtExpire", gmtExpire);
        return getSqlSession().selectList(NAMESPACE + ".getAllByCond", params);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.OpenTokenDao#getByCond(java.lang.String, java.lang.String, java.util.Date)
     */
    @Override
    public List<OpenTokenDo> getByCond(String appType, String appId, Date gmtExpire) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appType", appType);
        params.put("appId", appId);
        params.put("gmtExpire", gmtExpire);
        return getSqlSession().selectList(NAMESPACE + ".getByCond", params);
    }

}
