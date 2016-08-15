/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ExtHttpServletRequestWrapper.java, v 0.1 2016年8月15日 下午2:45:51 song.li@witontek.com Exp $
 */
public class ExtHttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
    /**
    * Logger for this class
    */
    private static final Logger logger     = LoggerFactory
        .getLogger(ExtHttpServletRequestWrapper.class);

    /**  */
    private static final int    MAX_LENGTH = 1 * 1024 * 1024;

    private byte[]              content    = null;

    /**
     * @param request
     */
    public ExtHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            if (getContentLength() != -1 && getContentLength() < MAX_LENGTH) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                IOUtils.copy(super.getInputStream(), bos);
                content = bos.toByteArray();
            }
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    /** 
     * @see javax.servlet.ServletRequestWrapper#getInputStream()
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        logger.info("");
        if (this.content != null) {
            final ByteArrayInputStream bis = new ByteArrayInputStream(content);
            return new ServletInputStream() {
                @Override
                public int read() throws IOException {
                    return bis.read();
                }
            };
        }
        return super.getInputStream();
    }

    /** 
     * @see javax.servlet.ServletRequestWrapper#getReader()
     */
    @Override
    public BufferedReader getReader() throws IOException {
        logger.info("");
        if (this.content != null) {
            if (StringUtils.isNoneBlank(getCharacterEncoding())) {
                return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content),
                    this.getCharacterEncoding()));
            }
            return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content)));
        }
        return super.getReader();
    }

}
