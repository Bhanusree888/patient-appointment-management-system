<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.siri.bean.UserDao,com.siri.bean.User1"%>  
  
<%  
String id=request.getParameter("Pre_id");  
User1 u=UserDao.getRecordById(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="edituser.jsp" method="post">  
<input type="hidden" name="pre_id" value="<%=u.getPre_id() %>"/>  
<table>  
<tr><td>doctor_name:</td><td>  
<input type="text" name="doctor_name" value="<%= u.getDoctor_name()%>"/></td></tr>  
<tr><td>prescription1_type:</td><td>  
<input type="text" name="prescription1_type" value="<%= u.getPrescription1_type()%>"/></td></tr>  
<tr><td>drugdosage:</td><td>  
<input type="text" name="drugdosage" value="<%= u.getDrugdosage()%>"/></td></tr>  
<tr><td>pat_name:</td><td>  
<input type="text" name="pat_name" value="<%= u.getPat_name()%>"/></td></tr>   
 <tr><td>quantity:</td><td>  
<input type="number" name="quantity" value="<%= u.getQuantity()%>"/></td></tr>   
 <tr><td>pres_date:</td><td>  
<input type="date" name="pres_date" value="<%= u.getPres_date()%>"/></td></tr>     
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>
</html>