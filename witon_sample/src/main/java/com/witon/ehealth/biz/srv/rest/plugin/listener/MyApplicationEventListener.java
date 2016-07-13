/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin.listener;

import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: MyApplicationEventListener.java, v 0.1 2016年6月23日 上午9:52:03 song.li@witontek.com Exp $
 */
public class MyApplicationEventListener implements ApplicationEventListener {

    /**
    * Logger for this class
    */
    private static final Logger logger     = LoggerFactory
        .getLogger(MyApplicationEventListener.class);

    private volatile int        requestCnt = 0;

    @Override
    public void onEvent(ApplicationEvent event) {
        switch (event.getType()) {
            case INITIALIZATION_FINISHED:
                logger.debug("Application {} was initialized.",
                    event.getResourceConfig().getApplicationName());
                break;
            case DESTROY_FINISHED:
                logger.debug("Application {} destroyed.",
                    event.getResourceConfig().getApplicationName());
                break;
            default:
                logger.debug("{}", event);
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        requestCnt++;
        logger.debug("Request " + requestCnt + " started.");
        // return the listener instance that will handle this request.
        return new MyRequestEventListener(requestCnt);
    }
}
