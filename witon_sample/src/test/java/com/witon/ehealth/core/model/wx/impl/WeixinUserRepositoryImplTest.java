/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.model.wx.WeixinUserRepository;

/**
 * 
 * @author Administrator
 * @version $Id: WeixinUserRepositoryImplTest.java, v 0.1 2016年4月12日 下午4:39:12 Administrator Exp $
 */
public class WeixinUserRepositoryImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WeixinUserRepository repo = getContext().getBean(WeixinUserRepository.class);

            logger.info("{}", repo.getById(61L));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
