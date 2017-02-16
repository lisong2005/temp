/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.asm;

import java.io.IOException;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: SecureAccountGenerator.java, v 0.1 2017年2月7日 下午4:14:21 song.li@witontek.com Exp $
 */
public class SecureAccountGenerator {
    /**
    * Logger for this class
    */
    private static final Logger                logger      = LoggerFactory
        .getLogger(SecureAccountGenerator.class);

    private static AccountGeneratorClassLoader classLoader = new AccountGeneratorClassLoader();

    private static Class<?>                    secureAccountClass;

    public Account generateSecureAccount() throws ClassFormatError, InstantiationException,
                                           IllegalAccessException {
        try {
            if (null == secureAccountClass) {
                ClassReader cr = new ClassReader("com/witon/ehealth/asm/Account");
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
                cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
                byte[] data = cw.toByteArray();
                logger.info("{}", data.length);
                // logger.info("{}", new String(data));
                secureAccountClass = classLoader
                    .defineClassFromClassFile("com.witon.ehealth.asm.Account$EnhancedByASM", data);
                logger.info("{}", secureAccountClass);
            }
            return (Account) secureAccountClass.newInstance();
        } catch (IOException e) {
            logger.error("", e);
            return null;
        }
    }

    private static class AccountGeneratorClassLoader extends ClassLoader {

        public Class<?> defineClassFromClassFile(String className,
                                                 byte[] classFile) throws ClassFormatError {
            return defineClass(className, classFile, 0, classFile.length);
        }
    }
}
