/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.jdk8.xx;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Test.java, v 0.1 2017年6月16日 下午4:24:16 song.li@witontek.com Exp $
 */
public class Test {
    public static void main(String[] args) {
        TestBean1 bean1 = new TestBean1();
        bean1.test(TestBean1::method2);

        TestBean2 bean2 = new TestBean2();
        bean2.test(TestBean1::method2);
    }
}
