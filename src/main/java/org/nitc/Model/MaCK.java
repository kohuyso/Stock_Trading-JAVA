package org.nitc.Model;

public class MaCK {
    protected String MACP;
	private String TENDN;
	private String MANGANH;
    protected float GIAHT;
	private String PTTHAYDOI;
	private float GIATC;
	private float GIAMAX;
	private float GIAMIN;
	private float TBPHIEN;
	private float KHOINGOAI;
    String LINKDATA, LINKANH, LINKCHART, LINKPTKT, SAN;
    private float PwE, PwB, BVPS, FPwE, BETA, RSI, COTUC, DINHGIA;
    private float lechDinhGia, volume;
    
    
    
    
    

	
	public MaCK(float rSI, String mACP, String mANGANH, float gIAHT, float dINHGIA) {
		
		MACP = mACP;
		MANGANH = mANGANH;
		GIAHT = gIAHT;
		RSI = rSI;
		DINHGIA = dINHGIA;
	}

	public MaCK(String PTTHAYDOI, float gIAHT, float kHOINGOAI, float volume) {
		super();
		this.PTTHAYDOI = PTTHAYDOI;
		GIAHT = gIAHT;
		KHOINGOAI = kHOINGOAI;
		this.volume = volume;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getLechDinhGia() {
		return lechDinhGia;
	}

	public void setLechDinhGia(float lechDinhGia) {
		this.lechDinhGia = lechDinhGia;
	}

	
	
	public MaCK (String mACP, float dINHGIA, float gIAHT, float rSI, String mANGANH) {
		
		MACP = mACP;
		MANGANH = mANGANH;
		GIAHT = gIAHT;
		RSI = rSI;
		DINHGIA = dINHGIA;
	}
	

	public MaCK (String mACP, String mANGANH, float gIAHT, float dINHGIA, float lechDinhGia) {
	
		MACP = mACP;
		MANGANH = mANGANH;
		GIAHT = gIAHT;
		DINHGIA = dINHGIA;
		this.lechDinhGia = lechDinhGia;
	}
	
	



public MaCK(String mACP, String mANGANH, float gIAHT, float pwE, float pwB, float BETA, float BVPS, float FPwE) {
		super();
		MACP = mACP;
		MANGANH = mANGANH;
		GIAHT = gIAHT;
		PwE = pwE;
		PwB = pwB;
		this.BETA = BETA;
		this.BVPS = BVPS;
		this.FPwE = FPwE;
		
	}

//	public MaCK(String mACP, String tENDN, String mANGANH, float gIAHT, float pTTHAYDOI, float gIATC, float gIAMAX,
//			float gIAMIN, float tBPHIEN, float kHOINGOAI, String lINKDATA, String lINKANH, String lINKCHART,
//			String lINKPTKT, String sAN, float pwE, float pwB, float rOA, float rOE, float rOS, float rSI, float cOTUC,
//			float dINHGIA) {
//	
//		MACP = mACP;
//		TENDN = tENDN;
//		MANGANH = mANGANH;
//		GIAHT = gIAHT;
//		PTTHAYDOI = pTTHAYDOI;
//		GIATC = gIATC;
//		GIAMAX = gIAMAX;
//		GIAMIN = gIAMIN;
//		TBPHIEN = tBPHIEN;
//		KHOINGOAI = kHOINGOAI;
//		LINKDATA = lINKDATA;
//		LINKANH = lINKANH;
//		LINKCHART = lINKCHART;
//		LINKPTKT = lINKPTKT;
//		SAN = sAN;
//		PwE = pwE;
//		PwB = pwB;
//		ROA = rOA;
//		ROE = rOE;
//		ROS = rOS;
//		RSI = rSI;
//		COTUC = cOTUC;
//		DINHGIA = dINHGIA;
//	}
	


	public String getMACP() {
		return MACP;
	}
	public void setMACP(String mACP) {
		MACP = mACP;
	}
	public String getTENDN() {
		return TENDN;
	}
	public void setTENDN(String tENDN) {
		TENDN = tENDN;
	}
	public String getMANGANH() {
		return MANGANH;
	}
	public void setMANGANH(String mANGANH) {
		MANGANH = mANGANH;
	}
	public float getGIAHT() {
		return GIAHT;
	}
	public void setGIAHT(float gIAHT) {
		GIAHT = gIAHT;
	}
	public String getPTTHAYDOI() {
		return PTTHAYDOI;
	}
	public void setPTTHAYDOI(String pTTHAYDOI) {
		PTTHAYDOI = pTTHAYDOI;
	}
	public float getGIATC() {
		return GIATC;
	}
	public void setGIATC(float gIATC) {
		GIATC = gIATC;
	}
	public float getGIAMAX() {
		return GIAMAX;
	}
	public void setGIAMAX(float gIAMAX) {
		GIAMAX = gIAMAX;
	}
	public float getGIAMIN() {
		return GIAMIN;
	}
	public void setGIAMIN(float gIAMIN) {
		GIAMIN = gIAMIN;
	}
	public float getTBPHIEN() {
		return TBPHIEN;
	}
	public void setTBPHIEN(float tBPHIEN) {
		TBPHIEN = tBPHIEN;
	}
	public float getKHOINGOAI() {
		return KHOINGOAI;
	}
	public void setKHOINGOAI(float kHOINGOAI) {
		KHOINGOAI = kHOINGOAI;
	}
	public String getLINKDATA() {
		return LINKDATA;
	}
	public void setLINKDATA(String lINKDATA) {
		LINKDATA = lINKDATA;
	}
	public String getLINKANH() {
		return LINKANH;
	}
	public void setLINKANH(String lINKANH) {
		LINKANH = lINKANH;
	}
	public String getLINKCHART() {
		return LINKCHART;
	}
	public void setLINKCHART(String lINKCHART) {
		LINKCHART = lINKCHART;
	}
	public String getLINKPTKT() {
		return LINKPTKT;
	}
	public void setLINKPTKT(String lINKPTKT) {
		LINKPTKT = lINKPTKT;
	}
	public String getSAN() {
		return SAN;
	}
	public void setSAN(String sAN) {
		SAN = sAN;
	}
	public float getPwE() {
		return PwE;
	}
	public void setPwE(float pwE) {
		PwE = pwE;
	}
	public float getPwB() {
		return PwB;
	}
	public void setPwB(float pwB) {
		PwB = pwB;
	}
	public float getBETA() {
		return BETA;
	}
	public void setBETA(float BETA) {
		this.BETA = BETA;
	}
	public float getBVPS() {
		return BVPS;
	}
	public void setROE(float BVPS) {
		this.BVPS = BVPS;
	}
	public float getFPwE() {
		return FPwE;
	}
	public void setFPwE(float FPwE) {
		this.FPwE = FPwE;
	}
	public float getRSI() {
		return RSI;
	}
	public void setRSI(float rSI) {
		RSI = rSI;
	}
	public float getCOTUC() {
		return COTUC;
	}
	public void setCOTUC(float cOTUC) {
		COTUC = cOTUC;
	}
	public float getDINHGIA() {
		return DINHGIA;
	}
	public void setDINHGIA(float dINHGIA) {
		DINHGIA = dINHGIA;
	}
    
    
}
