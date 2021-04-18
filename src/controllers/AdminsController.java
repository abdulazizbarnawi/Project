/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import project.Project;

/**
 * FXML Controller class
 *
 * @author UwU
 */
public class AdminsController implements Initializable {

    @FXML
    private Button butback;
    @FXML
    private Button butsignin;
    @FXML
    private TextField txtuser;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Label Output;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Project.changeView("/views/MainPage.fxml", "Main Page");
    }

    @FXML
    private void signin(ActionEvent event) throws IOException {

        if (txtuser.getText().isEmpty()) {
            Output.setText("Please enter Username or Password");
            return;

        } else if (txtpass.getText().isEmpty()) {
            Output.setText("Please enter Username or Password");
            return;
        }
        int o = Project.login(txtuser.getText(), txtpass.getText());
        if (o == 1) {
            Project.changeView("/views/adminsmainmenu.fxml", "Admin main menu");

        } else {
            System.out.println("Error");

        }

    }
}
