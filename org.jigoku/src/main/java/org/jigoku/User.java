package org.jigoku;

public class User {
	protected String name;
	protected String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			password = new String(md.digest());
		} catch (Exception e){
			//could not encrypt password
		}
		this.password = password;
	}
	
}
