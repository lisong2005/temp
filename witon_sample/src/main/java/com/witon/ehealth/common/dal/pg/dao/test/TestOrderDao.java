/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dao.test;

import com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TestOrderDao.java, v 0.1 2016年1月20日 上午10:36:37 song.li@witontek.com Exp $
 */
public interface TestOrderDao {

    public long add(TestOrderDo order);

    public long add2(TestOrderDo order);

    public TestOrderDo getById(long id);

    public TestOrderDo getByIdNew(long id);

    public TestOrderDo getByIdNew2(long id);
}
