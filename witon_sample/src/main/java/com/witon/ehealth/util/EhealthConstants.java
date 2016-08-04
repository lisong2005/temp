/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.util;

/**
 * 健康吧--常量定义
 * 
 * @author song.li@witontek.com
 * @version $Id: EhealthConstants.java, v 0.1 2014年7月29日 下午5:56:12 song.li@witontek.com Exp $
 */
public interface EhealthConstants {

    /** 秒转换为毫秒 */
    public static final int    SECOND_TO_MILLSECCOND     = 1000;

    /** sql批处理大小 */
    public static final int    BATCH_SIZE                = 20;

    /** web端自助用户创建UID */
    public static final String WEB_USER_CREATE_UID       = "WEB_USER";

    /** 错误页面 */
    public static final String ERROR_PAGE                = "redirect:/error.htm";

    /** 首页 */
    public static final String INDEX_PAGE                = "redirect:/index.htm";

    /** 登录页面 */
    public static final String LOGIN_PAGE                = "redirect:/login.htm";

    /** 404 */
    public static final String NOT_FOUND_PAGE            = "redirect:/notfound.htm";

    /** 默认编码字符集 */
    public static final String DEFAULT_CHARSET           = "utf-8";

    /** 用户信息校验--修改分隔符 */
    public static final String USER_VERIFY_SPLIT         = "->";

    /**  */
    public static final int    LOC_FIRST_LEVEL           = 1;

    public static final int    ORG_FIRST_LEVEL           = 1;

    // ================================================================
    // ================================================================
    // ================================================================

    public static final String KEY_UID_VALIDATE          = "uid.validate";

    // ================================================================
    // ================================================================
    // ================================================================

    /**  */
    public static final String RUN_MODE_TEST             = "0";

    // ================================================================
    // ================================================================
    // ================================================================

    /**  */
    public static final String SESSION_USER              = "user";

    /** 用户ID */
    public static final String SESSION_USER_ID           = "_user_id";

    /** 新用户信息 */
    public static final String SESSION_NEW_USER_INFO     = "_new_user_info";

    /** 临时用户信息 */
    public static final String TEMP_USER_INFO            = "_temp_user";

    /** 临时用户关注 */
    public static final String TEMP_USER_TAGS            = "_temp_tags";

    public static final String VERIFY_ID                 = "verifyId";

    // ================================================================
    // ================================================================
    // ================================================================

    public static final String REG_SRC_WX                = "wx_bind";

    public static final String REG_SRC_ALIPAY            = "alipay_bind";

    public static final String REG_SRC_API               = "rest_api";

    public static final String REG_SRC_API_3RD_TEMP      = "rest_api_3p_%s";

    public static final String REG_SRC_MIGRATE           = "migrate";

    //public static final String REG_SRC_NTJTYH           = "wx_bind";

    // public static final String REG_SRC_WX_EXT           = "WX_EXT_%S";

    // ================================================================
    // ================================================================
    // ================================================================

    public static final String TMPLATE_TOP_COLOR         = "#000000";

    // ================================================================
    // ================================================================
    // ================================================================

    /** 脂肪 */
    public static final int    REPORT_FAT_ORDINATE       = 50;
    /** 肌肉 */
    public static final int    REPORT_MUSCLE_ORDINATE    = 50;
    /** 水分 */
    public static final int    REPORT_MOISTURE_ORDINATE  = 100;
    /**  基础代谢 */
    public static final int    REPORT_KCAL_ORDINATE      = 1000;

    /** 血糖 */
    public static final int    REPORT_GL_ORDINATE        = 15;

    /** 血压 */
    public static final int    REPORT_BP_ORDINATE        = 250;
    /** 脉搏 */
    public static final int    REPORT_PULSE_ORDINATE     = 200;

    /** 身高体重指数 */
    public static final int    REPORT_BMI_ORDINATE       = 40;

    /** 体温 */
    public static final int    REPORT_TEMP_ORDINATE      = 40;

    // ================================================================
    // ================================================================
    // ================================================================

    /**  */
    public static final String SYSTEM_NAME               = "ehealth";

    // ================================================================
    // ================================================================
    // ================================================================

    /**  */
    public static final String JERSEY_CLIENT_LOGGER_NAME = "com.witon.jersey.CLIENT";

    // ================================================================
    // ================================================================
    // ================================================================

    /** url_md5_sign_salt */
    public static final String URL_SIGN_KEY              = "34yghfoirhstfhqwerty134dhc4foi55ty834bt2r4eyudsfoyurewt34uit8389toirto9i34rt5yht4u1";
}
