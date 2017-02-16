/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.asm;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AddSecurityCheckMethodAdapter.java, v 0.1 2017年2月7日 下午4:04:29 song.li@witontek.com Exp $
 */
public class AddSecurityCheckMethodAdapter extends MethodAdapter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory
        .getLogger(AddSecurityCheckMethodAdapter.class);

    /**
     * @param arg0
     */
    public AddSecurityCheckMethodAdapter(MethodVisitor arg0) {
        super(arg0);
    }

    public void visitCode() {
        logger.info("");
        visitMethodInsn(Opcodes.INVOKESTATIC, "com/witon/ehealth/asm/SecurityCheck",
            "checkSecurity", "()V");
    }

}
