/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.web.base;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.Assert;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TokenManager.java, v 0.1 2016年9月1日 下午1:16:41 song.li@witontek.com Exp $
 */
public class TokenManager extends BaseModel implements AutoCloseable {

    /**  */
    private static final long serialVersionUID = -905867602559321368L;

    private HttpSession       session;

    private String            paramName        = null;
    private String            token            = null;

    /**
     * @param session
     */
    public TokenManager(HttpSession session) {
        super();
        Assert.notNull(session, "session is null");
        this.session = session;
    }

    public void init(String namespace) {
        this.paramName = namespace + System.currentTimeMillis();
        this.token = UUID.randomUUID().toString();
        session.setAttribute(paramName, token);
        session = null;
    }

    /**
     * Getter method for property <tt>paramName</tt>.
     * 
     * @return property value of paramName
     */
    public String getParamName() {
        if (paramName == null) {
            throw new RuntimeException("未初始化");
        }
        return paramName;
    }

    /**
     * Getter method for property <tt>token</tt>.
     * 
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /** 
     * @see java.lang.AutoCloseable#close()
     */
    @Override
    public void close() throws Exception {
        this.session = null;
    }
}
