package com.siri.bean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.siri.bean.User1;
public class UserDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","siri","ps");
			System.out.println("Connection created");
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Connection not created");
		}
		return con;
	}
	public static int save(User1 u) {
		int status=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into prescription1(doctor_name,prescription1_type,drugdosage,pat_name,quantity,pres_date) values(?,?,?,?,?,?)");
			ps.setString(1,u.getDoctor_name());
			ps.setString(2,u.getPrescription1_type());
			ps.setString(3,u.getDrugdosage());
			ps.setString(4,u.getPat_name());
			ps.setInt(5,u.getQuantity());
			ps.setString(6,u.getPres_date());
			status =ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;	
	}
	public static List<User1> getAllRecords(){  
	    List<User1> list=new ArrayList<User1>();   
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from prescription1");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            User1 u=new User1();  
	            u.setPre_id(rs.getInt("Pre_id"));  
	            u.setDoctor_name(rs.getString("Doctor_name"));  
	            u.setPrescription1_type(rs.getString("Prescription1_type"));  
	            u.setDrugdosage(rs.getString("Drugdosage"));  
	            u.setPat_name(rs.getString("Pat_name"));  
	            u.setQuantity(rs.getInt("Quantity")); 
	           u.setPres_date(rs.getString("Pres_date"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static int update(User1 u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update prescription1 set doctor_name=?,prescription1_type=?,drugdosage=?,pat_name=?,quantity=?,pres_date=? where pre_id=?");  
	        ps.setString(1,u.getDoctor_name());  
	        ps.setString(2,u.getPrescription1_type());  
	        ps.setString(3,u.getDrugdosage());  
	        ps.setString(4,u.getPat_name());  
	        ps.setInt(5,u.getQuantity());  
	        ps.setString(6,u.getPres_date()); 
	        ps.setInt(7,u.getPre_id());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static User1 getRecordById(int id) {
		User1 u=null;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from prescription1 where pre_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				u=new User1();
				u.setPre_id(rs.getInt("pre_id"));
				u.setDoctor_name(rs.getString("doctor_name"));
				u.setPrescription1_type(rs.getString("prescription1_type"));
				u.setDrugdosage(rs.getString("drugdosage"));
				u.setPat_name(rs.getString("pat_name"));
				u.setQuantity(rs.getInt("quantity"));
				u.setPres_date(rs.getString("pres_date"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
	public static int delete(User1 u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from prescription1 where pre_id=?");  
	        ps.setInt(1,u.getPre_id());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println("Fail");
	    }  
	    return status;  
	}  
}
