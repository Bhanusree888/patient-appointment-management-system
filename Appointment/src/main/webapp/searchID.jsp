<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.Navaneetha.bean.UserDao,com.Navaneetha.bean.User"%>  
  
<%  
String id=request.getParameter("appointment_id");  
User u=UserDao.getRecordById(Integer.parseInt(id));  
%>  
  
<h1><%= u.getappointment_type()%></h1>  
 <table>
 <tr>
 <td>appointment_id</td><td>:&nbsp;<%=u.getappointment_id() %></td></tr>
 <tr><td>appointment_date</td><td>:&nbsp;<%= u.getappointment_date()%></td></tr>
 <tr><td>appointment_time</td><td>:&nbsp;<%= u.getappointment_time()%></td></tr>
 </table> 
</body>  
</html>