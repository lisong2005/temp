/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.biz.daemon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AbstractTask.java, v 0.1 2015年12月25日 下午4:18:34 song.li@witontek.com Exp $
 */
public abstract class AbstractTask implements Task {
    /**
    * Logger for this class
    */
    protected final Logger      logger     = LoggerFactory.getLogger(getClass());

    private static final Logger DIGEST_LOG = LoggerFactory.getLogger("EHEALTH-BIZ-DAEMON-DIGEST");

    private static final String FORMAT_STR = "[%s,%sms,%s]";

    /** 
     * @see com.witon.ehealth.biz.daemon.Task#run()
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String success = "S";
        try {
            execute();
        } catch (Throwable e) {
            logger.error(String.format("【定时任务异常】error=%s", e.getMessage()), e);
            success = "E";
        } finally {
            long endTime = System.currentTimeMillis();
            String clazzName = this.getClass().getSimpleName();

            DIGEST_LOG.info(String.format(FORMAT_STR, clazzName, (endTime - startTime), success));
        }
    }

}
