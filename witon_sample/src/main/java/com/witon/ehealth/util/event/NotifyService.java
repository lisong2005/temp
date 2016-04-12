/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.event;

import com.witon.ehealth.util.event.model.NotifyContext;

/**
 * 通知消息发送服务接口
 * 
 * 实现者负责接收消息，立即返回；事件关注者采用异步方式处理事件消息。<br/>
 * 本服务只提供消息接收，以及消息分发
 * 
 * @author song.li@witontek.com
 * @version $Id: NotifyService.java, v 0.1 2015年12月21日 下午5:05:45 song.li@witontek.com Exp $
 */
public interface NotifyService {

    /**
     * 发送通知消息
     * 
     * @param notifyContext
     */
    public void notify(NotifyContext notifyContext);
}
