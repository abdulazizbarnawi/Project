/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

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
 * FXML Controller class
 *
 * @author UwU
 */
public class RegisterController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button butt;
    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private Button butt1;
    @FXML
    private TextField txtemail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/hotelmange/FXMLDocument.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

 
    @FXML
    private void Save(ActionEvent event) throws SQLException {
         register u = new register();
        u.insertUser(txtusername.getText(), txtemail.getText(), txtpassword.getText());
    }
    
}
