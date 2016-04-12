/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.biz.daemon;

/**
 * 定时任务接口定义
 * 
 * @author song.li@witontek.com
 * @version $Id: Task.java, v 0.1 2015年1月9日 下午2:45:25 song.li@witontek.com Exp $
 */
public interface Task {

    /**
     * 定时任务处理
     */
    public void execute();

    /**
     * 
     */
    public void run();
}
