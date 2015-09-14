package org.hannes.rsd.io.netty;

import java.io.IOException;

import org.hannes.rsd.io.Channel;
import org.hannes.rsd.io.IOHandler;
import org.hibernate.Session;

public class NettyChannel implements Channel {

	/**
	 * The session for this channel
	 */
	private final Session session;

	/**
	 * the io handler
	 */
	private final IOHandler handler;
	
	/**
	 * The Netty channel
	 */
	private final io.netty.channel.Channel nettyChannel;

	public NettyChannel(Session session, IOHandler handler, io.netty.channel.Channel nettyChannel) {
		this.session = session;
		this.handler = handler;
		this.nettyChannel = nettyChannel;
	}


	public void write(Object object) throws IOException {
		// nettyChannel.writeAndFlush(object instanceof Serializable ? ((Serializable) object).serialize(session) : object);
	}

	public void read(Object object) throws IOException {
//		if (object instanceof Message) {
//			handler.fireRead(new IOContext(session, (Message) object, handler));
//		}
	}

}