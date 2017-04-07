/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.java;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: RSATest.java, v 0.1 2017年3月16日 上午9:01:14 song.li@witontek.com Exp $
 */
public class RSATest {
    /**
    * Logger for this class
    */
    private static final Logger logger        = LoggerFactory.getLogger(RSATest.class);

    /**
     * 非对称加密密钥算法
     */
    public static final String  KEY_ALGORITHM = "RSA";
    /**
     * RSA密钥长度 
     * 默认1024位，
     * 密钥长度必须是64的倍数， 
     * 范围在512至65536位之间。
     */
    private static final int    KEY_SIZE      = 1024;

    @Test
    public void test_001() {
        try {
            // 实例化密钥对生成器
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

            // 初始化密钥对生成器
            keyPairGen.initialize(KEY_SIZE);

            // 生成密钥对
            KeyPair keyPair = keyPairGen.generateKeyPair();

            // 公钥
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            // 私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
