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
import org.nitc.Model.LichSuGiaModel;
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

public class LichSuGiaController implements Initializable{

    @FXML
    private JFXButton About;

    @FXML
    private TableColumn<LichSuGiaModel, Float> Adjust;

    @FXML
    private TableColumn<LichSuGiaModel, String> Date;

    @FXML
    private JFXButton DauTu;

    @FXML
    private TableColumn<LichSuGiaModel, Float> Foreign;

    @FXML
    private JFXButton Home;

    @FXML
    private TableView<LichSuGiaModel> LSGtable;

    @FXML
    private TableColumn<LichSuGiaModel, Float> Price;

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
    private TableColumn<LichSuGiaModel, Float> Volume;

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
    
    ObservableList<LichSuGiaModel> listLSG = FXCollections.observableArrayList(
//    		new LichSuGiaModel((float)2, (float)3, (float)4, (float)5, "A"),
//    		new LichSuGiaModel((float)3, (float)4, (float)5, (float)6, "B"),
//    		new LichSuGiaModel((float)3, (float)4, (float)5, (float)6, "C")
    );

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			Connection con = ConnectDataBase.openConnection();
			String layMasql = "SELECT NGAY, GIA, KHOILUONG, KHOINGOAI, THAYDOI FROM LICHSUGIA WHERE MACK = ?";
			PreparedStatement psLayMa = con.prepareStatement(layMasql);
			psLayMa.setString(1, App.getTenCP());
			ResultSet rsCL = psLayMa.executeQuery();
			System.out.println(rsCL);
			while (rsCL.next()) {
				listLSG.add(new LichSuGiaModel(rsCL.getString("THAYDOI"),(float) rsCL.getFloat("GIA"), (float)rsCL.getFloat("KHOINGOAI"), (float)rsCL.getFloat("KHOILUONG"), rsCL.getString("NGAY")));
			}
		
			Date.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, String> ("date"));
			Price.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("GIAHT"));
			Adjust.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("PTTHAYDOI"));
			Volume.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("volume"));
			Foreign.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("KHOINGOAI"));
			
			LSGtable.setItems(listLSG);
			Time.setText(java.time.LocalDate.now().toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
