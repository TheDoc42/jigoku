package org.jigoku.structure;

/**
 * Observer pattern.
 */
public interface Observer {
	/**
	 * Callback called to inform that a change has occurred.
	 * 
	 * @param observable usually self
	 */
	void sendNotify(final Observable observable);
}
