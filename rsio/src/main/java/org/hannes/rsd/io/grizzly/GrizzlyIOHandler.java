package org.hannes.rsd.io.grizzly;

import java.io.IOException;
import java.net.SocketAddress;

import javax.enterprise.context.ApplicationScoped;

import org.hannes.rsd.io.IOHandler;
import org.jboss.weld.exceptions.UnsupportedOperationException;

@ApplicationScoped
@Grizzly public class GrizzlyIOHandler implements IOHandler {

	@Override
	public void bind(SocketAddress address) throws IOException {
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public void close() throws IOException {
		throw new UnsupportedOperationException("not yet implemented");
	}

}
