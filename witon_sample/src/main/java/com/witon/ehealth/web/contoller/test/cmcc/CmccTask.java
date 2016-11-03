/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.contoller.test.cmcc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.web.contoller.test.cmcc.util.CmccUtil;
import com.witon.ehealth.web.contoller.test.cmcc.vo.CookieItem;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CmccTask.java, v 0.1 2016年11月2日 下午3:52:05 song.li@witontek.com Exp $
 */
public class CmccTask {
    /**
    * Logger for this class
    */
    private static final Logger    logger = LoggerFactory.getLogger(CmccTask.class);

    private CookieItem             item;

    final ScheduledExecutorService exe    = Executors.newSingleThreadScheduledExecutor();

    /**
     * @param item
     */
    public CmccTask(CookieItem item) {
        super();
        this.item = item;
    }

    public void close() {
        try {
            exe.shutdownNow();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    public void run() {
        logger.info("start");
        exe.execute(new Runnable() {

            private boolean start = false;

            @Override
            public void run() {
                for (;;) {
                    try {
                        logger.info("yyyyyyyyyyyyy");
                        CmccUtil.exe_for_ls(item);
                        logger.info("{}", item);

                        // 
                        if (item.isEnable() && !start && CmccUtil.needStart()) {
                            startTimer();
                        }

                    } catch (Exception e) {
                        logger.error("{}", e.getMessage());
                        break;
                    } finally {
                        try {
                            Thread.sleep(20 * 1000);
                        } catch (InterruptedException e) {
                            logger.error("", e);
                            break;
                        }
                    }
                }
                logger.info("========================");

                try {
                    close();
                } catch (Exception e) {
                    logger.error("", e);
                }
            }

            /**
             * 
             */
            private void startTimer() {
                Date date = CmccUtil.getNext();
                item.setDate(date);

                final Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            logger.info("xxxxx");
                            if (!item.isEnable()) {
                                start = false;
                                timer.cancel();
                                return;
                            }

                            boolean result = CmccUtil.exe_for_ls(item);
                            if (result) {

                                start = false;
                                timer.cancel();
                                return;
                            } else {
                                if (System.currentTimeMillis()
                                    - item.getDate().getTime() > CmccUtil.MAX_TIME_OUT) {

                                    start = false;
                                    timer.cancel();
                                    return;
                                }
                            }
                        } catch (Exception e) {
                            logger.error("", e);
                            start = false;
                            timer.cancel();
                        }
                    }
                };

                logger.info("{}", task);
                logger.info("{}", date);

                timer.schedule(task, date, 100);

                start = true;
                logger.info("item = {}", item);
            }

        });
    }

    public static void main(String[] args) {
        String cookie = "";
        CookieItem item = new CookieItem();
        item.setId(1);
        item.setEnable(true);
        item.setCookie(cookie);

        CmccTask task = new CmccTask(item);
        task.run();

    }

}
