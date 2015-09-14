package org.hannes.rsd.io;

import java.io.IOException;
import java.net.SocketAddress;

/**
 * 
 * 
 * @author Red
 */
public interface IOHandler {

	/**
	 * Attempts to bind the service to the given socket address
	 * 
	 * @param address
	 * @throws IOException
	 */
	public abstract void bind(SocketAddress address) throws IOException;
	
	/**
	 * Attempts to close the service' socket
	 * 
	 * @throws IOException
	 */
	public abstract void close() throws IOException;

}