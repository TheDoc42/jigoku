package org.jigoku.inputmapper;

/**
 * Maps a string input from romaji to hiragana.
 */
public interface StringMapper {
	String map(final String input);
}
