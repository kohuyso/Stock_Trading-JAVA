package org.nitc.NewStock;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.nitc.Controller.ConnectDataBase;
import org.nitc.Controller.UpdateDataBase;
import org.nitc.Controller.XuLyData;
import org.nitc.Model.MaCK;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ChiSoController implements Initializable{
	

	@FXML
    private JFXButton About;

    @FXML
    private TableView<MaCK> ChiSoTable;

    @FXML
    private JFXButton DauTu;

    @FXML
    private JFXButton Home;

    @FXML
    private TableColumn<MaCK, String> Ma;

    @FXML
    private TableColumn<MaCK, String> Nganh;

    @FXML
    private TableColumn<MaCK, Float> Price;

    @FXML
    private TableColumn<MaCK, Float> PwB;

    @FXML
    private TableColumn<MaCK, Float> PwE;

    @FXML
    private TableColumn<MaCK, Float> ROA;

    @FXML
    private TableColumn<MaCK, Float> ROE;
    @FXML
    private Button SearchB;

    @FXML
    private TextField SearchText;

    @FXML
    private Text Time;

    @FXML
    private Text Time1;

    @FXML
    private JFXButton Update;

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
    
    ObservableList<MaCK> listChiSo = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Time.setText(UpdateDataBase.getGio());
		
		try {
			Connection con = ConnectDataBase.openConnection();
			String layMasql = "SELECT MACK, TENNGANH, GIAHT, PwE, PwB, BETA, BVPS, FPwE FROM COPHIEU WHERE TENNGANH = ?";
			PreparedStatement psLayMa = con.prepareStatement(layMasql);
			psLayMa.setString(1, App.getTenNganh());
			ResultSet rsCL = psLayMa.executeQuery();
			System.out.println(rsCL);
			while (rsCL.next()) {
				listChiSo.add(new MaCK(rsCL.getString("MACK"), rsCL.getString("TENNGANH"), (float)rsCL.getFloat("GIAHT"), (float)rsCL.getFloat("PwE"), (float)rsCL.getFloat("PwB"), (float)rsCL.getFloat("BETA"), (float)rsCL.getFloat("BVPS"), (float)rsCL.getFloat("FPwE")));
			}
		
			Ma.setCellValueFactory(new PropertyValueFactory<MaCK, String> ("MACP"));
			Nganh.setCellValueFactory(new PropertyValueFactory<MaCK, String> ("MANGANH"));
			Price.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("GIAHT"));
			PwE.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("PwE"));
			PwB.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("PwB"));
			ROA.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("FPwE"));
			ROE.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("BETA"));
			
			ChiSoTable.setItems(listChiSo);
			Time.setText(java.time.LocalDate.now().toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}





