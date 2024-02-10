package com.santhosh.bean;
import java.sql.*; 
import java.io.*;
import java.util.ArrayList;  
import java.util.List;  
import com.santhosh.bean.Doctor;  
public class DoctorDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			System.out.println("Connection is created");
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Connection NOT created");
		}
		return con;
	}
	public static int save(Doctor u) {
		int status=0;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into doctor(d_Name,d_Spec,d_Qual,d_Mblno,d_Email,d_Exp,d_Address) values(?,?,?,?,?,?,?)");
			ps.setString(1, u.getd_Name());
			ps.setString(2, u.getd_Spec());
			ps.setString(3, u.getd_Qual());
			ps.setString(4, u.getd_Mblno());
			ps.setString(5, u.getd_Email());
			ps.setInt(6, u.getd_Exp());
			ps.setString(7, u.getd_Address());
			status=ps.executeUpdate();
			System.out.println("Connection is closed");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Doctor> getAllRecords(){  
		    List<Doctor> list=new ArrayList<Doctor>();   
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from doctor");  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            Doctor u=new Doctor();  
		            u.setd_Id(rs.getInt("d_Id"));  
		            u.setd_Name(rs.getString("d_Name"));  
		            u.setd_Spec(rs.getString("d_Spec")); 
		            u.setd_Qual(rs.getString("d_Qual")); 
		            u.setd_Mblno(rs.getString("d_Mblno"));  
		            u.setd_Email(rs.getString("d_Email"));
		            u.setd_Exp(rs.getInt("d_Exp"));
		            u.setd_Address(rs.getString("d_Address"));  
		            list.add(u);  
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return list;  
		}  
	public static int delete(Doctor u){  
		    int status=0;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("delete from doctor where d_Id=?");  
		        ps.setInt(1,u.getd_Id());  
		        status=ps.executeUpdate();  
		    }catch(Exception e){System.out.println(e);}  
		  
		    return status;  
		}  
	public static int update(Doctor u){  
		    int status=0;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement(  
		"update doctor set d_Name=?,d_Spec=?,d_Qual=?,d_Mblno=?,d_Email=?,d_Exp=?,d_Address=? where d_Id=?");  
		        ps.setString(1, u.getd_Name());
				ps.setString(2, u.getd_Spec());
				ps.setString(3, u.getd_Qual());
				ps.setString(4, u.getd_Mblno());
				ps.setString(5, u.getd_Email());
				ps.setInt(6, u.getd_Exp());
				ps.setString(7, u.getd_Address());
				ps.setInt(8, u.getd_Id());
				status=ps.executeUpdate();
		    }catch(Exception e){System.out.println(e);}  
		    return status;  
		}  
	public static Doctor getRecordById(int id){  
		    Doctor u=null;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from doctor where d_Id=?");  
		        ps.setInt(1,id);  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            u=new Doctor();  
		            u.setd_Id(rs.getInt("d_Id"));  
		            u.setd_Name(rs.getString("d_Name"));  
		            u.setd_Spec(rs.getString("d_Spec"));  
		            u.setd_Qual(rs.getString("d_Qual"));  
		            u.setd_Mblno(rs.getString("d_Mblno"));  
		            u.setd_Email(rs.getString("d_Email"));
		            u.setd_Exp(rs.getInt("d_Exp"));
		            u.setd_Address(rs.getString("d_Address")); 
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return u;  
	}  
	public static Doctor getRecordByName(String name){  
	    Doctor u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from doctor where d_Name=?");  
	        ps.setString(1,name);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Doctor();  
	            u.setd_Id(rs.getInt("d_Id"));  
	            u.setd_Name(rs.getString("d_Name"));  
	            u.setd_Spec(rs.getString("d_Spec"));  
	            u.setd_Qual(rs.getString("d_Qual"));  
	            u.setd_Mblno(rs.getString("d_Mblno"));  
	            u.setd_Email(rs.getString("d_Email"));
	            u.setd_Exp(rs.getInt("d_Exp"));
	            u.setd_Address(rs.getString("d_Address")); 
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u; 
	}
}

