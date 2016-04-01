/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.comm;

import java.util.List;

import com.witon.ehealth.common.dal.pg.dbo.comm.PageList;
import com.witon.ehealth.core.model.comm.model.ConfigParam;
import com.witon.ehealth.core.model.comm.req.ConfigParamPageQueryReq;
import com.witon.ehealth.core.model.comm.req.CongfigParamQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ConfigParamRepository.java, v 0.1 2015年3月25日 下午3:11:16 song.li@witontek.com Exp $
 */
public interface ConfigParamRepository {

    public long add(ConfigParam configParam);

    public ConfigParam getById(long id);

    public ConfigParam lockById(long id);

    public PageList<ConfigParam> pageQuery(ConfigParamPageQueryReq pageQueryCond);

    public List<ConfigParam> getByCond(CongfigParamQueryReq cond);

    public int update(ConfigParam configParam);

    public int delete(List<Long> idList);
}
