package org.nitc.Model;

public class BOT {
	private String lenh;
	private float khoiLuong, gia;
	public BOT(String lenh, float khoiLuong, float gia) {
		super();
		this.lenh = lenh;
		this.khoiLuong = khoiLuong;
		this.gia = gia;
	}
	public String getLenh() {
		return lenh;
	}
	public void setLenh(String lenh) {
		this.lenh = lenh;
	}
	public float getKhoiLuong() {
		return khoiLuong;
	}
	public void setKhoiLuong(float khoiLuong) {
		this.khoiLuong = khoiLuong;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	
}
