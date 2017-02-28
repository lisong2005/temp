/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.common.dal.log;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.util.profiler.Profiler;

/**
 * dao性能摘要日志拦截器
 * 
 * @author song.li@witontek.com
 * @version $Id: DalDigestLogInterceptor.java, v 0.1 2014年7月31日 上午9:31:09 song.li@witontek.com Exp $
 */
public class DalDigestLogInterceptor implements MethodInterceptor {
    /**
    * Logger for this class
    */
    private static final Logger logger       = LoggerFactory
        .getLogger(DalDigestLogInterceptor.class);

    /** 摘要日志存储文件 */
    private final static Logger digestLogger = LoggerFactory.getLogger("EHEALTH-DAL-DIGEST");

    // [接口.方法名,耗时,成功失败]
    /** 日志格式 */
    private static final String FORMAT_STR   = "[%s.%s,%sms,%s]";

    /** 
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.debug("{}", invocation);
        //        DataSource dataSource = null;
        //        try {
        //            SqlSessionTemplate st = (SqlSessionTemplate) ((SqlSessionDaoSupport) invocation
        //                .getThis()).getSqlSession();
        //            dataSource = st.getSqlSessionFactory().getConfiguration().getEnvironment()
        //                .getDataSource();
        //
        //            logger.warn("{}", dataSource);
        //        } catch (Exception e) {
        //            logger.warn("获取数据源名称发生异常,dataSource=" + invocation.getThis().getClass(), e);
        //        }

        Method method = invocation.getMethod();
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        Profiler.enter(String.format("%s.%s", className, methodName));

        String logStr = null;
        long startTime = System.currentTimeMillis();
        try {
            Object result = invocation.proceed();
            logStr = String.format(FORMAT_STR, className, methodName,
                (System.currentTimeMillis() - startTime), 'S');
            return result;
        } catch (Throwable e) {
            logStr = String.format(FORMAT_STR, className, methodName,
                (System.currentTimeMillis() - startTime), 'E');
            // logger.error("DAO系统异常 msg={}", e.getMessage());
            throw e;
        } finally {
            // do logger
            digestLogger.info(logStr);
            Profiler.release();
        }
    }

}
