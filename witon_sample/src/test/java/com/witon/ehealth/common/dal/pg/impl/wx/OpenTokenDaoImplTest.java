/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.impl.wx;

import java.util.Date;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseTest;
import com.witon.ehealth.common.dal.pg.dao.wx.OpenTokenDao;
import com.witon.ehealth.common.dal.pg.dbo.wx.OpenTokenDo;
import com.witon.ehealth.util.DateUtil;

/**
 * 
 * @author Administrator
 * @version $Id: OpenTokenDaoImplTest.java, v 0.1 2016年4月12日 上午11:08:49 Administrator Exp $
 */
public class OpenTokenDaoImplTest extends BaseTest {

    @Test
    public void test_add_001() {
        try {
            OpenTokenDao dao = getContext().getBean(OpenTokenDao.class);
            OpenTokenDo token = new OpenTokenDo();
            token.setAppId("appId");
            token.setAppType("app_type");
            token.setGmtEffect(new Date());
            token.setGmtExpire(DateUtil.addDays(new Date(), 2));
            token.setAccessToken("accessToken");
            token.setMemo("test_xxx");
            long id = dao.add(token);
            logger.info("{}", id);

            logger.info("{}", dao.getById(id));
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
