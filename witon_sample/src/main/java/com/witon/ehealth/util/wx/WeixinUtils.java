/**
 * Witontek.com.
 * Copyright (c) 2012-2014 All Rights Reserved.
 */
package com.witon.ehealth.util.wx;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.ByteGroup;
import com.qq.weixin.mp.aes.PKCS7Encoder;
import com.witon.ehealth.util.EhealthConstants;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: WeixinUtils.java, v 0.1 2014年12月30日 下午2:15:11 song.li@witontek.com Exp $
 */
public class WeixinUtils {
    /**
    * Logger for this class
    */
    private static final Logger logger             = LoggerFactory.getLogger(WeixinUtils.class);

    public static final String  MESSAGE_DIGEST_ALG = "SHA-1";

    /**  */
    public static final Charset CHARSET            = Charset
                                                       .forName(EhealthConstants.DEFAULT_CHARSET);

    public static String        ENCRYPT_XML_FORMAT = "<xml>\n"
                                                     // =============================================
                                                     + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
                                                     + "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
                                                     + "<TimeStamp>%3$s</TimeStamp>\n"
                                                     + "<Nonce><![CDATA[%4$s]]></Nonce>\n"
                                                     // =============================================
                                                     + "</xml>";

    /**
     * 
     * @param signature
     * @param timestamp
     * @param nonce
     * @param token
     * @return
     */
    public static boolean verifyUrl(String signature, String timestamp, String nonce, String token)
                                                                                                   throws AesException {
        String digest = getSHA1HexStr(timestamp, nonce, token);
        return StringUtils.equalsIgnoreCase(signature, digest);
    }

    /**
     * 用SHA1算法生成安全签名
     * 
     * @param token 票据
     * @param timestamp 时间戳
     * @param nonce 随机字符串
     * @param encrypt 密文
     * @return 安全签名
     */
    public static String getSHA1(String token, String timestamp, String nonce, String encrypt)
                                                                                              throws AesException {
        return getSHA1HexStr(token, timestamp, nonce, encrypt);
    }

    /**
     * 验证签名并解密密文
     * 
     * @param appId
     * @param token
     * @param encodingAesKey
     * @param msgSignature
     * @param timeStamp
     * @param nonce
     * @param encrypt
     * @return
     * @throws AesException
     */
    public static String verifyDecryptMsg(String appId, String token, String encodingAesKey,
                                          String msgSignature, String timeStamp, String nonce,
                                          String encrypt) throws AesException {
        // 验证安全签名
        String signature = getSHA1(token, timeStamp, nonce, encrypt);
        if (!StringUtils.equalsIgnoreCase(signature, msgSignature)) {
            throw new AesException(AesException.ValidateSignatureError);
        }

        // 密文解密
        return decrypt(appId, encodingAesKey, encrypt);
    }

    /**
     * 
     * @param appId
     * @param encodingAesKey
     * @param text
     * @param token
     * @param nonce
     * @return
     * @throws AesException
     */
    public static String encryptAndSign(String appId, String encodingAesKey, String text,
                                        String token, String nonce) throws AesException {
        String encryptMsg = encrypt(appId, encodingAesKey, text);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        String msgSignature = getSHA1(token, timestamp, nonce, encryptMsg);
        return String.format(ENCRYPT_XML_FORMAT, encryptMsg, msgSignature, timestamp, nonce);
    }

    /**
     * 
     * @param appId
     * @param encodingAesKey
     * @param text
     * @param randomStr
     * @return
     * @throws AesException
     */
    public static String encrypt(String appId, String encodingAesKey, String text)
                                                                                  throws AesException {
        byte[] aesKey = Base64.decodeBase64(encodingAesKey + "=");

        ByteGroup byteCollector = new ByteGroup();
        byte[] randomStrBytes = getRandomStr().getBytes(CHARSET);
        byte[] textBytes = text.getBytes(CHARSET);
        byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
        byte[] appidBytes = appId.getBytes(CHARSET);

        // randomStr + networkBytesOrder + text + appid
        byteCollector.addBytes(randomStrBytes);
        byteCollector.addBytes(networkBytesOrder);
        byteCollector.addBytes(textBytes);
        byteCollector.addBytes(appidBytes);

        // ... + pad: 使用自定义的填充方式对明文进行补位填充
        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);

        // 获得最终的字节流, 未加密
        byte[] unencrypted = byteCollector.toBytes();

        try {
            // 设置加密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

            // 加密
            byte[] encrypted = cipher.doFinal(unencrypted);

            // 使用BASE64对加密后的字符串进行编码
            String base64Encrypted = Base64.encodeBase64String(encrypted);

            return base64Encrypted;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AesException(AesException.EncryptAESError);
        }
    }

    /**
     * 解密
     * @param appId
     * @param encodingAesKey
     * @param text
     * 
     * @return
     * @throws AesException
     */
    public static String decrypt(String appId, String encodingAesKey, String text)
                                                                                  throws AesException {
        byte[] aesKey = Base64.decodeBase64(encodingAesKey + "=");
        byte[] original;
        try {
            // 设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);

            // 使用BASE64对密文进行解码
            byte[] encrypted = Base64.decodeBase64(text);

            // 解密
            original = cipher.doFinal(encrypted);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AesException(AesException.DecryptAESError);
        }

        String xmlContent, from_appid;
        try {
            // 去除补位字符
            byte[] bytes = PKCS7Encoder.decode(original);

            // 分离16位随机字符串,网络字节序和AppId
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);

            int xmlLength = recoverNetworkBytesOrder(networkOrder);

            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
            from_appid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length),
                CHARSET);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AesException(AesException.IllegalBuffer);
        }

        // appid不相同的情况
        if (!StringUtils.equals(appId, from_appid)) {
            throw new AesException(AesException.ValidateAppidError);
        }
        return xmlContent;

    }

    /**
     * 
     * @param values
     * @return
     */
    private static String getSHA1HexStr(String... values) throws AesException {
        // 字符串排序
        String[] array = values;
        Arrays.sort(array);

        // 字符串创建
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        String str = sb.toString();

        // SHA1签名生成
        try {
            MessageDigest md = MessageDigest.getInstance(MESSAGE_DIGEST_ALG);
            md.update(str.getBytes());
            byte[] digest = md.digest();

            return Hex.encodeHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
            throw new AesException(AesException.ComputeSignatureError);
        }
    }

    // 还原4个字节的网络字节序
    protected static int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    // 生成4个字节的网络字节序
    protected static byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    // 随机生成16位字符串
    protected static String getRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
