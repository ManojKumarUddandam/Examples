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
session.invalidate();
out.println("Loggedout successfully...<br>");
%>
<jsp:include page="Home.html"></jsp:include>
</body>
</html>