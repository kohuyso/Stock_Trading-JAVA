package org.nitc.Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDataBase {
//	public static void main(String[] args) {
//		System.out.println("ds");
//		try {
//			System.out.println(openConnection());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static Connection openConnection() throws Exception {
		Connection con = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=STOCK_JAVA;user=sa;password=aaa");
		
		return con;
		
	}
}
