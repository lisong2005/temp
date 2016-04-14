/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.service.wx.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.witon.ehealth.core.service.wx.WxMsgComponent;
import com.witon.ehealth.core.service.wx.WxUserComponent;
import com.witon.ehealth.core.service.wx.enums.WxMsgTypeEnum;
import com.witon.ehealth.core.service.wx.executor.WxMsgExecutor;
import com.witon.ehealth.core.service.wx.executor.req.WxMsgExeRequest;
import com.witon.ehealth.core.service.wx.req.WxMsgReq;
import com.witon.ehealth.core.service.wx.result.WxUserInfoResult;
import com.witon.ehealth.core.service.wx.result.WxRetMsg;
import com.witon.ehealth.util.wx.EhWxConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxMsgComponentImpl.java, v 0.1 2015年1月13日 下午12:42:34 song.li@witontek.com Exp $
 */
public class WxMsgComponentImpl implements WxMsgComponent, InitializingBean {
    /**
    * Logger for this class
    */
    private static final Logger        logger       = LoggerFactory
        .getLogger(WxMsgComponentImpl.class);

    public static final String         MSG_TYPE_KEY = EhWxConstants.KEY_MSG_TYPE;

    /**  */
    private Map<String, WxMsgExecutor> routes       = new HashMap<String, WxMsgExecutor>();

    /**  */
    private List<WxMsgExecutor>        executors;

    /**  */
    @Autowired
    private WxUserComponent            wxUserComponent;

    /** 
     * @see com.witon.ehealth.core.service.wx.WxMsgComponent#process(WxMsgReq)
     */
    @Override
    public WxRetMsg process(WxMsgReq wxMsgReq) {
        logger.info("{}", wxMsgReq);
        WxRetMsg result = new WxRetMsg();

        Map<String, String> params = wxMsgReq.getParams();

        String msgType = params.get(MSG_TYPE_KEY);
        WxMsgTypeEnum msgTypeEnum = WxMsgTypeEnum.getByCode(msgType);
        if (msgTypeEnum == null) {
            logger.error("【未知消息类型】MsgType={}, params={}", msgType, params);
            result.setSuccess(false);
            return result;
        }

        // 重构：修改为查询，在关注和扫码关注事件中进行用户新增操作，允许用户信息查询失败（首次扫码关注）
        String fromUser = params.get(EhWxConstants.KEY_FROM_USER);
        // WxResult wxResult = wxUserComponent.subscribe(wxMsgReq.getAppId(), fromUser);
        WxUserInfoResult wxResult = wxUserComponent.query(wxMsgReq.getAppId(), fromUser);

        if (wxResult == null || !wxResult.isSuccess()) {
            logger.error("【查询用户信息失败】MsgType={}, params={}", msgType, params);
            result.setSuccess(false);
            return result;
        }
        //logger.info("msgType={}", msgType);
        WxMsgExecutor exe = routes.get(msgType);
        if (exe == null) {
            result.setSuccess(false);
            result.setResultMsg("处理器未找到 msgType=" + msgType);
            return result;
        }

        WxMsgExeRequest req = new WxMsgExeRequest();
        req.setParams(params);
        req.setWeixinUser(wxResult.getWeixinUser());
        //        req.setNewUserInfo(wxResult.getNewUserInfo());
        logger.info("微信事情响应请求 = {}", req);
        return exe.execute(req);
    }

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for (WxMsgExecutor item : executors) {
            routes.put(item.getMsgType().getCode(), item);
        }
        logger.info("[init]WxMsgComponent初始化成功 size={}", routes.size());
    }

    /**
     * Setter method for property <tt>executors</tt>.
     * 
     * @param executors value to be assigned to property executors
     */
    public void setExecutors(List<WxMsgExecutor> executors) {
        this.executors = executors;
    }

}
