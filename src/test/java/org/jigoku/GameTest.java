package org.jigoku;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yves on 29.12.2015.
 */
public class GameTest {

	private ArrayList<FlashCard> flashCards;
	private List<Kanji> kanjiList;

	@Before
	public void initResources() {
		ResourcePool resourcePool = new ResourcePool();
		flashCards = resourcePool.getFlashCards();
		kanjiList = resourcePool.getKanjiList();
	}

	@Test
	public void runGame() {


	}

}