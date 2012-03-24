package org.jigoku;



public interface TestDisplayInterface {
 
    public javax.swing.JTextField answer = null;
    public javax.swing.JLabel hint = null;
    public javax.swing.JCheckBox hintsEnabled = null;
    public javax.swing.JLabel labelSuccessRate = null;
    public javax.swing.JLabel labelTestProgress = null;
    public javax.swing.JLabel question = null;
    public javax.swing.JProgressBar successRate = null;
    public javax.swing.JProgressBar testProgress = null;
    public javax.swing.JLabel translation = null;
    public javax.swing.JCheckBox translationsEnabled = null;
    
    public void answerKeyTyped(java.awt.event.KeyEvent evt);

}
