/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.cglib;

import org.junit.Test;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: StaticInitTest.java, v 0.1 2017年2月24日 下午5:04:30 song.li@witontek.com Exp $
 */
public class StaticInitTest {

    
    public static class ConstClass {
        static {
            System.out.println("ConstClass init.");
        }
        
        public static final String HELLO = "hello world";
    }
    public static class SuperClass {
        static {
            System.out.println("SuperClass init.");
        }
        
        public static int value = 1111;
    }
    
    public static class SubClass extends SuperClass {
        static {
            System.out.println("SubClass init.");
        }
    }
    
   
    
    @Test
    public void test_001() {
        // 只初始化：直接定义此字段的类
        System.out.println(SubClass.value);
    }
    
    @Test
    public void test_002() {
        // 作为类型声明时，不进行初始化
        SuperClass[] sca = new SuperClass[10];
        System.out.println(sca == null);
    }

    @Test
    public void test_003() {
        // 常量对象编译阶段初始化
        System.out.println(ConstClass.HELLO);
    }
}
