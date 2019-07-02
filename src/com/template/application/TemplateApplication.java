package com.template.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

@SpringBootApplication
public class TemplateApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(getClass());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("application.fxml"));
		loader.setControllerFactory(springContext::getBean);
		root = loader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
			primaryStage.setFullScreenExitHint("");
			primaryStage.setFullScreenExitKeyCombination(null);
			primaryStage.setFullScreen(true);
			primaryStage.setTitle("Template Application");
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setOnCloseRequest((e) -> {
				springContext.stop();
				Platform.exit();
				System.exit(-1);
			});

			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX(primScreenBounds.getWidth() / 2 - primaryStage.getWidth() / 2);
			primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}

	public static void main(String[] args) {
		launch(TemplateApplication.class, args);
	}
}
