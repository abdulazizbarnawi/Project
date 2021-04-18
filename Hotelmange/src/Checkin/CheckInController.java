/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkin;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author UwU
 */
public class CheckInController implements Initializable {

    @FXML
    private Button bb;
    @FXML
    private Button savebut;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtpassport;
    @FXML
    private TextField roomN;
    @FXML
    private Button savebut1;
    @FXML
    private Label lablroomav;
    @FXML
    private Label lablroomav1co;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Save(ActionEvent event) throws SQLException {
        hotelusers u = new hotelusers();
        u.insertUser(txtname.getText(), txtemail.getText(), txtpassport.getText());
        
        
           }

    @FXML
   private void saveroom(ActionEvent event) throws SQLException {
        admineditroom.edit r = new admineditroom.edit();
      boolean checkroom = r.room(roomN.getText());
        lablroomav.setText("");
        lablroomav1co.setText("");
      if(checkroom){

          lablroomav.setText("");
          lablroomav1co.setText("Reservation was successful");

          boolean uproom = r.upState(roomN.getText(), checkroom);



      }else{
          lablroomav1co.setText("");
          lablroomav.setText("Room not  Available");
      }
    }
    
}
