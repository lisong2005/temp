/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.csv;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CSVTest.java, v 0.1 2016年10月28日 下午4:33:15 song.li@witontek.com Exp $
 */
public class CSVTest {
    /**
    * Logger for this class
    */
    private static final Logger   logger    = LoggerFactory.getLogger(CSVTest.class);

    private static final Object[] FILE_HEAD = { "编号", "城市", "房价" };

    @Test
    public void test_create() {
        logger.info("");

        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");

        try (Writer fileWriter = new OutputStreamWriter(new FileOutputStream("d:/test.csv"), "gbk");
                CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat)) {

            csvPrinter.printRecord(FILE_HEAD);
            csvPrinter.flush();

        } catch (Exception e) {
            logger.error("", e);
        }
        logger.info("");
    }

}
