/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.comm.enums;

import org.apache.commons.lang.StringUtils;

/**
 * rest接口结果码枚举
 * 
 * @author song.li@witontek.com
 * @version $Id: RestResultCodeEnum.java, v 0.1 2014年12月11日 下午2:19:13 song.li@witontek.com Exp $
 */
public enum RestResultCodeEnum {

    SUCCESS("0000", "成功"),

    PHONE_NO_REGISTERED("4002", "该手机号已注册"),

    PASSWORD_BLANK("4003", "密码为空"),

    非法验证码("4004", "非法验证码"),

    查找不到数据("4005", "查找不到数据"),

    请求参数为空("4006", "请求参数为空"),

    无法处理请求("4007", "无法处理请求"),

    短信发送失败("4016", "短信发送失败"),

    验证码过期或无效("4017", "验证码过期或无效"),

    无效的身份证("4021", "无效的身份证"),

    验证码为空("4023", "验证码为空"),

    手机号为空("4024", "手机号为空"),

    验证码错误("4046", "验证码错误"),

    密码不正确("4049", "密码不正确"),

    用户名已存在("4052", "用户名已存在"),

    非法的MAC地址("4053", "非法的MAC地址"),

    登录信息不能修改("4054", "登录信息不能修改"),

    服务器内部异常("5000", "服务器内部异常"),

    输入输出异常("5001", "输入输出异常"),

    JSON异常("5002", "JSON异常"),

    数字格式异常("5003", "数字格式异常"),

    API_REQUEST_DENIED("6000", "接口无权访问"),

    API_REQUEST_TIMEOUT("6001", "接口请求超时"),

    ILLEGAL_ARGUMENT("6002", "参数错误"),

    USER_NOT_EXIST("6003", "用户不存在"),

    WRONG_STATUS("6004", "错误的验证状态"),

    WRONG_PHONE_NUM("6005", "错误的验证手机号码"),

    USER_ALREADY_BIND("6006", "用户已绑定"),

    USER_NOT_VERIFY("6007", "登录账号未验证"),

    NO_FORMAT_PHONE_NUM("6008", "手机格式错误"),

    PIC_EXCEED_LIMIT("6009", "图片大小超过最大限制"),

    NULL_THIS_FILE("6010", "文件不存在"),

    LOGON_NAME_PHONE_EXIST("6011", "手机号已存在"),

    LOGON_NAME_EMAIL_EXIST("6012", "邮箱已存在"),

    LOGON_NAME_NORMAL_EXIST("6013", "登录名已存在"),

    API_TIMESTAMP_ILLEGAL("6014", "请求参数时间戳非法"),

    UNKNOWN_APP_ID("6015", "未知的app_id"),

    DUPLICATE_KEY("6016", "多次提交"),

    ERROR_ITEM_LIST("6017", "错误的检查项id"),

    RECORD_NOT_EXIST("6018", "记录不存在"),

    INVALID_USER("6019", "无效的用户"),

    NAME_OR_PWD_ERROR("6020", "登录名或密码错误"),

    API_INVALID_ORG("6021", "组织无效"),

    API_INVALID_SESSION("6022", "会话失效"),

    API_OPERATION_LIMIT("6023", "接口数据操作权限不足"),

    NULL_VERIFY("7000", "不存在此验证信息"),

    NULL_OR_MULTI_PHONE_NO_REGISTERED("7001", "手机号未注册或多次注册"),

    MANY_TIMES_VERIFY("7002", "手机号频繁校验"),

    OVER_MAX_SIZE("8000", "超过最大次数"),

    OVER_MAX_PAGESIZE("8001", "每页记录条数不能超过50"),

    DOCTOR_DETAILINFO_EXIST("8002", "医生详细信息已存在"),

    GET_LOCATION_TYPE_ERROR("8005", "地区获取方式错误"),

    USER_HOME_EXIST("8006", "用户已关联"),

    USER_CANNOT_RELATE_SELF("8007", "不能关联自己"),

    USER_CARD_DISABLE("8008", "卡已失效"),

    WRONG_CARDNO_OR_CARDPWD("8009", "卡号或卡密不正确"),

    USER_GRADE_UPDATE_NOT_REQUIRED("8010", "无需升级"),

    PACKAGE_DISABLE("8011", "套餐无效"),

    CARD_USERD("8012", "卡已使用"),

    NO_PACKAGE_SERVICE("8020", "用户无套餐服务信息"),

    NO_ENOUGT_POINT("8031", "此类积分不足"),

    ID_NOT_EXISTS("8040", "身份不存在"),

    ID_BIND_ALREADY("8041", "此身份证已绑定"),

    NO_FINGER_MAC("8050", "没有指纹信息"),

    NO_DEVICE_NO("8051", "没有此设备"),

    LOGON_FAIL("8052", "登录失败"),

    ID_NO_EXISTS("8053", "身份证已存在"),

    FINGER_EXISTS("8054", "指纹已存在"),

    FINGER_DELETE_FAIL("8055", "指纹删除失败"),
    // ...
    ;

    private RestResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /** code */
    private String code;

    /** desc */
    private String desc;

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

    public static RestResultCodeEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        for (RestResultCodeEnum item : values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }
}
