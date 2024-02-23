<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,test.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Information</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
        }
        .container {
            min-height: 100%;
            display: flex;
            flex-direction: column;
        }
        .content {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    ArrayList<BookBean> al = (ArrayList<BookBean>) session.getAttribute("alist");
    out.println("Page belongs to: " + ab.getfName() + "<br>");
    if (al.size() == 0) {
        out.println("Books not available...<br>");
    } else {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <%
            Iterator<BookBean> it = al.iterator();
            while (it.hasNext()) {
                BookBean bb = it.next();
            %>
            <tr>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrice() %></td>
                <td><%= bb.getQty() %></td>
                <td><a href='edit?bcode=<%= bb.getCode() %>'>Edit</a></td>
                <td><a href='delete?bcode=<%= bb.getCode() %>'>Delete</a></td>
            </tr>
            <%
                }
            }
            %>
        </tbody>
    </table>
    <a href="Logout">Logout</a>
</body>
</html>