/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx.convertor;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.dal.pg.dbo.wx.OpenTokenDo;
import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.model.OpenToken.AppTypeEnum;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenConvertor.java, v 0.1 2015年1月8日 下午2:27:35 song.li@witontek.com Exp $
 */
public class OpenTokenConvertor {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(OpenTokenConvertor.class);

    /**
     * 
     * @param aOpenTokenDo
     * @return
     */
    public static OpenToken convert(OpenTokenDo aOpenTokenDo) {
        if (aOpenTokenDo == null) {
            return null;
        }

        OpenToken ret = new OpenToken();
        ret.setId(aOpenTokenDo.getId());
        ret.setAppType(AppTypeEnum.getByCode(aOpenTokenDo.getAppType()));
        ret.setAppId(aOpenTokenDo.getAppId());
        ret.setAccessToken(aOpenTokenDo.getAccessToken());
        ret.setRefreshToken(aOpenTokenDo.getRefreshToken());
        if (StringUtils.isNotBlank(aOpenTokenDo.getProps())) {
            try {
                ret.setProps(new JSONObject(aOpenTokenDo.getProps()));
            } catch (JSONException e) {
                logger.error(e.getMessage(), e);
            }
        }
        ret.setMemo(aOpenTokenDo.getMemo());
        ret.setGmtCreate(aOpenTokenDo.getGmtCreate());
        ret.setGmtModify(aOpenTokenDo.getGmtModify());
        ret.setGmtEffect(aOpenTokenDo.getGmtEffect());
        ret.setGmtExpire(aOpenTokenDo.getGmtExpire());
        return ret;
    }

    /**
     * 
     * @param aOpenToken
     * @return
     */
    public static OpenTokenDo convert(OpenToken aOpenToken) {
        if (aOpenToken == null) {
            return null;
        }

        OpenTokenDo ret = new OpenTokenDo();
        ret.setId(aOpenToken.getId());
        ret.setAppType(aOpenToken.getAppType() != null ? aOpenToken.getAppType().getCode() : null);
        ret.setAppId(aOpenToken.getAppId());
        ret.setAccessToken(aOpenToken.getAccessToken());
        ret.setRefreshToken(aOpenToken.getRefreshToken());
        if (aOpenToken.getProps() != null) {
            ret.setProps(aOpenToken.getProps().toString());
        }
        ret.setMemo(aOpenToken.getMemo());
        ret.setGmtCreate(aOpenToken.getGmtCreate());
        ret.setGmtModify(aOpenToken.getGmtModify());
        ret.setGmtEffect(aOpenToken.getGmtEffect());
        ret.setGmtExpire(aOpenToken.getGmtExpire());
        return ret;
    }
}
