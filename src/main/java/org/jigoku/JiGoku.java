package org.jigoku;

import java.util.List;

import org.jigoku.display.TestdisplayControl;

/**
 * Main program.
 */
public final class JiGoku {
	private static final int LENGTH_OF_RUN = 5;
	private List<Kanji> testedKanji;

	/**
	 * Prevent instantiation.
	 */
	private JiGoku() {
	}

	/**
	 * Main program.
	 * 
	 * @param args
	 *            command line arguments.
	 */
	public static void main(final String[] args) {

		ResourcePool resourcePool = new ResourcePool();

		List<Kanji> testedKanji =  resourcePool.getKanjiList().subList(0, LENGTH_OF_RUN); 

		final List<FlashCard> testCards = (new CardStack(testedKanji, resourcePool.getFlashCards(), LENGTH_OF_RUN)).getFlashcards();
		final Game test =  new Game(testCards);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TestdisplayControl td = new TestdisplayControl(test);
				td.setVisible(true);
			}
		});
	}
}
