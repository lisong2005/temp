/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util.text;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: NumberFormatTest.java, v 0.1 2017年3月2日 上午10:38:42 song.li@witontek.com Exp $
 */
public class NumberFormatTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(NumberFormatTest.class);

    @Test
    public void test_001() {
        logger.info("");

        {
            logger.info("xxxxxxxxxxxxxxxxxxxxxx");
            Locale[] ls = NumberFormat.getAvailableLocales();
            for (Locale locale : ls) {
                NumberFormat nfItem = NumberFormat.getCurrencyInstance(locale);
                logger.info("{}, {}", locale, nfItem.getCurrency());
            }
        }
    }

    @Test
    public void test_002() {
        logger.info("");
        NumberFormat defaultNf = NumberFormat.getInstance();
        logger.info("{}, {}", defaultNf.getCurrency(), defaultNf.format(11111111.226));

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        logger.info("{}, {}", nf.getCurrency(), nf.format(11111111.226));

    }

}
