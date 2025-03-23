package s25.cs151.application;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TableViewController  {
    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @FXML
    TableView<OfficeHour> tableView;

    @FXML
    private TableColumn<OfficeHour, String> semester;

    @FXML
    private TableColumn<OfficeHour, String> year;

    @FXML
    private TableColumn<OfficeHour, String> days;

    ObservableList<OfficeHour> officehourslist = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setUpTable();
        loadTable();
    }

    @FXML
    private void goToHomePage() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();
            HomeController homeController = loader.getController();
            homeController.setStage(stage); // Pass the stage
            stage.getScene().setRoot(root);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Debug loading errors
        }

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

    private void setUpTable() {
        semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        days.setCellValueFactory(new PropertyValueFactory<>("days"));

        tableView.setItems(officehourslist);
    }

    private void loadTable() {
        officehourslist.clear();
        String query = "SELECT * FROM office_hours " + "ORDER BY year DESC, " +
                "CASE semester " +
                "WHEN 'Winter' THEN 1 " +
                "WHEN 'Fall' THEN 2 " +
                "WHEN 'Summer' THEN 3 " +
                "WHEN 'Spring' THEN 4 " +
                "END ASC;";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:office_hours.db");
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery(query)) {
            while(result.next()) {
                officehourslist.add(new OfficeHour(
                        result.getString("semester"),
                        result.getString("year"),
                        result.getString("days")

                ));
            }
            tableView.refresh();

        }
        catch(SQLException e) {
            e.printStackTrace();
        }

    }


}