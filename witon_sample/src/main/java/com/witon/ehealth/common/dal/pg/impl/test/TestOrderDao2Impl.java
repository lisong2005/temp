/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao2;
import com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo;

/**
 * 
 * http://stackoverflow.com/questions/23486547/mybatis-batch-insert-update-for-oracle
 * 
 * @author lisong
 * @version $Id: TestOrderDao2Impl.java, v 0.1 2016年9月24日 上午10:07:15 lisong Exp $
 */
public class TestOrderDao2Impl extends SqlSessionDaoSupport implements TestOrderDao2 {
    /**
    * Logger for this class
    */
    private static final Logger logger    = LoggerFactory.getLogger(TestOrderDao2Impl.class);

    /** NAMESPACE */
    private static final String NAMESPACE = TestOrderDao2.class.getName();

    private SqlSessionTemplate  sqlSessionForBatch;

    private SqlSessionTemplate  sqlSession;

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao2#add(com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo)
     */
    @Override
    public long add(TestOrderDo order) {
        return 0;
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao2#batchInsert(java.util.List)
     */
    @Override
    public List<Long> batchInsert(List<TestOrderDo> list) {
        logger.info("xx = {}", getSqlSession());
        logger.info("xx = {}", this.sqlSession);
        logger.info("xx = {}", getSqlSession().getConnection());
        logger.info("xx = {}", this.sqlSession.getConnection());

        SqlSession batchSession = ((SqlSessionTemplate) getSqlSession()).getSqlSessionFactory()
            .openSession(ExecutorType.BATCH, false);
        logger.info("xx = {}", batchSession);
        //        logger.info("xx = {}", this.sqlSessionForBatch.getConnection());

        List<Long> retIds = new ArrayList<Long>();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("list", list);
        int size = batchSession.insert(NAMESPACE + ".addBatch", params);
        logger.info("{}", size);
        logger.info("{}", params);

        for (TestOrderDo item : list) {
            retIds.add(item.getId());
        }
        return retIds;
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao2#batchInsert2(java.util.List)
     */
    @Override
    public List<Long> batchInsert2(List<TestOrderDo> list) {

        List<Long> retIds = new ArrayList<Long>();

        SqlSession batchSession = ((SqlSessionTemplate) getSqlSession()).getSqlSessionFactory()
            .openSession(ExecutorType.BATCH, false);

        for (TestOrderDo item : list) {
            int size = batchSession.insert(NAMESPACE + ".add", item);
            logger.info("size = {}", size);
            retIds.add(item.getId());
        }
        List<BatchResult> r = batchSession.flushStatements();
        logger.info("{}", r);
        showBr(r);
        return retIds;
    }

    /** 
     * @see com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao2#batchInsert3(java.util.List)
     */
    @Override
    public List<Long> batchInsert3(List<TestOrderDo> list) {

        List<Long> retIds = new ArrayList<Long>();

        try (SqlSession batchSession = ((SqlSessionTemplate) getSqlSession()).getSqlSessionFactory()
            .openSession(ExecutorType.BATCH, false);) {

            logger.info("xx = {}", batchSession);

            logger.info("xx = {}", getSqlSession().getConnection());
            logger.info("xx = {}", this.sqlSession.getConnection());
            logger.info("xx = {}", batchSession.getConnection());

            int batchSize = 5;
            long bs = Math.round(Math.ceil(list.size() * 1.0 / batchSize));

            for (int i = 0; i < bs; i++) {
                for (int j = 0; j < batchSize; j++) {
                    int index = i * batchSize + j;
                    if (index >= list.size()) {
                        break;
                    }
                    TestOrderDo item = list.get(index);
                    int size = batchSession.insert(NAMESPACE + ".add2", item);
                    logger.debug("size = {}", size);
                    retIds.add(item.getId());
                }
                List<BatchResult> r = batchSession.flushStatements();
                logger.info("{}", r);
                showBr(r);
            }

        }

        return retIds;
    }

    private void showBr(List<BatchResult> list) {
        for (BatchResult r : list) {
            logger.info("{}", r.getUpdateCounts());
            logger.info("{}", r.getSql());
            logger.info("{}", r.getMappedStatement());
        }
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
        logger.info("{}", this.sqlSessionForBatch);
        logger.info("{}", this.sqlSession.getSqlSessionFactory());
        logger.info("{}", this.sqlSessionForBatch.getSqlSessionFactory());
        // logger.info("{}", this.sqlSession.getConnection());
        // logger.info("{}", this.sqlSessionForBatch.getConnection());
    }

    /**
     * Setter method for property <tt>sqlSessionForBatch</tt>.
     * 
     * @param sqlSessionForBatch value to be assigned to property sqlSessionForBatch
     */
    public void setSqlSessionForBatch(SqlSessionTemplate sqlSessionForBatch) {
        this.sqlSessionForBatch = sqlSessionForBatch;
    }

    /**
     * Setter method for property <tt>sqlSession</tt>.
     * 
     * @param sqlSession value to be assigned to property sqlSession
     */
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

}
