


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
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class DauTuController implements Initializable {

    @FXML
    private JFXButton About;

    @FXML
    private Button CPsuhuuB;

    @FXML
    private TableColumn<CPTheoDoi, Float> ChenhLech;


    @FXML
    private JFXButton DauTu;

    @FXML
    private TableColumn<CPTheoDoi, Float> GiaHienTai;

    @FXML
    private TableColumn<CPTheoDoi, Float> GiaTheoDoi;

    @FXML
    private JFXButton Home;

    @FXML
    private TableColumn<CPTheoDoi, String> Ma;

    @FXML
    private TableView<CPTheoDoi> NoteTable;
    

    @FXML
    private Button SearchB;

    @FXML
    private Text Time;

    @FXML
    private JFXButton Update;

    @FXML
    private PieChart pieChart;

    @FXML
    private FontAwesomeIconView searchButton;

    @FXML
    private TextField textSearch;

    @FXML
    void AboutClick(ActionEvent event) throws IOException {
    	App.setRoot("About");
    }

    @FXML
    void CPsuhuuC(ActionEvent event) throws IOException {
    	App.setRoot("SoHuuPage");
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
    void SearchC(ActionEvent event) throws IOException {
    	App.setTenCP(textSearch.getText().toString());
    	System.out.println(App.getTenCP());
    	App.setRoot("CoPhieuPage");
    }

    @FXML
    void SearchClick(MouseEvent event) throws IOException {
    	App.setTenCP(textSearch.getText().toString());
    	System.out.println(App.getTenCP());
    	App.setRoot("CoPhieuPage");
    }

    @FXML
    void Time7(MouseEvent event) {
		Time.setText(java.time.LocalDate.now().toString());
    }

    @FXML
    void TypeSearch(ActionEvent event) {

    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    }
    
    ObservableList<CPTheoDoi> List = FXCollections.observableArrayList(
//    		new CPTheoDoi("A", 1, 2, 3),
//    		new CPTheoDoi("B", 4, 5, 6)
    ); 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Time.setText(java.time.LocalDate.now().toString());
		// TODO Auto-generated method stub
			try {
				Connection con = ConnectDataBase.openConnection();
				String layMasql = "SELECT TIENMAT, TIENCP  FROM TK WHERE TENTK = '24H'";
				PreparedStatement psLayMa = con.prepareStatement(layMasql);
				ResultSet rsCL = psLayMa.executeQuery();
				System.out.println(rsCL);
				rsCL.next();
				ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
						new PieChart.Data("Tiền mặt: ", rsCL.getFloat("TIENMAT")),
						new PieChart.Data("Cổ phiếu: ", rsCL.getFloat("TIENCP")));
						
					pieChartData.forEach(data -> 
						data.nameProperty().bind(
								Bindings.concat(
										data.getName(), data.pieValueProperty())));
		
					pieChart.getData().addAll(pieChartData);
					GiaTheoDoi.setCellValueFactory(new PropertyValueFactory<CPTheoDoi, Float>("giaTD"));
					ChenhLech.setCellValueFactory(new PropertyValueFactory<CPTheoDoi, Float>("chenhLech"));
					GiaHienTai.setCellValueFactory(new PropertyValueFactory<CPTheoDoi, Float>("giaHT"));
					Ma.setCellValueFactory(new PropertyValueFactory<CPTheoDoi, String>("maCP"));
					NoteTable.setItems(List);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// TODO Auto-generated method stub



			
			
	}

}




