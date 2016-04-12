/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.witon.ehealth.core.model.wx.WxAppConfigRepository;
import com.witon.ehealth.core.model.wx.model.WxAppConfig;
import com.witon.ehealth.util.conf.SystemConfig;
import com.witon.ehealth.util.conf.SystemConfig.RunModeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxAppConfigRepositoryImpl.java, v 0.1 2015年4月2日 上午9:20:47
 *          song.li@witontek.com Exp $
 */
public class WxAppConfigRepositoryImpl implements WxAppConfigRepository, InitializingBean {
    /**
     * Logger for this class
     */
    private static final Logger                        logger         = LoggerFactory
        .getLogger(WxAppConfigRepositoryImpl.class);

    /** 系统配置 */
    @Autowired
    private SystemConfig                               systemConfig;

    /**  */
    private Map<SystemConfig.RunModeEnum, WxAppConfig> defaultConfigs = new HashMap<SystemConfig.RunModeEnum, WxAppConfig>();

    /**
     * @see com.witon.ehealth.core.model.wx.WxAppConfigRepository#getDefault()
     */
    @Override
    public WxAppConfig getDefault() {
        logger.info("查询微信app配置信息");
        return defaultConfigs.get(systemConfig.getSystemRunMode());
    }

    /**
     * @see com.witon.ehealth.core.model.wx.WxAppConfigRepository#getByAppId(java.lang.String)
     */
    @Override
    public WxAppConfig getByAppId(String appId) {
        throw new NotImplementedException();
    }

    /**
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("=======================================");
        logger.info("=======================================");
        // 暂时保存在文件中，后续迁移到数据库配置

        // 开发环境配置
        WxAppConfig devConfig = new WxAppConfig();
        devConfig.setAppId("");
        devConfig.setAppSecret("");
        devConfig.setToken("");
        devConfig.setAesKey("");

        devConfig.setLastTemplateId("");

        // 生产环境配置
        WxAppConfig prodConfig = new WxAppConfig();
        prodConfig.setAppId("");
        prodConfig.setAppSecret("");
        prodConfig.setToken("");
        prodConfig.setAesKey("");

        prodConfig.setLastTemplateId("");

        defaultConfigs.put(RunModeEnum.DEVELOP, devConfig);
        defaultConfigs.put(RunModeEnum.PRODUCT, prodConfig);

        logger.info("微信APP配置初始化成功");
    }

}
