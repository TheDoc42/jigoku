package org.jigoku;

public final class Logger {
	protected static Logger logger = null;
	
	
	public enum Logtype {
		CONSOLE
	}
	
	protected Logtype logtype = null; 
	
	private Logger() {
	}
	
	public static synchronized Logger getInstance(Logtype logtype) {
		if (logger == null) {
			logger = new Logger();
			logger.logtype = logtype;
		}
		return logger;
	}
	
	public void log(String string) {
		if (logtype == Logtype.CONSOLE) {
			System.out.println(string);
		} 
	}

}
