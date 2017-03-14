/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.util.text;

import java.text.DecimalFormat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: DecimalFormatTest.java, v 0.1 2017年3月2日 上午10:55:41 song.li@witontek.com Exp $
 */
public class DecimalFormatTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(DecimalFormatTest.class);

    @Test
    public void test_001() {
        logger.debug("");
        DecimalFormat df1 = (DecimalFormat) DecimalFormat.getInstance();
        logger.info("{}", df1.toPattern());

        logger.info("{}", df1.format(11111.223456));
        df1.setGroupingSize(4);
        logger.info("{}", df1.toPattern());

        //        df1.setDecimalSeparatorAlwaysShown(false);
        df1.setMaximumFractionDigits(5);
        logger.info("{}", df1.toPattern());

        logger.info("{}", df1.format(11111.223456));
        logger.info("{}", df1.format(22222));

    }

    @Test
    public void test_002() {

        DecimalFormat df2 = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        logger.info("{}", df2.getRoundingMode());
        logger.info("{}", df2.toPattern());
        logger.info("{}", df2.format(22222));
        logger.info("{}", df2.format(22222.1));
        logger.info("{}", df2.format(22222.12));
        logger.info("{}", df2.format(22222.125));
        logger.info("{}", df2.format(22222.126));
        logger.info("{}", df2.format(22222.1269));
    }

}
