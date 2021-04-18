/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.User;
import project.Project;
 
public class EdituseradminController implements Initializable {

    @FXML
    private Button butb;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtpass;
    @FXML
    private TextField txtpn;
 
    @FXML
    private TableView<User> tblusers;
    @FXML
    private TableColumn<User, String> colname;
    @FXML
    private TableColumn<User, String> colpass;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private TableColumn<User, String> colpn;
   
    User selected=null;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            this.btnDelete.setDisable(true);
        Project.loadUsers();
        this.tblusers.setItems(Project.userList );
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colpass.setCellValueFactory(new PropertyValueFactory<>("password"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colpn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        this.tblusers.getSelectionModel().selectedIndexProperty().addListener(x -> {
            selected = this.tblusers.getSelectionModel().getSelectedItem();
            if (selected != null) {
                   this.btnDelete.setDisable(false);
            } else {
                this.btnDelete.setDisable(true);
                
            }
        });

    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
     
          Project.changeView("/views/adminsmainmenu.fxml","admin smain menu");
    }

    

    @FXML
    private void addUser(ActionEvent event) throws SQLException {
        String name=txtuser.getText();
        String password=txtpass.getText();
        String email=txtemail.getText();
        String phone=txtpn.getText();
        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()){
           Project.showAlert("Error", "All fields are required", Alert.AlertType.NONE);
            return;
        }
         Project.insertUser(txtuser.getText(), txtpass.getText(), txtemail.getText(),txtpn.getText());
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if(selected!=null){
            Project.deletUser(selected.getId());
        }
    }
    
}
