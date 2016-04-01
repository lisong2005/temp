/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.comm.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao;
import com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo;
import com.witon.ehealth.common.dal.pg.dbo.comm.PageList;
import com.witon.ehealth.core.model.comm.ConfigParamRepository;
import com.witon.ehealth.core.model.comm.convertor.ConfigParamConvertor;
import com.witon.ehealth.core.model.comm.model.ConfigParam;
import com.witon.ehealth.core.model.comm.req.ConfigParamPageQueryReq;
import com.witon.ehealth.core.model.comm.req.CongfigParamQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ConfigParamRepositoryImpl.java, v 0.1 2015年3月25日 下午3:12:39 song.li@witontek.com Exp $
 */
public class ConfigParamRepositoryImpl implements ConfigParamRepository {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ConfigParamRepositoryImpl.class);

    /**  */
    @Autowired
    private ConfigParamDao      configParamDao;

    /** 
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#add(com.witon.com.witon.common.service.facade.config.model.ConfigParam)
     */
    @Override
    public long add(ConfigParam configParam) {
        logger.info("【新增】configParam = {}", configParam);
        if (configParam == null) {
            throw new NullPointerException("configParam is null.");
        }
        return configParamDao.add(ConfigParamConvertor.convert(configParam));
    }

    /** 
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#getById(long)
     */
    @Override
    public ConfigParam getById(long id) {
        logger.info("【查询】id = {}", id);
        return ConfigParamConvertor.convert(configParamDao.getById(id));
    }

    /** 
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#lockById(long)
     */
    @Override
    public ConfigParam lockById(long id) {
        logger.info("【锁定】id = {}", id);
        return ConfigParamConvertor.convert(configParamDao.lockById(id));

    }

    /** 
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#pageQuery(com.witon.ehealth.core.model.ConfigParamPageQueryReq.config.model.ConfigParamPageQueryCond)
     */
    @Override
    public PageList<ConfigParam> pageQuery(ConfigParamPageQueryReq pageQueryCond) {
        logger.info("【分页查询】pageQueryCond = {}", pageQueryCond);
        PageList<ConfigParamDo> pageList = this.configParamDao.pageQuery(
            pageQueryCond.getSystemName(), pageQueryCond.getModuleName(),
            pageQueryCond.getParamKey(),
            pageQueryCond.getStatus() != null ? pageQueryCond.getStatus().getCode() : null,
            pageQueryCond.getPageSize(), pageQueryCond.getPageNum());

        PageList<ConfigParam> retPage = new PageList<ConfigParam>(pageList);

        if (!CollectionUtils.isEmpty(pageList.getResultList())) {
            List<ConfigParam> list = new ArrayList<ConfigParam>();
            for (ConfigParamDo item : pageList.getResultList()) {
                list.add(ConfigParamConvertor.convert(item));
            }

            retPage.setResultList(list);
        }

        return retPage;
    }

    /** 
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#getByCond(com.witon.ehealth.core.model.CongfigParamQueryReq.config.model.CongfigParamQueryCond)
     */
    @Override
    public List<ConfigParam> getByCond(CongfigParamQueryReq cond) {
        logger.info("【查询】cond = {}", cond);

        List<ConfigParamDo> list = this.configParamDao.getByCond(
            StringUtils.defaultString(cond.getSystemName()),
            StringUtils.defaultString(cond.getModuleName()), cond.getParamKey(),
            cond.getStatus() != null ? cond.getStatus().getCode() : null);

        List<ConfigParam> retList = new ArrayList<ConfigParam>();
        if (!CollectionUtils.isEmpty(list)) {
            for (ConfigParamDo item : list) {
                retList.add(ConfigParamConvertor.convert(item));
            }
        }
        return retList;
    }

    /**
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#update(com.witon.com.witon.common.service.facade.config.model.ConfigParam)
     */
    @Override
    public int update(ConfigParam configParam) {
        logger.info("【更新】 configParam={}", configParam);
        return this.configParamDao.update(ConfigParamConvertor.convert(configParam));
    }

    /**
     * @see com.witon.ehealth.core.model.common.config.ConfigParamRepository#delete(java.util.List)
     */
    @Override
    public int delete(List<Long> idList) {
        logger.info("【微信接入配置删除】,idList={}", idList);
        if (CollectionUtils.isEmpty(idList)) {
            return 0;
        }

        return this.configParamDao.delete(idList);
    }

}
