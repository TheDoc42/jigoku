package org.jigoku;

import lombok.Data;

import java.util.List;

/**
 * Represents a kanji with meta data to link it to the search system.
 */
@Data
public class Kanji {
	private final String kanji;
	private final int bushu;
	private final int grade;
	private final int strokeCount;
	private final int kanjiToKana;
	private final int jlpt;
	private final int kanjiOfWordsIndex;
	private final List<String> meanings;
}
