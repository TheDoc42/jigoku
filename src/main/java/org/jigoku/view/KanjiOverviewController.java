package org.jigoku.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import lombok.Getter;
import org.jigoku.Jiggy;
import org.jigoku.Kanji;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
	private TreeSet<Integer> selected = new TreeSet<>();
	private List<TextFlow> kanjiDisplays = new ArrayList<>();

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
			kanjiDisplay.setOnMouseClicked(e -> {
				final int clickedIndex = kanjiDisplays.indexOf(e.getSource());

				if (selected.isEmpty()) {
					selected.add(clickedIndex);
				} else if (e.isControlDown()) {
					if (selected.contains(clickedIndex)) {
						selected.remove(clickedIndex);
					} else {
						selected.add(clickedIndex);
					}
				} else if (e.isShiftDown()) {
					int firstIndex = selected.first();
					int lastIndex = selected.last();
					selected.clear();
					if (clickedIndex < firstIndex) {
						for (int i = lastIndex; i >= clickedIndex; i--) {
							selected.add(i);
						}
					} else {
						for (int i = firstIndex; i <= clickedIndex; i++) {
							selected.add(i);
						}
					}
				} else {
					selected.clear();
					selected.add(clickedIndex);
				}
				refreshSelected();
			});
			final Text text = new Text(kanji.getKanji());
			text.setFont(font);
			kanjiDisplay.getChildren().add(text);
			flowPlane.getChildren().add(kanjiDisplay);
			kanjiDisplays.add(kanjiDisplay);
		}
	}

	private void refreshSelected() {
		Background bgon = new Background(new BackgroundFill(Paint.valueOf("orange"), new CornerRadii(0.15, true), null));
		for (int i = 0; i < kanjiDisplays.size(); i++) {
			if (selected.contains(i)) {
				kanjiDisplays.get(i).setBackground(bgon);
			} else {
				kanjiDisplays.get(i).setBackground(null);
			}
		}
	}
}
