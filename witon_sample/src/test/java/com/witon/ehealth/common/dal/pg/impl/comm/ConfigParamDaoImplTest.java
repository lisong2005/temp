/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.comm;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.common.dal.pg.dao.comm.ConfigParamDao;

/**
 * 
 * @author Administrator
 * @version $Id: ConfigParamDaoImplTest.java, v 0.1 2016年4月1日 下午3:09:05 Administrator Exp $
 */
public class ConfigParamDaoImplTest extends BaseTest {

    @Test
    public void test_getById() {
        try {
            ConfigParamDao dao = getContext().getBean(ConfigParamDao.class);
            logger.info("{}", dao.getById(1L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
