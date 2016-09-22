/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.conf;

import java.io.File;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SystemConfigImpl.java, v 0.1 2015年2月13日 下午12:52:03 song.li@witontek.com Exp $
 */
public class SystemConfigImpl implements SystemConfig, InitializingBean {
    /**
    * Logger for this class
    */
    private static final Logger logger         = LoggerFactory.getLogger(SystemConfigImpl.class);

    /** 环境配置 */
    private Properties          envProps;

    /** 系统参数 */
    private Properties          extprops;

    /** 运行模式 */
    private RunModeEnum         runMode;

    /** 测试属性 */
    private String              test;

    public static final String  KEY_SERVER_URL = "eh.server.url";

    /** 
     * @see com.witon.ehealth.util.conf.SystemConfig#isMirror()
     */
    @Override
    public boolean isMirror() {
        return StringUtils.equalsIgnoreCase("mirror", get("test.env"));
    }

    /** 
     * @see com.witon.ehealth.util.conf.SystemConfig#getServerUrl()
     */
    @Override
    public String getServerUrl() {
        return get(KEY_SERVER_URL);
    }

    /** 
     * @see com.witon.ehealthMng.util.conf.SystemConfig#get(java.lang.String)
     */
    @Override
    public String get(String key) {
        logger.debug("key={}", key);

        String ret = envProps.getProperty(key);
        if (StringUtils.isNotBlank(ret)) {
            return ret;
        }
        return extprops.getProperty(key);
    }

    /** 
     * @see com.witon.ehealthMng.util.conf.SystemConfig#getSystemRunMode()
     */
    @Override
    public RunModeEnum getSystemRunMode() {
        return this.runMode;
    }

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("[init]xxxxxxxxxxxxxxxxxxxx");
        logger.info("[init]系统配置初始化");
        logger.info("envProps=\n{}", getStrForProps(envProps));
        logger.debug("extprops=\n{}", getStrForProps(extprops));
        logger.info("[init]xxxxxxxxxxxxxxxxxxxx");
        String runMode = envProps.getProperty("run.mode");
        if (StringUtils.equals("1", runMode)) {
            this.runMode = RunModeEnum.PRODUCT;
        }
        if (StringUtils.equals("0", runMode)) {
            this.runMode = RunModeEnum.DEVELOP;
        }
        if (this.runMode == null) {
            throw new RuntimeException(String.format("【运行模式非法】run.mode=%s", runMode));
        }

        logger.info("runMode={}", this.runMode);
        logger.info("test={}", this.test);
        logger.info("{}", new File("dd/aa.txt").getAbsolutePath());
    }

    private String getStrForProps(Properties props) {
        StringBuilder sb = new StringBuilder();
        if (props != null) {
            Enumeration<Object> keys = props.keys();
            sb.append("\n");
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                sb.append(key).append("=").append(props.get(key)).append("\n");
            }
        }
        return sb.toString();

    }

    /**
     * Setter method for property <tt>envProps</tt>.
     * 
     * @param envProps value to be assigned to property envProps
     */
    public void setEnvProps(Properties envProps) {
        this.envProps = envProps;
    }

    /**
     * Setter method for property <tt>extprops</tt>.
     * 
     * @param extprops value to be assigned to property extprops
     */
    public void setExtprops(Properties extprops) {
        this.extprops = extprops;
    }

    /**
     * Setter method for property <tt>test</tt>.
     * 
     * @param test value to be assigned to property test
     */
    public void setTest(String test) {
        this.test = test;
    }

}
