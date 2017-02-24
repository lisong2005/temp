/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.cglib;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witon.ehealth.cglib.cons.AccessFlagConstants;
import com.witon.ehealth.common.srv.integration.wx.WxRestServiceClient;
import com.witon.ehealth.util.event.model.NotifyContext;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: ByteCodeReader.java, v 0.1 2017年2月23日 下午2:08:17 song.li@witontek.com Exp $
 */
public class ByteCodeReader {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(ByteCodeReader.class);

    @Test
    public void test_001() {
        URL url = NotifyContext.class.getResource("NotifyContext.class");
        logger.info("{}", url.getPath());

        try {

            logger.info("\n{}", ByteCodeReader.readClazzFile(NotifyContext.class
                .getResourceAsStream(NotifyContext.class.getSimpleName() + ".class")));

            logger.info("\n{}", ByteCodeReader.readClazzFile(WxRestServiceClient.class
                .getResourceAsStream(WxRestServiceClient.class.getSimpleName() + ".class")));

        } catch (Exception e) {
            logger.error("", e);
        }
    }

    /**
     * 
     * @param is
     * @return
     */
    public static String readClazzFile(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try (DataInputStream bin = new DataInputStream(is)) {
            sb.append(Hex.encodeHex(
                new byte[] { bin.readByte(), bin.readByte(), bin.readByte(), bin.readByte() }));
            sb.append(System.lineSeparator());

            int minorVersion = bin.readUnsignedShort();
            int majorVersion = bin.readUnsignedShort();
            sb.append(majorVersion).append(".").append(minorVersion).append(System.lineSeparator());

            int constantPoolSize = bin.readUnsignedShort() - 1;
            sb.append("常量池大小：").append(constantPoolSize).append(System.lineSeparator());

            for (int i = 1; i <= constantPoolSize; i++) {
                sb.append("#").append(String.format("%03d", i));

                byte type = bin.readByte();
                sb.append(" [t:").append(String.format("%2d", type)).append("] ");
                switch (type) {
                    case 1:
                        int length = bin.readUnsignedShort();
                        byte[] bs = new byte[length];
                        bin.read(bs);
                        sb.append(new String(bs, Charset.forName("utf-8")));
                        break;
                    case 3:
                        sb.append("int value = ").append(bin.readInt());
                        break;
                    case 4:
                        sb.append("float value = ").append(bin.readFloat());
                        break;
                    case 5:
                        sb.append("long value = ").append(bin.readLong());
                        i++; // 
                        break;
                    case 6:
                        sb.append("double value = ").append(bin.readDouble());
                        break;
                    case 7:
                        sb.append("class_info to_index: ").append(bin.readUnsignedShort());
                        break;
                    case 8:
                        sb.append("string_info to_index: ").append(bin.readUnsignedShort());
                        break;
                    case 9:
                        sb.append("field_info to_index1: ").append(bin.readUnsignedShort());
                        sb.append(" to_index2: ").append(bin.readUnsignedShort());
                        break;
                    case 10:
                        sb.append("method_info to_index1: ").append(bin.readUnsignedShort());
                        sb.append(" to_index2: ").append(bin.readUnsignedShort());
                        break;
                    case 11:
                        sb.append("interface_info to_index1: ").append(bin.readUnsignedShort());
                        sb.append(" to_index2: ").append(bin.readUnsignedShort());
                        break;
                    case 12:
                        sb.append("type_info to_index1: ").append(bin.readUnsignedShort());
                        sb.append(" to_index2: ").append(bin.readUnsignedShort());
                        break;
                    case 15:
                        sb.append("method_hand_info ref_kind: ")
                            .append(Hex.encodeHex(new byte[] { bin.readByte() }));
                        sb.append(" ref_index: ").append(bin.readUnsignedShort());
                        break;
                    case 16:
                        sb.append("method_type_info desc_index: ").append(bin.readUnsignedShort());
                        break;
                    case 18:
                        sb.append("invoke_info att_index: ").append(bin.readUnsignedShort());
                        sb.append(" type_index: ").append(bin.readUnsignedShort());
                        break;
                    default:
                        sb.append("not found...");
                        return sb.toString();
                }
                sb.append(System.lineSeparator());
            }

            {
                int mod = bin.readUnsignedShort();
                if ((mod & AccessFlagConstants.ACC_PUBLIC) != 0) {
                    sb.append("public ");
                }
                if ((mod & AccessFlagConstants.ACC_FINAL) != 0) {
                    sb.append("final ");
                }
                if ((mod & AccessFlagConstants.ACC_SUPER) != 0) {
                    sb.append("super ");
                }
                if ((mod & AccessFlagConstants.ACC_INTERFACE) != 0) {
                    sb.append("interface ");
                }
                if ((mod & AccessFlagConstants.ACC_ABSTRACT) != 0) {
                    sb.append("abstract ");
                }
                if ((mod & AccessFlagConstants.ACC_SYNTHETIC) != 0) {
                    sb.append("synthetic ");
                }
                if ((mod & AccessFlagConstants.ACC_ANNOTATION) != 0) {
                    sb.append("annotation ");
                }
                if ((mod & AccessFlagConstants.ACC_ENUM) != 0) {
                    sb.append("enum ");
                }
            }

            {
                int clazzNameIndex = bin.readUnsignedShort();
                int superNameIndex = bin.readUnsignedShort();
                int interfaceCount = bin.readUnsignedShort();

                sb.append("classIndex:").append(clazzNameIndex).append(" ");
                sb.append("superIndex:").append(superNameIndex).append(" ");
                sb.append("interCount:").append(interfaceCount).append(" ");

                sb.append(System.lineSeparator());
            }

            return sb.toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return sb.toString();
        }
    }

}
