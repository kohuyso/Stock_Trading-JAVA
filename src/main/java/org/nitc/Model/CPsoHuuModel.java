package org.nitc.Model;

public class CPsoHuuModel {
	private String tenTK, maCK;
	private float gia, khoiLuong, giaMua, lai, ptLai, DuocGD;
	public CPsoHuuModel(String maCK, float gia, float khoiLuong, float giaMua, float lai) {
	
		this.maCK = maCK;
		this.gia = gia;
		this.khoiLuong = khoiLuong;
		this.giaMua = giaMua;
		this.lai = lai;

	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMaCK() {
		return maCK;
	}
	public void setMaCK(String maCK) {
		this.maCK = maCK;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public float getKhoiLuong() {
		return khoiLuong;
	}
	public void setKhoiLuong(float khoiLuong) {
		this.khoiLuong = khoiLuong;
	}
	public float getGiaMua() {
		return giaMua;
	}
	public void setGiaMua(float giaMua) {
		this.giaMua = giaMua;
	}
	public float getLai() {
		return lai;
	}
	public void setLai(float lai) {
		this.lai = lai;
	}
	public float getPtLai() {
		return ptLai;
	}
	public void setPtLai(float ptLai) {
		this.ptLai = ptLai;
	}
	public float getDuocGD() {
		return DuocGD;
	}
	public void setDuocGD(float duocGD) {
		DuocGD = duocGD;
	}
	
	
	
	
}
