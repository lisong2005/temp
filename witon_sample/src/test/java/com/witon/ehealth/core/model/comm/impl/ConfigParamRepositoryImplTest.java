/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.model.comm.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.model.comm.ConfigParamRepository;

/**
 * 
 * @author Administrator
 * @version $Id: ConfigParamRepositoryImplTest.java, v 0.1 2016年4月1日 下午3:13:03 Administrator Exp $
 */
public class ConfigParamRepositoryImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            ConfigParamRepository repo = getContext().getBean(ConfigParamRepository.class);
            logger.info("{}", repo.getById(1L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
