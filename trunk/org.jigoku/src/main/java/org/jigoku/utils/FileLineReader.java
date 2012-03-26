package org.jigoku.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads a file into a list of lines.
 */
public class FileLineReader {

	@Getter
	private final ArrayList<String> lines = new ArrayList<String>();

	public FileLineReader(final String filename) {
		final Logger logger = LoggerFactory.getLogger(getClass());
		try {
			InputStream inStream = getClass().getClassLoader().getResourceAsStream(filename);
			// keep file out of Jar: FileInputStream instream = new
			// FileInputStream(filename);
			InputStreamReader inReader = new InputStreamReader(inStream, "UTF-8");
			BufferedReader inBufReader = new BufferedReader(inReader);
			String line;
			while ((line = inBufReader.readLine()) != null) {
				logger.info(line);
				line = line.replace("\"", "");
				this.lines.add(line);
			}
		} catch (Exception e) {
			logger.debug(e.toString());
		}
	}
}
