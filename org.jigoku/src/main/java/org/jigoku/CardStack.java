package org.jigoku;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.jigoku.utils.Randomizer;

/**
 * Stack of Flashcards.
 */
/**
 *
 */
public class CardStack {

	@Getter
	private List<FlashCard> flashcards = new ArrayList<FlashCard>();

	/**
	 * Create a randomized stack of flashcards.
	 * 
	 * @param kanjiList
	 *            list of kanji to be tested
	 * @param cardPool
	 *            list of available flashcards
	 * @param stackSize
	 *            maximal amount of cards to return
	 */
	public CardStack(final List<Kanji> kanjiList, final List<FlashCard> cardPool, final int stackSize) {
		chooseCards(kanjiList, cardPool, stackSize);
		flashcards = Randomizer.shuffle(flashcards);
	}

	/**
	 * Get an amount of cards from the stack.
	 * 
	 * @param kanjiList
	 *            list of kanji to be tested
	 * @param cardPool
	 *            list of available flashcards
	 * @param stackSize
	 *            maximal amount of cards to return
	 */
	private void chooseCards(final List<Kanji> kanjiList, final List<FlashCard> cardPool, final int stackSize) {
		// choose cards
		List<FlashCard> cards = Randomizer.shuffle(cardPool);
		int cardsCount = 0;
        for (FlashCard card : cards) {
            if (card.getContents().contains(kanjiList.get(0).getKanji())) {
                flashcards.add(card);
                cardsCount++;
                if (cardsCount >= stackSize) {
                    break;
                }
            }
        }
	}

	/**
	 * Get the real size of the card stack.
	 * 
	 * @return amount of cards in the stack
	 */
	public final int size() {
		return flashcards.size();
	}

	/**
	 * Get a specific flash card from the stack.
	 * 
	 * @param index
	 *            index of the desired card
	 * @return one flash card
	 */
	public final FlashCard getCard(final int index) {
		return flashcards.get(index);
	}
}
