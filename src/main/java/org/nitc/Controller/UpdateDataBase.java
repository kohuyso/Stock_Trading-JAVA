package org.nitc.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UpdateDataBase {

	private static String Gio;

	public static String getGio() {
		return Gio;
	}

	public static void setGio(String gio) {
		Gio = gio;
	}

	public static void CapNhapDuLieu () throws Exception {
		Connection con = ConnectDataBase.openConnection();
		int hu = 0;
		String layMasql = "SELECT MACK, SAN FROM COPHIEU";
		PreparedStatement psLayMa = con.prepareStatement(layMasql);
		ResultSet rs = psLayMa.executeQuery();
		while (rs.next()) {
			hu += 1;
			
			try {
				if (rs.getString("SAN").equals("OTC") ==  false) {
		
		
					String LinkMalayData = "https://finance.vietstock.vn/" + rs.getString("MACK") + "/phan-tich-ky-thuat.htm";
						System.out.println(LinkMalayData);
						Document docPTKT = Jsoup.connect(LinkMalayData).get();
						Elements elementPTKT = docPTKT.getElementsByClass("pull-right");
							if (hu == 3) {
								Element elementTime = docPTKT.getElementById("tradedate");
								Gio = XuLyData.XuLyChu(elementTime.text().toCharArray());
							}
							//Update Time (=======================)
						Elements elementPTKTtendn = docPTKT.getElementsByClass("title-2 text");
						String insertMaCK = "UPDATE COPHIEU SET TENDN = ?, GIAHT = ?, THAYDOI = ?, GIAMAX = ?, GIAMIN = ?, PwB = ?, DINHGIA = ?, PwE = ?, GIAMC = ?, KHOILUONG = ?, VONHOA = ?, BETA = ?, EPS = ?, DUMUA = ?, DUBAN = ?, FPwE = ?, BVPS = ?, PTTHAYDOI = ? WHERE MACK = ?";
						int kichthuoc = elementPTKT.eachText().size() - 4;
						float GiaMC = 0;
						float GiaCN = 0;
						float GiaTN = 0;
						float KLGD = 0;
						float VonHoa = 0;
						float DuMua = 0;
						float DuBan = 0;
						float Beta = 0;
						float EPS = 0;
						float pWe = 0;
						float FpWe = 0;
						float BVPS = 0;
						float pWb = 0;
						String TenDn = "";
						float dinhgia = 0;
						float lech = 0;
						try {
							GiaMC = (float)XuLyData.XuLySo(elementPTKT.eachText().get(1).toCharArray());							
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							GiaCN = (float)XuLyData.XuLySo(elementPTKT.eachText().get(2).toCharArray());
							GiaTN = (float)XuLyData.XuLySo(elementPTKT.eachText().get(3).toCharArray());
							
	
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							KLGD = (float)XuLyData.XuLySo(elementPTKT.eachText().get(4).toCharArray());
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							DuMua = (float)XuLyData.XuLySo(elementPTKT.eachText().get(6).toCharArray());
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							VonHoa = (float)XuLyData.XuLySo(elementPTKT.eachText().get(5).toCharArray());
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						try {
							DuBan = (float)XuLyData.XuLySo(elementPTKT.eachText().get(7).toCharArray());
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							Beta = (float)XuLyData.XuLySo(elementPTKT.eachText().get(kichthuoc-5).toCharArray());
							EPS = (float)XuLyData.XuLySo(elementPTKT.eachText().get(kichthuoc-4).toCharArray());
							pWe = (float)XuLyData.XuLySo(elementPTKT.eachText().get(kichthuoc-3).toCharArray());
							FpWe = (float)XuLyData.XuLySo(elementPTKT.eachText().get(kichthuoc-2).toCharArray());
							BVPS = (float)XuLyData.XuLySo(elementPTKT.eachText().get(kichthuoc-1).toCharArray());
							pWb = (float)XuLyData.XuLySo(elementPTKT.eachText().get(kichthuoc).toCharArray());
							dinhgia = (float) (EPS * 15 * 4.4 / 4.67); 
						} catch (Exception e) {
							Beta = 0;
							EPS = 0;
							pWe = 0;
							FpWe = 0;
							BVPS = 0;
							pWb = 0;
						}
						try {
							TenDn = XuLyData.XuLyChu(elementPTKTtendn.eachText().get(0).toCharArray());
						} catch (Exception e) {
							// TODO: handle exception
						}
	 
						
						Elements elementPTKTgia = docPTKT.getElementsByClass("r1");
						float gia = 0;
						gia = (float)XuLyData.XuLySo(elementPTKTgia.eachText().get(0).toCharArray());
						lech = dinhgia/gia;

						String thaydoi = "";
						thaydoi =  XuLyData.XuLyChu(elementPTKTgia.eachText().get(1).toCharArray());
						
						PreparedStatement psInsertMACK = con.prepareStatement(insertMaCK);
						psInsertMACK.setString(1, TenDn);
						psInsertMACK.setFloat(2, gia);
						psInsertMACK.setString(3, thaydoi);
						psInsertMACK.setFloat(4, GiaCN);
						psInsertMACK.setFloat(5, GiaTN);
						psInsertMACK.setFloat(6, pWb);
						psInsertMACK.setFloat(7, dinhgia);
						psInsertMACK.setFloat(8, pWe);
						psInsertMACK.setFloat(9, GiaMC);
						psInsertMACK.setFloat(10, KLGD);
						psInsertMACK.setFloat(11, VonHoa);
						psInsertMACK.setFloat(12, Beta);
						psInsertMACK.setFloat(13, EPS);
						psInsertMACK.setFloat(14, DuMua);
						psInsertMACK.setFloat(15, DuBan);
						psInsertMACK.setFloat(16, FpWe);
						psInsertMACK.setFloat(17, BVPS);
						psInsertMACK.setFloat(18, lech);
						psInsertMACK.setString(19, rs.getString("MACK"));
						psInsertMACK.executeUpdate();
//						
//						
//					
					
					String KhoiNgoai = "https://s.cafef.vn/Lich-su-giao-dich-" + rs.getString("MACK") + "-3.chn#data";
					Document docKhoiNgoai = Jsoup.connect(KhoiNgoai).get();
					Elements elementKhoiNgoai = docKhoiNgoai.getElementsByClass("Item_Price");
					int CONG = 10, them = 3;
					String LinkLichSuGia = "https://s.cafef.vn/Lich-su-giao-dich-" + rs.getString("MACK") + "-1.chn";
					String stringToGetIP = "Item_Price1";
					if (rs.getString("SAN").equals("HSX")) {
						stringToGetIP = "Item_Price10";
						CONG = 11;
						them = 2;
						
					}
					else if (rs.getString("SAN").equals("HNX")) {
						CONG = 9;
						them = 2;
					}
						Document docLichSuGia = Jsoup.connect(LinkLichSuGia).get();
						Elements elementLichSuGiaNgay = docLichSuGia.getElementsByClass("Item_DateItem");
						Elements elementlsgChiSo = docLichSuGia.getElementsByClass(stringToGetIP);
						Elements elementChange = docLichSuGia.getElementsByClass("Item_ChangePrice");
						String insertLSG = "INSERT INTO LICHSUGIA(MACK, NGAY, GIA, THAYDOI, KHOILUONG, KHOINGOAI) VALUES (?, ?, ?, ?, ?, ?)";
						
						float tongd = 0, tonga = 0, tong = 0;		
					
						int j = 0;
						int k = 0;
						for (int i = 0; i < 14; i+=1) {
							System.out.println(i);
						
							PreparedStatement psInsertLSG = con.prepareStatement(insertLSG);
							
							psInsertLSG.setString(1, rs.getString("MACK"));
						
							String date = "";
							try {
								date = XuLyData.XuLyChu(elementLichSuGiaNgay.eachText().get(i).toCharArray());
							} catch (Exception e) {
								// TODO: handle exception
							}
							float gialsg = 0;
							String thaydoilsg = "";
							float khoiluonglsg = 0;
							
							try {
			
								gialsg = (float)XuLyData.XuLySo(elementlsgChiSo.eachText().get(j).toCharArray());
								khoiluonglsg = (float)(XuLyData.XuLySo(elementlsgChiSo.eachText().get(j+them).toCharArray())/100);
								
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							try {
								
								thaydoilsg = XuLyData.XuLyChu(elementChange.eachText().get(i).toCharArray());
							
							} catch (Exception e) {
								// TODO: handle exception
							}
							psInsertLSG.setFloat(3, gialsg);
							psInsertLSG.setString(4, thaydoilsg);
						
							psInsertLSG.setFloat(5, khoiluonglsg);
							
							
							
							tong = (float) XuLyData.XuLySoThayDoi(thaydoilsg.toCharArray());
							
							if (tong < 0) {
								tonga += (-tong);
							}
							else {
								tongd += tong;
							}
				
							
							float khoingoailsg = 0;
							
							try {
								khoingoailsg = XuLyData.XuLySo(elementKhoiNgoai.eachText().get(k).toCharArray());
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							psInsertLSG.setString(2, date);
							psInsertLSG.setFloat(6, khoingoailsg);
							j += CONG;
							k += 9;
							
							System.out.println(khoiluonglsg);
							System.out.println(khoingoailsg);
							System.out.println(date);
							System.out.println(thaydoilsg);
							System.out.println(gialsg);
							psInsertLSG.executeUpdate();
							System.out.println("DDMMMMM");
							
							
							
						}
					System.out.println("===");
					System.out.println(tongd);
					System.out.println(tonga);
					tong = 100 - 100/(tongd/tonga + 1);
					System.out.println(100 - 100/(tongd/tonga + 1));
	
					String insertMaCKrsi = "UPDATE COPHIEU SET RSI = ? WHERE MACK = ?";
					PreparedStatement psInsertMACKrsi = con.prepareStatement(insertMaCKrsi);	
					psInsertMACKrsi.setFloat(1, (float)tong);
					psInsertMACKrsi.setString(2, rs.getString("MACK"));
					psInsertMACKrsi.executeUpdate();

					
					
				}
				System.out.println(hu);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		
		
		
		String layNganhsql = "SELECT LINKNGANH, TENNGANH FROM NGANH";
		PreparedStatement psLayNganh = con.prepareStatement(layNganhsql);
		ResultSet rsNganh = psLayNganh.executeQuery();
		
		
		hu = 0;
		while (rsNganh.next()) {

			hu += 1;
			try {
				String linkNganh = rsNganh.getString("LINKNGANH");
				Document docNganh = Jsoup.connect(linkNganh).get();
				Elements elementChiSoNganh = docNganh.getElementsByClass("pull-right");
				Elements elementDiemNganh = docNganh.getElementsByClass("r1");
				String updateNganh = "UPDATE NGANH SET CHISO = ?, BIENDONG = ?, KHOILUONG = ?, GIATRI = ?, MUARONG = ? WHERE TENNGANH = ?";
				PreparedStatement psUpdateNganh = con.prepareStatement(updateNganh);
				float chisoNgang = 0, khoiluongNganh = 0, giaTriNganh = 0, muaRongNganh = 0, banRongNganh = 0;
				String biendongNganh = "";
				try {
					chisoNgang = XuLyData.XuLySo(elementDiemNganh.eachText().get(0).toCharArray());
					khoiluongNganh =  XuLyData.XuLySo(elementChiSoNganh.eachText().get(0).toCharArray());
					giaTriNganh = XuLyData.XuLySo(elementChiSoNganh.eachText().get(1).toCharArray());
					muaRongNganh =  XuLyData.XuLySo(elementChiSoNganh.eachText().get(2).toCharArray());
					biendongNganh = XuLyData.XuLyChu(elementDiemNganh.eachText().get(1).toCharArray());
					banRongNganh = XuLyData.XuLySo(elementChiSoNganh.eachText().get(3).toCharArray());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				psUpdateNganh.setFloat(1, chisoNgang);
				psUpdateNganh.setString(2, biendongNganh);
				psUpdateNganh.setFloat(3, khoiluongNganh);
				psUpdateNganh.setFloat(4, giaTriNganh);
				psUpdateNganh.setFloat(5, muaRongNganh-banRongNganh);
				psUpdateNganh.setString(6, rsNganh.getString("TENNGANH"));
				psUpdateNganh.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}


			System.out.println(hu);


		
		}
	}

}
