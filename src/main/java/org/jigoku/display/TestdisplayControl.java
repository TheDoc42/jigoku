package org.jigoku.display;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import org.apache.commons.lang3.StringUtils;
import org.jigoku.FlashCard;
import org.jigoku.Game;
import org.jigoku.structure.Observable;
import org.jigoku.structure.Observer;

public class TestdisplayControl extends TestDisplay implements Observer {
	public static final long serialVersionUID = 2L;

	private final Game test;

	public TestdisplayControl(final Game test) {
		super();
		// initComponents();
		this.test = test;
		updateDisplay(this.test);
		getTestProgressDisplay().setMaximum(this.test.getLength());
		this.test.addObserver(this);
	}

	private String formatQuestion(final FlashCard card) {
		// return cards.getCard(index).getContents();

		// TODO: move this bit to the card's contents? or Testdisplay (better)
		// move table to testdisplay.
		// where do we limit the furigana? -> The test should know about past
		// history

		StringBuilder display = new StringBuilder();
		display.append("<html><table>");
		StringBuilder furigana = new StringBuilder("<tr>");
		StringBuilder characters = new StringBuilder("<tr>");

		for (int i = 0; i < card.getDisplayChars().size(); i++) {

			// TODO: limit furigana to untrained characters

			furigana.append("<td><center>");
			furigana.append(card.getDisplayChars().get(i).getFurigana());
			furigana.append("</center></td>");
			characters.append("<td><font size=+5>");
			characters.append(card.getDisplayChars().get(i).getOriginal());
			characters.append("</font></td>");
		}

		characters.append("</tr>");
		furigana.append("</tr>");
		display.append(furigana);
		display.append(characters);
		display.append("</table></html>");
		return display.toString();

	}

	private void updateDisplay(final Game test) {
		setQuestion(formatQuestion(test.getCard()));
		setHint(test.getHint());
		setAnswer(StringUtils.EMPTY);
		setTranslation(test.getTranslation());
		getTestProgressDisplay().setValue(test.getIndex());
		getSuccessRateDisplay().setValue(test.getSuccessrate());
	}

	public void sendNotify(final Observable obs) {
		// the test has changed!
		if (obs == test) {
			if (test.testIsDone()) {
				WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
			} else {
				updateDisplay(test);
			}
		}
	}

	@Override
	public void answerKeyTyped(final java.awt.event.KeyEvent evt) {
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			test.giveAnswer(getAnswer());
		}
	}

	public String getAnswer() {
		return getAnswerDisplay().getText();
	}

	public void setAnswer(final String answer) {
		getAnswerDisplay().setText(answer);
	}

	public void setHint(final String hint) {
		getHintDisplay().setText(hint);
	}

	public void setQuestion(final String question) {
		getQuestionDisplay().setText(question);
	}

	public void setTranslation(final String translation) {
		getTranslationDisplay().setText(translation);
	}

}
