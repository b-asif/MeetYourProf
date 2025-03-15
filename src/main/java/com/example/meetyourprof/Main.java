package com.example.meetyourprof;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.stage.Stage;


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