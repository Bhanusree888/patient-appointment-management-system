<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.Navaneetha.bean.UserDao1"%>
	<jsp:useBean id="u" class="com.Navaneetha.bean.User"></jsp:useBean>
	<jsp:setProperty property="*" name="u" />


	<%
	int i=UserDao1.save(u);
	if(i>0) {
		response.sendRedirect("PAYadduser-success.jsp");
	} else {
		response.sendRedirect("PAYadduser-error.jsp");
	}
	%>
</body>
</html>