<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form doctor</title>  
</head>  
<body>  
<%@page import="com.santhosh.bean.DoctorDao,com.santhosh.bean.Doctor"%>  
  
<%  
String id=request.getParameter("d_Id");  
Doctor u=DoctorDao.getRecordById(Integer.parseInt(id));  
%>    
<h1>Doctor Edit Form </h1>  
<form action="editdoctor.jsp" method="post">  
<input type="hidden" name="d_Id" value="<%=u.getd_Id()%>"/>  
<table>  
<tr><td>Name</td><td>  
<input type="text" name="d_Name" value="<%= u.getd_Name()%>"/></td></tr>  
<tr><td>Role</td><td>  
<input type="text" name="d_Role" value="<%= u.getd_Role()%>"/></td></tr>  
<tr><td>Mobile no</td><td>  
<input type="text" name="d_Mblno" value="<%= u.getd_Mblno()%>"/></td></tr>  
<tr><td>Email</td>
<td><input type="text" name="d_Email" value="<%= u.getd_Email()%>"/></td></tr>  
 <tr><td>Address</td>
 <td><textarea name="d_Address"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Doctor"/></td></tr>  
</table>  
</form>   
</body>  
</html>  