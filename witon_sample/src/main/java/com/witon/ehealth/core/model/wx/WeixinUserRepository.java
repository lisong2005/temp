/**
 * Witontek.com.
 * Copyright (c) 2012-2015 All Rights Reserved.
 */
package com.witon.ehealth.core.model.wx;

import java.util.List;

import com.witon.ehealth.core.model.wx.model.WeixinUser;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WexinUserRepository.java, v 0.1 2015年1月8日 下午1:36:06 song.li@witontek.com Exp $
 */
public interface WeixinUserRepository {

    /**
     * 
     * @param wexinUser
     * @return
     */
    public long add(WeixinUser wexinUser);

    /**
     * 
     * @param id
     * @return
     */
    public WeixinUser getById(long id);

    /**
     * 
     * @param id
     * @return
     */
    public WeixinUser lockById(long id);

    /**
     * 
     * @param openId
     * @param appId
     * @return
     */
    public WeixinUser getByOpenId(String openId, String appId);

    /**
     * 
     * @param unionId
     * @return
     */
    public int deleteByUnionId(String unionId);

    /**
     * 
     * @param unionId
     * @return
     */
    public List<WeixinUser> getByUnionId(String unionId);
}
