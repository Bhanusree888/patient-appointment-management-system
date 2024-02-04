package com.Navaneetha.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.Navaneetha.bean.billuser;

public class billuserdao {
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

	public static int save(billuser u) {
		int status=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps = con.prepareStatement("insert into generatebill(patient_id,patient_name,medicine_name,doctor_fee) values(?,?,?,?)");
			ps.setInt(1, u.getpatient_id());
			ps.setString(2, u.getpatient_name());
			ps.setString(3, u.getmedicine_name());
			ps.setInt(4, u.getdoctor_fee());


			status=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(billuser u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps=con.prepareStatement(
		"update generatebill set patient_id=?,patient_name=?,medicine_name=?,doctor_fee=? where bill_id=?");
			ps.setInt(1, u.getpatient_id());
			ps.setString(2, u.getpatient_name());
			ps.setString(3, u.getmedicine_name());
			ps.setInt(4, u.getdoctor_fee());
			ps.setInt(5, u.getbill_id());
			
			status=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(billuser u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("DELETE FROM generatebill WHERE bill_id=?");  
	        ps.setInt(1,u.getbill_id());  
	        status=ps.executeUpdate();  
	        System.out.println("pass");
	    }catch(Exception e){System.out.println("Fail");}  
	  
	    return status;  
	}    

	public static List<billuser> getAllRecords() {
		List<billuser> list = new ArrayList<billuser>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from generatebill");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				billuser u = new billuser();
				u.setbill_id(rs.getInt("bill_id"));
			    u.setpatient_id(rs.getInt("patient_id"));
			    u.setpatient_name(rs.getString("patient_name"));
			    u.setmedicine_name(rs.getString("medicine_name"));
			    u.setdoctor_fee(rs.getInt("doctor_fee"));
				
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static billuser getRecordById(int id) {
		billuser u = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from generatebill where bill_id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new billuser();
				u.setbill_id(rs.getInt("bill_id"));
				u.setpatient_id(rs.getInt("patient_id"));
				u.setpatient_name(rs.getString("patient_name"));
				u.setmedicine_name(rs.getString("medicine_name"));
				u.setdoctor_fee(rs.getInt("doctor_fee"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
}
