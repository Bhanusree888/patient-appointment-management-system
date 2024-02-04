<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search doctor</title>  
</head>  
<body>  
<%@page import="com.santhosh.bean.DoctorDao,com.santhosh.bean.Doctor"%>  
  
<%  
String id=request.getParameter("d_Name");  
Doctor u=DoctorDao.getRecordByName(id);  
%>    
<h1><%= u.getd_Name()%> </h1> 
<table>
<tr>
<td>Doctor ID</td><td>:&nbsp;<%=u.getd_Id()%></td>
</tr>
<tr>
<td>Doctor Role</td><td>:&nbsp;<%= u.getd_Role()%></td>
</tr>
<tr>
<td>Email</td><td>:&nbsp;<%= u.getd_Email()%></td>
</tr>
<tr>
<td>Mobile No</td><td>:&nbsp;<%= u.getd_Mblno()%></td>
</tr>
</table> 
 
</body>  
</html>  