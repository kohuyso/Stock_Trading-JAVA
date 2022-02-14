package org.nitc.NewStock;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.nitc.Controller.ConnectDataBase;
import org.nitc.Controller.ConnectPython_Predict;
import org.nitc.Controller.UpdateDataBase;
import org.nitc.Controller.XuLyData;
import org.nitc.Model.BOT;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class PredictAndBotController implements Initializable {

    @FXML
    private JFXButton About;

    @FXML
    private TableView<BOT> CoTucTable;

    @FXML
    private JFXButton DauTu;

    @FXML
    private Text GiaDD_TEXT;

    @FXML
    private JFXButton Home;

    @FXML
    private TableColumn<BOT, Float> KhoiLuongBot;

    @FXML
    private TableColumn<BOT, String> Lenh_BOT;

    @FXML
    private Button PreB;

    @FXML
    private Text PreNgay;

    @FXML
    private TableColumn<BOT, Float> Price_BOT;

    @FXML
    private Button RunBotB;

    @FXML
    private Text SoCoin;

    @FXML
    private Text Time;

    @FXML
    private JFXButton Update;

    @FXML
    private TextField aa;

    @FXML
    private Text lai;

    @FXML
    private Text now;

    @FXML
    private Text start;

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
    	//GiaDD_TEXT.setText(ConnectPython_Predict.LayOutPut("C:\\Users\\PC\\PycharmProjects\\pythonProject1\\venv\\Lib\\site-packages\\Prediction.py", MaTruyen));    	
    	GiaDD_TEXT.setText(ConnectPython_Predict.LayOutPut("C:\\Users\\PC\\Desktop\\STOCK\\NewStock\\src\\Prediction.py", MaTruyen));    	

    }

    @FXML
    void RunBOTC(ActionEvent event) {
		//ConnectPython_Predict.LayRSI("C:\\Users\\PC\\PycharmProjects\\pythonProject1\\venv\\Lib\\site-packages\\main.py");
		ConnectPython_Predict.LayRSI("C:\\Users\\PC\\Desktop\\STOCK\\NewStock\\src\\main.py");

    }

    @FXML
    void Time7(MouseEvent event) {

    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    }
    
  ObservableList<BOT> listTrade = FXCollections.observableArrayList();
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		PreNgay.setText(java.time.LocalDate.now().toString());
		
		
		try {
		Connection con = ConnectDataBase.openConnection();
		String layMasql = "SELECT LENH, VOLUME, GIAGD FROM LStrade";
		PreparedStatement psLayMa = con.prepareStatement(layMasql);
		ResultSet rsCL = psLayMa.executeQuery();
		System.out.println(rsCL);
		while (rsCL.next()) {
			listTrade.add(new BOT(rsCL.getString("LENH"), rsCL.getFloat("VOLUME"), rsCL.getFloat("GIAGD")));
		}
		Lenh_BOT.setCellValueFactory(new PropertyValueFactory<BOT, String>("lenh"));
		Price_BOT.setCellValueFactory(new PropertyValueFactory<BOT, Float> ("gia"));
		KhoiLuongBot.setCellValueFactory(new PropertyValueFactory<BOT, Float> ("khoiLuong"));
	
		CoTucTable.setItems(listTrade);
		
		String layDataTK = "SELECT LAI, TONGTS, KHOILUONG FROM Trading_BOT";
		PreparedStatement psDataTK = con.prepareStatement(layDataTK);
		ResultSet rsDataTK = psDataTK.executeQuery();
		rsDataTK.next();
		lai.setText("Tiền lãi: " + rsDataTK.getString("LAI"));
		now.setText("Tài sản hiện tại: " + rsDataTK.getString("TONGTS"));
		SoCoin.setText("Số lượng coin: " + rsDataTK.getString("KHOILUONG"));
		start.setText("Số tiền gốc: 20000");
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
