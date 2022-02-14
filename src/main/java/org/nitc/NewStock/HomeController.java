package org.nitc.NewStock;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.nitc.Controller.UpdateDataBase;
import org.nitc.Controller.XuLyData;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class HomeController implements Initializable{

    @FXML
    private JFXButton About;

    @FXML
    private JFXButton CoTuc;

    @FXML
    private JFXButton DauTu;

    @FXML
    private JFXButton DinhGia;

    @FXML
    private JFXButton DongTien;

    @FXML
    private JFXButton Home;

    @FXML
    private JFXButton LocNGanh;

    @FXML
    private JFXButton LocRSI;

    @FXML
    private JFXButton Penny;

    @FXML
    private Button SearchB;

    @FXML
    private TextField SearchText;

    @FXML
    private Text Time;

    @FXML
    private JFXButton Update;

    @FXML
    void AboutClick(ActionEvent event) throws IOException {
    	App.setRoot("About");
    }

    @FXML
    void CoTucClick(ActionEvent event) throws IOException {
    	App.setRoot("PredictAndBot");
    }

    @FXML
    void DauTuClick(ActionEvent event) throws IOException {
    	App.setRoot("DauTuPage");
    }

    @FXML
    void DinhGiaClick(ActionEvent event) throws IOException {
    	App.setRoot("EvaluatePage");
    }

    @FXML
    void DongTienClick(ActionEvent event) throws IOException {
    	App.setRoot("DongTienPage");
    }

    @FXML
    void HomeClick(ActionEvent event) {
    	
    }

    @FXML
    void LocNganhClick(ActionEvent event) throws IOException {
    	
    	App.setRoot("BangNganh");
    	
    }

    @FXML
    void LockRsiClick(ActionEvent event) throws IOException {
    	App.setRoot("RSIpage");
    }

    @FXML
    void PennyClick(ActionEvent event) throws IOException {
    	App.setRoot("PennyPage");
    }

    @FXML
    void SearchClick(ActionEvent event) throws IOException {
    	App.setTenCP(SearchText.getText().toString());
    	System.out.println(App.getTenCP());
    	App.setRoot("CoPhieuPage");
    }

    @FXML
    void SearchType(ActionEvent event) {
    	
    }

    @FXML
    void Time7(MouseEvent event) {
    	
    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Time.setText(java.time.LocalDate.now().toString());


	}

}
