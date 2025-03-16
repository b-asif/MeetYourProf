package s25.cs151.application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OfficeHourController {
    @FXML private ComboBox<String> semesterDropDown;
    @FXML private TextField courseCode;
    @FXML private TextField courseName;
    @FXML private TextField sectionNumber;
    @FXML private TextField year;
    @FXML private TextField startTime;
    @FXML private TextField endTime;

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void goToHomePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();
            HomeController control = loader.getController();
            control.setStage(stage);
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {
        semesterDropDown.getItems().addAll("Spring", "Summer", "Fall", "Winter");

    }

}
