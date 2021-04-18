/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmange;
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
    private Button butt;
    @FXML
    private Button adminslogin;
    @FXML
    private Button butt1;
    @FXML
    private TextField txtuser;
    @FXML
    private PasswordField txtpass;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        register.register r = new register.register();
  boolean o = r.login(txtuser.getText(),txtpass.getText());
  if(o){
      ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/homepage/homepage.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
      
  }else{
      System.out.println("Error");
      
      
  }
        
         
    }

    @FXML
    private void adminslogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/adminlogin/adminlogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/register/register.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
