package org.jigoku.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import lombok.Getter;
import org.jigoku.Jiggy;
import org.jigoku.Kanji;

/**
 * Created by Yves on 03.01.2016.
 */
@Getter
public class KanjiOverviewController {
	@FXML
	public FlowPane flowPlane;
	@Getter
	ObservableList<Kanji> kanjiList = FXCollections.observableArrayList();

	private static final double KANJI_DISPLAY_SIZE = 80;
	private static final double KANJI_DISPLAY_FONT_SIZE = 40;

	// Reference to the main application.
	private Jiggy jiggy;

	public KanjiOverviewController() {
	}

	@FXML
	private void initialize() {
	}

	public void setJiggy(Jiggy jiggy) {
		this.jiggy = jiggy;
		kanjiList.addAll(jiggy.getResourcePool().getKanjiList());

		final Font font = new Font(KANJI_DISPLAY_FONT_SIZE);

		for (Kanji kanji : kanjiList) {

			//	<TextFlow prefHeight="180.0" prefWidth="180.0">
			//		<FlowPane.margin
			// 			<Insets bottom="10.0" left="10.0" right="10.0" top="10.0"/>
			//		</FlowPane.margin>
			//	</TextFlow>

			TextFlow kanjiDisplay = new TextFlow();
			kanjiDisplay.setPrefSize(KANJI_DISPLAY_SIZE, KANJI_DISPLAY_SIZE);
			kanjiDisplay.setTextAlignment(TextAlignment.CENTER);
			final Text text = new Text(kanji.getKanji());
			text.setFont(font);
			kanjiDisplay.getChildren().add(text);
			flowPlane.getChildren().add(kanjiDisplay);
		}

	}
}
