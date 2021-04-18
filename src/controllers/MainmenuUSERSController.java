
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import project.Project;

public class MainmenuUSERSController implements Initializable {

    @FXML
    private Button butcit;
    @FXML
    private Button butb;
    @FXML
    private Button btnFeedback;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void viewcities(ActionEvent event) throws IOException {
         
         Project.changeView("/views/map.fxml","map");
          
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         Project.changeView("/views/users.fxml","users");
          
        
    }

    @FXML
    private void handelFeedback(ActionEvent event) throws IOException {
        Project.changeView("/views/feedback.fxml","feedback");
    }
    
}
