/**
 * Witontek.com.
 * Copyright (c) 2012-2017 All Rights Reserved.
 */
package com.witon.ehealth.test.netty.client;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: TimeClientHandler.java, v 0.1 2017年6月23日 上午11:13:57 song.li@witontek.com Exp $
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(TimeClientHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("");
        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            logger.info("{}", new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.info("");
        cause.printStackTrace();
        ctx.close();
    }
}
