package org.nitc.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.nitc.Model.TK;
import org.nitc.Controller.*;



public class DangNhap_TK {
	public TK checkLogin(String tenDangNhap, String matKhau) throws Exception{
		String sql = "SELECT TENTK, MK FROM TK WHERE TENTK = ? AND MK = ?";

		try (
				Connection con = ConnectDataBase.openConnection();
				PreparedStatement pstm = con.prepareStatement(sql);
			
				
			) {
			System.out.println(con);
			System.out.println(pstm);
		
			pstm.setString(1, tenDangNhap);
			pstm.setString(2, matKhau);
			try (ResultSet rs = pstm.executeQuery();) {
				if (rs.next()) {
					TK taikhoan = new TK();
					taikhoan.setTenTK("a");
					taikhoan.setMK("a");
					return taikhoan;
				}
			}
			
		}
		
		
		return null;
		
	}
	
	public static void main(String[] args) throws SQLException, Exception {
//		String sql = "SELECT TENTK, MK FROM TK WHERE TENTK = ? AND MK = ?";
//		String tenDangNhap = "a";
//		String matKhau = "b";
//		
//		try (	
//				Connection con = ConnectDataBase.openConnection();
//				
//				PreparedStatement pstm = con.prepareStatement(sql);
//				
//				
//			) {
//			System.out.println(con);
//			System.out.println(pstm);
//			pstm.setString(1, tenDangNhap);
//			pstm.setString(2, matKhau);
//			try (ResultSet rs = pstm.executeQuery();) {
//				if (rs.next()) {
//					TK taikhoan = new TK();
//					taikhoan.setTenTK(tenDangNhap);
//					taikhoan.setMK(matKhau);
//					System.out.println(taikhoan);
//				}
//			}
//		}
		DangNhap_TK dn = new DangNhap_TK();
		TK taikhoan = dn.checkLogin("a", "a");
		
		System.out.println(taikhoan.getTenTK() == "a");
	
	}
}
