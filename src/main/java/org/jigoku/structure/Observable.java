package org.jigoku.structure;

/**
 * Observable pattern.
 */
public interface Observable {
	/**
	 * Add an object to the observer's list.
	 * 
	 * @param observer usually self
	 */
	void addObserver(final Observer observer);

	/**
	 * Remove an object form the observer's list.
	 * 
	 * @param observer usually self
	 */
	void removeObserver(final Observer observer);

	/**
	 * Notify each observer in the list by calling it's Observer.sendNotify
	 * method.
	 */
	void notifyObservers();
}
