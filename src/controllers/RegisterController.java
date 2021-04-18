/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Project;

/**
 * FXML Controller class
 *
 * @author UwU
 */
public class RegisterController implements Initializable {

    @FXML
    private Button butbac;
    @FXML
    private TextField txtname;
    @FXML
    private PasswordField txtpass;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtphone;
    @FXML
    private Button butregister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backk(ActionEvent event) throws IOException {
        
          Project.changeView("/views/users.fxml","users");
    }

    @FXML
    private void register(ActionEvent event) throws SQLException {
       
        Project.insertUser(txtname.getText(), txtpass.getText(), txtemail.getText(),txtphone.getText());
    }
    
}
