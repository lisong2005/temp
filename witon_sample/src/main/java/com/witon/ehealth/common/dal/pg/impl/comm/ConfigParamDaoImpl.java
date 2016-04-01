/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.comm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao;
import com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo;
import com.witon.ehealth.common.dal.pg.dbo.comm.PageList;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ConfigParamDaoImpl.java, v 0.1 2015年3月25日 上午10:23:48 song.li@witontek.com Exp $
 */
public class ConfigParamDaoImpl extends SqlSessionDaoSupport implements ConfigParamDao {

    /**
     * Logger for this class
     */
    private static final Logger logger    = LoggerFactory.getLogger(ConfigParamDaoImpl.class);

    /** NAMESPACE */
    private static final String NAMESPACE = ConfigParamDao.class.getName();

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#add(com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo)
     */
    @Override
    public long add(ConfigParamDo configParamDo) {
        int size = getSqlSession().insert(NAMESPACE + ".add", configParamDo);
        logger.debug("insert size = {}", size);
        Assert.isTrue(size == 1, String.format("insert error. do={}", configParamDo));
        return configParamDo.getId();
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#getById(long)
     */
    @Override
    public ConfigParamDo getById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".getById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#lockById(long)
     */
    @Override
    public ConfigParamDo lockById(long id) {
        return getSqlSession().selectOne(NAMESPACE + ".lockById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#getByCond(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<ConfigParamDo> getByCond(String systemName, String moduleName, String paramKey,
                                         String status) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("systemName", systemName);
        params.put("moduleName", moduleName);
        params.put("paramKey", paramKey);
        params.put("status", status);
        return getSqlSession().selectList(NAMESPACE + ".getByCond", params);
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#pageQuery(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
     */
    @Override
    public PageList<ConfigParamDo> pageQuery(String systemName, String moduleName, String paramKey,
                                             String status, int pageSize, int pageNum) {
        PageList<ConfigParamDo> result = new PageList<ConfigParamDo>();
        result.setPageSize(pageSize);
        result.setPageNum(pageNum);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("systemName", systemName);
        params.put("moduleName", moduleName);
        params.put("paramKey", paramKey);
        params.put("status", status);

        long count = getSqlSession().selectOne(NAMESPACE + ".pageQueryCount", params);

        result.setTotalCount(count);
        result.setMaxPageNum(Math.round(Math.ceil(count * 1.0 / pageSize)));
        if (result.getPageNum() > result.getMaxPageNum()) {
            result.setPageNum(1); // 重置到首页
        }

        params.put("limit", pageSize);
        params.put("offset", pageSize * (result.getPageNum() - 1));

        if (count <= 0) {
            return result;
        }
        List<ConfigParamDo> list = getSqlSession().selectList(NAMESPACE + ".pageQuery", params);

        result.setResultList(list);

        return result;
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#update(com.witon.ehealth.common.dal.pg.dbo.comm.ConfigParamDo)
     */
    @Override
    public int update(ConfigParamDo configParamDo) {
        return getSqlSession().update(NAMESPACE + ".update", configParamDo);
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao#delete(java.util.List)
     */
    @Override
    public int delete(List<Long> idList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idList", idList);
        return getSqlSession().delete(NAMESPACE + ".delete", params);
    }

}
