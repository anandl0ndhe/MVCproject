<%@page import="in.anand.user.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
	User user = (User)session.getAttribute("session_user");
	%>
<center>
<h1>Welcome </h1><br><br>
<h3>Name : <%=user.getName() %> </h3><br><br>
<h3>E-mail : <%=user.getEmail() %> </h3><br><br>
<h3>City : <%=user.getCity() %> </h3><br><br>

<a href="logout">Logout</a>

</center>
</body>
</html>