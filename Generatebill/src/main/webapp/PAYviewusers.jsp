<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page
		import="com.Navaneetha.bean.billuserdao,com.Navaneetha.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<h1>Users List</h1>

	<%
	List<User> list = billuserdao.getAllRecords();
	request.setAttribute("list", list);
	%>
	<form action="Search.jsp">
	<input type="text" name="bill_id" placeholder="Search">
	
	<tr><td>Generatebill:</td><td>  
<select name="Generatebill" style="width:155px">  
<option>Id</option>
<option>Id</option>  
<option>Name</option>  
<option>Name</option>  
<option>Fee</option>
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Search"/></td></tr>  
</table>  
</form>  
	<table border="1" width="90%">
		<tr>
			<th>Bill_Id</th>
			<th>Patient_Id</th>
			<th>Patient_Name</th>
			<th>Medicine_Name</th>
			<th>doctor_Fee</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getbill_id()}</td>
				<td>${u.getpatient_id()}</td>
				<td>${u.getpatient_name()}</td>
				<td>${u.getmedicine_name()}</td>
				<td>${u.getdoctor_fee()}</td>
				
				<td><a href="PAYeditform.jsp?bill_id=${u.getbill_id()}">Edit</a></td>
				<td><a href="PAYdeleteuser.jsp?bill_id=${u.getbill_id()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="payadduserform.jsp">Add New User</a>
</body>
</html>