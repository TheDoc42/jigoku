package org.jigoku;
import java.util.ArrayList;
import java.util.List;

import org.jigoku.inputmapper.BaseRomajiMapper;
import org.jigoku.inputmapper.OchaRomajiMapper;
import org.jigoku.structure.Observable;
import org.jigoku.structure.Observer;



public class Test implements Observable {
	
	private List<FlashCard> cards;
	private int index = 0;
	private BaseRomajiMapper romajimapper = new OchaRomajiMapper();
	private List<Observer> observers = new ArrayList<Observer>();
	private int successCount = 0;
	private int errorCount = 0;
	private List<FlashCard> errors = new ArrayList<FlashCard>();
	private FlashCard card;
	
	public Test(List<FlashCard> testCards) {
		this.cards = testCards;
		card = cards.get(index);
	}
	
	public void giveAnswer(String answer) {
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
			//Test is done
		}

		notifyObservers();
	}

	public boolean testIsDone() {
		return index >= cards.size();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers() {
		for (Observer obs: observers) {
			obs.sendNotify(this);
		}
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public int getLength() {
		return cards.size();
	}

	public FlashCard getCard() {
		return card;
	}

	public String getHint() {
		return card.getHint();
	}

	public String getTranslation() {
		return card.getHint();
	}

	public int getSucceeded() {
		return successCount;
	}

	public int getIndex() {
		return index;
	}
	
	public List<FlashCard> getErrors() {
		return errors;
	}

	/**
	 * Returns the success rate of the running test.
	 * @return success rate in percents.
	 */
	public int getSuccessrate() {
		if (index == 0 && successCount == 0) {
			return 100;
		} else {
			return (int)(((float)successCount / index) * 100);
		}
	}
}
