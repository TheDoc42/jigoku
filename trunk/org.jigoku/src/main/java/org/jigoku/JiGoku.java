package org.jigoku;

import java.util.List;

public class JiGoku {
	protected User user;

	// get all cards

	public static void main(String[] args) {

		ResourcePool resourcePool = new ResourcePool();

		List<Kanji> testedKanji = resourcePool.getKanjiList().subList(0, 5);

		final List<FlashCard> testCards = (new CardStack(testedKanji,
				resourcePool.getFlashCards(), 5)).getFlashcards();
		final Test test = new Test(testCards);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TestdisplayControl td = new TestdisplayControl(test);
				td.setVisible(true);
			}
		});
	}
}
