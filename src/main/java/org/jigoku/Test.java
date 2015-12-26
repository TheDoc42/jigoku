package org.jigoku;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.jigoku.inputmapper.BaseRomajiMapper;
import org.jigoku.inputmapper.OchaRomajiMapper;
import org.jigoku.structure.Observable;
import org.jigoku.structure.Observer;

public class Test implements Observable {

	@Getter
	private int index = 0;
	@Getter
	private final List<FlashCard> errors = new ArrayList<FlashCard>();
	@Getter
	private FlashCard card;
	@Getter
	private int successCount = 0;

	private final List<FlashCard> cards;
	private final BaseRomajiMapper romajimapper = new OchaRomajiMapper();
	private final List<Observer> observers = new ArrayList<Observer>();
	private int errorCount = 0;

	public Test(final List<FlashCard> testCards) {
		this.cards = testCards;
		card = cards.get(index);
	}

	public void giveAnswer(final String answer) {
		String mappedanswer = romajimapper.map(answer);
		String solution = card.getSolution();
		if (mappedanswer.equals(solution)) {
			successCount++;
		} else {
			errorCount++;
			errors.add(card);
		}
		index++;
		if (index < cards.size()) {
			card = cards.get(index);
		} else {
			// Test is done
		}

		notifyObservers();
	}

	public boolean testIsDone() {
		return index >= cards.size();
	}

	public void addObserver(final Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.sendNotify(this);
		}
	}

	public void removeObserver(final Observer observer) {
		observers.remove(observer);
	}

	public int getLength() {
		return cards.size();
	}

	public String getHint() {
		return card.getHint();
	}

	public String getTranslation() {
		return card.getHint();
	}

	/**
	 * Returns the success rate of the running test.
	 * 
	 * @return success rate in percents.
	 */
	public int getSuccessrate() {
		if (index == 0 && successCount == 0) {
			return 100;
		} else {
			return (int) (((float) successCount / index) * 100);
		}
	}
}
