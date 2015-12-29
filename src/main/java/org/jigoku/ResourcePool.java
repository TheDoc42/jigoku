package org.jigoku;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.jigoku.utils.FileLineReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prepares a list of kanjis and flashcards extracted from the resource files.
 */
public class ResourcePool {

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

	private static final int KANJI_INFO_INDEX_KANJI = 0;
	private static final int KANJI_INFO_INDEX_BUSHU = 1;
	private static final int KANJI_INFO_INDEX_GRADE = 2;
	private static final int KANJI_INFO_INDEX_STROKE_COUNT = 3;
	private static final int KANJI_INFO_INDEX_KANJI_TO_KANA = 4;
	private static final int KANJI_INFO_INDEX_JLPT = 5;
	private static final int KANJI_INFO_INDEX_KANJI_OF_WORDS_INDEX = 6;
	private static final int KANJI_INFO_INDEX_MEANINGS = 7;

	// 0 - row
	// 1 - position
	// 2 - character
	// 3 - furigana
	// 4 - display
	// 5 - Kanji Number

	private static final int WORD_PARTS_INDEX_CHARACTER = 2;
	private static final int WORD_PARTS_INDEX_FURIGANA = 3;
	private static final int WORD_PARTS_INDEX_DISPLAY = 4;
	private static final int WORD_PARTS_INDEX_KANJI_NUMBER = 5;

	// 0 - wordInKanji
	// 1 - wordInHiragana
	// 2 - Meaning
	// 3 - JLPT
	// 4 - ambiguous
	// 5 - firstCharRow
	// 6 - last test
	// 7 - first successful test
	// 8 - Tested Kanji
	// 9 - Most Elementary Kanji
	// 10 - LastTestNumber
	// 11 - original row

	private static final int VOCABULARY_INDEX_WORD_IN_KANJI = 0;
	private static final int VOCABULARY_INDEX_WORD_IN_HIRAGANA = 1;
	private static final int VOCABULARY_INDEX_MEANING = 2;
	private static final int VOCABULARY_INDEX_FIRST_CHAR_ROW = 5;

	@Getter
	private final ArrayList<FlashCard> flashCards = new ArrayList<>();

	@Getter
	private final List<Kanji> kanjiList = new ArrayList<>();

	public ResourcePool() {
		initFlashCardsFromVocabulary("vocabulary.csv");
		initWordPartsForFlashCards("wordparts.csv");
		initKanjiInfos("kanji.csv");
	}

	private void initFlashCardsFromVocabulary(final String fileName) {
		FileLineReader flr = new FileLineReader(fileName);
		ArrayList<String> lines = flr.getLines();

		// we skip the first line, which contains the header information

		for (int i = 1; i < lines.size(); i++) {
			// let's cut the line in pieces

			String[] fields = lines.get(i).split(";");

			FlashCard flashCard = new FlashCard(
					fields[VOCABULARY_INDEX_WORD_IN_KANJI],
					fields[VOCABULARY_INDEX_MEANING],
					fields[VOCABULARY_INDEX_FIRST_CHAR_ROW]);

			//set initial solution
			flashCard.setSolution(fields[VOCABULARY_INDEX_WORD_IN_HIRAGANA]);

			flashCards.add(flashCard);
		}
	}

	private void initWordPartsForFlashCards(final String fileName) {
		FileLineReader flr = new FileLineReader(fileName);
		ArrayList<String> lines = flr.getLines();

		// we skip the first line, which contains the header information

		for (FlashCard flashcard : flashCards) {
			try {

				// our line count starts at 0

				int index = new Integer(flashcard.getFirstCharRow());
				index--;
				int subindex = 0;
				StringBuilder translate = new StringBuilder();
				ArrayList<JapChar> displaychars = new ArrayList<>();
				while ((index + subindex) < lines.size()) {
					String[] fields = lines.get(index + subindex).split(";");
					subindex++;

					// check if we're too far: the position parameter should be
					// equal to subindex;
					if (new Integer(fields[1]) != subindex) {
						break;
					}

					// "display" means not kanji or "～"
					// "displaykanji" means non jouyo-kanji

					if (isDisplayOnlyKana(fields[WORD_PARTS_INDEX_DISPLAY])) {

						// kana or ～

						displaychars.add(new JapChar(fields[WORD_PARTS_INDEX_CHARACTER], StringUtils.EMPTY, 0));

					} else {

						// kanji

						displaychars.add(new JapChar(fields[WORD_PARTS_INDEX_CHARACTER],
								fields[WORD_PARTS_INDEX_FURIGANA], new Integer(fields[WORD_PARTS_INDEX_KANJI_NUMBER])));
					}

					// ignore ～ for the solution
					if (!fields[3].equals("～")) {
						translate.append(fields[WORD_PARTS_INDEX_FURIGANA]);
					}

				}

				//replace initial solution
				flashcard.setSolution(translate.toString());

				flashcard.setDisplayChars(displaychars);
			} catch (Exception e) {
				System.out.println("enrichFromFile:" + e);
			}
		}
	}

	private void initKanjiInfos(final String fileName) {
		FileLineReader flr = new FileLineReader(fileName);
		ArrayList<String> lines = flr.getLines();

		// we skip the first line, which contains the header information

		for (int i = 1; i < lines.size(); i++) {

			String[] fields = lines.get(i).split(";");

			List<String> meanings = Arrays.asList(StringUtils.split(fields[KANJI_INFO_INDEX_MEANINGS], "{}"));

			kanjiList.add(new Kanji(fields[KANJI_INFO_INDEX_KANJI], new Integer(fields[KANJI_INFO_INDEX_BUSHU]),
					new Integer(fields[KANJI_INFO_INDEX_GRADE]), new Integer(fields[KANJI_INFO_INDEX_STROKE_COUNT]),
					new Integer(fields[KANJI_INFO_INDEX_KANJI_TO_KANA]), new Integer(fields[KANJI_INFO_INDEX_JLPT]),
					new Integer(fields[KANJI_INFO_INDEX_KANJI_OF_WORDS_INDEX]), meanings));
		}
	}

	private boolean isDisplayOnlyKana(final String field) {
		return field.equals("display") || field.equals("displayKanji");
	}

}
