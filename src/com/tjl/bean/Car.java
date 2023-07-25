package com.tjl.bean;

public class Car {

	private String Number;
	private int CNumber;
	private int SNumber;
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public int getCNumber() {
		return CNumber;
	}
	public void setCNumber(int cNumber) {
		CNumber = cNumber;
	}
	public int getSNumber() {
		return SNumber;
	}
	public void setSNumber(int sNumber) {
		SNumber = sNumber;
	}
	@Override
	public String toString() {
		return "Car [Number=" + Number + ", CNumber=" + CNumber + ", SNumber=" + SNumber + "]";
	}
	public Car(String number, int cNumber, int sNumber) {
		super();
		Number = number;
		CNumber = cNumber;
		SNumber = sNumber;
	}
	public Car(String number, int cNumber) {
		super();
		Number = number;
		CNumber = cNumber;
	}
	
	
	
}
