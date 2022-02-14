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
import org.nitc.Model.CPTheoDoi;

import com.jfoenix.controls.JFXButton;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DongTienController implements Initializable {

    @FXML
    private JFXButton About;

    @FXML
    private JFXButton DauTu;

    @FXML
    private JFXButton Home;
    
    @FXML
    private AnchorPane TongNe;

    @FXML
    private Button SearchB;

    @FXML
    private TextField SearchText;

    @FXML
    private Text Time;

    @FXML
    private JFXButton Update;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private AnchorPane lineChart;

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
    
    @FXML
    private Text SumeNe;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Time.setText(UpdateDataBase.getGio());

		XYChart.Series dt = new XYChart.Series();

		
		barChart.getData().addAll(dt);
		
		try {
			Connection con = ConnectDataBase.openConnection();
			String layMasql = "SELECT TENNGANH , GIATRI FROM NGANH";
			PreparedStatement psLayMa = con.prepareStatement(layMasql);
			ResultSet rsCL = psLayMa.executeQuery();
			dt.setName("Ngành");
			int sum = 0;
			while (rsCL.next()) {
				dt.getData().add(new XYChart.Data(rsCL.getString("TENNGANH"), (float) rsCL.getFloat("GIATRI")));
				sum += rsCL.getInt("GIATRI");
			}
			
			SumeNe.setText("Tổng: " + String.valueOf(sum));
			Time.setText(java.time.LocalDate.now().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	

}
