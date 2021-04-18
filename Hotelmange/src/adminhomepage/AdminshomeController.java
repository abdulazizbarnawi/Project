/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminhomepage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author UwU
 */
public class AdminshomeController implements Initializable {

    @FXML
    private Button buteditrres;
    @FXML
    private Button buteditguest;
    @FXML
    private Button coustmerbut;
    @FXML
    private Button bb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void editrooms(ActionEvent event) throws IOException {
          ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/admineditroom/editroomandbreakfast.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void editguest(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/admineditguest/editguest.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void coustmerrecord(ActionEvent event) throws IOException {
          ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/coustmer/coustmerr.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/adminlogin/adminlogin.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
    
}
