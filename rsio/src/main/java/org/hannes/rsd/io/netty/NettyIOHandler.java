package org.hannes.rsd.io.netty;

import java.io.IOException;
import java.net.SocketAddress;

import javax.enterprise.context.ApplicationScoped;

import org.hannes.rsd.io.IOHandler;
import org.jboss.weld.exceptions.UnsupportedOperationException;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@ApplicationScoped
@Netty public class NettyIOHandler implements IOHandler {

	/**
	 * The server bootstrap
	 */
	private final ServerBootstrap bootstrap = new ServerBootstrap();

	@Override
	public void bind(SocketAddress address) throws IOException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			/*
			 * Create the bootstrap group
			 */
			bootstrap.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new NettyChannelInitializer(new NettyChannelHandler(this)))
					.option(ChannelOption.SO_BACKLOG, 128)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			/*
			 * Bind and start to accept incoming connections.
			 */
			ChannelFuture f = bootstrap.bind(address).sync();

			/*
			 * Wait until the server socket is closed to shut down the server
			 */
			f.channel().closeFuture().sync();
		} catch (InterruptedException ex) {
			throw new IOException("could not start server",ex);
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	@Override
	public void close() throws IOException {
		throw new UnsupportedOperationException("not yet implemented");
	}

}