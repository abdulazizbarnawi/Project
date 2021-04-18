/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg439005074;

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
public class CarssController implements Initializable {

    @FXML
    private TextField txtvn;
    @FXML
    private TextField txtcn;
    @FXML
    private TextField year;
    @FXML
    private Button buthome;
    @FXML
    private Button butview;
    @FXML
    private Button butadd;
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
    private void home(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

     Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void view(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();

     Parent root = FXMLLoader.load(getClass().getResource("viewdata.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
       if (txtvn.getText().isEmpty()){
           Output.setText("Please Enter the Information");
           
       }else
           if (txtcn.getText().isEmpty()){
               Output.setText("Please Enter the Information");
           }else
           if (year.getText().isEmpty()){
               Output.setText("Please Enter the Information");
           }else{
               data u = new data();
        u.insertUser(txtvn.getText(), txtcn.getText(), year.getText());
           }
    }
    
}
