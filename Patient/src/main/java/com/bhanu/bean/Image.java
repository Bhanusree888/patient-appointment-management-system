package com.bhanu.bean;

public class Image {
	import java.sql.*;  
	import java.io.*;  
	public class InsertImage {  
	public static void main(String[] args) {  
	try{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
	              
	PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");  
	ps.setString(1,"sonoo");  
	  
	FileInputStream fin=new FileInputStream("C:\Users\bhanu\OneDrive\Pictures\Camera Roll");  
	ps.setBinaryStream(2,fin,fin.available());  
	int i=ps.executeUpdate();  
	System.out.println(i+" records affected");  
	          
	con.close();  
	}catch (Exception e) {e.printStackTrace();}  
	}  
	} 
}
