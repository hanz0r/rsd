package org.hannes.rsd.io.netty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.hannes.rsd.io.IOHandler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 
 * @author Red
 *
 */
@ApplicationScoped public class NettyChannelHandler extends ChannelHandlerAdapter {
	
	/**
	 * The io handler
	 */
	private final IOHandler handler;
	
	public NettyChannelHandler(IOHandler handler) {
		this.handler = handler;
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
	}

}