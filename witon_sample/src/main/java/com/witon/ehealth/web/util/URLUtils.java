/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.web.util;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.util.CollectionUtils;

import com.witon.ehealth.util.EhealthConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: URLUtils.java, v 0.1 2015年1月14日 下午2:11:18 song.li@witontek.com Exp $
 */
public class URLUtils {

    /**
     * 
     * @param queryStr
     * @return
     */
    public static Map<String, String> getParams(String queryStr) {
        Map<String, String> params = new HashMap<String, String>();
        List<NameValuePair> pairs = URLEncodedUtils.parse(queryStr,
            Charset.forName(EhealthConstants.DEFAULT_CHARSET));
        if (!CollectionUtils.isEmpty(pairs)) {
            for (NameValuePair item : pairs) {
                params.put(item.getName(), item.getValue());
            }
        }
        return params;
    }

    /**
     * 获取所有request请求参数key-value
     * 
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> getRequestParams(HttpServletRequest request) {

        Map<String, String> params = new HashMap<String, String>();
        if (null != request) {
            Set<String> paramsKey = request.getParameterMap().keySet();
            for (String key : paramsKey) {
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
}
