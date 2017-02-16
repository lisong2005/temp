/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.asm.t1;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: Generator.java, v 0.1 2017年2月7日 下午5:05:21 song.li@witontek.com Exp $
 */
public class Generator {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(Generator.class);

    public static void main(String[] args) {
        try {
            getC().m();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    public static C getC() {
        try {
            AccountGeneratorClassLoader classLoader = new AccountGeneratorClassLoader();

            ClassReader cr = new ClassReader("com/witon/ehealth/asm/t1/C");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassAdapter classAdapter = new AddTimeClassAdapter(cw);
            //使给定的访问者访问Java类的ClassReader
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();

            Class<?> clazz = classLoader.defineClassFromClassFile("com.witon.ehealth.asm.t1.C",
                data);
            return (C) clazz.newInstance();
        } catch (Exception e) {
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
