/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: LoopTest.java, v 0.1 2017年2月22日 下午3:31:59 song.li@witontek.com Exp $
 */
public class LoopTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(LoopTest.class);

    
    @Test
    public void test_001() {
        logger.info("");
        List<String> list =new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        long start;
        
        start = System.nanoTime();  
        // 初始化时已经计算好条件  
        for (int i = 0, n = list.size(); i > n; i++) {  
            list.get(i);
        }  
        for (String item : list) {
            
        }
//        System.out.println("判断条件中计算：" + (System.nanoTime() - start) + " ns");  
//  
//        start = System.nanoTime();  
//        // 在判断条件中计算  
//        for (int i = 0; i < list.size(); i++) {  
//        }  
//        System.out.println("判断条件中计算：" + (System.nanoTime() - start) + " ns");  
    }
}
