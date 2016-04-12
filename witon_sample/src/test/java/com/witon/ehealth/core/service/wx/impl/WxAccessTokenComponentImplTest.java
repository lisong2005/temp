/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.service.wx.WxAccessTokenComponent;

/**
 * 
 * @author Administrator
 * @version $Id: WxAccessTokenComponentImplTest.java, v 0.1 2016年4月12日 下午4:51:27 Administrator Exp $
 */
public class WxAccessTokenComponentImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WxAccessTokenComponent comp = getContext().getBean(WxAccessTokenComponent.class);
            logger.info("{}", comp.getAccessToken("wx1d165e2a1833cafc"));
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
