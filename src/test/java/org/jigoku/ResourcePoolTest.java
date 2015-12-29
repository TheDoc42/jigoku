package org.jigoku;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yves on 29.12.2015.
 */
public class ResourcePoolTest {

	private ArrayList<FlashCard> flashCards;
	private List<Kanji> kanjiList;

	@Before
	public void initResources() {
		ResourcePool resourcePool = new ResourcePool();
		flashCards = resourcePool.getFlashCards();
		kanjiList = resourcePool.getKanjiList();
	}

	@Test
	public void testFirstFlashCard() throws Exception {
		final FlashCard flashCard = flashCards.get(0);

		assertEquals("(n-suf) ~ an / ~ese (eg.: Japanese)", flashCard.getHint());
		assertEquals("じん", flashCard.getSolution());

		final ArrayList<JapChar> displayChars = flashCard.getDisplayChars();

		assertEquals(2, displayChars.size());
		assertEquals("～", displayChars.get(0).getOriginal());
		assertEquals(StringUtils.EMPTY, displayChars.get(0).getFurigana());
		assertEquals(0, displayChars.get(0).getKanjiId());
		assertEquals("人", displayChars.get(1).getOriginal());
		assertEquals("じん", displayChars.get(1).getFurigana());
		assertEquals(2, displayChars.get(1).getKanjiId());
	}

	@Test
	public void testTenthFlashCard() throws Exception {
		final FlashCard flashCard = flashCards.get(10);

		assertEquals("いちにち", flashCard.getSolution());
	}

	@Test
	public void testFirstKanji() throws Exception {
		final Kanji kanji = kanjiList.get(0);

		assertEquals("人", kanji.getKanji());
		assertEquals(9, kanji.getBushu());
		assertEquals(1, kanji.getGrade());
		assertEquals(4, kanji.getJlpt());
		assertEquals(11021, kanji.getKanjiOfWordsIndex());
		assertEquals(1, kanji.getKanjiToKana());
		assertEquals(2, kanji.getStrokeCount());
		assertEquals(Collections.singletonList("person"), kanji.getMeanings());
	}

	@Test
	public void testTenthKanji() throws Exception {
		final Kanji kanji = kanjiList.get(10);

		assertEquals("九", kanji.getKanji());
	}
}