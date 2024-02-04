package com.Navaneetha.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.Navaneetha.bean.*;

public class appUserDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println("Connection Created");
		} catch (Exception e) {
			System.out.println("Connection Not Created");
		}
		return con;
	}

	public static int save(appuser u) {
		int status=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps = con.prepareStatement("insert into appointment(appointment_type,appointment_date,appointment_time) values(?,?,?)");
			ps.setString(1, u.getappointment_type());
			ps.setString(2, u.getappointment_date());
			ps.setString(3, u.getappointment_time());

			status=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(appuser u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps=con.prepareStatement(
		"update appointment set appointment_type=?,appointment_date=?,appointment_time=? where appointment_id=?");
			ps.setString(1, u.getappointment_type());
			ps.setString(2, u.getappointment_date());
			ps.setString(3, u.getappointment_time());
			ps.setInt(4, u.getappointment_id());
			
			status=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(appuser u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("DELETE FROM appointment WHERE appointment_id=?");  
	        ps.setInt(1,u.getappointment_id());  
	        status=ps.executeUpdate();  
	        System.out.println("pass");
	    }catch(Exception e){System.out.println("Fail");}  
	  
	    return status;  
	}    

	public static List<appuser> getAllRecords() {
		List<appuser> list = new ArrayList<appuser>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from appointment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				appuser u = new appuser();
				u.setappointment_id(rs.getInt("appointment_id"));
			    u.setappointment_type(rs.getString("appointment_type"));
			    u.setappointment_date(rs.getString("appointment_date"));
			    u.setappointment_time(rs.getString("appointment_time"));
				
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static appuser getRecordById(int id) {
		appuser u = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from appointment where appointment_id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new appuser();
				u.setappointment_id(rs.getInt("appointment_id"));
				u.setappointment_type(rs.getString("appointment_type"));
				u.setappointment_date(rs.getString("appointment_date"));
				u.setappointment_time(rs.getString("appointment_time"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
}
