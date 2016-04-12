/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.witon.ehealth.core.service.wx.enums.WxMsgTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;
import com.witon.ehealth.util.wx.EhWxConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgExecutorForEvent.java, v 0.1 2015年1月13日 下午1:16:06 song.li@witontek.com Exp $
 */
public class WxMsgExecutorForEvent extends AbstractWxMsgExecutor implements InitializingBean {

    /**  */
    private Map<String, WxEventExecutor> routes = new HashMap<String, WxEventExecutor>();

    /**  */
    private List<WxEventExecutor>        list;

    /**  */
    private WxEventExecutor              defalutExecutor;

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxMsgExecutor#getMsgType()
     */
    @Override
    public WxMsgTypeEnum getMsgType() {
        return WxMsgTypeEnum.EVENT;
    }

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxMsgExecutor#execute(WxMsgExeRequest)
     */
    @Override
    public WxRetMsg execute(WxMsgExeRequest req) {
        logger.info("{}", req);

        String eventType = req.getParams().get(EhWxConstants.E_EVENT);

        WxEventExecutor exe = routes.get(eventType);
        if (exe == null) {
            //            WxRetMsg ret = new WxRetMsg();
            //            ret.setSuccess(false);
            //            ret.setResultMsg("处理器未找到 eventType=" + eventType);
            //            return ret;
            return defalutExecutor.execute(req);
        }
        return exe.execute(req);
    }

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for (WxEventExecutor item : list) {
            routes.put(item.getEventType().getCode(), item);
        }

        logger.info("[init]WxMsgExecutorForEvent初始化成功 size={}", routes.size());
    }

    /**
     * Setter method for property <tt>routes</tt>.
     * 
     * @param routes value to be assigned to property routes
     */
    public void setRoutes(Map<String, WxEventExecutor> routes) {
        this.routes = routes;
    }

    /**
     * Setter method for property <tt>list</tt>.
     * 
     * @param list value to be assigned to property list
     */
    public void setList(List<WxEventExecutor> list) {
        this.list = list;
    }

    /**
     * Setter method for property <tt>defalutExecutor</tt>.
     * 
     * @param defalutExecutor value to be assigned to property defalutExecutor
     */
    public void setDefalutExecutor(WxEventExecutor defalutExecutor) {
        this.defalutExecutor = defalutExecutor;
    }

}
