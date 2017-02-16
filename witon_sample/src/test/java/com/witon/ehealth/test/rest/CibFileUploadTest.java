/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package com.witon.ehealth.test.rest;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.common.srv.integration.EhJerseyClient;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: CibFileUploadTest.java, v 0.1 2016年12月23日 上午10:45:34 song.li@witontek.com Exp $
 */
public class CibFileUploadTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(CibFileUploadTest.class);

    @Test
    public void test_001() {
        exe_for_ls();
    }

    /**
     * 
     */
    private static void exe_for_ls() {
        String uri = "http://rb-esf01.chinacloudapp.cn/cibPay/ed/property/importPropertyExcel.html";
        // uri = "https://icloud.cib.com.cn/educationPay/ed/student/importStudentsExcel";
        uri = "https://icloud.cib.com.cn/educationPay/ed/schpayItem/importPayingExcel";
        try {
            Client client = EhJerseyClient.getSSLTrustJerseyClient();
            WebTarget target = client.target(uri);

            FormDataMultiPart multiPart = new FormDataMultiPart();
            {
                FormDataBodyPart item = new FormDataBodyPart("uploaditemid",
                    "8ea99b91803b4ae89152621108d33f99");
                multiPart.bodyPart(item);
            }
            {
                FormDataBodyPart item = new FormDataBodyPart("upLoadItemFeeType", "2222");
                multiPart.bodyPart(item);
            }
            {
                String pathname = "d:/b.jsp";
                FileDataBodyPart fdbp = new FileDataBodyPart("uploadFile", new File(pathname)
                // , MediaType.APPLICATION_OCTET_STREAM_TYPE
                );
                BodyPart bp = multiPart.bodyPart(fdbp);
                logger.info("{}", bp);
            }
            //            {
            //                String pathname = "d:/property-wuye.xlsx";
            //                FileDataBodyPart fdbp = new FileDataBodyPart("uploadFile2", new File(pathname));
            //                BodyPart bp = multiPart.bodyPart(fdbp);
            //                logger.info("{}", bp);
            //            }

            String restResult = target.request(MediaType.MULTIPART_FORM_DATA_TYPE)
                .header("Cookie", "JSESSIONID=7E90C524FEF886E20757AEC093F9990D")
                //
                .post(Entity.entity(multiPart, multiPart.getMediaType()), String.class);

            logger.info("{}", restResult);

        } catch (Exception e) {
            logger.error("", e);
        }
    }
}
