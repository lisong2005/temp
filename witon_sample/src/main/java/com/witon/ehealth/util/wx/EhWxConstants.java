/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.util.wx;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: EhWxConstants.java, v 0.1 2015年1月13日 下午12:52:58 song.li@witontek.com Exp $
 */
public interface EhWxConstants {

    // url params
    public static final String P_SIGNATURE        = "signature";
    public static final String P_TIMESTAMP        = "timestamp";
    public static final String P_NONCE            = "nonce";
    public static final String P_ECHOSTR          = "echostr";
    public static final String P_MSG_SIGNATURE    = "msg_signature";
    public static final String P_ENCRYPT_TYPE     = "encrypt_type";

    // xml key
    public static final String KEY_MSG_TYPE       = "MsgType";
    public static final String KEY_TO_USER        = "ToUserName";
    public static final String KEY_FROM_USER      = "FromUserName";
    public static final String KEY_CREATE_TIME    = "CreateTime";
    public static final String KEY_CONTENT        = "Content";
    public static final String KEY_MSG_ID         = "MsgId";
    public static final String KEY_PIC_URL        = "PicUrl";
    public static final String KEY_MEDIA_ID       = "MediaId";
    public static final String KEY_FORMAT         = "Format";
    public static final String KEY_THUMB_MEDIA_ID = "ThumbMediaId";
    public static final String KEY_LOCATION_X     = "Location_X";
    public static final String KEY_LOCATION_Y     = "Location_Y";
    public static final String KEY_SCALE          = "Scale";
    public static final String KEY_LABEL          = "Label";
    public static final String KEY_TITLE          = "Title";
    public static final String KEY_DESCRIPTION    = "Description";
    public static final String KEY_URL            = "Url";
    public static final String KEY_ENCRYPT        = "Encrypt";

    // event key
    public static final String E_EVENT            = "Event";
    public static final String E_EVENT_KEY        = "EventKey";
    public static final String E_TICKET           = "Ticket";
    public static final String E_LATITUDE         = "Latitude";
    public static final String E_LONGITUDE        = "Longitude";
    public static final String E_PRECISION        = "Precision";

    // ret key
    public static final String RKEY_ARTICLE_COUNT = "ArticleCount";
    public static final String RKEY_ARTICLES      = "Articles";
    public static final String RKEY_MSG_SIGNATURE = "MsgSignature";

    // ....
    public static final String ENCRYPT_TYPE       = "aes";
}
