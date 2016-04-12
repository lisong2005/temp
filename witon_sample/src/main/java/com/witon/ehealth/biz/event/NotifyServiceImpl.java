/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.biz.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.util.event.NotifyListener;
import com.witon.ehealth.util.event.NotifyService;
import com.witon.ehealth.util.event.model.NotifyContext;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: NotifyServiceImpl.java, v 0.1 2015年12月22日 上午8:32:46 song.li@witontek.com Exp $
 */
public class NotifyServiceImpl implements NotifyService, InitializingBean {
    /**
    * Logger for this class
    */
    private static final Logger                     logger     = LoggerFactory
        .getLogger(NotifyServiceImpl.class);

    private static final Logger                     DIGEST_LOG = LoggerFactory
        .getLogger("EHEALTH-BIZ-EVENT-DIGEST");

    private static final String                     FORMAT_STR = "[%s,%sms,%s]";

    /**  */
    private Map<String, List<NotifyListener>>       routes     = new HashMap<String, List<NotifyListener>>();

    /**  */
    private final ExecutorService                   exe        = Executors
        .newSingleThreadExecutor();

    /**  */
    private static final int                        MAX_SIZE   = 128;

    /**  */
    private final ArrayBlockingQueue<NotifyContext> queue      = new ArrayBlockingQueue<NotifyContext>(
        MAX_SIZE);

    @Autowired
    private ThreadPoolTaskExecutor                  taskExecutor;

    /** 
     * @see com.witon.ehealth.common.service.facade.common.notify.NotifyService#notify(com.witon.ehealth.common.service.facade.common.notify.model.NotifyContext)
     */
    @Override
    public void notify(NotifyContext notifyContext) {
        logger.debug("【消息队列】添加消息 {}", notifyContext);
        boolean addResult = queue.offer(notifyContext);
        logger.info("【消息队列】添加消息结果 {}", addResult);
    }

    /**
     * Getter method for property <tt>routes</tt>.
     * 
     * @return property value of routes
     */
    public Map<String, List<NotifyListener>> getRoutes() {
        return routes;
    }

    /**
     * Setter method for property <tt>routes</tt>.
     * 
     * @param routes value to be assigned to property routes
     */
    public void setRoutes(Map<String, List<NotifyListener>> routes) {
        this.routes = routes;
    }

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("【通知处理器】routes = {}", routes);
        exe.execute(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        final NotifyContext nc = queue.poll(1, TimeUnit.SECONDS);

                        if (nc == null) {
                            continue;
                        }

                        String eventKey = nc.getEventKey();
                        List<NotifyListener> ls = routes.get(eventKey);

                        if (CollectionUtils.isEmpty(ls)) {
                            logger.info("【消息处理】不存在关注此消息的listener. [eventkey={}]", eventKey);
                            continue;
                        }

                        for (final NotifyListener listener : ls) {
                            if (listener == null) {
                                logger.warn("【listener为空】{}", ToStringBuilder.reflectionToString(ls,
                                    ToStringStyle.SHORT_PREFIX_STYLE));
                                continue;
                            }

                            // 异步调用 listener 的处理方法
                            taskExecutor.execute(new Runnable() {
                                @Override
                                public void run() {
                                    long startTime = System.currentTimeMillis();
                                    String success = "S";

                                    try {
                                        listener.execute(nc);
                                    } catch (Throwable e) {
                                        success = "E";
                                        logger.error(
                                            String.format("【消息处理】error=%s", e.getMessage()), e);
                                    } finally {
                                        long endTime = System.currentTimeMillis();
                                        String clazzName = listener.getClass().getSimpleName();

                                        DIGEST_LOG.info(String.format(FORMAT_STR, clazzName,
                                            (endTime - startTime), success));
                                    }
                                }
                            });
                        }

                    } catch (Throwable e) {
                        logger.error(String.format("【消息处理】error=%s", e.getMessage()), e);
                    }
                }
            }
        });
    }

}
