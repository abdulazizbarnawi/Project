package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.Project;

public class FeedbackController implements Initializable {

    @FXML
    private TextField txtemail;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtq1;
    @FXML
    private TextField txtq3;
    @FXML
    private TextField txtq5;
    @FXML
    private TextField txtq6;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtq2;
    @FXML
    private TextField txtq4;
    @FXML
    private Button btnsave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void back(ActionEvent event) {
        Project.changeView("/views/mainmenuUSERS.fxml", "main menu USERS");
    }

    @FXML
    private void save(ActionEvent event) {
        String q1, q2, q3, q4, q5, q6, name, email;
        q1 = txtq1.getText();
        q2 = txtq2.getText();
        q3 = txtq3.getText();
        q4 = txtq4.getText();
        q5 = txtq5.getText();
        q6 = txtq6.getText();

        name = txtname.getText();
        email = txtemail.getText();

        if (q1.isEmpty() || q2.isEmpty() || q3.isEmpty() || q4.isEmpty() || q5.isEmpty() || q6.isEmpty() || name.isEmpty() || email.isEmpty()) {
            Project.showAlert("error", "all fields are required", Alert.AlertType.ERROR);
            return;
        }
        Project.insertFeed(name, email, q1, q2, q3, q4, q5, q6);
        txtname.setText("");
        txtemail.setText("");
        txtq1.setText("");
        txtq2.setText("");
        txtq3.setText("");
        txtq4.setText("");
        txtq5.setText("");
        txtq6.setText("");
    }

}
