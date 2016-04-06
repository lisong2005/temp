/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx;

import com.witon.ehealth.common.srv.integration.wx.req.WxJsApiTicketReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxMsgSendReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxOauthReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxOpenTokenReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxTemplateSendReq;
import com.witon.ehealth.common.srv.integration.wx.result.QrCreateResult;
import com.witon.ehealth.common.srv.integration.wx.result.WxMsgSendResult;
import com.witon.ehealth.common.srv.integration.wx.result.WxOauthResult;
import com.witon.ehealth.common.srv.integration.wx.result.WxOpenTokenResult;
import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxRestServiceClient.java, v 0.1 2015年1月13日 上午9:59:39 song.li@witontek.com Exp $
 */
public interface WxRestServiceClient {

    /**
     * 
     * @param appId
     * @param scenceId
     * @return
     */
    public QrCreateResult qrCreate(String appId, String scenceId);

    /**
     * 
     * @param appId
     * @param openId
     * @return
     */
    public WeixinUser queryUserInfo(String appId, String openId);

    /**
     * 
     * @param req
     * @return
     */
    public WxOauthResult oauthQuery(WxOauthReq req);

    /**
     * 
     * @param req
     * @return
     */
    public WxOpenTokenResult refreshOpenToken(WxOpenTokenReq req);

    /**
     * 微信jsApi ticket刷新
     * 
     * @param req
     * @return
     */
    public WxOpenTokenResult refreshJsTicket(WxJsApiTicketReq req);

    /**
     * 
     * @param req
     * @return
     */
    public WxMsgSendResult sendMsg(WxMsgSendReq req);

    /**
     * 
     * @param req
     * @return
     */
    public WxMsgSendResult sendTemplateMsg(WxTemplateSendReq req);

    /**
     * 
     * @param req
     * @return
     */
    public WxMsgSendResult getTemplateId(String templateShortId, String appI);

}
