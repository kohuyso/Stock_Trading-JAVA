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

public class PennyController implements Initializable{

    @FXML
    private JFXButton About;

    @FXML
    private JFXButton DauTu;

    @FXML
    private TableColumn<MaCK, Float> EvaluPrice;

    @FXML
    private JFXButton Home;

    @FXML
    private TableColumn<MaCK, String> Ma;

    @FXML
    private TableColumn<MaCK, String> Nganh;

    @FXML
    private TableView<MaCK> PennyTable;

    @FXML
    private TableColumn<MaCK, Float> Price;

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
    private TableColumn<MaCK, Float> rsi;

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

    ObservableList<MaCK> listChiSoPenny = FXCollections.observableArrayList(

    );

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		try {
			Connection con = ConnectDataBase.openConnection();
			String layMasql = "SELECT COPHIEU.MACK, TENNGANH, GIAHT, DINHGIA, RSI FROM COPHIEU, PENNY WHERE PENNY.MACK = COPHIEU.MACK";
			PreparedStatement psLayMa = con.prepareStatement(layMasql);
			ResultSet rsCL = psLayMa.executeQuery();
			System.out.println(rsCL);
			while (rsCL.next()) {
				listChiSoPenny.add(new MaCK(rsCL.getString("MACK"), (float)rsCL.getFloat("DINHGIA"), (float)rsCL.getFloat("GIAHT"), (float)rsCL.getFloat("RSI"), rsCL.getString("TENNGANH")));
			}
		
			Ma.setCellValueFactory(new PropertyValueFactory<MaCK, String> ("MACP"));
			Nganh.setCellValueFactory(new PropertyValueFactory<MaCK, String> ("MANGANH"));
			Price.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("GIAHT"));
			rsi.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("RSI"));
			EvaluPrice.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("DINHGIA"));
			PennyTable.setItems(listChiSoPenny);
			Time.setText(java.time.LocalDate.now().toString());

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
