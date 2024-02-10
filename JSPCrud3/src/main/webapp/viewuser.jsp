<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view users</title>
</head>
<body>
	<%@page
import="com.siri.bean.UserDao,com.siri.bean.User1,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>Users List</h1>
	
	<%
	List<User1> list=UserDao.getAllRecords();
	request.setAttribute("list",list);
	%>
	<form action="searchid.jsp">
	<input type="text" name="pre_id" placeholder="Search">
	<tr><td>prescription1:</td><td>  
<select name="prescription1" style="width:155px">  
<option>pre_id</option>  
<option>doctor_name</option>  
<option>prescription1_type</option>  
<option>drugdosage</option>  
<option>pat_name</option>  
<option>quantity</option>
<option>date</option>
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="search"/></td></tr> </form>  
	<table border="1" width="90%">
		<tr>
			<th>pre_id</th>
			<th>doctor_name</th>
			<th>prescription1_type</th>
			<th>drugdosage</th>
			<th>pat_name</th>
			<th> quantity</th>
			<th> pres_date</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getPre_id()}</td>
				<td>${u.getDoctor_name()}</td>
				<td>${u.getPrescription1_type()}</td>
				<td>${u.getDrugdosage()}</td>
				<td>${u.getPat_name()}</td>
				<td>${u.getQuantity()}</td>
				<td>${u.getPres_date()}</td>
				<td><a href="editform.jsp?Pre_id=${u.getPre_id()}">Edit</a></td>
				<td><a href="deleteuser.jsp?Pre_id=${u.getPre_id()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduserform.jsp">Add New User</a>
</body>
</html>