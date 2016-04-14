/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.test;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao;
import com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo;
import com.witon.ehealth.util.money.Money;

/**
 * 
 * @author Administrator
 * @version $Id: TestOrderDaoImplTest.java, v 0.1 2016年4月1日 下午3:12:27 Administrator Exp $
 */
public class TestOrderDaoImplTest extends BaseTest {

    @Test
    public void test_add_001() {
        try {
            TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            TestOrderDo order = new TestOrderDo();
            order.setAmount(new Money(12));
            order.setMemo("test_xxx");
            order.setTradeNo("111");
            long id = dao.add(order);
            logger.info("{}", id);

            logger.info("{}", dao.getById(id));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_add_002() {
        try {
            TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            TestOrderDo order = new TestOrderDo();
            order.setAmount(new Money(12));
            order.setMemo("222");
            order.setTradeNo("222");
            long id = dao.add2(order);
            logger.info("{}", id);

            logger.info("{}", dao.getById(id));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_getById() {
        try {
            TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            logger.info("{}", dao.getById(1L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_getById_new_001() {
        try {
            TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            logger.info("{}", dao.getByIdNew(1L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_getById_new_002() {
        try {
            TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            logger.info("{}", dao.getByIdNew2(1L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
