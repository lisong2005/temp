/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.impl;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.core.model.wx.WeixinEventRepository;
import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;

/**
 * 
 * @author Administrator
 * @version $Id: WeixinEventRepositoryImplTest.java, v 0.1 2016年4月12日 下午4:38:59 Administrator Exp $
 */
public class WeixinEventRepositoryImplTest extends BaseTest {

    @Test
    public void test_001() {
        try {
            WeixinEventRepository repo = getContext().getBean(WeixinEventRepository.class);

            WeixinEvent weixinEvent = new WeixinEvent();
            weixinEvent.setEventKey("ek");
            weixinEvent.setEventProps(new JSONObject());
            weixinEvent.setFromUser("from_user");
            weixinEvent.setToUser("to_user");
            weixinEvent.setEventType(EventTypeEnum.CLICK);

            long id = repo.add(weixinEvent);

            logger.info("{}", repo.getById(id));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
