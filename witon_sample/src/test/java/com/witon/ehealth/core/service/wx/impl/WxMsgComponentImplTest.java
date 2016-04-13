/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;
import com.witon.ehealth.core.service.wx.WxMsgComponent;
import com.witon.ehealth.core.service.wx.enums.WxMsgTypeEnum;
import com.witon.ehealth.core.service.wx.req.WxMsgReq;
import com.witon.ehealth.util.wx.EhWxConstants;

/**
 * 
 * @author Administrator
 * @version $Id: WxMsgComponentImplTest.java, v 0.1 2016年4月12日 下午5:08:29 Administrator Exp $
 */
public class WxMsgComponentImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WxMsgComponent comp = getContext().getBean(WxMsgComponent.class);

            Map<String, String> params = new HashMap<String, String>();
            params.put(EhWxConstants.KEY_FROM_USER, "ouf3ytx8GektXcQQk1ekiGo0bVn4");
            params.put(EhWxConstants.KEY_MSG_TYPE, WxMsgTypeEnum.TEXT.getCode());

            WxMsgReq wxMsgReq = new WxMsgReq();
            wxMsgReq.setAppId("Default");
            wxMsgReq.setAsync(false);
            wxMsgReq.setParams(params);

            logger.info("{}", comp.process(wxMsgReq));

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void test_002() {
        try {
            WxMsgComponent comp = getContext().getBean(WxMsgComponent.class);

            Map<String, String> params = new HashMap<String, String>();
            params.put(EhWxConstants.KEY_FROM_USER, "ouf3ytx8GektXcQQk1ekiGo0bVn4");
            params.put(EhWxConstants.KEY_MSG_TYPE, WxMsgTypeEnum.EVENT.getCode());
            params.put(EhWxConstants.KEY_CREATE_TIME, "" + System.currentTimeMillis() / 1000);
            params.put(EhWxConstants.E_EVENT, EventTypeEnum.CLICK.getCode());

            WxMsgReq wxMsgReq = new WxMsgReq();
            wxMsgReq.setAppId("Default");
            wxMsgReq.setAsync(false);
            wxMsgReq.setParams(params);

            logger.info("{}", comp.process(wxMsgReq));

        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
