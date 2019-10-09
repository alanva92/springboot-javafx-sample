package com.samples.alanworks.springbootjfx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class MainApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent rootNode;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(MainApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(rootNode,500,200));
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
