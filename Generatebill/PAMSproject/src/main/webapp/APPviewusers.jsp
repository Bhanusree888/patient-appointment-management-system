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
		import="com.Navaneetha.bean.UserDao,com.Navaneetha.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Users List</h1>

	<%
	List<User> list = UserDao.getAllRecords();
	request.setAttribute("list", list);
	%>
	<form action="searchID.jsp">
	<input type="text" name="appointment_id" placeholder="Search">
	
	<tr><td>Appointment:</td><td>  
<select name="appointment" style="width:155px">  
<option>Id</option>  
<option>Type</option>  
<option>Date</option>  
<option>time</option>
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Search"/></td></tr>  
</table>  
</form>  	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Type</th>
			<th>Date</th>
			<th>Time</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getappointment_id()}</td>
				<td>${u.getappointment_type()}</td>
				<td>${u.getappointment_date()}</td>
				<td>${u.getappointment_time()}</td>
				<td><a href="APPeditform.jsp?appointment_id=${u.getappointment_id()}">Edit</a></td>
				<td><a href="APPdeleteuser.jsp?appointment_id=${u.getappointment_id()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="APPadduserform.jsp">Add New User</a>
	</body>
</html>