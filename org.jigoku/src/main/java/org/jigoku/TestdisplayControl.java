package org.jigoku;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import org.apache.commons.lang.StringUtils;
import org.jigoku.structure.Observable;
import org.jigoku.structure.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


	public class TestdisplayControl extends TestDisplay implements Observer {
		public static final long serialVersionUID = 2L;
	    
		private Test test;
		Logger log = LoggerFactory.getLogger(TestdisplayControl.class);

		public TestdisplayControl(Test test) {
	        super();
	        //initComponents();
	        this.test = test;
    		updateDisplay(test);
	        testProgress.setMaximum(this.test.getLength());
	        this.test.addObserver(this);
	    }
	    
		private String formatQuestion(FlashCard card){
			//return cards.getCard(index).getContents();
			
			//TODO: move this bit to the card's contents? or Testdisplay (better)
			//move table to testdisplay.
			//where do we limit the furigana? -> The test should know about past history
			
			StringBuilder display = new StringBuilder();
			display.append("<html><table>");
			StringBuilder furigana = new StringBuilder("<tr>");
			StringBuilder characters = new StringBuilder("<tr>");

			for (int i=0; i< card.getDisplaychars().size(); i++) {
				
				
				//TODO: limit furigana to untrained characters
				
				furigana.append("<td><center>");
				furigana.append(card.getDisplaychars().get(i).furigana);
				furigana.append("</center></td>");
				characters.append("<td><font size=+5>");
				characters.append(card.getDisplaychars().get(i).original);
				characters.append("</font></td>");
			}
			
			characters.append("</tr>");
			furigana.append("</tr>");
			display.append(furigana);
			display.append(characters);
			display.append("</table></html>");
			return display.toString();
			
		}
		
	    private void updateDisplay(Test test) {
    		setQuestion(formatQuestion(test.getCard()));
    		setHint(test.getHint());
    		setAnswer(StringUtils.EMPTY);
    		setTranslation(test.getTranslation());
    		testProgress.setValue(test.getIndex());
    		successRate.setValue(test.getSuccessrate());
	    }

	    public void sendNotify(Observable obs) {
	    	//the test has changed!
	    	if (obs == test) {
	    		if (test.testIsDone()) {
	    			WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
	    		} else {
	    			updateDisplay(test);
	    		}
	    	}
	    }
	    
	    public void answerKeyTyped(java.awt.event.KeyEvent evt) {
	        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
	        	test.giveAnswer(answer.getText());
	        }
	    }

	    public String getAnswer() {
			return answer.getText();
		}

		public void setAnswer(String answer) {
			this.answer.setText(answer);
		}

		public void setHint(String hint) {
			this.hint.setText(hint);
		}

		public void setQuestion(String question) {
			this.question.setText(question);
		}

		public void setTranslation(String translation) {
			this.translation.setText(translation);
		}
	    

}
