/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.model.wx.WxAppConfigRepository;

/**
 * 
 * @author Administrator
 * @version $Id: WxAppConfigRepositoryImplTest.java, v 0.1 2016年4月12日 下午4:36:16 Administrator Exp $
 */
public class WxAppConfigRepositoryImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WxAppConfigRepository repo = getContext().getBean(WxAppConfigRepository.class);
            logger.info("{}", repo.getDefault());
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
