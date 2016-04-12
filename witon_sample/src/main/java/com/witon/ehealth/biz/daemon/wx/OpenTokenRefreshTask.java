/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.biz.daemon.wx;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.biz.daemon.AbstractTask;
import com.witon.ehealth.biz.daemon.Task;
import com.witon.ehealth.common.srv.integration.wx.WxRestServiceClient;
import com.witon.ehealth.common.srv.integration.wx.req.WxJsApiTicketReq;
import com.witon.ehealth.common.srv.integration.wx.req.WxOpenTokenReq;
import com.witon.ehealth.common.srv.integration.wx.result.WxOpenTokenResult;
import com.witon.ehealth.core.model.wx.OpenTokenRepository;
import com.witon.ehealth.core.model.wx.WxAppConfigRepository;
import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.model.OpenToken.AppTypeEnum;
import com.witon.ehealth.core.model.wx.model.WxAppConfig;
import com.witon.ehealth.core.model.wx.req.OpenTokenQueryReq;
import com.witon.ehealth.util.DateUtil;
import com.witon.ehealth.util.EhealthConstants;
import com.witon.ehealth.util.conf.SystemConfig;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenRefreshTask.java, v 0.1 2015年1月9日 下午2:46:17 song.li@witontek.com Exp $
 */
public class OpenTokenRefreshTask extends AbstractTask implements Task, EhealthConstants {

    /** 失效时间：分钟 */
    private static final int        EXPIRE_TIME = 10;

    /**  */
    @Autowired
    private OpenTokenRepository     openTokenRepository;

    /**  */
    @Autowired
    private WxRestServiceClient     wxRestServiceClient;

    /**  */
    @Autowired
    protected WxAppConfigRepository wxAppConfigRepository;

    /**  */
    @Autowired
    protected SystemConfig          systemConfig;

    /** 
     * @see com.witon.ehealth.biz.daemon.Task#execute()
     */
    @Override
    public void execute() {
        logger.info("【令牌刷新任务】mode={} start", systemConfig.getSystemRunMode());

        // 一般开发测试模式不刷新
        if (systemConfig.getSystemRunMode() == SystemConfig.RunModeEnum.DEVELOP
            && !systemConfig.isMirror()) {
            logger.warn("[开发模式不执行定时任务]");
            return;
        }

        WxAppConfig appConfig = wxAppConfigRepository.getDefault();

        {
            // 微信accessToken刷新
            OpenTokenQueryReq cond = new OpenTokenQueryReq();
            cond.setAppType(AppTypeEnum.WEIXIN);
            cond.setAppId(appConfig.getAppId());
            cond.setGmtExpire(DateUtil.addMinutes(new Date(), EXPIRE_TIME));

            List<OpenToken> list = openTokenRepository.getByCond(cond);
            logger.debug("list.size={}", list.size());
            if (CollectionUtils.isEmpty(list)) {
                refresh(appConfig);
            }
        }

        {
            // 微信jsapi ticket刷新
            OpenTokenQueryReq cond = new OpenTokenQueryReq();
            cond.setAppType(AppTypeEnum.WEIXIN_JS_API);
            cond.setAppId(appConfig.getAppId());
            cond.setGmtExpire(DateUtil.addMinutes(new Date(), EXPIRE_TIME));

            List<OpenToken> list = openTokenRepository.getByCond(cond);
            logger.debug("list.size={}", list.size());
            if (CollectionUtils.isEmpty(list)) {
                refreshJsTicket(appConfig);
            }
        }
        logger.info("【令牌刷新任务】end");
    }

    /**
     * 
     */
    private void refreshJsTicket(WxAppConfig appConfig) {
        try {
            WxJsApiTicketReq req = new WxJsApiTicketReq();
            req.setAppId(appConfig.getAppId());

            WxOpenTokenResult result = wxRestServiceClient.refreshJsTicket(req);
            if (result.isSuccess()) {
                openTokenRepository.add(result.getOpenToken());
            } else {
                logger.warn("【jsApiTicket刷新任务失败】{}", result);
            }
        } catch (Exception e) {
            logger.error(String.format("【jsApiTicket刷新任务失败】error=%s", e.getMessage()), e);
        }
    }

    /**
     * 
     */
    private void refresh(WxAppConfig appConfig) {
        try {
            WxOpenTokenReq req = new WxOpenTokenReq();
            req.setAppId(appConfig.getAppId());
            req.setAppSecret(appConfig.getAppSecret());
            WxOpenTokenResult result = wxRestServiceClient.refreshOpenToken(req);
            if (result.isSuccess()) {
                openTokenRepository.add(result.getOpenToken());
            } else {
                logger.warn("【令牌刷新任务失败】{}", result);
            }
        } catch (Exception e) {
            logger.error(String.format("【令牌刷新任务失败】error=%s", e.getMessage()), e);
        }
    }

}
