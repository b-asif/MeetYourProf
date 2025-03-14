package com.example.meetyourprof;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;


import java.io.IOException;

public class HomeController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void goToOfficeHoursPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("office_hour.fxml"));
        Scene officeHour = new Scene(loader.load(), 1920, 1080);
        stage.setScene(officeHour);
    }

}