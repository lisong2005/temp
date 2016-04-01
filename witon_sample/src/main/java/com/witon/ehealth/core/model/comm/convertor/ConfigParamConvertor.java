/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.comm.convertor;

import com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo;
import com.witon.ehealth.core.model.comm.model.ConfigParam;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ConfigParamConvertor.java, v 0.1 2015年3月25日 下午3:07:38 song.li@witontek.com Exp $
 */
public class ConfigParamConvertor {

    /**
     * 
     * @param configParamDo
     * @return
     */
    public static ConfigParam convert(ConfigParamDo configParamDo) {
        if (configParamDo == null) {
            return null;
        }
        ConfigParam ret = new ConfigParam();
        ret.setId(configParamDo.getId());
        ret.setSystemName(configParamDo.getSystemName());
        ret.setModuleName(configParamDo.getModuleName());
        ret.setParamKey(configParamDo.getParamKey());
        ret.setParamValue(configParamDo.getParamValue());
        ret.setStatus(ConfigParam.StatusEnum.getByCode(configParamDo.getStatus()));
        ret.setMemo(configParamDo.getMemo());
        ret.setGmtCreate(configParamDo.getGmtCreate());
        ret.setGmtModify(configParamDo.getGmtModify());
        return ret;
    }

    /**
     * 
     * @param configParam
     * @return
     */
    public static ConfigParamDo convert(ConfigParam configParam) {
        if (configParam == null) {
            return null;
        }
        ConfigParamDo ret = new ConfigParamDo();
        ret.setId(configParam.getId());
        ret.setSystemName(configParam.getSystemName());
        ret.setModuleName(configParam.getModuleName());
        ret.setParamKey(configParam.getParamKey());
        ret.setParamValue(configParam.getParamValue());
        ret.setStatus(configParam.getStatus() != null ? configParam.getStatus().getCode() : null);
        ret.setMemo(configParam.getMemo());
        ret.setGmtCreate(configParam.getGmtCreate());
        ret.setGmtModify(configParam.getGmtModify());
        return ret;
    }
}
