/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.Assert;

import com.witon.ehealth.core.model.user.model.UserInfo;
import com.witon.ehealth.util.EhealthConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SessionUtil.java, v 0.1 2014年9月24日 上午9:37:57 song.li@witontek.com Exp $
 */
public class SessionUtil {

    /**
     * 
     * @param request
     * @return
     */
    public static String getUserId(HttpServletRequest request) {
        HttpSession s = request.getSession();
        if (s == null) {
            return null;
        }
        UserInfo newUserInfo = (UserInfo) s.getAttribute(EhealthConstants.SESSION_NEW_USER_INFO);
        if (newUserInfo != null) {
            return newUserInfo.getUid();
        }
        return (String) s.getAttribute(EhealthConstants.SESSION_USER_ID);
    }

    /**
     * 
     * @param request
     * @return
     */
    public static UserInfo getNewUserInfo(HttpServletRequest request) {
        HttpSession s = request.getSession();
        if (s == null) {
            return null;
        }
        return (UserInfo) s.getAttribute(EhealthConstants.SESSION_NEW_USER_INFO);
    }

    /**
     * 
     * @param request
     * @param newUserInfo
     */
    public static void setNewUserInfo(HttpServletRequest request, UserInfo newUserInfo) {
        Assert.notNull(newUserInfo, String.format("用户信息不能为空 info={}", newUserInfo));

        removeNewUserInfo(request);

        HttpSession s = request.getSession(true);
        String uid = newUserInfo.getUid();
        s.setAttribute(EhealthConstants.SESSION_USER_ID, uid);
        s.setAttribute(EhealthConstants.SESSION_NEW_USER_INFO, newUserInfo);
    }

    /**
     * 
     * @param request
     * @param newUserInfo
     */
    public static void removeNewUserInfo(HttpServletRequest request) {
        HttpSession s = request.getSession();
        if (s == null) {
            return;
        }

        s.removeAttribute(EhealthConstants.SESSION_USER_ID);
        s.removeAttribute(EhealthConstants.SESSION_NEW_USER_INFO);
        OperationContext.remove();
    }

    /**
     * 
     * @param request
     * @param key
     * @param value
     */
    public static void add(HttpServletRequest request, String key, Object value) {
        HttpSession s = request.getSession(true);
        s.setAttribute(key, value);
    }

    /**
     * 
     * @param request
     * @param key
     * @return
     */
    public static Object get(HttpServletRequest request, String key) {
        HttpSession s = request.getSession();
        if (s == null) {
            return null;
        }
        return s.getAttribute(key);
    }

    /**
     * 
     * @param request
     * @param key
     * @return
     */
    public static Object getAndRemove(HttpServletRequest request, String key) {
        HttpSession s = request.getSession();
        if (s == null) {
            return null;
        }
        Object retValue = s.getAttribute(key);
        s.removeAttribute(key);
        return retValue;
    }

}
