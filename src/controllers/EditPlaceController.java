package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Place;
import project.Project;

public class EditPlaceController implements Initializable {

    @FXML
    private TextArea txtInfo;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtArea;
    @FXML
    private TextArea txtBest;
    @FXML
    private TextField txtName;
    @FXML
    private TableView<Place> table;
    @FXML
    private TableColumn<Place, Integer> colId;
    @FXML
    private TableColumn<Place, String> colName;
    @FXML
    private TableColumn<Place, Integer> colArea;
    @FXML
    private TableColumn<Place, String> colInfo;
    @FXML
    private TableColumn<Place, String> colBest;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    Place selected = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btnDelete.setDisable(true);
        this.btnUpdate.setDisable(true);

        Project.loadPlaces();
        this.table.setItems(Project.places);

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        colInfo.setCellValueFactory(new PropertyValueFactory<>("info"));
        colBest.setCellValueFactory(new PropertyValueFactory<>("best"));

        this.table.getSelectionModel().selectedIndexProperty().addListener(x -> {
            selected = this.table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                this.btnDelete.setDisable(false);
                this.btnUpdate.setDisable(false);
                txtName.setText(selected.getName());
                txtInfo.setText(selected.getInfo());
                txtBest.setText(selected.getBest());
                txtArea.setText(selected.getArea() + "");
            } else {
                this.btnDelete.setDisable(true);
                this.btnUpdate.setDisable(true);

            }
        });

    }

    @FXML
    private void handelSave(ActionEvent event) {
        String name = txtName.getText();
        String info = txtInfo.getText();
        String best = txtBest.getText();
        int area = 0;
        try {
            area = Integer.parseInt(txtArea.getText());
        } catch (Exception e) {
            area = 0;
        }
        if (name.isEmpty() || info.isEmpty() || best.isEmpty() || area == 0) {
            Project.showAlert("Error", "All fields are required", Alert.AlertType.ERROR);
            return;
        }

        Project.insertPlace(name, info, best, area);
        txtName.setText("");
        txtInfo.setText("");
        txtBest.setText("");
        txtArea.setText("");
        Project.loadPlaces();
        this.table.refresh();

    }

    @FXML
    private void handelBack(ActionEvent event) {
        Project.changeView("/views/adminsmainmenu.fxml", "Admin main menu");
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        if (selected == null) {
            Project.showAlert("Error", "Please select place", Alert.AlertType.NONE);
            return;
        }
        String name = txtName.getText();
        String info = txtInfo.getText();
        String best = txtBest.getText();
        int area = 0;
        try {
            area = Integer.parseInt(txtArea.getText());
        } catch (Exception e) {
            area = 0;
        }
        if (name.isEmpty() || info.isEmpty() || best.isEmpty() || area == 0) {
            Project.showAlert("Error", "All fields are required", Alert.AlertType.ERROR);
            return;
        }
//int id, int area,String name, String info, int best
        Project.updatePlace(selected.getId(), area, name, info, best);
        txtName.setText("");
        txtInfo.setText("");
        txtBest.setText("");
        txtArea.setText("");
        Project.loadPlaces();
        this.table.refresh();

    }

    @FXML
    private void handleDelete(ActionEvent event) {
        if (selected != null) {
            Project.deletePlaces(selected.getId());
            Project.loadPlaces();
            this.table.refresh();
        }
    }

}
