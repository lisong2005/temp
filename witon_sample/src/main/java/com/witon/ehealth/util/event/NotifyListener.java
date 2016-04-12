/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.event;

import com.witon.ehealth.util.event.model.NotifyContext;

/**
 * 事件关注者监听接口
 * 
 * 实现者对事件主体进行解析和处理
 * 
 * @author song.li@witontek.com
 * @version $Id: NotifyListener.java, v 0.1 2015年12月21日 下午5:26:56 song.li@witontek.com Exp $
 */
public interface NotifyListener {

    /**
     * 
     * @param notifyContext
     */
    public void execute(NotifyContext notifyContext);
}
