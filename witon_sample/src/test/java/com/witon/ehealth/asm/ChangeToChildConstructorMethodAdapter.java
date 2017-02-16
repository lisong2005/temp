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
 * @version $Id: ChangeToChildConstructorMethodAdapter.java, v 0.1 2017年2月7日 下午4:12:48 song.li@witontek.com Exp $
 */
public class ChangeToChildConstructorMethodAdapter extends MethodAdapter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory
        .getLogger(ChangeToChildConstructorMethodAdapter.class);

    private String              superClassName;

    public ChangeToChildConstructorMethodAdapter(MethodVisitor mv, String superClassName) {
        super(mv);
        this.superClassName = superClassName;
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        logger.info("{}, {}, {}, {}", opcode, owner, name, desc);
        // 调用父类的构造函数时
        //        if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
        if (opcode == Opcodes.INVOKESPECIAL) {
            owner = superClassName;
        }
        super.visitMethodInsn(opcode, owner, name, desc);// 改写父类为 superClassName 
    }

}
