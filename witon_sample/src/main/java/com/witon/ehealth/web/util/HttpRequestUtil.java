/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.util;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: HttpRequestUtil.java, v 0.1 2016年8月15日 下午2:35:56 song.li@witontek.com Exp $
 */
public class HttpRequestUtil {

    /** xml请求报文最大读取行数 */
    public static final int MAX_LINE_SIZE = 1024;

    /**
     * 
     * @param reader
     * @return
     * @throws IOException
     */
    public static String getContent(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_LINE_SIZE; i++) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        return sb.toString();
    }
}
