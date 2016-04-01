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

import com.witon.ehealth.common.dal.pg.dao.wx.WeixinUserDao;
import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinUserDo;
import com.witon.ehealth.core.model.wx.WeixinUserRepository;
import com.witon.ehealth.core.model.wx.convertor.WexinUserConvertor;
import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WexinUserRepositoryImpl.java, v 0.1 2015年1月8日 下午1:37:35 song.li@witontek.com Exp $
 */
public class WeixinUserRepositoryImpl implements WeixinUserRepository {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WeixinUserRepositoryImpl.class);

    @Autowired
    private WeixinUserDao       weixinUserDao;

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinUserRepository#add(com.witon.ehealth.core.model.wx.model.WeixinUser)
     */
    @Override
    public long add(WeixinUser wexinUser) {
        logger.info("【微信用户-新增】{}", wexinUser);
        return weixinUserDao.add(WexinUserConvertor.convert(wexinUser));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinUserRepository#getById(long)
     */
    @Override
    public WeixinUser getById(long id) {
        logger.info("【微信用户-查询】id={}", id);
        return WexinUserConvertor.convert(this.weixinUserDao.getById(id));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinUserRepository#lockById(long)
     */
    @Override
    public WeixinUser lockById(long id) {
        logger.info("【微信用户-锁定】id={}", id);
        return WexinUserConvertor.convert(this.weixinUserDao.lockById(id));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinUserRepository#getByOpenId(java.lang.String, java.lang.String)
     */
    @Override
    public WeixinUser getByOpenId(String openId, String appId) {
        logger.info("【微信用户-openId查询】openId={}, appId={}", openId, appId);
        return WexinUserConvertor.convert(this.weixinUserDao.getByOpenId(openId, appId));
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinUserRepository#deleteByUnionId(java.lang.String)
     */
    @Override
    public int deleteByUnionId(String unionId) {
        logger.info("【微信用户-根据unionId删除】unionId={}", unionId);
        return weixinUserDao.deleteByUnionId(unionId);
    }

    /** 
     * @see com.witon.ehealth.core.model.wx.WeixinUserRepository#getByUnionId(java.lang.String)
     */
    @Override
    public List<WeixinUser> getByUnionId(String unionId) {
        logger.info("【微信用户-unionId查询】unionId={}", unionId);
        List<WeixinUser> weixinUserList = new ArrayList<WeixinUser>();
        for (WeixinUserDo w : this.weixinUserDao.getByUnionId(unionId)) {
            weixinUserList.add(WexinUserConvertor.convert(w));
        }
        return weixinUserList;
    }

}
