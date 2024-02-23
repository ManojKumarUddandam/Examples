<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
UserBean ub=(UserBean)session.getAttribute("ubean");
out.println("Welcome User:"+ub.getfName()+"<br>");
%>
<a href="view2">ViewAllBookDetails</a>
<a href="Logout">Logout</a>
</body>
</html>