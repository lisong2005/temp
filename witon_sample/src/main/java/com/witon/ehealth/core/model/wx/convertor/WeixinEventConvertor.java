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

import com.witon.ehealth.common.dal.pg.dbo.wx.WeixinEventDo;
import com.witon.ehealth.core.model.wx.model.WeixinEvent;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinEventConvertor.java, v 0.1 2015年1月9日 下午1:30:14 song.li@witontek.com Exp $
 */
public class WeixinEventConvertor {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(WeixinEventConvertor.class);

    /**
     * 
     * @param aWeixinEventDo
     * @return
     */
    public static WeixinEvent convert(WeixinEventDo aWeixinEventDo) {
        if (aWeixinEventDo == null) {
            return null;
        }
        WeixinEvent ret = new WeixinEvent();
        ret.setId(aWeixinEventDo.getId());
        ret.setToUser(aWeixinEventDo.getToUser());
        ret.setFromUser(aWeixinEventDo.getFromUser());
        ret.setEventKey(aWeixinEventDo.getEventKey());

        WeixinEvent.EventTypeEnum type = WeixinEvent.EventTypeEnum
            .getByCode(aWeixinEventDo.getEventType());
        if (type == null) {
            ret.setWxEventType(aWeixinEventDo.getEventType());
        } else {
            ret.setEventType(type);
        }

        if (StringUtils.isNotBlank(aWeixinEventDo.getEventProps())) {
            try {
                ret.setEventProps(new JSONObject(aWeixinEventDo.getEventProps()));
            } catch (JSONException e) {
                logger.error(e.getMessage(), e);
            }
        }

        ret.setGmtUpload(aWeixinEventDo.getGmtUpload());
        ret.setGmtCreate(aWeixinEventDo.getGmtCreate());
        ret.setGmtModify(aWeixinEventDo.getGmtModify());
        return ret;
    }

    /**
     * 
     * @param aWeixinEvent
     * @return
     */
    public static WeixinEventDo convert(WeixinEvent aWeixinEvent) {
        if (aWeixinEvent == null) {
            return null;
        }
        WeixinEventDo ret = new WeixinEventDo();
        ret.setId(aWeixinEvent.getId());
        ret.setToUser(aWeixinEvent.getToUser());
        ret.setFromUser(aWeixinEvent.getFromUser());
        ret.setEventKey(aWeixinEvent.getEventKey());

        if (aWeixinEvent.getEventType() != null) {
            ret.setEventType(aWeixinEvent.getEventType().getCode());
        } else {
            ret.setEventType(aWeixinEvent.getWxEventType());
        }

        if (aWeixinEvent.getEventProps() != null) {
            ret.setEventProps(aWeixinEvent.getEventProps().toString());
        }

        ret.setGmtUpload(aWeixinEvent.getGmtUpload());
        ret.setGmtCreate(aWeixinEvent.getGmtCreate());
        ret.setGmtModify(aWeixinEvent.getGmtModify());
        return ret;
    }
}
