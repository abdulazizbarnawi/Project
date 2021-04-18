/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admineditroom;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author UwU
 */
public class EditroomandbreakfastController implements Initializable {

    @FXML
    private Button butback;
    @FXML
    private Button butadd;
    @FXML
    private TextField txtroomid;
    @FXML
    private TextField txtroomtype;
    @FXML
    private TextField txtroomcap;
    @FXML
    private TextField txtchkin;
    @FXML
    private TextField txtchkout;
    @FXML
    private TextField txtbreakfast;
    @FXML
    private TableView<?> tabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
          ((Node) event.getSource()).getScene().getWindow().hide();

    Parent root = FXMLLoader.load(getClass().getResource("/adminhomepage/adminshome.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
         edit u = new edit();
        u.insertUser(txtroomid.getText(), txtroomtype.getText(), txtroomcap.getText(),txtchkin.getText(),txtchkout.getText(),txtbreakfast.getText());
        
        
    }
    
}
