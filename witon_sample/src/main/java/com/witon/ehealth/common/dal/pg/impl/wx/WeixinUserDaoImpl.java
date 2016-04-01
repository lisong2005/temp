/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.wx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dao.wx.WeixinUserDao;
import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinUserDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WexinUserDaoImpl.java, v 0.1 2015年1月8日 下午1:11:51 song.li@witontek.com Exp $
 */
public class WeixinUserDaoImpl extends SqlSessionDaoSupport implements WeixinUserDao {
    /**
    * Logger for this class
    */
    private static final Logger logger    = LoggerFactory.getLogger(WeixinUserDaoImpl.class);

    /** NAMESPACE */
    private static final String NAMESPACE = WeixinUserDao.class.getName();

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinUserDao#add(com.witon.ehealth.common.dal.dbo.WeixinUserDo)
     */
    @Override
    public long add(WeixinUserDo wexinUserDo) {
        int size = getSqlSession().insert(NAMESPACE + ".add", wexinUserDo);
        logger.debug("insert result size={}", size);
        return wexinUserDo.getId();
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinUserDao#getById(long)
     */
    @Override
    public WeixinUserDo getById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".getById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinUserDao#lockById(long)
     */
    @Override
    public WeixinUserDo lockById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".lockById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinUserDao#deleteByUnionId(java.lang.String)
     */
    @Override
    public int deleteByUnionId(String unionId) {
        return getSqlSession().delete(NAMESPACE + ".deleteByUnionId", unionId);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinUserDao#getByUnionId(java.lang.String)
     */
    @Override
    public List<WeixinUserDo> getByUnionId(String unionId) {
        return getSqlSession().selectList(NAMESPACE + ".getByUnionId", unionId);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.WeixinUserDao#getByOpenId(java.lang.String, java.lang.String)
     */
    @Override
    public WeixinUserDo getByOpenId(String openId, String appId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("openId", openId);
        params.put("appId", appId);
        return getSqlSession().selectOne(NAMESPACE + ".getByOpenId", params);
    }

}
