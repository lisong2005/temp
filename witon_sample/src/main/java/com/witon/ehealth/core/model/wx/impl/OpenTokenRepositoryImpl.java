/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.common.dal.pg.dao.wx.OpenTokenDao;
import com.witon.ehealth.common.dal.pg.dbo.wx.OpenTokenDo;
import com.witon.ehealth.core.model.wx.OpenTokenRepository;
import com.witon.ehealth.core.model.wx.convertor.OpenTokenConvertor;
import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.req.OpenTokenQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenRepositoryImpl.java, v 0.1 2015年1月8日 下午2:40:12 song.li@witontek.com Exp $
 */
public class OpenTokenRepositoryImpl implements OpenTokenRepository {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(OpenTokenRepositoryImpl.class);

    @Autowired
    private OpenTokenDao        openTokenDao;

    /** 
     * @see com.witon.ehealth.core.model.wx.OpenTokenRepository#add(com.witon.ehealth.core.model.wx.model.OpenToken)
     */
    @Override
    public long add(OpenToken openToken) {
        logger.info("【开放令牌--新增】{}", openToken);
        return openTokenDao.add(OpenTokenConvertor.convert(openToken));
    }

    /** 
     * 
     * @see com.witon.ehealth.core.model.wx.OpenTokenRepository#update(com.witon.ehealth.core.model.wx.model.OpenToken)
     */
    @Override
    public int update(OpenToken openToken) {
        logger.info("【开放令牌--更新】openToken={}", openToken);
        return this.openTokenDao.update(OpenTokenConvertor.convert(openToken));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.OpenTokenRepository#getById(long)
     */
    @Override
    public OpenToken getById(long id) {
        logger.info("【开放令牌--查询】id={}", id);
        return OpenTokenConvertor.convert(this.openTokenDao.getById(id));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.OpenTokenRepository#lockById(long)
     */
    @Override
    public OpenToken lockById(long id) {
        logger.info("【开放令牌--锁定】id={}", id);
        return OpenTokenConvertor.convert(this.openTokenDao.lockById(id));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.OpenTokenRepository#getByCond(com.witon.ehealth.core.model.wx.req.OpenTokenQueryReq)
     */
    @Override
    public List<OpenToken> getByCond(OpenTokenQueryReq cond) {
        logger.info("【开放令牌--查询】cond={}", cond);
        List<OpenToken> retList = new ArrayList<OpenToken>();

        List<OpenTokenDo> list = this.openTokenDao.getByCond(
                cond.getAppType() != null ? cond.getAppType().getCode() : null, cond.getAppId(), cond.getGmtExpire());
        if (!CollectionUtils.isEmpty(list)) {
            for (OpenTokenDo item : list) {
                retList.add(OpenTokenConvertor.convert(item));
            }
        }
        return retList;
    }

    // --------------------------------
    // --------------------------------

    /**
     * Setter method for property <tt>openTokenDao</tt>.
     * 
     * @param openTokenDao value to be assigned to property openTokenDao
     */
    public void setOpenTokenDao(OpenTokenDao openTokenDao) {
        this.openTokenDao = openTokenDao;
    }

}
