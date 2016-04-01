/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.comm.req;

import com.witon.ehealth.common.base.BaseModel;
import com.witon.ehealth.core.model.comm.model.ConfigParam;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CongfigParamQueryCond.java, v 0.1 2015年3月25日 下午3:16:31 song.li@witontek.com Exp $
 */
public class CongfigParamQueryReq extends BaseModel {

    /**  */
    private static final long      serialVersionUID = -7940254757573700238L;

    private String                 systemName;

    private String                 moduleName;

    private String                 paramKey;

    private ConfigParam.StatusEnum status;

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
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public ConfigParam.StatusEnum getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(ConfigParam.StatusEnum status) {
        this.status = status;
    }

}
