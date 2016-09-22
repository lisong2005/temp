/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.fx;

import java.util.List;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ResultHandler.java, v 0.1 2016年9月22日 下午12:25:32 song.li@witontek.com Exp $
 */
public interface ResultHandler {

    public <E> List<E> handleResultSets(String stmt);
}
