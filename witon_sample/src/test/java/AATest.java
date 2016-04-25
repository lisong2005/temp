import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */

/**
 * 
 * @author Administrator
 * @version $Id: AATest.java, v 0.1 2016年4月25日 下午2:57:24 Administrator Exp $
 */
public class AATest {

    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args) throws Exception {
        System.out.println("start");
        for (int i = 0; i < 10; i++) {
            InputStream is = new FileInputStream(new File("d:/rsync.txt"));
        }

        byte[] b = new byte[16];
        System.in.read(b); // pause1
        System.out.println("A: " + new String(b));

        System.gc();
        System.out.println("2");

        byte[] b2 = new byte[16];
        System.in.read(b2); // pause2
        System.out.println("B: " + new String(b2));

        System.out.println("end");
    }
}
