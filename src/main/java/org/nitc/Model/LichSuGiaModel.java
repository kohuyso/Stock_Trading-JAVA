package org.nitc.Model;

public class LichSuGiaModel extends MaCK{
	
	private String date;

	public LichSuGiaModel(String PTTHAYDOI, float gIAHT, float kHOINGOAI, float volume, String date) {
		super(PTTHAYDOI, gIAHT, kHOINGOAI, volume);
		this.date = date;
	}




	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

	
	
	
}
