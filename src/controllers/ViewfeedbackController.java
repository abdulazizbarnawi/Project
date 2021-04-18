package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Feedback;
import project.Project;

public class ViewfeedbackController implements Initializable {

    @FXML
    private Button butb;

    @FXML
    private TableColumn<Feedback, String> colname;
    @FXML
    private TableColumn<Feedback, String> colemail;
    @FXML
    private TableColumn<Feedback, String> colq1;
    @FXML
    private TableColumn<Feedback, String> colq2;
    @FXML
    private TableColumn<Feedback, String> colq3;
    @FXML
    private TableColumn<Feedback, String> colq4;
    @FXML
    private TableColumn<Feedback, String> colq5;
    @FXML
    private TableColumn<Feedback, String> colq6;
    @FXML
    private Button butdelete;

    Feedback selected = null;
    @FXML
    private TableView<Feedback> table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colq1.setCellValueFactory(new PropertyValueFactory<>("q1"));
        colq2.setCellValueFactory(new PropertyValueFactory<>("q2"));
        colq3.setCellValueFactory(new PropertyValueFactory<>("q3"));
        colq4.setCellValueFactory(new PropertyValueFactory<>("q4"));
        colq5.setCellValueFactory(new PropertyValueFactory<>("q5"));
        colq6.setCellValueFactory(new PropertyValueFactory<>("q6"));
        Project.loadFeeds();
        table.setItems(Project.feedList);

        this.table.getSelectionModel().selectedIndexProperty().addListener(x -> {
            selected = this.table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                this.butdelete.setDisable(false);

            } else {
                this.butdelete.setDisable(true);

            }
        });
    }

    @FXML
    private void back(ActionEvent event) {
        Project.changeView("/views/adminsmainmenu.fxml", "Admin main menu");
    }

    @FXML
    private void Delete(ActionEvent event) {
        if (selected != null) {
            Project.deleteFeed(selected.getId());
        
            Project.loadFeeds();
                this.table.refresh();;
        }
    }

}
