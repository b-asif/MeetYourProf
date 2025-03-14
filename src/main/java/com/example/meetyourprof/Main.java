package com.example.meetyourprof;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/com/example/meetyourprof/HomePage.fxml"));
        Scene home = new Scene(load.load(), 1920,1080);

        HomeController control = load.getController();
        control.setStage(stage);

        stage.setScene(home);
        stage.setTitle("Meet Your Professor");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}