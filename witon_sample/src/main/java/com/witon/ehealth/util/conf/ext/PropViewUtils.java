/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util.conf.ext;

import java.util.Enumeration;
import java.util.Properties;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: PropViewUtils.java, v 0.1 2017年2月28日 下午2:05:50 song.li@witontek.com Exp $
 */
public class PropViewUtils {

    
    public static String getStrForProps(Properties props) {
        StringBuilder sb = new StringBuilder();
        if (props != null) {
            Enumeration<Object> keys = props.keys();
            sb.append("\n");
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                sb.append(key).append("=").append(props.get(key)).append("\n");
            }
        }
        return sb.toString();

    }
}
