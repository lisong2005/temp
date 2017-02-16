/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.cglib;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CglibTest.java, v 0.1 2017年2月8日 上午8:40:01 song.li@witontek.com Exp $
 */
public class CglibTest {

    @Test
    public void test_002() {
        Callback[] callbacks = new Callback[] { new MethodInterceptorImpl(), NoOp.INSTANCE };

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(MyClass.class);
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new CallbackFilterImpl());

        MyClass my = (MyClass) enhancer.create();

        my.method();
        my.method2();
    }

    @Test
    public void test_001() {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(MyClass.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        MyClass my = (MyClass) enhancer.create();

        my.method();
    }

    private static class CallbackFilterImpl implements CallbackFilter {

        public int accept(Method method) {

            if (method.getName().equals("method2")) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {

        public Object intercept(Object obj, Method method, Object[] args,
                                MethodProxy proxy) throws Throwable {

            System.out.println(method);

            return proxy.invokeSuper(obj, args);
        }
    }
}
