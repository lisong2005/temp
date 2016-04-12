/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.executor;

import java.util.Date;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.witon.ehealth.core.model.wx.WeixinEventRepository;
import com.witon.ehealth.core.model.wx.model.WeixinEvent;
import com.witon.ehealth.core.model.wx.model.WeixinEvent.EventTypeEnum;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;
import com.witon.ehealth.util.wx.EhWxConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AbstractWxEventExecutor.java, v 0.1 2015年1月13日 下午1:29:10 song.li@witontek.com Exp $
 */
public abstract class AbstractWxEventExecutor implements WxEventExecutor {

    /**  */
    protected Logger              logger = LoggerFactory.getLogger(getClass());

    /**  */
    @Autowired
    private WeixinEventRepository weixinEventRepository;

    /** 
     * @see com.witon.ehealth.core.service.wx.executor.WxEventExecutor#execute(WxMsgExeRequest)
     */
    @Override
    public WxRetMsg execute(WxMsgExeRequest req) {
        Map<String, String> params = req.getParams();
        WeixinEvent weixinEvent = new WeixinEvent();
        try {
            String eventType = params.get(EhWxConstants.E_EVENT);
            weixinEvent.setWxEventType(eventType);
            weixinEvent.setEventType(EventTypeEnum.getByCode(eventType));
            weixinEvent.setEventKey(params.get(EhWxConstants.E_EVENT_KEY));
            weixinEvent.setFromUser(params.get(EhWxConstants.KEY_FROM_USER));
            weixinEvent.setToUser(params.get(EhWxConstants.KEY_TO_USER));
            weixinEvent.setEventProps(new JSONObject(params));
            weixinEvent.setGmtUpload(
                new Date(1000L * Long.parseLong(params.get(EhWxConstants.KEY_CREATE_TIME))));
            weixinEventRepository.add(weixinEvent);
        } catch (Exception e) {
            logger.error(String.format("【微信事件保存失败】req=%s", req), e);
        }

        // 核心事件处理逻辑
        return process(req, weixinEvent);
    }

    /**
     * 
     * @param req 
     * @param weixinEvent
     * @return
     */
    protected abstract WxRetMsg process(WxMsgExeRequest req, WeixinEvent weixinEvent);

}
