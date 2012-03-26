package org.jigoku.display;

import lombok.Getter;

public class TestDisplay extends javax.swing.JFrame implements DisplayQuestionsInterface {
	public static final long serialVersionUID = 1L;

	protected TestDisplay() {
		// used only for unittest
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">
	protected void initComponents() {
		questionDisplay = new javax.swing.JLabel();
		hintsEnabledDisplay = new javax.swing.JCheckBox();
		hintDisplay = new javax.swing.JLabel();
		answerDisplay = new javax.swing.JTextField();
		translationsEnabledDisplay = new javax.swing.JCheckBox();
		translationDisplay = new javax.swing.JLabel();
		testProgressDisplay = new javax.swing.JProgressBar();
		labelTestProgressDisplay = new javax.swing.JLabel();
		successRateDisplay = new javax.swing.JProgressBar();
		labelSuccessRateDisplay = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		hintsEnabledDisplay.setText("hints");
		hintsEnabledDisplay.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		hintsEnabledDisplay.setMargin(new java.awt.Insets(0, 0, 0, 0));
		hintsEnabledDisplay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(final java.beans.PropertyChangeEvent evt) {
				hintsEnabledPropertyChange(evt);
			}
		});

		hintDisplay.setBackground(new java.awt.Color(255, 255, 255));
		hintDisplay.setText("Ten (things)");

		answerDisplay.setText("jTextField1");
		answerDisplay.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(final java.awt.event.KeyEvent evt) {
				answerKeyTyped(evt);
			}
		});

		translationsEnabledDisplay.setText("translation");
		translationsEnabledDisplay.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		translationsEnabledDisplay.setMargin(new java.awt.Insets(0, 0, 0, 0));

		translationDisplay.setText("jLabel2");

		testProgressDisplay.setMaximum(50);
		testProgressDisplay.setValue(27);

		labelTestProgressDisplay.setText("Test Progress");

		questionDisplay.setText("jLabel1");

		successRateDisplay.setBackground(new java.awt.Color(255, 102, 51));
		successRateDisplay.setForeground(new java.awt.Color(204, 255, 0));
		successRateDisplay.setMaximum(100);
		successRateDisplay.setValue(100);

		labelSuccessRateDisplay.setText("Success rate");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(questionDisplay, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(hintsEnabledDisplay)
														.addGap(6, 6, 6)
														.addComponent(hintDisplay,
																javax.swing.GroupLayout.DEFAULT_SIZE, 333,
																Short.MAX_VALUE))
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(translationsEnabledDisplay)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(translationDisplay,
																javax.swing.GroupLayout.DEFAULT_SIZE, 307,
																Short.MAX_VALUE))
										.addComponent(answerDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 380,
												Short.MAX_VALUE)
										.addComponent(labelSuccessRateDisplay)
										.addComponent(successRateDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 380,
												Short.MAX_VALUE)
										.addComponent(labelTestProgressDisplay)
										.addComponent(testProgressDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 380,
												Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(questionDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(hintsEnabledDisplay, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(hintDisplay, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(translationsEnabledDisplay).addComponent(translationDisplay))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(answerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(labelSuccessRateDisplay)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(successRateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(labelTestProgressDisplay)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(testProgressDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pack();
	}// </editor-fold>

	protected void hintsEnabledPropertyChange(final java.beans.PropertyChangeEvent evt) {
		hintDisplay.setVisible(hintsEnabledDisplay.isSelected());
	}

	public void answerKeyTyped(final java.awt.event.KeyEvent evt) {

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TestDisplay().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	@Getter
	private javax.swing.JTextField answerDisplay;
	@Getter
	private javax.swing.JLabel hintDisplay;
	@Getter
	private javax.swing.JCheckBox hintsEnabledDisplay;
	@Getter
	private javax.swing.JLabel labelSuccessRateDisplay;
	@Getter
	private javax.swing.JLabel labelTestProgressDisplay;
	@Getter
	private javax.swing.JLabel questionDisplay;
	@Getter
	private javax.swing.JProgressBar successRateDisplay;
	@Getter
	private javax.swing.JProgressBar testProgressDisplay;
	@Getter
	private javax.swing.JLabel translationDisplay;
	@Getter
	private javax.swing.JCheckBox translationsEnabledDisplay;
	// End of variables declaration

}
