/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: AddSecurityCheckClassAdapter.java, v 0.1 2017年2月7日 下午4:03:21 song.li@witontek.com Exp $
 */
public class AddSecurityCheckClassAdapter extends ClassAdapter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory
        .getLogger(AddSecurityCheckClassAdapter.class);

    private String              enhancedSuperName;

    /**
     * @param arg0
     */
    public AddSecurityCheckClassAdapter(ClassVisitor arg0) {
        super(arg0);
    }

    // 重写 visitMethod，访问到 "operation" 方法时，
    // 给出自定义 MethodVisitor，实际改写方法内容
    public MethodVisitor visitMethod(final int access, final String name, final String desc,
                                     final String signature, final String[] exceptions) {
        logger.info("{}, {}, {}", name, desc, signature);
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        if (mv != null) {
            if (name.equals("operation")) {
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            } else if (name.equals("<init>")) {
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv, enhancedSuperName);
            } else if (name.equals("<clinit>")) {
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv, enhancedSuperName);
            }
        }
        return wrappedMv;
    }

    public void visit(final int version, final int access, final String name,
                      final String signature, final String superName, final String[] interfaces) {
        logger.info("{}, {}, {}, {}", version, name, signature, superName);
        String enhancedName = name + "$EnhancedByASM"; // 改变类命名
        enhancedSuperName = name; // 改变父类，这里是”Account”
        super.visit(version, access, enhancedName, signature, enhancedSuperName, interfaces);
    }
}
