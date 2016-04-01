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

import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinUserDo;
import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WexinUserConvertor.java, v 0.1 2015年1月8日 下午1:30:02 song.li@witontek.com Exp $
 */
public class WexinUserConvertor {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WexinUserConvertor.class);

    /**
     * 
     * @param aWexinUserDo
     * @return
     * @throws JSONException
     */
    public static WeixinUser convert(WeixinUserDo aWexinUserDo) {
        if (aWexinUserDo == null) {
            return null;
        }
        WeixinUser ret = new WeixinUser();
        ret.setId(aWexinUserDo.getId());
        ret.setAppId(aWexinUserDo.getAppId());
        ret.setOpenId(aWexinUserDo.getOpenId());
        ret.setUnionId(aWexinUserDo.getUnionId());
        if (StringUtils.isNotBlank(aWexinUserDo.getProps())) {
            try {
                ret.setProps(new JSONObject(aWexinUserDo.getProps()));
            } catch (JSONException e) {
                logger.error(e.getMessage(), e);
            }
        }
        ret.setGmtCreate(aWexinUserDo.getGmtCreate());
        ret.setGmtModify(aWexinUserDo.getGmtModify());
        return ret;
    }

    /**
     * 
     * @param aWexinUser
     * @return
     */
    public static WeixinUserDo convert(WeixinUser aWexinUser) {
        if (aWexinUser == null) {
            return null;
        }
        WeixinUserDo ret = new WeixinUserDo();
        ret.setId(aWexinUser.getId());
        ret.setAppId(aWexinUser.getAppId());
        ret.setOpenId(aWexinUser.getOpenId());
        ret.setUnionId(aWexinUser.getUnionId());
        if (aWexinUser.getProps() != null) {
            ret.setProps(aWexinUser.getProps().toString());
        }
        ret.setGmtCreate(aWexinUser.getGmtCreate());
        ret.setGmtModify(aWexinUser.getGmtModify());
        return ret;
    }
}
