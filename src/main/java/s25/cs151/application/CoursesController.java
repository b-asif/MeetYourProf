package s25.cs151.application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CoursesController {
    @FXML private GridPane formContainer;
    @FXML private TextField courseCode;
    @FXML private TextField courseName;
    @FXML private TextField sectionNumber;

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void submitCourse() {

        String code = courseCode.getText();
        String name = courseName.getText();
        String section = sectionNumber.getText();


        if(!code.isEmpty() && !name.isEmpty() && !section.isEmpty()) {
            Alert storedInfo = new Alert(Alert.AlertType.INFORMATION);
            storedInfo.setTitle("Course Recorded for the Semester!");
            storedInfo.setHeaderText(null);
            storedInfo.setContentText("Visit the page to see all stored Semester Courses");
            storedInfo.showAndWait();
        }
        else{
            System.out.println("You need to fill the form.");
        }
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