package org.nitc.Model;

public class CPTheoDoi {
	private String maCP;
	private float giaTD, giaHT, chenhLech;
	
	public CPTheoDoi(String maCP, float giaTD, float giaHT, float chenhLech) {
		super();
		this.maCP = maCP;
		this.giaTD = giaTD;
		this.giaHT = giaHT;
		this.chenhLech = chenhLech;
	}
	public String getMaCP() {
		return maCP;
	}
	public float getGiaTD() {
		return giaTD;
	}
	public float getGiaHT() {
		return giaHT;
	}
	public float getChenhLech() {
		return chenhLech;
	}
	
}
