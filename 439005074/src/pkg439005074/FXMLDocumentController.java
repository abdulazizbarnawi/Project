/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg439005074;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author UwU
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField txtuser;
    @FXML
    private PasswordField txtpass;
    @FXML
    private Button butlogin;
    @FXML
    private Label Output;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
         if (txtuser.getText().isEmpty()){
           Output.setText("Please enter Username or Password");
           
       }else
           if (txtpass.getText().isEmpty()){
               Output.setText("Please enter Username or Password");
           }else
       if (txtuser.getText().equalsIgnoreCase("s439005074@st.uqu.edu.sa" +
"")&& txtpass.getText().endsWith("439005074")){
           ((Node) event.getSource()).getScene().getWindow().hide();

     Parent root = FXMLLoader.load(getClass().getResource("carss.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
       }else if (!txtuser.getText().isEmpty()&& !txtpass.getText().isEmpty()){
                          Output.setText("Wrong Username or Password");

       }
    }
    
}
