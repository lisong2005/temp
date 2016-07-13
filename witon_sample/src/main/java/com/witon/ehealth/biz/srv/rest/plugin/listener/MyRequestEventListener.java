/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.biz.srv.rest.plugin.listener;

import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: MyRequestEventListener.java, v 0.1 2016年6月23日 上午9:54:56 song.li@witontek.com Exp $
 */
public class MyRequestEventListener implements RequestEventListener {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(MyRequestEventListener.class);

    private final int           requestNumber;
    private final long          startTime;

    public MyRequestEventListener(int requestNumber) {
        this.requestNumber = requestNumber;
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onEvent(RequestEvent event) {
        switch (event.getType()) {
            case RESOURCE_METHOD_START:
                logger.debug("Resource method {} started for request {}",
                    event.getUriInfo().getMatchedResourceMethod().getHttpMethod(), requestNumber);
                break;
            case FINISHED:
                logger.debug("Request {} finished. Processing time {} ms.", requestNumber,
                    (System.currentTimeMillis() - startTime));
                break;
            default:
                logger.debug("event {}", event);
        }
    }
}
