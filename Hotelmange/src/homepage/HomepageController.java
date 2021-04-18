/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;

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
public class HomepageController implements Initializable {

    @FXML
    private Button butcheckin;
    @FXML
    private Button butcout;
    @FXML
    private Button butbooking;
    @FXML
    private Button butroom;
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
    private void checkin(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/Checkin/check in.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void checkout(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/Checkout/checkout.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void booking(ActionEvent event) {
    }

    @FXML
    private void roomrestirant(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/roomsandres/roomsrestruant.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/hotelmange/FXMLDocument.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
    
}
