package org.jigoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.jigoku.utils.FileLineReader;

public class ResourcePool {
	private static final int MEANINGS_INDEX_KANJIOFWORDSINDEX = 6;

	private static final int MEANINGS_INDEX_JLPT = 5;

	private static final int MEANINGS_INDEX_KANJITOKANA = 4;

	private static final int MEANINGS_INDEX_STROKECOUNT = 3;

	private static final int MEANINGS_INDEX_GRADE = 2;

	private static final int MEANINGS_INDEX_BUSHU = 1;

	private static final int MEANINGS_INDEX_KANJI = 0;

	private static final int KANJIINFOS_INDEX_MEANINGS = 7;

	private static final int WORDPARTS_INDEX_KANJINUMBER = 5;

	private static final int WORDPARTS_INDEX_FURIGANA = 3;

	private static final int WORDPARTS_INDEX_CHARACTER = 2;

	private static final int WORDPARTS_INDEX_DISPLAY = 4;

	private static final int VOCABULARY_INDEX_FIRSTCHARROW = 5;

	private static final int VOCABULARY_INDEX_WORDINHIRAGANA = 1;

	private static final int VOCABULARY_INDEX_WORDINKANJI = 0;

	private static final int VOCABULARY_INDEX_MEANING = 2;

	@Getter
	private final ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();

	@Getter
	private final List<Kanji> kanjiList = new ArrayList<Kanji>();

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
			// 0 - wordInKanji
			// 1 - WordinHiragana
			// 2 - Meaning
			// 3 - JLPT
			// 4 - ambiguous
			// 5 - firstcharrow
			// 6 - last test
			// 7 - first successful test
			// 8 - Tested Kanji
			// 9 - Most Elementary Kanji
			// 10 - LastTestNumber
			// 11 - original row

			String[] fields = lines.get(i).split(";");

			FlashCard flashCard = new FlashCard(fields[VOCABULARY_INDEX_WORDINKANJI], fields[VOCABULARY_INDEX_MEANING],
					fields[VOCABULARY_INDEX_FIRSTCHARROW]);
			flashCard.setSolution(fields[VOCABULARY_INDEX_WORDINHIRAGANA]);
			flashCards.add(flashCard);
		}
	}

	private void initWordPartsForFlashCards(final String fileName) {
		FileLineReader flr = new FileLineReader(fileName);
		ArrayList<String> lines = flr.getLines();

		// we skip the first line, which contains the header information

		/*
		 * 
		 * for (int i=1; i<lines.size(); i++) { //let's cut the line in pieces
		 * // 0 - row // 1 - position // 2 - character // 3 - furigana // 4 -
		 * display // 5 - Kanji Number }
		 */

		for (FlashCard flashcard : flashCards) {
			try {

				// our line count starts at 0

				int index = new Integer(flashcard.getFirstcharrow());
				index--;
				int subindex = 0;
				StringBuilder translate = new StringBuilder();
				ArrayList<JapChar> displaychars = new ArrayList<JapChar>();
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

					if (isDisplayOnlyKana(fields[WORDPARTS_INDEX_DISPLAY])) {

						// kana or ～

						displaychars.add(new JapChar(fields[WORDPARTS_INDEX_CHARACTER], StringUtils.EMPTY, 0));

					} else {

						// kanji

						displaychars.add(new JapChar(fields[WORDPARTS_INDEX_CHARACTER],
								fields[WORDPARTS_INDEX_FURIGANA], new Integer(fields[WORDPARTS_INDEX_KANJINUMBER])));
					}

					// ignore ～ for the solution
					if (!fields[3].equals("～")) {
						translate.append(fields[WORDPARTS_INDEX_FURIGANA]);
					}

				}
				flashcard.setSolution(translate.toString());
				flashcard.setDisplaychars(displaychars);
			} catch (Exception e) {
				System.out.println("enrichFromFile:" + e);
			}
		}
	}

	private boolean isDisplayOnlyKana(final String field) {
		return field.equals("display") || field.equals("displayKanji");
	}

	private void initKanjiInfos(final String fileName) {
		FileLineReader flr = new FileLineReader(fileName);
		ArrayList<String> lines = flr.getLines();

		// we skip the first line, which contains the header information

		for (int i = 1; i < lines.size(); i++) {
			// let's cut the line in pieces
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

			String[] fields = lines.get(i).split(";");

			List<String> meanings = Arrays.asList(StringUtils.split(fields[KANJIINFOS_INDEX_MEANINGS], "{}"));

			kanjiList.add(new Kanji(fields[MEANINGS_INDEX_KANJI], new Integer(fields[MEANINGS_INDEX_BUSHU]),
					new Integer(fields[MEANINGS_INDEX_GRADE]), new Integer(fields[MEANINGS_INDEX_STROKECOUNT]),
					new Integer(fields[MEANINGS_INDEX_KANJITOKANA]), new Integer(fields[MEANINGS_INDEX_JLPT]),
					new Integer(fields[MEANINGS_INDEX_KANJIOFWORDSINDEX]), meanings));
		}
	}
}
