package com.example.meetyourprof;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HomeController {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void goToOfficeHoursPage() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("office_hour.fxml"));
            Parent root = loader.load();  // Load first
            Scene officeHour = new Scene(root, 1920, 1080);
            stage.setScene(officeHour);
            stage.show();  // Ensure stage is visible
        } catch (IOException e) {
            e.printStackTrace();  // Debug loading errors
        }

    }

}