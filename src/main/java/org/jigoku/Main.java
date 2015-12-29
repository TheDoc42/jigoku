package org.jigoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/userInterface/kanjiOverview.fxml"));
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();

		Parent root2 = FXMLLoader.load(getClass().getResource("/userInterface/game.fxml"));
		primaryStage.setTitle("Hello World2");
		primaryStage.setScene(new Scene(root2, 600, 400));
		primaryStage.show();

	}


	public static void main(String[] args) {
		launch(args);
	}
}
