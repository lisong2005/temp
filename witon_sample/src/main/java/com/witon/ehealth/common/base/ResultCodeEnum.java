/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.common.base;

import org.apache.commons.lang.StringUtils;

/**
 * 结果码枚举值定义
 * 
 * @author song.li@witontek.com
 * @version $Id: ResultCodeEnum.java, v 0.1 2014年8月11日 下午5:12:36 song.li@witontek.com Exp $
 */
public enum ResultCodeEnum {

    SUCCESS("SUCCESS", "成功"),

    RECORD_NOT_EXIST("RECORD_NOT_EXIST", "记录不存在"),

    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT", "参数错误"),

    USER_NOT_EXIST("USER_NOT_EXIST", "用户不存在"),

    USER_DISABLE("USER_DISABLE", "用户不可用"),

    USER_EXIST("USER_EXIST", "用户已存在"),

    LOGON_NAME_EXIST("LOGON_NAME_EXIST", "登录名已被使用"),

    SYSTEM_ERROR("SYSTEM_ERROR", "系统异常"),

    VERIFY_ERROR("VERIFY_ERROR", "安全校验失败"),

    PASSWORD_ERROR("PASSWORD_ERROR", "密码错误"),

    DUPLICATION_REQUEST("DUPLICATION_REQUEST", "重复请求"),

    DUPLICATION_KEY("DUPLICATION_KEY", "主键冲突"),

    EMAIL_DUPLICATION("EMAIL_DUPLICATION", "该邮箱被使用"),

    PHONENUM_DUPLICATION("PHONENUM_DUPLICATION", "该手机号被使用"),

    UPDATE_ERROR("UPDATE_ERROR", "记录更新失败"),

    EASEMOB_ERROR("EASEMOB_ERROR", "环信错误"),

    USERNAME_EXIST("USERNAME_EXIST", "登录账号已存在"),

    NOT_FOUND("NOT_FOUND", "未找到"),

    NOT_LOGIN("NOT_LOGIN", "用户未登录"),

    ACCESS_DENIED("ACCESS_DENIED", "访问拒绝"),

    EXIST_OPERATOR("EXIST_OPERATOR", "角色下存在用户信息"),

    ORGANIZATION_DISABLE("ORGANIZATION_DISABLE", "组织无效"),

    PACKAGE_NAME_EXIST("PACKAGE_NAME_EXIST", "套餐名称已存在"),

    PACKAGE_IN_USE("PACKAGE_IN_USE", "套餐正在被使用"),

    NO_ENOUGT_POINT("8031", "此类积分不足");

    /** code */
    private String code;

    /** desc */
    private String desc;

    private ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     * 
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 通过code查询结果码枚举值
     * 
     * @param code
     * @return
     */
    public static ResultCodeEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (ResultCodeEnum item : values()) {
            if (StringUtils.equals(item.code, code)) {
                return item;
            }
        }
        return null;
    }

}
