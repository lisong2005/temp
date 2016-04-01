/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.comm.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ConfigParam.java, v 0.1 2015年3月25日 下午2:56:44 song.li@witontek.com Exp $
 */
public class ConfigParam extends BaseModel {

    /** SUID */
    private static final long serialVersionUID = 4808270547367521416L;

    /** ID */
    private long              id;

    /** 系统名 */
    private String            systemName;

    /** 模块名 */
    private String            moduleName;

    /** 配置参数key */
    private String            paramKey;

    /** 配置参数value */
    private String            paramValue;

    /** 状态 */
    private StatusEnum        status;

    /**  */
    private String            memo;

    /** 创建日期 */
    private Date              gmtCreate;

    /** 最近修改日期 */
    private Date              gmtModify;

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>systemName</tt>.
     * 
     * @return property value of systemName
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * Setter method for property <tt>systemName</tt>.
     * 
     * @param systemName value to be assigned to property systemName
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * Getter method for property <tt>moduleName</tt>.
     * 
     * @return property value of moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Setter method for property <tt>moduleName</tt>.
     * 
     * @param moduleName value to be assigned to property moduleName
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * Getter method for property <tt>paramKey</tt>.
     * 
     * @return property value of paramKey
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     * Setter method for property <tt>paramKey</tt>.
     * 
     * @param paramKey value to be assigned to property paramKey
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    /**
     * Getter method for property <tt>paramValue</tt>.
     * 
     * @return property value of paramValue
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * Setter method for property <tt>paramValue</tt>.
     * 
     * @param paramValue value to be assigned to property paramValue
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModify</tt>.
     * 
     * @return property value of gmtModify
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * Setter method for property <tt>gmtModify</tt>.
     * 
     * @param gmtModify value to be assigned to property gmtModify
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    // ==========================================
    // StatusEnum
    // ==========================================
    public static enum StatusEnum {

        /** 有效 */
        ENABLE("E", "有效"),

        /** 无效 */
        DISABLE("D", "无效")

        ;

        private StatusEnum(String code, String desc) {
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

        public static StatusEnum getByCode(String code) {
            if (StringUtils.isBlank(code)) {
                return null;
            }
            for (StatusEnum item : values()) {
                if (StringUtils.equals(item.getCode(), code)) {
                    return item;
                }
            }
            return null;
        }
    }
}
