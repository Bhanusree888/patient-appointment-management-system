package com.Navaneetha.bean;

public class appuser {
	private String appointment_type;
	private String appointment_date;
	private int appointment_id;
	private String appointment_time;
	
	public String getappointment_type() {
		return appointment_type;
	}
	public String getappointment_date() {
		return appointment_date;
	}
	public int getappointment_id() {
		return appointment_id;
	}
	public String getappointment_time() {
		return appointment_time;
	}


	public void setappointment_type(String name) {
		this.appointment_type=name;
	}
	public void setappointment_date(String date) {
		this.appointment_date=date;
	}
	public void setappointment_id(int id) {
		this.appointment_id=id;
	}
	public void setappointment_time(String time) {
		this.appointment_time=time;
	}	
}

