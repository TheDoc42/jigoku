package org.jigoku.view;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import lombok.Getter;

/**
 * Created by Yves on 03.01.2016.
 */
@Getter
public class GameController {
	@FXML
	private TextFlow display;
	@FXML
	private TextField textInput;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private CheckBox showHint;
	@FXML
	private Label hintLabel;
	@FXML
	private CheckBox showTranslation;
	@FXML
	private Label translationLabel;

	private static boolean DEFAULT_VISIBILITY_HINTS = false;
	private static boolean DEFAULT_VISIBILITY_TRANSLATION = false;

	public GameController() {
	}

	@FXML
	private void initialize() {
		showHint.setSelected(DEFAULT_VISIBILITY_HINTS);
		showHint.setOnAction((e) -> hintLabel.setVisible(showHint.isSelected()));
		hintLabel.setVisible(DEFAULT_VISIBILITY_HINTS);
		hintLabel.setText("Hint");

		showTranslation.setSelected(DEFAULT_VISIBILITY_TRANSLATION);
		showTranslation.setOnAction((e) -> translationLabel.setVisible(showTranslation.isSelected()));
		translationLabel.setVisible(DEFAULT_VISIBILITY_TRANSLATION);
		translationLabel.setText("Translation");
	}
}
