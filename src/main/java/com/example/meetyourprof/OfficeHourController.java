package com.example.meetyourprof;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class OfficeHourController {
    @FXML private ComboBox<String> semesterDropDown;
    @FXML private TextField courseCode;
    @FXML private TextField courseName;
    @FXML private TextField sectionNumber;
    @FXML private TextField year;
    @FXML private TextField startTime;
    @FXML private TextField endTime;



    @FXML
    public void initialize() {
        semesterDropDown.getItems().addAll("Spring", "Summer", "Fall", "Winter");

    }

}
