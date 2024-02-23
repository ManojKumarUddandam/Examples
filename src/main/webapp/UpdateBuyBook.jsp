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
out.println("page belongs to:"+ub.getfName()+"<br>");
Float Price=(Float)request.getAttribute("updatedPrice");
out.println(Price);
String msg=(String)request.getAttribute("msg");
out.println(msg);
%>
</body>
</html>