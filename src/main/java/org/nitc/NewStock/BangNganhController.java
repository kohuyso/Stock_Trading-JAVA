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

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class BangNganhController implements Initializable {

    @FXML
    private JFXButton About;

    @FXML
    private Button BanBuonB;

    @FXML
    private Button BanLeB;

    @FXML
    private Button BangChiSoB;

    @FXML
    private Button BaoHiemB;

    @FXML
    private Button BatDongSanB;

    @FXML
    private Button CNTTb;

    @FXML
    private Button CaoSuB;

    @FXML
    private Button ChungKhoanB;

    @FXML
    private JFXButton DauTu;

    @FXML
    private Button DuLichB;

    @FXML
    private Button GiaDungB;

    @FXML
    private Button HoaChatB;

    @FXML
    private JFXButton Home;

    @FXML
    private Button KhaiKhoangB;

    @FXML
    private Button MayMocB;

    @FXML
    private Button NLNb;

    @FXML
    private Button NganHangB;

    @FXML
    private Button PhuTroB;

    @FXML
    private Button SucKhoeB;

    @FXML
    private Button THietBiDienB;

    @FXML
    private Button TaiChinhKhacB;

    @FXML
    private Button ThucPhamB;

    @FXML
    private Button ThuySanB;

    @FXML
    private Button TienIchB;

    @FXML
    private Text Time;

    @FXML
    private Button TuVanHoTroB;

    @FXML
    private JFXButton Update;

    @FXML
    private Button VanTaiKhoBaiB;

    @FXML
    private Button VatlLieuXayDungB;

    @FXML
    public Button XayDungB;

    @FXML
    private Text Xd;

    @FXML
    private Text bb;

    @FXML
    private Text bds;

    @FXML
    private Text bh;

    @FXML
    private Text bl;

    @FXML
    private Text cntt;

    @FXML
    private Text cs;

    @FXML
    private Text dl;

    @FXML
    private Text gd;

    @FXML
    private Text hc;

    @FXML
    private Text kk;

    @FXML
    private Text mm;

    @FXML
    private Text nh;

    @FXML
    private Text nln;

    @FXML
    private Text pt;

    @FXML
    private Text sk;

    @FXML
    private Text tbd;

    @FXML
    private Text tckhac;

    @FXML
    private Text ti;

    @FXML
    private Text tp;

    @FXML
    private Text ts;
    
    @FXML
    private Text ck;

    @FXML
    private Text tvht;

    @FXML
    private Text vlxd;

    @FXML
    private Text vtkb;
    
    private Parent root;

    @FXML
    void AboutClick(ActionEvent event) throws IOException {
    	App.setRoot("About");
    }

    @FXML
    void BanBuonC(ActionEvent event) throws IOException {
    	App.setTenNganh("BanBuon");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void BanLeC(ActionEvent event) throws IOException {
    	App.setTenNganh("BanLe");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void BaoHiemC(ActionEvent event) throws IOException {
    	App.setTenNganh("BaoHiem");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void BatDongSanC(ActionEvent event) throws IOException {
    	App.setTenNganh("BatDongSan");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void CNTTc(ActionEvent event) throws IOException {
    	App.setTenNganh("CaoSu");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void CaoSuC(ActionEvent event) throws IOException {
    	App.setTenNganh("ChungKhoan");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void ChungKhoanC(ActionEvent event) throws IOException {
    	App.setTenNganh("CongNgheThongTin");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void DauTuClick(ActionEvent event) throws IOException {
    	App.setRoot("DauTuPage");
    }

    @FXML
    void DuLichC(ActionEvent event) throws IOException {
    	App.setTenNganh("DichVuDuLich");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void GiaDungC(ActionEvent event) throws IOException {
    	App.setTenNganh("SxGiaDung");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void HoaChatC(ActionEvent event) throws IOException {
    	App.setTenNganh("NhuaHoaChat");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void BangChiSoC(ActionEvent event) throws IOException {
    	App.setRoot("ChiSoPage");
    }
    
    @FXML
    void HomeClick(ActionEvent event) throws IOException {
    	App.setRoot("Home");
    }

    @FXML
    void KhaiKhoangC(ActionEvent event) throws IOException {
    	App.setTenNganh("KhaiKhoang");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void MayMocC(ActionEvent event) throws IOException {
    	App.setTenNganh("SxThietBiMayMoc");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void NLNc(ActionEvent event) throws IOException {
    	App.setTenNganh("NongLamNgu");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void NganHangC(ActionEvent event) throws IOException {
    	App.setTenNganh("NganHang");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void PhuTroC(ActionEvent event) throws IOException {
    	App.setTenNganh("SanXuatPhuTro");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void SucKhoeC(ActionEvent event) throws IOException {
    	App.setTenNganh("SucKhoe");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void TaiChinhKhacC(ActionEvent event) throws IOException {
    	App.setTenNganh("TaiChinhKhac");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void ThietBiDienC(ActionEvent event) throws IOException {
    	App.setTenNganh("ThietBiDien");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void ThucPhamC(ActionEvent event) throws IOException {
    	App.setTenNganh("ThucPham");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void ThuySanC(ActionEvent event) throws IOException {
    	App.setTenNganh("ThuySan");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void TienIchC(ActionEvent event) throws IOException {
    	App.setTenNganh("TienIch");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void Time7(MouseEvent event) throws IOException {
 
    }

    @FXML
    void TuVanHoTroC(ActionEvent event) throws IOException {
    	App.setTenNganh("DichVuHoTro");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void UpdateClick(ActionEvent event) throws Exception {
    	UpdateDataBase.CapNhapDuLieu();
    }

    @FXML
    void VanTaiKhoBaiC(ActionEvent event) throws IOException {
    	App.setTenNganh("VanTaiKhoBai");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void VatLieuXayDungC(ActionEvent event) throws IOException {
    	App.setTenNganh("VatLieuXayDung");
    	App.setRoot("ChiSoPage");
    }

    @FXML
    void XayDungC(ActionEvent event) throws IOException {
    	App.setTenNganh("XayDung");
    	App.setRoot("ChiSoPage");
    }
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(UpdateDataBase.getGio());
		Time.setText(UpdateDataBase.getGio());

		// TODO Auto-generated method stub
		try {
			Connection con = ConnectDataBase.openConnection();
			System.out.println(con);
	
			String layMasql = "SELECT BIENDONG, TENNGANH FROM NGANH";
			PreparedStatement psLayMa = con.prepareStatement(layMasql);
			ResultSet rsCL = psLayMa.executeQuery();
			System.out.println(con);
			int i = 0;
			while (rsCL.next()) {
				if (rsCL.getString("TENNGANH").equals("UNDEFINED") == false) {
					if (i == 0) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							BanBuonB.setStyle("-fx-base: #D50100;");
						}
						else {
							BanBuonB.setStyle("-fx-base: #4CAF50;");
							
						}
						bb.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 1) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							BaoHiemB.setStyle("-fx-base: #D50100;");
						}
						else {
							BaoHiemB.setStyle("-fx-base: #4CAF50;");
						}
						bh.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 2) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							BatDongSanB.setStyle("-fx-base: #D50100;");
						}
						else {
							BatDongSanB.setStyle("-fx-base: #4CAF50;");
						}
						bds.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 3) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							ChungKhoanB.setStyle("-fx-base: #D50100;");
						}
						else {
							ChungKhoanB.setStyle("-fx-base: #4CAF50;");
						}
						ck.setText(rsCL.getString("BIENDONG"));

					}
					else if (i == 4) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							CNTTb.setStyle("-fx-base: #D50100;");
						}
						else {
							CNTTb.setStyle("-fx-base: #4CAF50;");
						}
						cntt.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 5) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							BanLeB.setStyle("-fx-base: #D50100;");
						}
						else {
							BanLeB.setStyle("-fx-base: #4CAF50;");
						}
						bl.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 6) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							SucKhoeB.setStyle("-fx-base: #D50100;");
						}
						else {
							SucKhoeB.setStyle("-fx-base: #4CAF50;");
							
						}
						sk.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 7) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							KhaiKhoangB.setStyle("-fx-base: #D50100;");
						}
						else {
							KhaiKhoangB.setStyle("-fx-base: #4CAF50;");
							
						}
						kk.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 8) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							NganHangB.setStyle("-fx-base: #D50100;");
						}
						else {
							NganHangB.setStyle("-fx-base: #4CAF50;");
							
						}
						nh.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 9) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							NLNb.setStyle("-fx-base: #D50100;");
						}
						else {
							NLNb.setStyle("-fx-base: #4CAF50;");
							
						}
						nln.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 10) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							MayMocB.setStyle("-fx-base: #D50100;");
						}
						else {
							MayMocB.setStyle("-fx-base: #4CAF50;");
							
						}
						mm.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 11) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							GiaDungB.setStyle("-fx-base: #D50100;");
						}
						else {
							GiaDungB.setStyle("-fx-base: #4CAF50;");
							
						}
						gd.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 12) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							CaoSuB.setStyle("-fx-base: #D50100;");
						}
						else {
							CaoSuB.setStyle("-fx-base: #4CAF50;");
							
						}
						cs.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 13) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							HoaChatB.setStyle("-fx-base: #D50100;");
						}
						else {
							HoaChatB.setStyle("-fx-base: #4CAF50;");
							
						}
						hc.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 14) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							ThucPhamB.setStyle("-fx-base: #D50100;");
						}
						else {
							ThucPhamB.setStyle("-fx-base: #4CAF50;");
							
						}
						tp.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 15) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							ThuySanB.setStyle("-fx-base: #D50100;");
						}
						else {
							ThuySanB.setStyle("-fx-base: #4CAF50;");
							
						}
						ts.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 16) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							VatlLieuXayDungB.setStyle("-fx-base: #D50100;");
						}
						else {
							VatlLieuXayDungB.setStyle("-fx-base: #4CAF50;");
							
						}
						vlxd.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 17) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							TienIchB.setStyle("-fx-base: #D50100;");
						}
						else {
							TienIchB.setStyle("-fx-base: #4CAF50;");
							
						}
						ti.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 18) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							VanTaiKhoBaiB.setStyle("-fx-base: #D50100;");
						}
						else {
							VanTaiKhoBaiB.setStyle("-fx-base: #4CAF50;");
							
						}
						vtkb.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 19) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							XayDungB.setStyle("-fx-base: #D50100;");
						}
						else {
							XayDungB.setStyle("-fx-base: #4CAF50;");
							
						}
						Xd.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 20) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							DuLichB.setStyle("-fx-base: #D50100;");
						}
						else {
							DuLichB.setStyle("-fx-base: #4CAF50;");
							
						}
						dl.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 21) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							PhuTroB.setStyle("-fx-base: #D50100;");
						}
						else {
							PhuTroB.setStyle("-fx-base: #4CAF50;");
							
						}
						pt.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 23) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							THietBiDienB.setStyle("-fx-base: #D50100;");
						}
						else {
							THietBiDienB.setStyle("-fx-base: #4CAF50;");
							
						}
						tbd.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 24) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							TuVanHoTroB.setStyle("-fx-base: #D50100;");
						}
						else {
							TuVanHoTroB.setStyle("-fx-base: #4CAF50;");
							
						}
						tvht.setText(rsCL.getString("BIENDONG"));
					}
					else if (i == 25) {
						if (rsCL.getString("BIENDONG").charAt(0) == '-') {
							TaiChinhKhacB.setStyle("-fx-base: #D50100;");
						}
						else {
							TaiChinhKhacB.setStyle("-fx-base: #4CAF50;");
							
						}
						tckhac.setText(rsCL.getString("BIENDONG"));
				}

				
				i += 1;
				}
			
				Time.setText(java.time.LocalDate.now().toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}

}
