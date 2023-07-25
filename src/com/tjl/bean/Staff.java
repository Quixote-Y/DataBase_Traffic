package com.tjl.bean;

public class Staff {
	
	private String Number;
	private String Name;
	private String Sex;
	private String data;
	
	public String getNumber() {
		return Number;
	}
	
	public void setNumber(String number) {
		Number = number;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getdata() {
		return data;
	}
	public void setdata(String data) {
		this.data = data;
	}
	
	
	public Staff() {
		super();
	}

	public Staff(String name, String sex, String data) {
		super();
		Name = name;
		Sex = sex;
		this.data = data;
	}
	
	public Staff(String number, String name, String sex, String data) {
		super();
		Number = number;
		Name = name;
		Sex = sex;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Staff [Number=" + Number + ", Name=" + Name + ", Sex=" + Sex + ", data=" + data + "]";
	}
	
	

}
