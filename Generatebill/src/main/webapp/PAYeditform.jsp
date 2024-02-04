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
  
<h1>Edit Form</h1>  
<form action="PAYedituser.jsp" method="post">  
<input type="hidden" name="bill_id" value="<%=u.getbill_id() %>"/>  
<table>  
<tr><td>Patient_id</td><td>  
<input type="number" name="patient_id" value="<%= u.getpatient_id()%>"/></td></tr>  
<tr><td>Patient_name</td><td>
<input type="text" name="patient_name" value="<%= u.getpatient_name()%>"/></td></tr>    
 <tr><td>Medicine_name</td><td>
<input type="text" name="medicine_name" value="<%= u.getmedicine_name()%>"/></td></tr>    
 <tr><td>Doctor_fee</td><td>
<input type="number" name="doctor_fee" value="<%= u.getdoctor_fee()%>"/></td></tr>    
   
   
   
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  