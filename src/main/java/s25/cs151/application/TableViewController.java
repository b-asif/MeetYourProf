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
    private TableColumn<OfficeHour, Integer> id;

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

    private void setUpTable() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        days.setCellValueFactory(new PropertyValueFactory<>("days"));

        tableView.setItems(officehourslist);
    }

    private void loadTable() {
        String query = "SELECT * FROM office_hours " + "ORDER BY year DESC, " +
                "CASE semester " +
                "WHEN 'WINTER' THEN 1 " +
                "WHEN 'FALL' THEN 2 " +
                "WHEN 'SUMMER' THEN 3 " +
                "WHEN 'SPRING' THEN 4 " +
                "END ASC;";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/bushraasif/IdeaProjects/MeetYourProf/office_hours.db");
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery(query)) {
                 while(result.next()) {
                     officehourslist.add(new OfficeHour(
                             result.getInt("id"),
                             result.getString("semester"),
                             result.getString("year"),
                             result.getString("days")

                     ));
                 }
        }
        catch(SQLException e) {
            e.printStackTrace();
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


}


