<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.Navaneetha.bean.billuserdao"%>
	<jsp:useBean id="u" class="com.Navaneetha.bean.billuser"></jsp:useBean>
	<jsp:setProperty property="*" name="u" />


	<%
	int i=billuserdao.save(u);
	if(i>0) {
		response.sendRedirect("PAYadduser-success.jsp");
	} else {
		response.sendRedirect("PAYadduser-error.jsp");
	}
	%>
</body>
</html>