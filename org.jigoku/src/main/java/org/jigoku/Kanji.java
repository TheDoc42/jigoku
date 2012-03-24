package org.jigoku;

import java.util.List;

import lombok.Data;

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

	// 0 - Kanji
	// 1 - Bushu
	// 2 - Grade
	// 3 - StrokeCount
	// 4 - kanji to kana
	// 5 - JLPT
	// 6 - KanjiOfWords index
	// 7 - Meaning
	// 8 - Knowledge
	// 9 - last test
	// 10 - first successful test

//	public Kanji(String kanji, Integer bushu, Integer grade, Integer strokeCount,
//			Integer kanjiToKana, Integer jlpt, Integer kanjiOfWordsIndex, List<String> meanings) {
//				this.kanji = kanji;
//				this.bushu = bushu;
//				this.grade = grade;
//				this.strokeCount = strokeCount;
//				this.kanjiToKana = kanjiToKana;
//				this.jlpt = jlpt;
//				this.kanjiOfWordsIndex = kanjiOfWordsIndex;
//				this.meanings = meanings;
//	}

}
