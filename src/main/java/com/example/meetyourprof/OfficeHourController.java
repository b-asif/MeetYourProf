package com.example.meetyourprof;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class OfficeHourController {
    @FXML private ComboBox<String> semesterDropDown;
    @FXML private TextField courseCode;
    @FXML private TextField courseName;
    @FXML private TextField sectionNumber;

    @FXML
    public void initialize() {
        semesterDropDown.getItems().addAll("Spring", "Summer", "Fall", "Winter");
    }

}
