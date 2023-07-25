package com.tjl.bean;

public class Peccant {

	int PNumber;
	String PName;
	String PSNumber;
	String data;
	String PPlace;
	String CSNumber;
	public int getPNumber() {
		return PNumber;
	}
	public void setPNumber(int pNumber) {
		PNumber = pNumber;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public String getPSNumber() {
		return PSNumber;
	}
	public void setPSNumber(String pSNumber) {
		PSNumber = pSNumber;
	}
	public String getdata() {
		return data;
	}
	public void setdata(String data) {
		data = data;
	}
	public String getPPlace() {
		return PPlace;
	}
	public void setPPlace(String pPlace) {
		PPlace = pPlace;
	}
	public String getCSNumber() {
		return CSNumber;
	}
	public void setCSNumber(String cSNumber) {
		CSNumber = cSNumber;
	}
	@Override
	public String toString() {
		return "Peccant [PNumber=" + PNumber + ", PName=" + PName + ", PSNumber=" + PSNumber + ", data=" + data
				+ ", PPlace=" + PPlace + ", CSNumber=" + CSNumber + "]";
	}
	public Peccant(int pNumber, String pName, String pSNumber, String data, String pPlace, String cSNumber) {
		super();
		PNumber = pNumber;
		PName = pName;
		PSNumber = pSNumber;
		data = data;
		PPlace = pPlace;
		CSNumber = cSNumber;
	}
	public Peccant(String pName, String pSNumber, String data, String pPlace, String cSNumber) {
		super();
		PName = pName;
		PSNumber = pSNumber;
		data = data;
		PPlace = pPlace;
		CSNumber = cSNumber;
	}
	public Peccant(int pNumber, String pSNumber, String data, String pPlace, String cSNumber) {
		super();
		PNumber = pNumber;
		PSNumber = pSNumber;
		data = data;
		PPlace = pPlace;
		CSNumber = cSNumber;
	}
	public String toString2() {
		return "违章编号=" + PNumber + ", 违章名=" + PName + ", 违章员工号=" + PSNumber + ", 发生时间=" + data
				+ ", 发生地点=" + PPlace + ", 记录人员员工号=" + CSNumber + ""
						+ "\n";
	}
	
	
	
}
