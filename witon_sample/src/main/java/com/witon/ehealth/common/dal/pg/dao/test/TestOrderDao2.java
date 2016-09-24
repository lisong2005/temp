/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.pg.dao.test;

import java.util.List;

import com.witon.ehealth.common.dal.pg.dbo.test.TestOrderDo;

/**
 * 
 * @author lisong
 * @version $Id: TestOrderDao2.java, v 0.1 2016年9月24日 上午10:05:56 lisong Exp $
 */
public interface TestOrderDao2 {

    public long add(TestOrderDo order);

    public List<Long> batchInsert(List<TestOrderDo> list);

    public List<Long> batchInsert2(List<TestOrderDo> list);

    public List<Long> batchInsert3(List<TestOrderDo> list);
}
