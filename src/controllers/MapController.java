package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Place;
import project.Project;

public class MapController implements Initializable {

    @FXML
    private Button buttback;
    @FXML
    private Button btnMakkah;
    @FXML
    private Button btnRiyadh;
    @FXML
    private Button btnMadinah;
    @FXML
    private TextField txtName;
    @FXML
    private TextArea txtInfo;
    @FXML
    private TextArea txtBest;
    @FXML
    private TextField txtArea;
    @FXML
    private Button btnJeddah;
    @FXML
    private Button btnNajran;
    @FXML
    private Button btnTabuk;
    @FXML
    private Button btnJawf;
    @FXML
    private Button btnJizan;
    @FXML
    private Button btnAsir;
    @FXML
    private Button btnHail;
    @FXML
    private Button btnQasim;
    @FXML
    private Button btnBahah;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void B1(ActionEvent event) throws IOException {
        Project.changeView("/views/mainmenuUSERS.fxml", "main menu USERS");

    }

    @FXML
    private void getMakkah(ActionEvent event) {
        Place p = Project.getPlace("Makkah");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getRiyadh(ActionEvent event) {
        Place p = Project.getPlace("Riyadh");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getMadinah(ActionEvent event) {
        Place p = Project.getPlace("Madinah");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getJeddah(ActionEvent event) {
        Place p = Project.getPlace("Jeddah");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getNajran(ActionEvent event) {
        Place p = Project.getPlace("Najran");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getTabuk(ActionEvent event) {
        Place p = Project.getPlace("Tabuk");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getJawf(ActionEvent event) {
        Place p = Project.getPlace("Jawf");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getJizan(ActionEvent event) {
        Place p = Project.getPlace("Jizan");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getAsir(ActionEvent event) {
        Place p = Project.getPlace("Asir");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getHail(ActionEvent event) {
        Place p = Project.getPlace("Hail");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getQasim(ActionEvent event) {
        Place p = Project.getPlace("Qasim");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

    @FXML
    private void getBahah(ActionEvent event) {
        Place p = Project.getPlace("Bahah");
        if (p != null) {
            this.txtArea.setText(p.getArea() + "");
            this.txtBest.setText(p.getBest());
            this.txtInfo.setText(p.getInfo());
            this.txtName.setText(p.getName());
        } else {
            this.txtArea.setText("");
            this.txtBest.setText("");
            this.txtInfo.setText("");
            this.txtName.setText("");
        }
    }

}
