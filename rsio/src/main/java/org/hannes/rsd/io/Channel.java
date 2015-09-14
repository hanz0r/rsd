package org.hannes.rsd.io;

import java.io.IOException;

/**
 * 
 * @author Red
 */
public interface Channel {

	/**
	 * Writes an object
	 * 
	 * @param object
	 */
	public abstract void write(Object object) throws IOException;
	
	/**
	 * Reads an object
	 * 
	 * @param object
	 */
	public abstract void read(Object object) throws IOException;

}