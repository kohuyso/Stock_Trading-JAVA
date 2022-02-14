//package org.nitc.NewStock;
//
//import java.io.IOException;
//import com.jfoenix.controls.JFXButton;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.text.Text;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ResourceBundle;
//
//import org.nitc.Controller.ConnectDataBase;
//import org.nitc.Controller.XuLyData;
//
//import org.nitc.Model.CPsoHuuModel;
//
//
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import javafx.fxml.Initializable;
//
//import javafx.scene.control.Alert;
//
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class SoHuuController implements Initializable {
//
//    @FXML
//    private JFXButton About;
//
//    @FXML
//    private JFXButton DauTu;
//
//    @FXML
//    private TableColumn<CPsoHuuModel, Float> DuocGD;
//
//    @FXML
//    private JFXButton Home;
//
//    @FXML
//    private TableColumn<CPsoHuuModel, Float> Lai;
//
//    @FXML
//    private TableColumn<CPsoHuuModel, String> Ma;
//
//    @FXML
//    private TableView<CPsoHuuModel> NoteTable;
//
//    @FXML
//    private Button SearchB;
//
//    @FXML
//    private TableColumn<CPsoHuuModel, Float> SoLuong;
//
//    @FXML
//    private TableColumn<CPsoHuuModel, Float> ThiGia;
//
//    @FXML
//    private Text TienCP;
//
//    @FXML
//    private Text TienMat;
//
//    @FXML
//    private Text Time;
//
//    @FXML
//    private Text Tong;
//
//    @FXML
//    private JFXButton Update;
//
//    @FXML
//    private TableColumn<CPsoHuuModel, Float> Von;
//
//    @FXML
//    private FontAwesomeIconView searchButton;
//
//    @FXML
//    private TextField textSearch;
//
//    @FXML
//    void AboutClick(ActionEvent event) throws IOException {
//    	App.setRoot("About");
//    }
//
//    @FXML
//    void DauTuClick(ActionEvent event) throws IOException {
//    	App.setRoot("DauTuPage");
//    }
//
//    @FXML
//    void HomeClick(ActionEvent event) throws IOException {
//    	App.setRoot("Home");
//    }
//
//    @FXML
//    void SearchC(ActionEvent event) throws IOException {
//    	App.setTenCP(SearchB.getText().toString());
//    	System.out.println(App.getTenCP());
//    	App.setRoot("CoPhieuPage");
//    }
//    
//    @FXML
//    private JFXButton BanB;
//
//    @FXML
//    private TextField BanKL;
//
//    @FXML
//    private TextField BanMa;
//    
//    @FXML
//    void MuaC(ActionEvent event) {
//    	int khoiluong = 0;
//    	String ma = "";
//    	try {
//    		khoiluong = (int) XuLyData.XuLySo(MuaKL.getText().toCharArray());
//    		ma = XuLyData.XuLyChu(MuaMa.getText().toCharArray());
//			Connection con = org.nitc.Controller.ConnectDataBase.openConnection();
//			String chonMa = "BEGIN\r\n"
//					+ "	DECLARE @sales INT, @gia FLOAT;\r\n"
//					+ "	SELECT @sales = TIENMAT FROM TK WHERE TENTK = '24H';\r\n"
//					+ "	SELECT @gia = GIAHT FROM COPHIEU WHERE MACK = ?;\r\n"
//					+ "	IF @sales > ? * @gia \r\n"
//					+ "		BEGIN\r\n"
//					+ "			IF EXISTS ( SELECT CPSOHUU.MACK FROM CPSOHUU WHERE CPSOHUU.MACK = ?)\r\n"
//					+ "				BEGIN\r\n"
//					+ "					UPDATE CPSOHUU\r\n"
//					+ "					SET TONGKL = TONGKL + ?, GIAMUA = @gia\r\n"
//					+ "					WHERE MACK = ? and TENTK = '24h'\r\n"
//					+ "					UPDATE CPSOHUU\r\n"
//					+ "					SET GIAMUA = @gia, GIAMUA = (GIAMUA * TONGKL + @gia * ?)/(TONGKL+?), PTLAI = (@gia/GIAMUA - 1)*100\r\n"
//					+ "					WHERE MACK = ? and TENTK = '24h'\r\n"
//					+ "\r\n"
//					+ "					UPDATE TK \r\n"
//					+ "					SET TIENMAT = TIENMAT - (? * @gia), TONGTS = TIENMAT + TIENCP\r\n"
//					+ "					WHERE TENTK = '24H'\r\n"
//					+ "					UPDATE TK\r\n"
//					+ "					SET TIENCP = TIENCP + (? * (SELECT GIAHT FROM COPHIEU where MACK = ?)), LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
//					+ "					WHERE TENTK = '24H'"
//					+ "\r\n"	
//					+ "\r\n"
//					+ "				END\r\n"
//					+ "			ELSE\r\n"
//					+ "				BEGIN \r\n"
//					+ "					INSERT INTO CPSOHUU(MACK, TENTK, TONGKL, GIAMUA, PTLAI) VALUES (?, '24H', ?, @gia, 0)\r\n"
//					+ "						UPDATE TK\r\n"
//					+ "						SET TIENMAT = TIENMAT - (? * @gia), GIAMUA = @gia\r\n"
//					+ "						WHERE TENTK = '24H'\r\n"
//					+ "\r\n"
//					+ "						UPDATE TK\r\n"
//					+ "						SET TIENCP = (? * @gia), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
//					+ "						WHERE TENTK = '24H'"
//					+ "				END\r\n"
//					+ "		END\r\n"
//					+ "END";
//			PreparedStatement PStimMa = con.prepareStatement(chonMa);
//			PStimMa.setString(1, ma);
//			PStimMa.setInt(2, khoiluong);
//			PStimMa.setString(3, ma);
//			PStimMa.setInt(4, khoiluong);
//			PStimMa.setString(5, ma);
//			PStimMa.setInt(6, khoiluong);
//			PStimMa.setInt(7, khoiluong);
//			PStimMa.setString(8, ma);
//
//			PStimMa.setInt(9, khoiluong);
//			PStimMa.setInt(10, khoiluong);
//
//			PStimMa.setString(11, ma);
//			PStimMa.setString(12, ma);
//			PStimMa.setInt(13, khoiluong);
//			PStimMa.setInt(14, khoiluong);
//			PStimMa.setInt(15, khoiluong);
//
//			PStimMa.executeUpdate();
//			App.setRoot("SoHuuPage");
//			
//    	} catch (Exception e) {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Mua that bai");
//		}
//    }
//    
//    @FXML
//    void BanC(ActionEvent event) {
//    	int khoiluong = 0;
//    	String ma = "BEGIN\r\n"
//    			+ "DECLARE @sales INT, @gia FLOAT;\r\n"
//    			+ "SELECT @gia = GIAHT FROM COPHIEU WHERE MACK = ?\r\n"
//    			+ "SELECT @sales = TONGKL FROM CPSOHUU WHERE TENTK = '24H' and MACK= ?;\r\n"
//    			+ "IF @sales > ?\r\n"
//    			+ "	BEGIN\r\n"
//    			+ "		IF EXISTS ( SELECT CPSOHUU.MACK FROM CPSOHUU WHERE CPSOHUU.MACK = ?)\r\n"
//    			+ "			BEGIN\r\n"
//    			+ "				UPDATE CPSOHUU\r\n"
//    			+ "				SET TONGKL = TONGKL - ?\r\n"
//    			+ "				WHERE MACK = ? and TENTK = '24h'\r\n"
//    			+ "\r\n"
//    			+ "				UPDATE TK\r\n"
//    			+ "				SET TIENMAT = TIENMAT + (? * @gia), TIENCP = TIENCP - (? * @gia), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
//    			+ "				WHERE TENTK = '24H'\r\n"
//    			+ "			END\r\n"
//    			+ "	END\r\n"
//    			+ "IF @sales = ?\r\n"
//    			+ "	BEGIN\r\n"
//    			+ "		IF EXISTS ( SELECT CPSOHUU.MACK FROM CPSOHUU WHERE CPSOHUU.MACK = ?)\r\n"
//    			+ "			BEGIN\r\n"
//    			+ "				DELETE CPSOHUU \r\n"
//    			+ "				WHERE MACK = ? and TENTK = '24h'\r\n"
//    			+ "				UPDATE TK\r\n"
//    			+ "				SET TIENMAT = TIENMAT + (? * @gia), TIENCP = TIENCP - (? * @gia), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
//    			+ "				WHERE TENTK = '24H'\r\n"
//    			+ "			end\r\n"
//    			+ "		end\r\n"
//    			+ "	end";
//    	try {
//    		khoiluong = (int) XuLyData.XuLySo(MuaKL.getText().toCharArray());
//    		ma = XuLyData.XuLyChu(MuaMa.getText().toCharArray());
//			Connection con = org.nitc.Controller.ConnectDataBase.openConnection();
//			String chonMa = "";
//			PreparedStatement PStimMa = con.prepareStatement(chonMa);
//			PStimMa.setString(1, ma);
//			PStimMa.setString(2, ma);
//			PStimMa.setInt(3, khoiluong);
//			PStimMa.setString(4, ma);
//			PStimMa.setInt(5, khoiluong);
//			PStimMa.setString(6, ma);
//			PStimMa.setInt(7, khoiluong);
//			PStimMa.setInt(8, khoiluong);
//			PStimMa.setInt(9, khoiluong);
//			PStimMa.setString(10, ma);
//			PStimMa.setString(11, ma);
//			PStimMa.setInt(12, khoiluong);
//			PStimMa.setInt(13, khoiluong);
//			PStimMa.executeUpdate();
//			App.setRoot("SoHuuPage");
//			
//    	} catch (Exception e) {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Ban that bai");
//		}
//    }
//    
//    @FXML
//    private JFXButton MuaB;
//
//    @FXML
//    private TextField MuaKL;
//
//    @FXML
//    private TextField MuaMa;
//
//    @FXML
//    void SearchClick(MouseEvent event) {
//    	try {
//			Connection con = org.nitc.Controller.ConnectDataBase.openConnection();
//			String chonMa = "SELECT MACK FROM COPHIEU WHERE MACK = ?";
//			PreparedStatement PStimMa = con.prepareStatement(chonMa);
//			PStimMa.setNString(1, XuLyData.XuLyChu(textSearch.getText().toCharArray()));
//			ResultSet rs = PStimMa.executeQuery();
//			if (rs.next() == true) {
//				App.setRoot("CoPhieuPage");
//			}
//			
//		} catch (Exception e) {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Tìm mã chứng khoán thất bại");
//			alert.setContentText("Mã chứng khoán không tồn tại");
//		}
//    }
//
//    @FXML
//    void Time7(MouseEvent event) {
//
//    }
//
//    @FXML
//    void TypeSearch(ActionEvent event) {
//
//    }
//
//    @FXML
//    void UpdateClick(ActionEvent event) {
//
//    }
//    
//    ObservableList<CPsoHuuModel> listChiSo = FXCollections.observableArrayList(
////    		new MaCK("A", "A1", (float)2, (float)3, (float)4, (float)5, (float)6),
////    		new MaCK("B", "B2", (float)2, (float)3, (float)4, (float)5, (float)6),
////    		new MaCK("C", "C3", (float)2, (float)3, (float)4, (float)5, (float)6)
//    );
//    
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
////		Time.setText(UpdateDataBase.getGio());
////		
////		
////
////		try {
////			Connection con = ConnectDataBase.openConnection();
////			String layMasql = "SELECT MACK, TONGKL, GIAMUA, LAI, GIAHT FROM CPSOHUU, COPHIEU";
////			PreparedStatement psLayMa = con.prepareStatement(layMasql);
////			ResultSet rsCL = psLayMa.executeQuery();
////			System.out.println(rsCL);
////			while (rsCL.next()) {
////				listChiSo.add(new CPsoHuuModel(rsCL.getString("MACK"), (float)rsCL.getFloat("GIAHT"), (float)rsCL.getFloat("TONGKL"), (float)rsCL.getFloat("GIAMUA"), (float)rsCL.getFloat("LAI")));
////			}
////	
////				Ma.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, String> ("maCK"));
////				SoLuong.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("khoiLuong"));
////				ThiGia.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("gia"));
////				Von.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("giaMua"));
////				DuocGD.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("DuocGD"));
////				Lai.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("lai"));
////				NoteTable.setItems(listChiSo);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//	}
//
//}
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

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SoHuuController implements Initializable{

    @FXML
    private JFXButton About;

    @FXML
    private JFXButton BanB;

    @FXML
    private TextField BanKL;

    @FXML
    private TextField BanMa;

    @FXML
    private JFXButton DauTu;

    @FXML
    private JFXButton Home;

  @FXML
  private TableColumn<CPsoHuuModel, Float> Lai;

  @FXML
  private TableColumn<CPsoHuuModel, String> Ma;

    @FXML
    private JFXButton MuaB;

    @FXML
    private TextField MuaKL;

    @FXML
    private TextField MuaMa;

    @FXML
    private TableView<CPsoHuuModel> NoteTable;

    @FXML
    private Button SearchB;

  @FXML
  private TableColumn<CPsoHuuModel, Float> SoLuong;

  @FXML
  private TableColumn<CPsoHuuModel, Float> ThiGia;

    @FXML
    private Text TienCP;

    @FXML
    private Text TienMat;

    @FXML
    private Text Time;

    @FXML
    private Text Tong;

    @FXML
    private JFXButton Update;

    @FXML
    private TableColumn<CPsoHuuModel, Float> Von;

    @FXML
    private FontAwesomeIconView searchButton;

    @FXML
    private TextField textSearch;

    @FXML
    void AboutClick(ActionEvent event) throws IOException {
    	App.setRoot("About");
    }

    @FXML
    void BanC(ActionEvent event) {
    	int khoiluong = 0;
    	String ma = "";

    	try {
    		khoiluong = (int) XuLyData.XuLySo(BanKL.getText().toCharArray());
    		ma = XuLyData.XuLyChu(BanMa.getText().toCharArray());
			Connection con = org.nitc.Controller.ConnectDataBase.openConnection();
	
	    	String chonMa = "BEGIN\r\n"
	    			+ "DECLARE @sales INT, @gia FLOAT;\r\n"
	    			+ "SELECT @gia = GIAHT FROM COPHIEU WHERE MACK = ?\r\n"
	    			+ "SELECT @sales = TONGKL FROM CPSOHUU WHERE TENTK = '24H' and MACK= ?;\r\n"
	    			+ "IF @sales > ?\r\n"
	    			+ "	BEGIN\r\n"
	    			+ "		IF EXISTS ( SELECT CPSOHUU.MACK FROM CPSOHUU WHERE CPSOHUU.MACK = ?)\r\n"
	    			+ "			BEGIN\r\n"
	    			+ "				UPDATE CPSOHUU\r\n"
	    			+ "				SET TONGKL = TONGKL - ?\r\n"
	    			+ "				WHERE MACK = ? and TENTK = '24h'\r\n"
	    			+ "\r\n"
	    			+ "				UPDATE TK\r\n"
	    			+ "				SET TIENMAT = TIENMAT + (? * @gia), TIENCP = TIENCP - (? * @gia), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
	    			+ "				WHERE TENTK = '24H'\r\n"
	    			+ "			END\r\n"
	    			+ "	END\r\n"
	    			+ "IF @sales = ?\r\n"
	    			+ "	BEGIN\r\n"
	    			+ "		IF EXISTS ( SELECT CPSOHUU.MACK FROM CPSOHUU WHERE CPSOHUU.MACK = ?)\r\n"
	    			+ "			BEGIN\r\n"
	    			+ "				DELETE CPSOHUU \r\n"
	    			+ "				WHERE MACK = ? and TENTK = '24h'\r\n"
	    			+ "				UPDATE TK\r\n"
	    			+ "				SET TIENMAT = TIENMAT + (? * @gia), TIENCP = TIENCP - (? * @gia), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
	    			+ "				WHERE TENTK = '24H'\r\n"
	    			+ "			end\r\n"
	    			+ "		end\r\n"
	    			+ "	end";
			PreparedStatement PStimMa = con.prepareStatement(chonMa);
			PStimMa.setString(1, ma);
			PStimMa.setString(2, ma);
			PStimMa.setInt(3, khoiluong);
			PStimMa.setString(4, ma);
			PStimMa.setInt(5, khoiluong);
			PStimMa.setString(6, ma);
			PStimMa.setInt(7, khoiluong);
			PStimMa.setInt(8, khoiluong);
			PStimMa.setInt(9, khoiluong);
			PStimMa.setString(10, ma);
			PStimMa.setString(11, ma);
			PStimMa.setInt(12, khoiluong);
			PStimMa.setInt(13, khoiluong);
			System.out.println("ALO1");
			PStimMa.executeUpdate();
			System.out.println("ALO2");
			App.setRoot("SoHuuPage");
		
			
    	} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ban that bai");
			e.printStackTrace();
		}
    }

    @FXML
    void DauTuClick(ActionEvent event) throws IOException {
    	App.setRoot("Home");
    }

    @FXML
    void HomeClick(ActionEvent event) throws IOException {
    	App.setRoot("Home");
    }

    @FXML
    void MuaC(ActionEvent event) {
    	int khoiluong = 0;
    	String ma = "";
    	try {
    		khoiluong = (int) XuLyData.XuLySo(MuaKL.getText().toCharArray());
    		ma = XuLyData.XuLyChu(MuaMa.getText().toCharArray());
			Connection con = org.nitc.Controller.ConnectDataBase.openConnection();
			String chonMa = "BEGIN\r\n"
					+ "	DECLARE @sales INT, @gia FLOAT;\r\n"
					+ "	SELECT @sales = TIENMAT FROM TK WHERE TENTK = '24H';\r\n"
					+ "	SELECT @gia = GIAHT FROM COPHIEU WHERE MACK = ?;\r\n"
					+ "	IF @sales > ? * @gia \r\n"
					+ "		BEGIN\r\n"
					+ "			IF EXISTS ( SELECT CPSOHUU.MACK FROM CPSOHUU WHERE CPSOHUU.MACK = ?)\r\n"
					+ "				BEGIN\r\n"
					+ "					UPDATE CPSOHUU\r\n"
					+ "					SET TONGKL = TONGKL + ?\r\n"
					+ "					WHERE MACK = ? and TENTK = '24h'\r\n"
					+ "					UPDATE CPSOHUU\r\n"
					+ "					SET GIAMUA = (GIAMUA * TONGKL + @gia * ?)/(TONGKL+?), PTLAI = (@gia/GIAMUA - 1)*100\r\n"
					+ "					WHERE MACK = ? and TENTK = '24h'\r\n"
					+ "\r\n"
					+ "					UPDATE TK \r\n"
					+ "					SET TIENMAT = TIENMAT - (? * @gia)\r\n"
					+ "					WHERE TENTK = '24H'\r\n"
					+ "					UPDATE TK\r\n"
					+ "					SET TIENCP = TIENCP + (? * (SELECT GIAHT FROM COPHIEU where MACK = ?)), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
					+ "					WHERE TENTK = '24H'"
					+ "\r\n"	
					+ "\r\n"
					+ "				END\r\n"
					+ "			ELSE\r\n"
					+ "				BEGIN \r\n"
					+ "					INSERT INTO CPSOHUU(MACK, TENTK, TONGKL, GIAMUA, PTLAI) VALUES (?, '24H', ?, @gia, 0)\r\n"
					+ "						UPDATE TK\r\n"
					+ "						SET TIENMAT = TIENMAT - (? * @gia)\r\n"
					+ "						WHERE TENTK = '24H'\r\n"
					+ "\r\n"
					+ "						UPDATE TK\r\n"
					+ "						SET TIENCP = (? * @gia), TONGTS = TIENMAT + TIENCP, LAI = TONGTS - TSbandau, PTLAI = TONGTS/TSbandau\r\n"
					+ "						WHERE TENTK = '24H'"
					+ "				END\r\n"
					+ "		END\r\n"
					+ "END";
			PreparedStatement PStimMa = con.prepareStatement(chonMa);
			PStimMa.setString(1, ma);
			PStimMa.setInt(2, khoiluong);
			PStimMa.setString(3, ma);
			PStimMa.setInt(4, khoiluong);
			PStimMa.setString(5, ma);
			PStimMa.setInt(6, khoiluong);
			PStimMa.setInt(7, khoiluong);
			PStimMa.setString(8, ma);

			PStimMa.setInt(9, khoiluong);
			PStimMa.setInt(10, khoiluong);

			PStimMa.setString(11, ma);
			PStimMa.setString(12, ma);
			PStimMa.setInt(13, khoiluong);
			PStimMa.setInt(14, khoiluong);
			PStimMa.setInt(15, khoiluong);
			System.out.println("ALO!");
			PStimMa.executeUpdate();
			System.out.println("ALO@");
			App.setRoot("SoHuuPage");
			
    	} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mua that bai");
			e.printStackTrace();
		}
    }

    @FXML
    void SearchC(ActionEvent event) {
    	
    }

    @FXML
    void SearchClick(MouseEvent event) throws IOException {
    	App.setTenCP(textSearch.getText().toString());
    	System.out.println(App.getTenCP());
    	App.setRoot("CoPhieuPage");
    }

    @FXML
    void Time7(MouseEvent event) {

    }

    @FXML
    void TypeSearch(ActionEvent event) {
    	
    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    }
    
    ObservableList<CPsoHuuModel> listChiSo = FXCollections.observableArrayList(

    );

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Time.setText(java.time.LocalDate.now().toString());

		try {
		Connection con = ConnectDataBase.openConnection();
		String layMasql = "SELECT CPSOHUU.MACK, TONGKL, GIAMUA, LAI, COPHIEU.GIAHT FROM CPSOHUU, COPHIEU where COPHIEU.MACK = CPSOHUU.MACK";
		PreparedStatement psLayMa = con.prepareStatement(layMasql);
		ResultSet rsCL = psLayMa.executeQuery();
		System.out.println(rsCL);
		while (rsCL.next()) {
			listChiSo.add(new CPsoHuuModel(rsCL.getString("MACK"), (float)rsCL.getFloat("GIAHT"), (float)rsCL.getFloat("TONGKL"), (float)rsCL.getFloat("GIAMUA"), (float)rsCL.getFloat("LAI")));
		}
	
			Ma.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, String> ("maCK"));
			SoLuong.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("khoiLuong"));
			ThiGia.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("gia"));
			Von.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("giaMua"));
			Lai.setCellValueFactory(new PropertyValueFactory<CPsoHuuModel, Float> ("lai"));
			NoteTable.setItems(listChiSo);
			
		String layTK = "SELECT TIENMAT, TIENCP, TONGTS FROM CPSOHUU, COPHIEU where COPHIEU.MACK = CPSOHUU.MACK";
		PreparedStatement psLayTK = con.prepareStatement(layTK);
		ResultSet rsTK = psLayTK.executeQuery();
		rsTK.next();
		TienMat.setText(rsTK.getString("TIENMAT"));
		TienCP.setText(rsTK.getString("TIENCP"));
		Tong.setText(rsTK.getString("TONGTS"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}

