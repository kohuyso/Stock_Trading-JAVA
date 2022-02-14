package org.nitc.NewStock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.nitc.Controller.ConnectPython_Predict;
import org.nitc.Controller.UpdateDataBase;
import org.nitc.Controller.XuLyData;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DuDoanGiaController implements Initializable{

    @FXML
    private JFXButton About;

    @FXML
    private JFXButton DauTu;

    @FXML
    private JFXButton Home;

    @FXML
    private Text Ngay_Pre;

    @FXML
    private Button PreB;

    @FXML
    private Button SearchB;

    @FXML
    private TextField SearchText;

    @FXML
    private Text Time;
    
    @FXML
    private JFXButton TradingB;

    @FXML
    private JFXButton Update;

    @FXML
    private TextField aa;
    
    @FXML
    private Text GiaDoanText;

    @FXML
    void AboutClick(ActionEvent event) throws IOException {
    	App.setRoot("About");
    }

    @FXML
    void DauTuClick(ActionEvent event) throws IOException {
    	App.setRoot("DauTuPage");
    }

    @FXML
    void HomeClick(ActionEvent event) throws IOException {
    	App.setRoot("Home");
    }

    @FXML
    void PreC(ActionEvent event) {
    	String MaTruyen = XuLyData.XuLyChu(aa.getText().toCharArray());
    	GiaDoanText.setText(ConnectPython_Predict.LayOutPut("C:\\Users\\PC\\PycharmProjects\\pythonProject1\\venv\\Lib\\site-packages\\Prediction.py", MaTruyen));
    }

    @FXML
    void SearchClick(ActionEvent event) throws IOException {
    	App.setTenCP(SearchText.getText().toString());
    	System.out.println(App.getTenCP());
    	App.setRoot("CoPhieuPage");
    }
    
    @FXML
    void TradingClick(ActionEvent event) throws IOException {
    	App.setRoot("CoTucPage");
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
		Ngay_Pre.setText(java.time.LocalDate.now().toString());
		
		
		Time.setText(java.time.LocalDate.now().toString());
	}

}
