////package org.nitc.NewStock;
////
////import java.io.IOException;
////import java.net.URL;
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.util.ResourceBundle;
////
////import org.nitc.Model.LichSuGiaModel;
////import org.nitc.Model.MaCK;
////
////import com.jfoenix.controls.JFXButton;
////
////import javafx.collections.FXCollections;
////import javafx.collections.ObservableList;
////import javafx.event.ActionEvent;
////import javafx.fxml.FXML;
////import javafx.fxml.Initializable;
////import javafx.scene.control.TableColumn;
////import javafx.scene.control.TableView;
////import javafx.scene.control.TextField;
////import javafx.scene.control.cell.PropertyValueFactory;
////import javafx.scene.input.MouseEvent;
////import javafx.scene.layout.AnchorPane;
////import javafx.scene.layout.Pane;
////import javafx.scene.text.Text;
////
////public class CoPhieuInfor implements Initializable{
////
////    @FXML
////    private JFXButton About;
////
////    @FXML
////    private TableColumn<LichSuGiaModel, String> Adjust;
////
////    @FXML
////    private JFXButton BaoCaoB;
////
////    @FXML
////    private Text CaoNhat;
////
////    @FXML
////    private JFXButton ChiTietB;
////
////    @FXML
////    private TableColumn<LichSuGiaModel, String> Date;
////
////    @FXML
////    private JFXButton DauTu;
////
////    @FXML
////    private TableColumn<LichSuGiaModel, Float> Forign;
////
////    @FXML
////    private TableView<LichSuGiaModel> HistoryTable;
////
////    @FXML
////    private JFXButton Home;
////
////    @FXML
////    private Text MaText;
////
////    @FXML
////    private AnchorPane NganhT;
////
////    @FXML
////    private TableColumn<LichSuGiaModel, Float> Price;
////
////    @FXML
////    private Text PtramThayD;
////
////    @FXML
////    private Text SanText;
////
////    @FXML
////    private Pane SeachB;
////
////    @FXML
////    private TextField SeachT;
////
////    @FXML
////    private Text TenDN_T;
////
////    @FXML
////    private Text ThamChieu;
////
////    @FXML
////    private Text ThapNhat;
////
////    @FXML
////    private Text Time;
////
////    @FXML
////    private JFXButton Update;
////
////    @FXML
////    private TableColumn<LichSuGiaModel, Float> Volume;
////
////    @FXML
////    private Text volume;
////
////    @FXML
////    void AboutClick(ActionEvent event) {
////
////    }
////
////    @FXML
////    void BaoCaoC(ActionEvent event) {
////
////    }
////
////    @FXML
////    void ChiTietC(ActionEvent event) throws IOException {
////    	App.setRoot("HistoryPage");
////    }
////
////    @FXML
////    void DauTuClick(ActionEvent event) throws IOException {
////    	App.setRoot("DauTuClick");
////    }
////
////    @FXML
////    void HomeClick(ActionEvent event) throws IOException {
////    	App.setRoot("Home");
////    }
////
////    @FXML
////    void SearchC(ActionEvent event) {
////
////    }
////
////    @FXML
////    void Time7(MouseEvent event) {
////
////    }
////
////    @FXML
////    void UpdateClick(ActionEvent event) {
////
////    }
////    
////    ObservableList<LichSuGiaModel> listLSG = FXCollections.observableArrayList(
//////    		new LichSuGiaModel((float)2, (float)3, (float)4, (float)5, "A"),
//////    		new LichSuGiaModel((float)3, (float)4, (float)5, (float)6, "B"),
//////    		new LichSuGiaModel((float)3, (float)4, (float)5, (float)6, "C")
////    );
////
////	@Override
////	public void initialize(URL location, ResourceBundle resources) {
//////		try {
//////			Connection con = ConnectDataBase.openConnection();
//////			String layMasql = "SELECT NGAY, GIA, KHOILUONG, KHOINGOAI, THAYDOI FROM LICHSUGIA WHERE MACK = 'ACB'";
//////			PreparedStatement psLayMa = con.prepareStatement(layMasql);
//////			ResultSet rsCL = psLayMa.executeQuery();
//////			System.out.println(rsCL);
//////			int i = 0;
//////			while (rsCL.next()) {
//////				listLSG.add(new LichSuGiaModel(rsCL.getString("THAYDOI"),(float) rsCL.getFloat("GIA"), (float)rsCL.getFloat("KHOINGOAI"), (float)rsCL.getFloat("KHOILUONG"), rsCL.getString("NGAY")));
//////				i += 1;
//////				if (i == 5) {
//////					break;
//////				}
//////			}
//////		
//////			Date.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, String> ("date"));
//////			Price.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("GIAHT"));
//////			Adjust.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, String> ("PTTHAYDOI"));
//////			Volume.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("volume"));
//////			Forign.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("KHOINGOAI"));
//////			
//////			HistoryTable.setItems(listLSG);
//////
//////			
//////		} catch (Exception e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}
////
////	}
////
////}
//
//
package org.nitc.NewStock;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.nitc.Controller.ConnectDataBase;
import org.nitc.Controller.UpdateDataBase;
import org.nitc.Controller.XuLyData;
import org.nitc.Model.LichSuGiaModel;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.VBox;
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
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.ScrollPane;

public class CoPhieuInfor implements Initializable {
	
	

    @FXML
    private VBox vBoxNe;
    
    @FXML
    private ImageView AnhBD;

    @FXML
    private ImageView AnhLoGo;
    
    @FXML
    private Text Gia;
    
    @FXML
    private Text ptThayDoi;
    
    @FXML
    private Text KhoiLuong;
    
    
    private WebEngine engine;
    @FXML
    private WebView PTKT;
    @FXML
    private WebView BieuDo6Month;

    
    
    @FXML
    private Text beta;

    @FXML
    private Text bvps;

    @FXML
    private Text dinhgia;

    @FXML
    private Text eps;

    @FXML
    private Text pb;

    @FXML
    private Text pe;


    @FXML
    private Text rsi;

    @FXML
    private JFXButton About;

    @FXML
    private TableColumn<LichSuGiaModel, String> Adjust;

    @FXML
    private JFXButton BaoCaoB;

    @FXML
    private Text CaoNhat;

    @FXML
    private JFXButton ChiTietB;

    @FXML
    private TableColumn<LichSuGiaModel, String> Date;

    @FXML
    private JFXButton DauTu;

	@FXML
	private TableColumn<LichSuGiaModel, Float> Forign;
	
	@FXML
	private TableView<LichSuGiaModel> HistoryTable;

    @FXML
    private JFXButton Home;

    @FXML
    private Text MaText;

    @FXML
    private TableColumn<LichSuGiaModel, Float> Price;

    @FXML
    private Text PtramThayD;

    @FXML
    private Text SanText;

    @FXML
    private Pane SeachB;

    @FXML
    private TextField SeachT;

    @FXML
    private Button SearchB;

    @FXML
    private Text TenDN_T;

    @FXML
    private Text ThamChieu;

    @FXML
    private Text ThapNhat;

    @FXML
    private Text Time;

    @FXML
    private JFXButton Update;

    @FXML
    private TableColumn<LichSuGiaModel, Float> Volume;

    @FXML
    private Text volume;
    
    @FXML
    private ScrollPane chaHieu;

    @FXML
    void AboutClick(ActionEvent event) throws IOException {
    	App.setRoot("About");
    }

    @FXML
    void BaoCaoC(ActionEvent event) {

    }

    @FXML
    void ChiTietC(ActionEvent event) throws IOException {
    	App.setRoot("HistoryPage");
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
    	App.setTenCP(SeachT.getText().toString());
    	System.out.println(App.getTenCP());
    	App.setRoot("CoPhieuPage");
    }

    @FXML
    void Time7(MouseEvent event) {

    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    }
    
ObservableList<LichSuGiaModel> listLSG = FXCollections.observableArrayList(
//new LichSuGiaModel((float)2, (float)3, (float)4, (float)5, "A"),
//new LichSuGiaModel((float)3, (float)4, (float)5, (float)6, "B"),
//new LichSuGiaModel((float)3, (float)4, (float)5, (float)6, "C")
);

@Override
public void initialize(URL location, ResourceBundle resources) {

	System.out.println(App.getTenCP());
	Time.setText(UpdateDataBase.getGio());
	
	PTKT.getEngine().load("https://stockchart.vietstock.vn/?stockcode="+ App.getTenCP() +"&lang=vi&isIframe=1");
	BieuDo6Month.getEngine().load("http://charthistory.cafef.vn/"+ App.getTenCP() +"/6months.png");

	
	try {
	Connection con = ConnectDataBase.openConnection();
	String layMasql = "SELECT NGAY, GIA, KHOILUONG, KHOINGOAI, THAYDOI FROM LICHSUGIA WHERE MACK = ?";
	PreparedStatement psLayMa = con.prepareStatement(layMasql);
//	System.out.println(App.getTenCP());
	psLayMa.setString(1, App.getTenCP());
	ResultSet rsCL = psLayMa.executeQuery();
	System.out.println(rsCL);
	int i = 0;
	while (rsCL.next()) {
		listLSG.add(new LichSuGiaModel(rsCL.getString("THAYDOI"),(float) rsCL.getFloat("GIA"), (float)rsCL.getFloat("KHOINGOAI"), (float)rsCL.getFloat("KHOILUONG"), rsCL.getString("NGAY")));
		i += 1;
		if (i == 5) {
			break;
		}
	}
	
	Date.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, String> ("date"));
	Price.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("GIAHT"));
	Adjust.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, String> ("PTTHAYDOI"));
	Volume.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("volume"));
	Forign.setCellValueFactory(new PropertyValueFactory<LichSuGiaModel, Float> ("KHOINGOAI"));	
	HistoryTable.setItems(listLSG);
	
	
	String layDatasql = "SELECT TENDN, MACK, SAN, GIAHT, THAYDOI, KHOILUONG, GIAMAX, GIAMIN, GIAMC, DINHGIA, PwE, PwB, BETA, BVPS, EPS, RSI FROM COPHIEU WHERE MACK = ?";
	PreparedStatement psDaTa = con.prepareStatement(layDatasql);
	psDaTa.setString(1, App.getTenCP());
	ResultSet rsGetData = psDaTa.executeQuery();
	rsGetData.next();


	TenDN_T.setText(rsGetData.getString("TENDN"));
	MaText.setText(rsGetData.getString("MACK"));
	SanText.setText(rsGetData.getString("SAN"));
	String giaht = String.valueOf(rsGetData.getFloat("GIAHT"));
	Gia.setText("Giá: " +giaht);
	ptThayDoi.setText("Thay đổi: " + rsGetData.getString("THAYDOI"));
	String khoil = String.valueOf(rsGetData.getFloat("KHOILUONG"));
	KhoiLuong.setText("Khối lượng: " + khoil);
	String giamc = String.valueOf(rsGetData.getFloat("GIAMC"));
	ThamChieu.setText("Giá mở cửa: " + giamc);
	String giamin = String.valueOf(rsGetData.getFloat("GIAMIN"));
	ThapNhat.setText("Giá thấp nhất: " + giamin);
	String giamax = String.valueOf(rsGetData.getFloat("GIAMAX"));
	CaoNhat.setText("Giá cao nhất: " + giamax);
	String Pe  = String.valueOf(rsGetData.getFloat("PwE"));
	pe.setText("P/E: " + Pe);
	String Pb = String.valueOf(rsGetData.getFloat("PwB"));
	pb.setText("P/B: " + Pb);
	String Rsi = String.valueOf(rsGetData.getFloat("RSI"));
	rsi.setText("RSI: " + Rsi);
	String Beta = String.valueOf(rsGetData.getFloat("BETA"));
	beta.setText("Beta: " + Beta);
	String dinhg = String.valueOf(rsGetData.getFloat("DINHGIA"));
	dinhgia.setText("Giá định giá: " + dinhg);
	String Eps = String.valueOf(rsGetData.getFloat("EPS"));
	eps.setText("EPS: " + Eps);
	String Bvps = String.valueOf(rsGetData.getFloat("BVPS"));
	bvps.setText("BVPS: " + Bvps);

	Time.setText(java.time.LocalDate.now().toString());
	
	
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

}

}

