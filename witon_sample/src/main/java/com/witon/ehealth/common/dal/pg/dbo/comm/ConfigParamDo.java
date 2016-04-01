/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dbo.comm;

import java.util.Date;

/**
 * 
 * @author Administrator
 * @version $Id: ConfigParamDo.java, v 0.1 2016年4月1日 上午9:26:59 Administrator Exp $
 */
public class ConfigParamDo extends BaseDo {

    /**  */
    private static final long serialVersionUID = 5085003143221281485L;

    private long              id;

    private String            systemName;

    private String            moduleName;

    private String            paramKey;

    private String            paramValue;

    private String            status;

    private String            memo;

    private Date              gmtCreate;

    private Date              gmtModify;

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
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

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

}
