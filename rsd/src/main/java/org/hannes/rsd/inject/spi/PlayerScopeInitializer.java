package org.hannes.rsd.inject.spi;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class PlayerScopeInitializer implements Extension, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param event
	 */
	public void addScope(@Observes final BeforeBeanDiscovery event) {
		event.addScope(PlayerScope.class, true, false);
	}

	public void registerContext(@Observes final AfterBeanDiscovery event) {
		event.addContext(new PlayerScopeContext());
	}

}