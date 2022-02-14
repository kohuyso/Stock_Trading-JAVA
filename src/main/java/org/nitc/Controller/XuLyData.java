package org.nitc.Controller;

public class XuLyData {
	public static String XuLyChu (char[] mangChar) {
		String s = "";
		
		for (int i = 0; i < mangChar.length; i+=1) {
			if (mangChar[i] != ',') {
				s += mangChar[i];
			}
		}
		
		return s;
	}
	
	public static float XuLySo (char[] mangChar) {
		String s = "";
		
		for (int i = 0; i < mangChar.length; i+=1) {
			if (mangChar[i] != ',') {
				s += mangChar[i];
			}
		}
		
		float so = Float.parseFloat(s);
		return so;
	}
	
	
	public static float XuLySoThayDoi (char[] mangChar) {
		String s = "";
		
		for (int i = 0; i < mangChar.length; i+=1) {
			if (mangChar[i] == ' ') {
				break;
			}
			if (mangChar[i] != ',') {
				s += mangChar[i];
			}
		}
		
		float so = Float.parseFloat(s);
		return so;
	}
	
	public static String XuLyChuDuDoan (char[] mangChar) {
		String s = "";
		
		for (int i = 0; i < mangChar.length; i+=1) {
			if (mangChar[i] != '[' || mangChar[i] != ']') {
				s += mangChar[i];
			}
		}
		
		return s;
	}
	
}
