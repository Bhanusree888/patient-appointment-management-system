package com.Navaneetha.bean;

public class billuser {
	private int bill_id;
	private int patient_id;
	private String patient_name;
	private String medicine_name;
	private int doctor_fee;
	
	public int getbill_id() {
		return bill_id;
	}
	public int getpatient_id() {
		return patient_id;
	}
	public String getpatient_name() {
		return patient_name;
	}
	public String getmedicine_name() {
		return medicine_name;
	}
	public int getdoctor_fee() {
		return doctor_fee;
	}
	public void setbill_id(int id) {
		this.bill_id=id;
	}
		public void setpatient_id(int id) {
			this.patient_id=id;
		}
	public void setpatient_name(String name) {
		this.patient_name=name;
	}
	public void setmedicine_name(String name) {
		this.medicine_name=name;
	}
	public void setdoctor_fee(int id) {
		this.doctor_fee=id;
	}
	
}

