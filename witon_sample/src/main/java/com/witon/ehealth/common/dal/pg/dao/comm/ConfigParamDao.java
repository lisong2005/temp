/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dao.comm;

import java.util.List;

import com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo;
import com.witon.ehealth.common.dal.pg.dbo.comm.PageList;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ConfigParamDao.java, v 0.1 2015年3月25日 上午10:18:19 song.li@witontek.com Exp $
 */
public interface ConfigParamDao {

    /**
     * 
     * @param configParamDo
     * @return
     */
    public long add(ConfigParamDo configParamDo);

    /**
     * 
     * @param id
     * @return
     */
    public ConfigParamDo getById(long id);

    /**
     * 
     * @param id
     * @return
     */
    public ConfigParamDo lockById(long id);

    /**
     * 
     * @param systemName
     * @param moduleName
     * @param paramKey
     * @param status
     * @return
     */
    public List<ConfigParamDo> getByCond(String systemName, String moduleName, String paramKey,
                                         String status);

    /**
     * 
     * @param systemName
     * @param moduleName
     * @param paramKey
     * @param status
     * @param pageSize
     * @param pageNum
     * @return
     */
    public PageList<ConfigParamDo> pageQuery(String systemName, String moduleName, String paramKey,
                                             String status, int pageSize, int pageNum);

    /**
     * @param configParam
     * @return
     */
    public int update(ConfigParamDo configParamDo);

    /**
     * @param idList
     * @return
     */
    public int delete(List<Long> idList);

}
