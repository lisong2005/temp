/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.service.wx.WxUserComponent;

/**
 * 
 * @author Administrator
 * @version $Id: WxUserComponentImplTest.java, v 0.1 2016年4月12日 下午5:05:57 Administrator Exp $
 */
public class WxUserComponentImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WxUserComponent comp = getContext().getBean(WxUserComponent.class);
            logger.info("{}", comp.subscribe("", ""));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
