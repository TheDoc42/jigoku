package org.jigoku;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO: implement class

public class User {
	@Getter
	private final String name;
	private String password;

	private final Logger LOGGER = LoggerFactory.getLogger(User.class);

	public User(final String name, final String password) {
		this.name = name;
		this.password = password;

	}

	/**
	 * Stores the password securely for further use.
	 * 
	 * @param password
	 *            secret
	 */
	public final void setPassword(String password) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			password = new String(md.digest());
		} catch (Exception e) {
			LOGGER.error("could not store password");
		}
		this.password = password;
	}
}
