/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.conf;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SystemConfig.java, v 0.1 2015年2月13日 下午12:45:28 song.li@witontek.com Exp $
 */
public interface SystemConfig {

    /** 系统运行模式 */
    public static enum RunModeEnum {

        /** 发布模式 */
        PRODUCT,

        /** 开发模式 */
        DEVELOP;

    }

    /**
     * 
     * @param key
     * @return
     */
    public String get(String key);

    /**
     * 
     * @return
     */
    public RunModeEnum getSystemRunMode();

    /**
     * 
     * @return
     */
    public boolean isMirror();

    /**
     * 
     * @return
     */
    public String getServerUrl();
}
