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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pkg439005074.data.tabel;

/**
 * FXML Controller class
 *
 * @author UwU
 */
public class ViewdataController implements Initializable {

    @FXML
    private TextField txtsearch;
    @FXML
    private Button butsearch;
    @FXML
    private TableView<tabel> tbldata;
    @FXML
    private TableColumn<tabel, String> col;
    @FXML
    private TableColumn<tabel, String> colvn;
    @FXML
    private TableColumn<tabel, String> colcn;
     ObservableList<tabel> oblist = FXCollections.observableArrayList();
    @FXML
    private Button butback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         data con = new data();
         try {
            con.UsersData(oblist);
        } catch (SQLException ex) {
            Logger.getLogger(ViewdataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colvn.setCellValueFactory(new PropertyValueFactory<>("Vname"));
        colcn.setCellValueFactory(new PropertyValueFactory<>("Cname"));

        tbldata.setItems(oblist);
    }    

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         ((Node) event.getSource()).getScene().getWindow().hide();

     Parent root = FXMLLoader.load(getClass().getResource("carss.fxml"));
        
    Scene scene = new Scene(root);
      Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
    
}
