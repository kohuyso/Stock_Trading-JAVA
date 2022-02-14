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
import org.nitc.Model.CPsoHuuModel;
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

public class RSIcontroller implements Initializable{

    @FXML
    private JFXButton About;

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
    private TableView<MaCK> RSItable;

    @FXML
    private TableColumn<MaCK, Float> Rprice;

    @FXML
    private Button SearchB;

    @FXML
    private TextField SearchText;

    @FXML
    private Text Time;

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
    
    ObservableList<MaCK> listRsi = FXCollections.observableArrayList(
    );

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Time.setText(java.time.LocalDate.now().toString());
		try {
			Connection con = ConnectDataBase.openConnection();
			String layMasql = "SELECT MACK, TENNGANH, GIAHT, DINHGIA, RSI FROM COPHIEU WHERE RSI != 0 and RSI != 1";
			PreparedStatement psLayMa = con.prepareStatement(layMasql);
			ResultSet rsCL = psLayMa.executeQuery();
			System.out.println(rsCL);
			while (rsCL.next()) {
				listRsi.add(new MaCK((float)rsCL.getFloat("RSI"), rsCL.getString("MACK"), rsCL.getString("TENNGANH"), (float)rsCL.getFloat("GIAHT"), (float)rsCL.getFloat("DINHGIA")));
			}
			rsi.setCellValueFactory(new PropertyValueFactory<MaCK, Float>("RSI"));
			Ma.setCellValueFactory(new PropertyValueFactory<MaCK, String> ("MACP"));
			Nganh.setCellValueFactory(new PropertyValueFactory<MaCK, String> ("MANGANH"));
			Price.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("GIAHT"));
			Rprice.setCellValueFactory(new PropertyValueFactory<MaCK, Float> ("DINHGIA"));
		
			RSItable.setItems(listRsi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
