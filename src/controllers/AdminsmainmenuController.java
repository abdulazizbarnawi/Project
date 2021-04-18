
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import project.Project;


public class AdminsmainmenuController implements Initializable {

    @FXML
    private Button butb;
    @FXML
    private Button mangebut;
    @FXML
    private Button favbut;
    @FXML
    private Button editbut;
    @FXML
    private Button btnViewFeedback;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
         
        Project.changeView("/views/admins.fxml","Admins");
    }

    @FXML
    private void mangecity(ActionEvent event) {
         Project.changeView("/views/EditPlace.fxml","Edit Place");
    }

    @FXML
    private void favcity(ActionEvent event) {
    }

    @FXML
    private void edituser(ActionEvent event) throws IOException {
         Project.changeView("/views/edituseradmin.fxml","edit user admin");
               
    }

    @FXML
    private void handelViewFeedback(ActionEvent event) {
         Project.changeView("/views/viewfeedback.fxml","viewfeedback");
    }
    
}
