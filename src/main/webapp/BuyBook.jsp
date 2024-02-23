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
BookBean bb=(BookBean)request.getAttribute("bbean");
out.println("Page belongs to:"+ub.getfName()+"<br>");
%>
<form action="updatedetails" method="post">
<input type="hidden" name="bcode" value=<%=bb.getCode()%>>
BookQty:<input type="text" name="bqty" value=<%=bb.getQty() %>><br>
<input type="submit" value="BuyBook">
</body>
</html>