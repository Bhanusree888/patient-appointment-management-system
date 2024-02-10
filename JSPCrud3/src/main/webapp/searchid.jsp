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
String id=request.getParameter("pre_id");  
User1 u=UserDao.getRecordById(Integer.parseInt(id));  
%>  
 <h1><%= u.getPre_id()%></h1>   
 <table>
 <tr>
 <td>Pre_id</td><td>:&nbsp;<%=u.getPre_id() %></td></tr>
 <tr><td>prescription1_type</td><td>:&nbsp;<%= u.getPrescription1_type()%></td></tr>
 <tr><td>drugdosage</td><td>:&nbsp;<%= u.getDrugdosage()%></td></tr>
 <tr><td>quantity</td><td>:&nbsp;<%=u.getQuantity() %></td></tr>
 <tr><td>pat_name</td><td>:&nbsp;<%=u.getPat_name() %></td></tr>
 </table> 
</body>
</html>