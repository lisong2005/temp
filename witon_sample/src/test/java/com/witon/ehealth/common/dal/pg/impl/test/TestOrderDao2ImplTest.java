/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao;
import com.witon.ehealth.common.dal.pg.dao.test.TestOrderDao2;
import com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo;
import com.witon.ehealth.util.money.Money;

/**
 * 
 * @author lisong
 * @version $Id: TestOrderDao2ImplTest.java, v 0.1 2016年9月24日 上午11:00:14 lisong Exp $
 */
public class TestOrderDao2ImplTest extends BaseTest {

    @Test
    public void test_add_001() {
        try {
            TransactionTemplate tranactionTemplate = getContext().getBean("transactionTemplate",
                TransactionTemplate.class);

            final TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            final TestOrderDao2 dao2 = getContext().getBean(TestOrderDao2.class);

            tranactionTemplate.execute(new TransactionCallback<Boolean>() {

                @Override
                public Boolean doInTransaction(TransactionStatus status) {
                    try {

                        {
                            List<TestOrderDo> list = new ArrayList<TestOrderDo>();
                            for (int i = 0; i < 2; i++) {
                                TestOrderDo order = new TestOrderDo();
                                order.setAmount(new Money(i));
                                order.setMemo("yy" + i);
                                order.setTradeNo("zz:" + i);
                                list.add(order);
                            }
                            logger.info("{}", dao2.batchInsert(list));
                        }

                        {
                            TestOrderDo order = new TestOrderDo();
                            order.setAmount(new Money(1111));
                            order.setMemo("sdfafd");
                            order.setTradeNo("yyy");
                            logger.info("{}", dao.add(order));
                        }

                        // status.setRollbackOnly();
                        logger.info("success");
                        logger.info("success");
                        logger.info("success");
                    } catch (Exception e) {
                        status.setRollbackOnly();
                        logger.error("", e);
                    }
                    return Boolean.TRUE;
                }

            });
            logger.info("end");
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_add_002() {
        try {
            TransactionTemplate tranactionTemplate = getContext().getBean("transactionTemplate",
                TransactionTemplate.class);

            final TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            final TestOrderDao2 dao2 = getContext().getBean(TestOrderDao2.class);

            tranactionTemplate.execute(new TransactionCallback<Boolean>() {

                @Override
                public Boolean doInTransaction(TransactionStatus status) {
                    try {

                        {
                            List<TestOrderDo> list = new ArrayList<TestOrderDo>();
                            for (int i = 0; i < 3; i++) {
                                TestOrderDo order = new TestOrderDo();
                                order.setAmount(new Money(i));
                                order.setMemo("yy" + i);
                                order.setTradeNo("zz:" + i);
                                list.add(order);
                            }
                            logger.info("{}", dao2.batchInsert2(list));
                        }

                        {
                            TestOrderDo order = new TestOrderDo();
                            order.setAmount(new Money(1111));
                            order.setMemo("sdfafd");
                            order.setTradeNo("yyy");
                            logger.info("{}", dao.add(order));
                        }

                        // status.setRollbackOnly();
                        logger.info("success");
                        logger.info("success");
                        logger.info("success");
                    } catch (Exception e) {
                        status.setRollbackOnly();
                        logger.error("", e);
                    }
                    return Boolean.TRUE;
                }

            });
            logger.info("end");
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_add_003() {
        try {
            TransactionTemplate tranactionTemplate = getContext().getBean("transactionTemplate",
                TransactionTemplate.class);

            final TestOrderDao dao = getContext().getBean(TestOrderDao.class);
            final TestOrderDao2 dao2 = getContext().getBean(TestOrderDao2.class);

            tranactionTemplate.execute(new TransactionCallback<Boolean>() {

                @Override
                public Boolean doInTransaction(TransactionStatus status) {
                    try {

                        {
                            List<TestOrderDo> list = new ArrayList<TestOrderDo>();
                            for (int i = 0; i < 7; i++) {
                                TestOrderDo order = new TestOrderDo();
                                order.setAmount(new Money(i));
                                order.setMemo("dfaad" + i);
                                order.setTradeNo("zz:" + i);
                                list.add(order);
                            }
                            logger.info("{}", dao2.batchInsert3(list));
                        }

                        {
                            TestOrderDo order = new TestOrderDo();
                            order.setAmount(new Money(1111));
                            order.setMemo("sdfafd");
                            order.setTradeNo("yyy");
                            logger.info("{}", dao.add(order));
                        }

                        // status.setRollbackOnly();
                        logger.info("success");
                        logger.info("success");
                        logger.info("success");
                    } catch (Exception e) {
                        status.setRollbackOnly();
                        logger.error("", e);
                    }
                    return Boolean.TRUE;
                }

            });
            logger.info("end");
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
