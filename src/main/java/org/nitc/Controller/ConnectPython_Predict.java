package org.nitc.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.w3c.dom.Text;

public class ConnectPython_Predict {
	public static String LayOutPut (String link, String ma) {
		String line = null;
		String lines = null;
		try {
			ProcessBuilder builder = new ProcessBuilder("python", link, ma);
			Process process = builder.start();
			
			BufferedReader readerIn = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader readerEr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			while(readerIn.readLine() != null) {
				line = readerIn.readLine();
				//System.out.println(line);
			}
			
			while((lines = readerEr.readLine()) != null) {
				//System.out.println(lines);
			}
			
			String a = XuLyData.XuLyChu(line.toCharArray());
			System.out.println(line);
			

		} catch (Exception e) {
			System.out.println("czx");
		
			
		
	}
		return XuLyData.XuLyChu(line.toCharArray());
	
	
	}
	
	public static void LayRSI (String link) {
		String line = null;
		String lines = null;
		try {
			ProcessBuilder builder = new ProcessBuilder("python", link);
			Process process = builder.start();
			
			BufferedReader readerIn = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader readerEr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			line = readerIn.readLine();
			System.out.println(line);
			float rsi, dotBien, gia;
			int i = 0;
			while((line = readerIn.readLine()) != null) {
				i += 1;
				Connection con = ConnectDataBase.openConnection();
				rsi = XuLyData.XuLySo(line.toCharArray());
				//System.out.println(line);
				if ((line = readerIn.readLine()) != null) {
					dotBien = XuLyData.XuLySo(line.toCharArray());
				}
				else {
					break;
				}
				
				
				if ((line = readerIn.readLine()) != null) {
					gia = XuLyData.XuLySo(line.toCharArray());
				}
				else {
					break;
				}
				
				System.out.println(rsi);
				if (rsi < 36 && dotBien > 95) {
					System.out.println("BUY1");
					String UDdulieu = "BEGIN DECLARE @GIA FLOAT = ?, @TIENCO FLOAT; SELECT @TIENCO = TIEN FROM Trading_BOT IF @TIENCO > @GIA*0.5 BEGIN UPDATE Trading_BOT SET TIEN = TIEN - 0.5 * @GIA, KHOILUONG = KHOILUONG+0.5, TONGTS = TIEN + KHOILUONG*@GIA, LAI = (TONGTS/20000 - 1)*100 INSERT INTO LStrade VALUES ('M', 0.5, @GIA) END END";
					PreparedStatement psUpdateNganh = con.prepareStatement(UDdulieu);
					psUpdateNganh.setFloat(1, gia);
					psUpdateNganh.executeUpdate();
					System.out.println("BUY2");
				}
				else if (dotBien < 93 || rsi > 69) {
					System.out.println("SELL1");
					String UDdulieu = "BEGIN DECLARE @GIA FLOAT = ?, @KHOILUONG FLOAT; SELECT @KHOILUONG = KHOILUONG FROM Trading_BOT IF @KHOILUONG >= 0.5 BEGIN UPDATE  Trading_BOT SET TIEN = TIEN + 0.5 * @GIA, KHOILUONG = KHOILUONG-0.5, TONGTS = TIEN + KHOILUONG*@GIA, LAI = (TONGTS/20000 - 1)*100 INSERT INTO LStrade VALUES ('B', 0.5, @GIA) END END"; 
					PreparedStatement psUpdateNganh = con.prepareStatement(UDdulieu);
					psUpdateNganh.setFloat(1, gia);
					psUpdateNganh.executeUpdate();
					System.out.println("SELL2");
				}
				
				
			}
			
			while((lines = readerEr.readLine()) != null) {
				System.out.println(lines);
			}
			
			

		} catch (Exception e) {
			System.out.println("czx");
		
			
		
	}
		
	
	
	}
}
