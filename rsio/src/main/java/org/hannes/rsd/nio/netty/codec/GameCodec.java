package org.hannes.rsd.nio.netty.codec;

import java.util.List;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

/**
 * 
 * @author Red
 *
 */
public class GameCodec extends MessageToMessageCodec<ByteBuf, Object> {
	
	/**
	 * The logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GameCodec.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
		logger.info(msg + " sent");
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		logger.info(msg + " received");
	}

}