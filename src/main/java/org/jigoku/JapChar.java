package org.jigoku;

import lombok.Data;

/**
 * Represents a single character with its associated furigana.
 */
@Data
public class JapChar {
	private final String original;
	private final String furigana;
	private final int kanjiId;
}
