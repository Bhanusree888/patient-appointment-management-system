<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.Navaneetha.bean.UserDao1,com.Navaneetha.bean.User"%>  
  
<%  
String id=request.getParameter("bill_id");  
User u=UserDao1.getRecordById(Integer.parseInt(id));  
%>  
  
<h1><%= u.getpatient_id()%></h1>  
 <table>
 <tr>
 <td>Bill_id</td><td>:&nbsp;<%=u.getbill_id() %></td></tr>
 <tr><td>Patient_id</td><td>:&nbsp;<%= u.getpatient_id()%></td></tr>
 <tr><td>Patient_name</td><td>:&nbsp;<%= u.getpatient_name()%></td></tr>
 <tr><td>Medicine_name</td><td>:&nbsp;<%= u.getmedicine_name()%></td></tr>
 <tr><td>Doctor_fee</td><td>:&nbsp;<%= u.getdoctor_fee()%></td></tr>
 </table> 
</body>  
</html>