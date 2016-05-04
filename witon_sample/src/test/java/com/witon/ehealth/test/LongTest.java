/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: LongTest.java, v 0.1 2016年4月29日 上午8:17:11 song.li@witontek.com Exp $
 */
public class LongTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(LongTest.class);

    @Test
    public void test_001() {
        int a = 0xcafebabe;
        logger.info("{}", a);
        logger.info("{}", Integer.toHexString(a));
        logger.info("{}", Long.toHexString(a));

        int b = 0x7afebabe;
        logger.info("{}", b);
        logger.info("{}", Integer.toHexString(b));
        logger.info("{}", Long.toHexString(b));

    }

    @Test
    public void test_002() {
        byte[] bs = new byte[] { 0x41, 0x20, 0x41, 0x61, (byte) 0xe0, 0x61 };
        logger.info("{}", new String(bs));

        byte b = 0x7f;
        for (int i = 0; i < 129; i++) {
            byte a = (byte) (i);
            byte newB = (byte) (b + a);
            String ss = new String(new byte[] { newB });
            logger.info("{}, {}, {}, {}, {}", i, newB, ss, ss.trim(), StringUtils.strip(ss));
        }
    }

    @Test
    public void test_003() throws DecoderException {
        byte a = 127;
        for (;;) {
            a += 1;
            logger.info("{}, {}", a, Hex.encodeHexString(new byte[] { a }));
            if (a > 0) {
                break;
            }
        }
        byte b = -1;
        byte c = (byte) 0x80;
        byte e = 0x7f;
        logger.info("{}, {}", c, e);
        int aa = 0xff & b;
        logger.info("{}", Integer.toBinaryString(-1));
        logger.info("{}", Integer.toBinaryString(aa));

        Object ret = new BinaryCodec().decode(Integer.toBinaryString(-1));
        Object ret2 = new BinaryCodec().decode(Integer.toBinaryString(aa));
        logger.info("{}", ret);
        logger.info("{}", ret2);
    }
}
