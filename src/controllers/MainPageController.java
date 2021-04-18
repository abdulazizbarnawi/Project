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
import javafx.scene.image.ImageView;
import project.Project;

/**
 *
 * @author UwU
 */
public class MainPageController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button butuser;
    @FXML
    private Button butad;
    @FXML
    private ImageView imagie;
    
    
    
    
    private void handleButtonAction(ActionEvent event) {
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void users(ActionEvent event) throws IOException {
          Project.changeView("/views/users.fxml","admin smain menu");
     
    }

    @FXML
    private void admins(ActionEvent event) throws IOException {
        Project.changeView("/views/admins.fxml","admin smain menu");
        
    }
    
}
