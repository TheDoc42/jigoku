package org.jigoku;

public final class Registry {

	protected static Registry registry = null;

	private Registry() {
	}
	
	public static synchronized Registry getInstance() {
		if (registry == null) {
			registry = new Registry();
		}
		return registry;
	}
	
}
