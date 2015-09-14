package org.hannes.rsd;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.hannes.rsd.io.IOHandler;
import org.hannes.rsd.io.netty.Netty;
import org.jboss.weld.environment.se.events.ContainerInitialized;

public class App {

	/**
	 * The address the service will be bound to
	 */
	public static final SocketAddress SERVICE_ADDRESS = new InetSocketAddress(43594);

	/**
	 * The IO handler implementation that this server will be using
	 */
	@Inject @Netty private IOHandler io_handler;

	/**
	 * The program entry point. Called when the Weld CDI container has been initialized
	 * 
	 * @param event
	 */
	public void initialize(@Observes ContainerInitialized event) throws IOException {
		io_handler.bind(SERVICE_ADDRESS);
	}

}