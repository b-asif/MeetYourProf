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

public class OfficeHourController {
    @FXML private ComboBox<String> semesterDropDown;
    @FXML private GridPane formContainer;
    @FXML private TextField courseCode;
    @FXML private TextField courseName;
    @FXML private TextField sectionNumber;
    @FXML private TextField year;
    @FXML private TextField startTime;
    @FXML private TextField endTime;
    @FXML private CheckBox mCheckBox;
    @FXML private CheckBox tCheckBox;
    @FXML private CheckBox wCheckBox;
    @FXML private CheckBox thCheckBox;
    @FXML private CheckBox fCheckBox;


    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void submitOfficeHourSchedule() {

        String semester = semesterDropDown.getValue();
        String yearVal = year.getText();
        StringBuilder daysSelected = new StringBuilder();

        if(yearVal.length() != 4) {
            Alert invalidYear = new Alert(Alert.AlertType.ERROR);
            invalidYear.setTitle("Invalid year entry");
            invalidYear.setHeaderText("Please enter a valid 4-digit year.");
            invalidYear.showAndWait();
            return;
        }
        if(mCheckBox.isSelected()) {
            daysSelected.append("M, ");
        }
        if(tCheckBox.isSelected()) {
            daysSelected.append("T, ");
        }
        if(wCheckBox.isSelected()) {
            daysSelected.append("W, ");
        }
        if(thCheckBox.isSelected()) {
            daysSelected.append("TH, ");
        }
        if(fCheckBox.isSelected()) {
            daysSelected.append("F, ");
        }
        if(semester != null && !yearVal.isEmpty() && daysSelected.length() > 0) {
            OfficeHourDataBase.insertOfficeHourSchedule(semester, yearVal, daysSelected.toString());
            Alert storedInfo = new Alert(Alert.AlertType.INFORMATION);
            storedInfo.setTitle("Office Hour Recorded for the Semester!");
            storedInfo.setHeaderText(null);
            storedInfo.setContentText("Visit the Schedule page to see all stored Semester Office Hours");
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


    @FXML
    public void initialize() {
        semesterDropDown.getItems().addAll("Spring", "Summer", "Fall", "Winter");

    }

}