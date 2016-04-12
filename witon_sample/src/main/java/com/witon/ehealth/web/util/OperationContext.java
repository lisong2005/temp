/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.core.model.user.model.UserInfo;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OperationContext.java, v 0.1 2015年1月15日 上午9:11:24 song.li@witontek.com Exp $
 */
public class OperationContext {
    /**
    * Logger for this class
    */
    private static final Logger                          logger          = LoggerFactory
        .getLogger(OperationContext.class);

    /**  */
    public static final ThreadLocal<UserInfo>            currentUserInfo = new ThreadLocal<UserInfo>();

    /**  */
    public static final ThreadLocal<String>              uidInfo         = new ThreadLocal<String>();

    /**  */
    public static final ThreadLocal<Map<String, Object>> contextInfo     = new ThreadLocal<Map<String, Object>>();

    /**
     * 
     * @return
     */
    public static UserInfo getUserInfo() {
        return currentUserInfo.get();
    }

    /**
     * 
     * @return
     */
    public static String getUserId() {
        return uidInfo.get();
    }

    /**
     * 
     * @param key
     * @return
     */
    public static Object getContext(String key) {
        Map<String, Object> map = contextInfo.get();
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    /**
     * 
     * @param key
     * @param value
     */
    public static void setContext(String key, Object value) {
        logger.debug("[OperationContext]key={}, value={}", key, value);
        Map<String, Object> map = contextInfo.get();
        if (map == null) {
            map = new HashMap<String, Object>();
        }
        map.put(key, value);
        contextInfo.set(map);
    }

    /**
     * 
     */
    public static void remove() {
        logger.debug("[OperationContext]remove");
        currentUserInfo.remove();
        uidInfo.remove();
        if (contextInfo.get() != null) {
            contextInfo.get().clear();
            contextInfo.remove();
        }
    }

    // ============================================================
    // ============================================================
    // ============================================================

    protected static void setUserInfo(UserInfo newUserInfo) {
        currentUserInfo.set(newUserInfo);
    }

    protected static void setUid(String uid) {
        uidInfo.set(uid);
    }
}
