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
		final List<FlashCard> hand = getHand();
//create game
		//assign hand
		//play
		//check score


	}

	private List<FlashCard> getHand() {
		ArrayList<FlashCard> hand = new ArrayList();
		for (int i = 0; i < 10; i++) {
			hand.add(flashCards.get(i));
		}
		return hand;
	}

}