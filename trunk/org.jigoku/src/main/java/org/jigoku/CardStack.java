package org.jigoku;

import java.util.ArrayList;
import java.util.List;

import org.jigoku.utils.Randomizer;



public class CardStack {

	private static final int STACK_SIZE = 5;
	private List<FlashCard> flashcards = new ArrayList<FlashCard>();

	public CardStack(List<Kanji> kanjiList, List<FlashCard> cardPool, int stackSize) {
		chooseCards(kanjiList, cardPool, stackSize);
		flashcards = Randomizer.shuffle(flashcards);
	}

	private void chooseCards(List<Kanji> kanjiList, List<FlashCard> cardPool, int stackSize) {
		// choose cards
		List<FlashCard> cards = Randomizer.shuffle(cardPool);
		int cardsCount = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getContents().contains(kanjiList.get(0).getKanji())) {
				flashcards.add(cards.get(i));
				cardsCount++;
				if (cardsCount >= stackSize) {
					break;
				}
			}
		}
	}
	
	public List<FlashCard> getFlashcards() {
		return flashcards;
	}
	
	public int size() {
		return flashcards.size();
	}
	
	public FlashCard getCard(int index) {
		return flashcards.get(index);
	}
}
