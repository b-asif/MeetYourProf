package s25.cs151.application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
            Parent root = loader.load();
            OfficeHourController officeHourController = loader.getController();
            officeHourController.setStage(stage); // Pass the stage
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Debug loading errors
        }

    }
    @FXML
    private void goToTableView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tableView.fxml"));
            Parent root = loader.load();
            TableViewController control = loader.getController();
            control.setStage(stage);
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}