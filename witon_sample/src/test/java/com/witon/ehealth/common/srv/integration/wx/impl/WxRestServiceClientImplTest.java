/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.impl;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.common.srv.integration.wx.WxRestServiceClient;
import com.witon.ehealth.common.srv.integration.wx.req.WxOpenTokenReq;

/**
 * 
 * @author Administrator
 * @version $Id: WxRestServiceClientImplTest.java, v 0.1 2016年4月12日 下午4:55:01 Administrator Exp $
 */
public class WxRestServiceClientImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WxRestServiceClient client = getContext().getBean(WxRestServiceClient.class);
            WxOpenTokenReq req = new WxOpenTokenReq();
            req.setAppId("aaa");
            req.setAppSecret("xxx");

            logger.info("{}", client.refreshOpenToken(req));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
