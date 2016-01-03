package org.jigoku;
/**
 * Created by Yves on 03.01.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;
import org.jigoku.view.KanjiOverviewController;

import java.io.IOException;

public class Jiggy extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	@Getter
	private ResourcePool resourcePool;

	public void init() throws Exception {
		resourcePool = new ResourcePool();
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Jigoku");

		initRootLayout();

		showKanjiOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Jiggy.class.getResource("/userInterface/jigoku.fxml"));
			rootLayout = loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the kanji overview inside the root layout.
	 */
	public void showKanjiOverview() {
		try {
			// Load kanji overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Jiggy.class.getResource("/org/jigoku/view/kanjiOverview.fxml"));
			AnchorPane kanjiOverview = loader.load();

			// Give the controller access to the main app.
			KanjiOverviewController controller = loader.getController();
			controller.setJiggy(this);

			// Set kanji overview into the center of root layout.
			rootLayout.setCenter(kanjiOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
