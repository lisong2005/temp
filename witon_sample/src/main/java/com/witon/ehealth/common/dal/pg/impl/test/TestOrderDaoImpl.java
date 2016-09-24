/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.test;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao;
import com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TestOrderDaoImpl.java, v 0.1 2016年1月20日 上午10:39:16 song.li@witontek.com Exp $
 */
public class TestOrderDaoImpl extends SqlSessionDaoSupport implements TestOrderDao {

    /**
     * Logger for this class
     */
    private static final Logger logger    = LoggerFactory.getLogger(TestOrderDaoImpl.class);

    /** NAMESPACE */
    private static final String NAMESPACE = TestOrderDao.class.getName();

    /** 
     * @see com.witon.ehealth.common.dal.dao.test.TestOrderDao#add(com.witon.ehealth.common.dal.dbo.test.TestOrderDo)
     */
    @Override
    public long add(TestOrderDo order) {
        logger.info("{}", order);
        int size = getSqlSession().insert(NAMESPACE + ".add", order);

        logger.debug("insert result size={}", size);
        return order.getId();
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.test.TestOrderDao#add2(com.witon.ehealth.common.dal.dbo.test.TestOrderDo)
     */
    @Override
    public long add2(TestOrderDo order) {
        logger.info("{}", order);
        int size = getSqlSession().insert(NAMESPACE + ".add2", order);

        logger.debug("insert result size={}", size);
        return order.getId();
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.test.TestOrderDao#getById(long)
     */
    @Override
    public TestOrderDo getById(long id) {
        logger.info("getById ,id={}", id);

        return getSqlSession().selectOne(NAMESPACE + ".getById", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.test.TestOrderDao#getByIdNew(long)
     */
    @Override
    public TestOrderDo getByIdNew(long id) {
        logger.info("getByIdNew ,id={}", id);
        return getSqlSession().selectOne(NAMESPACE + ".getByIdNew", id);
    }

    /** 
     * @see com.witon.ehealth.common.dal.dao.test.TestOrderDao#getByIdNew2(long)
     */
    @Override
    public TestOrderDo getByIdNew2(long id) {
        logger.info("getByIdNew ,id={}", id);
        return getSqlSession().selectOne(NAMESPACE + ".getByIdNew2", id);
    }

    /** 
     * @see org.springframework.dao.support.DaoSupport#initDao()
     */
    @Override
    protected void initDao() throws Exception {
        super.initDao();
        logger.info("***********************************");
        logger.info("***********************************");
        logger.info("***********************************");
        logger.info("{}", getSqlSession());
    }

}
