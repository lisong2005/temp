/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.common.srv.integration.wx.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.witon.ehealth.common.base.ResultCodeEnum;
import com.witon.ehealth.common.srv.integration.wx.WxRestServiceClient;
import com.witon.ehealth.common.srv.integration.wx.req.WxJsApiTicketReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxMsgSendReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxOauthReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxOpenTokenReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxTemplateSendReq;
import com.witon.ehealth.common.srv.integration.wx.result.QrCreateResult;
import com.witon.ehealth.common.srv.integration.wx.result.WxMsgSendResult;
import com.witon.ehealth.common.srv.integration.wx.result.WxOauthResult;
import com.witon.ehealth.common.srv.integration.wx.result.WxOpenTokenResult;
import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.model.OpenToken.AppTypeEnum;
import com.witon.ehealth.core.model.wx.model.WeixinUser;
import com.witon.ehealth.core.service.wx.WxAccessTokenComponent;
import com.witon.ehealth.util.DateUtil;
import com.witon.ehealth.util.wx.model.WxNewsArticle;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WxRestServiceClientImpl.java, v 0.1 2015年1月13日 上午10:02:54 song.li@witontek.com Exp $
 */
public class WxRestServiceClientImpl implements WxRestServiceClient {

    /**
    * Logger for this class
    */
    private static final Logger    logger                 = LoggerFactory
        .getLogger(WxRestServiceClientImpl.class);

    // =====================================================
    // =====================================================

    /** 微信二维码创建接口地址 */
    //    private static final String    QR_CREATE_URL          = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";

    // =====================================================
    // =====================================================

    /** 查询关注者：微信账号信息 */
    //    private static final String    USER_INFO_URL          = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

    // =====================================================
    // =====================================================

    /** oauth 登录地址 */
    //    private static final String    OAUTH_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /** oauth 用户信息查询地址 */
    //    private static final String    OAUTH_USER_INFO_URL    = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    // =====================================================
    // =====================================================

    /** accesstoken 刷新地址 */
    private static final String    OPEN_TOKEN_REFRESH_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&"
                                                            + "appid=%s" + "&" + "secret=%s";

    /** jsapi_ticket 刷新地址 */
    private static final String    JS_TICKET_REFRESH_URL  = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

    // =====================================================
    // =====================================================

    /** TEMPLATE_SEND_URL 模板消息发送地址 */
    //    private static final String    TEMPLATE_SEND_URL      = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    /** 模板添加接口地址 */
    //    private static final String    TEMPLATE_ADD_URL       = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s";

    /** 消息发送接口地址 */
    //    private static final String    MESSAGE_SEND_URL       = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";

    // =====================================================
    // =====================================================

    /** 微信二维码 */
    private static final String    QR_SCENE               = "QR_SCENE";

    /** 微信二维码有效时间   单位秒 */
    private static final int       QR_EXPIRE_SECONDS      = 1800;

    /** 微信accessToken服务组件 */
    @Autowired
    private WxAccessTokenComponent wxAccessTokenComponent;

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#qrCreate(String, java.lang.String)
     */
    @Override
    public QrCreateResult qrCreate(String appId, String scenceId) {
        logger.info("【微信二维码】scenceId={}", scenceId);
        QrCreateResult result = new QrCreateResult();

        String accessToken = wxAccessTokenComponent.getAccessToken(appId);
        if (StringUtils.isBlank(accessToken)) {
            logger.error("【微信二维码】【access_token未找到】appId={}, accessToken={}", appId, accessToken);
            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
            return result;
        }

        try {
            JSONObject scenceInfo = new JSONObject();
            scenceInfo.put("scene_id", Long.parseLong(scenceId));
            scenceInfo.put("scene_str", scenceId);

            JSONObject actionInfo = new JSONObject();
            actionInfo.put("scene", scenceInfo);

            JSONObject request = new JSONObject();
            request.put("expire_seconds", QR_EXPIRE_SECONDS);
            request.put("action_name", QR_SCENE);
            request.put("action_info", actionInfo);

            logger.info("【微信二维码】restRequest={}", request.toString());

            //            WebResource r = c.resource(String.format(QR_CREATE_URL, accessToken));
            //
            //            String restResult = r.entity(request, MediaType.APPLICATION_JSON)
            //                .accept(MediaType.APPLICATION_JSON).post(String.class);

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com")
                .path("cgi-bin/qrcode/create").queryParam("access_token", accessToken);
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), String.class);

            logger.info("【微信二维码】restResult={}", restResult);

            JSONObject jo = new JSONObject(restResult);
            setupResult(jo, result);
        } catch (Exception e) {
            logger.error(String.format("【微信二维码】异常 error=%s", e.getMessage()), e);
            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
        }
        return result;
    }

    /**
     * 
     * @param jo
     * @param result
     * @throws JSONException
     */
    private void setupResult(JSONObject jo, QrCreateResult result) throws JSONException {
        String ticket = jo.optString("ticket");
        if (StringUtils.isNotBlank(ticket)) {
            // 成功处理结果
            String url = jo.optString("url");
            int expire_seconds = jo.getInt("expire_seconds");

            result.setSuccess(true);
            result.setTicket(ticket);
            result.setExpireDate(DateUtils.addSeconds(new Date(), expire_seconds));
            result.setUrl(url);
            return;
        } else {
            // 异常结果
            String errcode = jo.optString("errcode");
            String errmsg = jo.optString("errmsg");

            result.setSuccess(false);
            result.setResultCode(errcode);
            result.setResultMsg(errmsg);
            return;
        }
    }

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#queryUserInfo(java.lang.String, java.lang.String)
     */
    @Override
    public WeixinUser queryUserInfo(String appId, String openId) {

        String accessToken = wxAccessTokenComponent.getAccessToken(appId);
        if (StringUtils.isBlank(accessToken)) {
            logger.error("【access_token未找到】appId={}, accessToken={}", appId, accessToken);
            return null;
        }

        try {
            //            Client c = Client.create();
            //            WebResource r = c.resource(String.format(USER_INFO_URL, accessToken, openId));
            //
            //            String restResult = r.accept(MediaType.APPLICATION_JSON).get(String.class);

            // https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com").path("cgi-bin/user/info")
                .queryParam("access_token", accessToken).queryParam("openid", openId)
                .queryParam("lang", "zh_CN");
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("restResult={}", restResult);

            JSONObject jo = new JSONObject(restResult);

            String unionId = jo.optString("unionid");
            String _openid = jo.optString("openid");

            if (StringUtils.isNotBlank(_openid)) {
                WeixinUser user = new WeixinUser();
                user.setAppId(appId);
                user.setOpenId(openId);
                user.setUnionId(unionId);
                user.setProps(jo);
                return user;
            } else {
                logger.warn("【查询微信用户信息失败】{}", jo);
                return null;
            }
        } catch (Exception e) {
            logger.error("【查询微信用户信息异常】", e);
            return null;
        }
    }

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#oauthQuery(com.witon.ehealth.common.service.integration.wx.req.WxOauthReq)
     */
    @Override
    public WxOauthResult oauthQuery(WxOauthReq req) {
        logger.info("【微信OAuth授权登录】req={}", req);
        WxOauthResult result = new WxOauthResult();

        try {
            //            Client c = Client.create();
            //            WebResource r = c.resource(String.format(OAUTH_ACCESS_TOKEN_URL, req.getAppId(),
            //                req.getAppSecret(), req.getCode()));
            //            String restResult = r.accept(MediaType.APPLICATION_JSON).get(String.class);

            // https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com")
                .path("sns/oauth2/access_token").queryParam("appid", req.getAppId())
                .queryParam("secret", req.getAppSecret()).queryParam("code", req.getCode())
                .queryParam("grant_type", "authorization_code");
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info("restResult={}", restResult);

            JSONObject basejo = new JSONObject(restResult);

            String access_token = basejo.optString("access_token");

            if (StringUtils.isBlank(access_token)) {
                logger.warn("【查询微信用户信息失败】{}", basejo);
                result.setSuccess(false);
                result.setResultMsg(basejo.toString());
                return result;
            }

            String openid = basejo.optString("openid");
            int expires_in = basejo.optInt("expires_in");
            String refresh_token = basejo.optString("refresh_token");
            String scope = basejo.optString("scope");

            result.setAccessToken(access_token);
            result.setRefreshToken(refresh_token);
            result.setExpiresIn(expires_in);
            result.setOpenId(openid);
            result.setScope(scope);

            if (req.isNeedUserInfo()) {

                //                WebResource r2 = c
                //                    .resource(String.format(OAUTH_USER_INFO_URL, access_token, openid));
                //                String userRet = r2.accept(MediaType.APPLICATION_JSON).get(String.class);
                // https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN

                Client client2 = ClientBuilder.newClient();
                WebTarget target2 = client2.target("https://api.weixin.qq.com").path("sns/userinfo")
                    .queryParam("access_token", access_token).queryParam("openid", openid)
                    .queryParam("lang", "zh_CN");
                String userRet = target2.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

                logger.info("userRet={}", userRet);

                JSONObject userJo = new JSONObject(userRet);
                String unionId = userJo.optString("unionid");

                if (StringUtils.isBlank(unionId)) {
                    logger.warn("【查询微信用户信息失败】{}", userJo);
                    result.setSuccess(false);
                    result.setResultMsg(userJo.toString());
                    return result;
                }

                WeixinUser user = new WeixinUser();
                user.setAppId(req.getAppId());
                user.setOpenId(openid);
                user.setUnionId(unionId);
                user.setProps(userJo);

                result.setWeixinUser(user);
            }

            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.error("【查询微信用户信息异常】", e);
            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
            return result;
        }
    }

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#refreshOpenToken(com.witon.ehealth.common.service.integration.wx.req.WxOpenTokenReq)
     */
    @Override
    public WxOpenTokenResult refreshOpenToken(WxOpenTokenReq req) {
        logger.info("【openToken刷新】req={}", req);

        WxOpenTokenResult result = new WxOpenTokenResult();

        String url = String.format(OPEN_TOKEN_REFRESH_URL, req.getAppId(), req.getAppSecret());
        logger.info("url={}", url);
        try {
            //            Client c = Client.create();
            //            WebResource r = c.resource(url);
            //            String jsResult = r.get(String.class);

            // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com").path("cgi-bin/token")
                .queryParam("grant_type", "client_credential").queryParam("appid", req.getAppId())
                .queryParam("secret", req.getAppSecret());
            String jsResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info(jsResult);

            JSONObject jo = new JSONObject(jsResult);
            String accessToken = jo.optString("access_token");
            if (StringUtils.isNotBlank(accessToken)) {
                long expires_in = jo.getLong("expires_in");

                OpenToken openToken = new OpenToken();
                openToken.setAppId(req.getAppId());
                openToken.setAccessToken(accessToken);
                openToken.setAppType(AppTypeEnum.WEIXIN);
                openToken.setGmtEffect(new Date());
                openToken.setGmtExpire(DateUtil.addSeconds(new Date(), expires_in));
                openToken.setProps(jo);

                result.setSuccess(true);
                result.setResultCode(ResultCodeEnum.SUCCESS.getCode());
                result.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
                result.setOpenToken(openToken);
                return result;
            } else {
                // fail
                String errcode = jo.optString("errcode");
                String errmsg = jo.optString("errmsg");
                logger.warn(String.format("【刷新失败】[errcode={}, errmsg={}]", errcode, errmsg));
                result.setSuccess(false);
                result.setResultCode(errcode);
                result.setResultMsg(errmsg);
            }
        } catch (Exception e) {
            logger.error(String.format("【刷新令牌失败】%s", e.getMessage()), e);
            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
        }
        return result;
    }

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#refreshJsTicket(com.witon.ehealth.common.service.integration.wx.req.WxJsApiTicketReq)
     */
    @Override
    public WxOpenTokenResult refreshJsTicket(WxJsApiTicketReq req) {
        logger.info("【ticket刷新】req={}", req);
        WxOpenTokenResult result = new WxOpenTokenResult();

        String token = wxAccessTokenComponent.getAccessToken(req.getAppId());
        if (StringUtils.isBlank(token)) {
            logger.error("【access_token未找到】req={}", req);
            result.setSuccess(false);
            return result;
        }

        String url = String.format(JS_TICKET_REFRESH_URL, token);
        logger.info("【ticket刷新】 url={}", url);
        try {
            //            Client c = Client.create();
            //            WebResource r = c.resource(url);
            //            String jsResult = r.get(String.class);
            // https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com")
                .path("cgi-bin/ticket/getticket").queryParam("access_token", token)
                .queryParam("type", "jsapi");
            String jsResult = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            logger.info(jsResult);

            JSONObject jo = new JSONObject(jsResult);
            String ticket = jo.optString("ticket");
            if (StringUtils.isNotBlank(ticket)) {
                long expires_in = jo.getLong("expires_in");

                OpenToken openToken = new OpenToken();
                openToken.setAppId(req.getAppId());
                openToken.setAccessToken(ticket);
                openToken.setAppType(AppTypeEnum.WEIXIN_JS_API);
                openToken.setGmtEffect(new Date());
                openToken.setGmtExpire(DateUtil.addSeconds(new Date(), expires_in));
                openToken.setProps(jo);

                result.setSuccess(true);
                result.setResultCode(ResultCodeEnum.SUCCESS.getCode());
                result.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
                result.setOpenToken(openToken);
                return result;
            } else {
                // fail
                String errcode = jo.optString("errcode");
                String errmsg = jo.optString("errmsg");
                logger.warn(String.format("【ticket刷新失败】[errcode={}, errmsg={}]", errcode, errmsg));
                result.setSuccess(false);
                result.setResultCode(errcode);
                result.setResultMsg(errmsg);
            }
        } catch (Exception e) {
            logger.error(String.format("【ticket刷新失败】%s", e.getMessage()), e);
            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
        }
        return result;
    }

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#sendMsg(WxMsgSendReq)
     */
    @SuppressWarnings("unchecked")
    @Override
    public WxMsgSendResult sendMsg(WxMsgSendReq req) {
        logger.info("sendMsg req={}", req);
        WxMsgSendResult result = new WxMsgSendResult();

        String accessToken = wxAccessTokenComponent.getAccessToken(req.getAppId());
        if (StringUtils.isBlank(accessToken)) {
            logger.error("【access_token未找到】req={}", req);
            result.setSuccess(false);
            return result;
        }

        // 发送客服消息
        // http://mp.weixin.qq.com/wiki/1/70a29afed17f56d537c833f89be979c9.html

        //        String url = String.format(MESSAGE_SEND_URL, accessToken);

        try {
            JSONObject request = new JSONObject();

            request.put("touser", req.getToUser());

            JSONObject content = new JSONObject();
            switch (req.getMsgType()) {
                case TEXT:
                    request.put("msgtype", req.getMsgType().getCode());
                    content.put("content", String.valueOf(req.getMsgBody()));
                    request.put(req.getMsgType().getCode(), content);
                    break;
                case NEWS:
                    request.put("msgtype", req.getMsgType().getCode());
                    Object c = req.getMsgBody();
                    if (c instanceof List) {
                        List<WxNewsArticle> list = (List<WxNewsArticle>) c;
                        List<JSONObject> articles = new ArrayList<JSONObject>();
                        for (WxNewsArticle item : list) {
                            JSONObject article = new JSONObject();
                            article.put("title", item.getTitle());
                            article.put("description", item.getDescription());
                            article.put("url", item.getUrl());
                            article.put("picurl", item.getPicUrl());
                            articles.add(article);
                        }
                        content.put("articles", articles);
                    }
                    request.put(req.getMsgType().getCode(), content);
                    break;
                case TEMPLATE:
                default:
                    logger.error("不支持的消息类型{}", req.getMsgType());
                    break;
            }

            logger.debug("restRequest={}", request.toString());

            //            Client c = Client.create();
            //            WebResource r = c.resource(url);
            //
            //            String restResult = r.entity(request, MediaType.APPLICATION_JSON)
            //                .accept(MediaType.APPLICATION_JSON).post(String.class);

            // https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com")
                .path("cgi-bin/message/custom/send").queryParam("access_token", accessToken);
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), String.class);

            logger.info("restResult={}", restResult);

            JSONObject joResult = new JSONObject(restResult);
            String errCode = joResult.optString("errcode");
            String errMsg = joResult.optString("errmsg");

            if (StringUtils.equals("0", errCode)) {
                result.setSuccess(true);
                result.setResultCode(errCode);
                result.setResultMsg(errMsg);
                result.setRetMsg(joResult);
                return result;
            } else {
                result.setSuccess(false);
                result.setResultCode(errCode);
                result.setResultMsg(errMsg);
                result.setRetMsg(joResult);
                return result;
            }
        } catch (Exception e) {
            logger.error(String.format("req=%s, err=%s", req, e.getMessage()), e);

            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
            return result;
        }
    }

    /** 
     * @see com.witon.ehealth.common.service.integration.wx.WxRestServiceClient#sendTemplateMsg(com.witon.ehealth.common.service.integration.wx.req.WxTemplateSendReq)
     */
    @Override
    public WxMsgSendResult sendTemplateMsg(WxTemplateSendReq req) {
        logger.info("【发送模板消息】req={}", req);
        WxMsgSendResult result = new WxMsgSendResult();

        // 
        String accessToken = wxAccessTokenComponent.getAccessToken(req.getAppId());
        if (StringUtils.isBlank(accessToken)) {
            logger.error("【access_token未找到】req={}", req);
            result.setSuccess(false);
            return result;
        }

        //        String url = String.format(TEMPLATE_SEND_URL, accessToken);

        JSONObject request = new JSONObject();
        try {
            request.put("touser", req.getToUser());
            request.put("template_id", req.getTemplateId());
            request.put("url", req.getUrl());
            request.put("topcolor", req.getTopColor());
            request.put("data", req.getMsgBody());

            //            Client c = Client.create();
            //            WebResource r = c.resource(url);
            //
            //            String restResult = r.entity(request, MediaType.APPLICATION_JSON)
            //                .accept(MediaType.APPLICATION_JSON).post(String.class);

            // https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com")
                .path("cgi-bin/message/template/send").queryParam("access_token", accessToken);
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), String.class);

            logger.info("restResult={}", restResult);

            JSONObject joResult = new JSONObject(restResult);
            String errCode = joResult.optString("errcode");
            String errMsg = joResult.optString("errmsg");

            if (StringUtils.equals("0", errCode)) {
                result.setSuccess(true);
                result.setResultCode(errCode);
                result.setResultMsg(errMsg);
                result.setRetMsg(joResult);
                return result;
            } else {
                result.setSuccess(false);
                result.setResultCode(errCode);
                result.setResultMsg(errMsg);
                result.setRetMsg(joResult);
                return result;
            }
        } catch (Exception e) {
            logger.error(String.format("errMsg=%s", e.getMessage()), e);
            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
        }
        return result;
    }

    @Override
    public WxMsgSendResult getTemplateId(String templateShortId, String appId) {
        WxMsgSendResult result = new WxMsgSendResult();
        String accessToken = wxAccessTokenComponent.getAccessToken(appId);
        if (StringUtils.isBlank(accessToken)) {
            logger.error("【access_token未找到】");
            result.setSuccess(false);
            return result;
        }
        try {
            //            String url = String.format(TEMPLATE_ADD_URL, accessToken);

            JSONObject jsonData = new JSONObject();
            jsonData.put("template_id_short", templateShortId);

            //            Client c = Client.create();
            //            WebResource r = c.resource(url);
            //            String restResult = r.entity(jsonData, MediaType.APPLICATION_JSON)
            //                .accept(MediaType.APPLICATION_JSON).post(String.class);

            // https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("https://api.weixin.qq.com")
                .path("cgi-bin/template/api_add_template").queryParam("access_token", accessToken);
            String restResult = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(jsonData, MediaType.APPLICATION_JSON_TYPE), String.class);

            logger.info("restResult={}", restResult);

            JSONObject joResult = new JSONObject(restResult);
            String errCode = joResult.optString("errcode");
            String errMsg = joResult.optString("errmsg");
            String templateId = joResult.optString("template_id");

            if (StringUtils.equals("0", errCode)) {
                result.setSuccess(true);
                result.setResultCode(errCode);
                result.setResultMsg(errMsg);
                result.setRetMsg(joResult);
                return result;
            } else {
                result.setSuccess(false);
                result.setResultCode(errCode);
                result.setResultMsg(errMsg);
                result.setRetMsg(templateId);
                return result;
            }
        } catch (Exception e) {
            logger.error(String.format("tempShortId=%s, appId=%s, err=%s", templateShortId, appId,
                e.getMessage()), e);

            result.setSuccess(false);
            result.setResultCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
            result.setResultMsg(ResultCodeEnum.SYSTEM_ERROR.getDesc());
            return result;
        }
    }

}
