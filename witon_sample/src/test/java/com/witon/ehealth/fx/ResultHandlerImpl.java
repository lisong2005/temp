/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.fx;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ResultHandlerImpl.java, v 0.1 2016年9月22日 下午12:26:28 song.li@witontek.com Exp $
 */
public class ResultHandlerImpl implements ResultHandler {

    /** 
     * @see com.witon.ehealth.fx.ResultHandler#handleResultSets(java.sql.Statement)
     */
    @Override
    public List<Object> handleResultSets(String stmt) {
        List<Object> s = new ArrayList<Object>();
        s.add("hello");
        return s;
    }

}
