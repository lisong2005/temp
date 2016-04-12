/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.model.wx.OpenTokenRepository;

/**
 * 
 * @author Administrator
 * @version $Id: OpenTokenRepositoryImplTest.java, v 0.1 2016年4月12日 下午4:38:44 Administrator Exp $
 */
public class OpenTokenRepositoryImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            OpenTokenRepository repo = getContext().getBean(OpenTokenRepository.class);
            logger.info("{}", repo.getById(1L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
