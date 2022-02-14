package org.nitc.Model;

public class TK {
	private String TenTK, MK;
	private long TongTS, TienMat, TienCP, Lai, PTLai;
	
	public TK(String tenTK, String mK, long tongTS, long tienMat, long tienCP, long lai, long pTLai) {

		TenTK = tenTK;
		MK = mK;
		TongTS = tongTS;
		TienMat = tienMat;
		TienCP = tienCP;
		Lai = lai;
		PTLai = pTLai;
	}

	public TK() {
		// TODO Auto-generated constructor stub
	}

	public String getTenTK() {
		return TenTK;
	}

	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}

	public String getMK() {
		return MK;
	}

	public void setMK(String mK) {
		MK = mK;
	}

	public long getTongTS() {
		return TongTS;
	}

	public void setTongTS(long tongTS) {
		TongTS = tongTS;
	}

	public long getTienMat() {
		return TienMat;
	}

	public void setTienMat(long tienMat) {
		TienMat = tienMat;
	}

	public long getTienCP() {
		return TienCP;
	}

	public void setTienCP(long tienCP) {
		TienCP = tienCP;
	}

	public long getLai() {
		return Lai;
	}

	public void setLai(long lai) {
		Lai = lai;
	}

	public long getPTLai() {
		return PTLai;
	}

	public void setPTLai(long pTLai) {
		PTLai = pTLai;
	}
	
	
	
	
}
