/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx;

import java.util.List;

import com.witon.ehealth.core.model.wx.model.OpenToken;
import com.witon.ehealth.core.model.wx.req.OpenTokenQueryReq;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: OpenTokenRepository.java, v 0.1 2015年1月8日 下午2:34:32 song.li@witontek.com Exp $
 */
public interface OpenTokenRepository {

    public long add(OpenToken openToken);

    public int update(OpenToken openToken);

    public OpenToken getById(long id);

    public OpenToken lockById(long id);

    public List<OpenToken> getByCond(OpenTokenQueryReq cond);

}
