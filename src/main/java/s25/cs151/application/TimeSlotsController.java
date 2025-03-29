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

public class TimeSlotsController
{
    @FXML private GridPane formContainer;
    @FXML private ComboBox<Integer> fromHour;
    @FXML private ComboBox<String> fromMinutes;
    @FXML private ComboBox<Integer> toHour;
    @FXML private ComboBox<String> toMinutes;

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
    private void goToTableView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TimeSlots.fxml"));
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
    private void submitTimeSlot() {

        Integer selectedFromHour = fromHour.getValue();
        String selectedFromMinute = fromMinutes.getValue();
        Integer selectedToHour = toHour.getValue();
        String selectedToMinute = toMinutes.getValue();

        if(selectedFromHour != null && selectedFromMinute != null && selectedToHour != null && selectedToMinute != null) {
            Alert storedInfo = new Alert(Alert.AlertType.INFORMATION);
            storedInfo.setTitle("Time Slot Recorded for the Semester!");
            storedInfo.setHeaderText(null);
            storedInfo.setContentText("Visit the Schedule page to see all stored Time Slots for the Semester.");
            storedInfo.showAndWait();
        }
        else{
            System.out.println("You need to fill the form.");
        }
    }

    @FXML
    private void initializeFromHourDropDown() {
        fromHour.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
                , 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);

    }
    @FXML
    private void initializeFromMinutesDropDown() {
        fromMinutes.getItems().addAll("00", "15", "30", "45");

    }
    @FXML
    private void initializeToHourDropDown() {
        toHour.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
                , 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);

    }
    @FXML
    private void initializeToMinutesDropDown() {
        toMinutes.getItems().addAll("00", "15", "30", "45");

    }
    @FXML
    public void initialize()
    {
        initializeFromHourDropDown();
        initializeFromMinutesDropDown();
        initializeToHourDropDown();
        initializeToMinutesDropDown();
    }

}
