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
  
<h1>Edit Form</h1>  
<form action="APPedituser.jsp" method="post">  
<input type="hidden" name="appointment_id" value="<%=u.getappointment_id() %>"/>  
<table>  
<tr><td>Type</td><td>  
<input type="text" name="appointment_type" value="<%= u.getappointment_type()%>"/></td></tr>  
<tr><td>Type</td><td>  
<input type="date" name="appointment_date" value="<%= u.getappointment_date()%>"/></td></tr>
<tr><td>Type</td><td>  
<input type="time" name="appointment_time" value="<%= u.getappointment_time()%>"/></td></tr>    
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  