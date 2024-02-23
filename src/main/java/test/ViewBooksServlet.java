package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view2")
public class ViewBooksServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
 ServletException,IOException{
	 HttpSession hs=req.getSession(false);
	 if(hs==null) {
		 req.setAttribute("msg", "Session expired...<br>");
		 req.getRequestDispatcher("Home.jsp").forward(req, res);
	 }else {
		 ArrayList<BookBean>al=new ViewAllBooksDAO().retrieve();
		 hs.setAttribute("alist", al);
		 req.getRequestDispatcher("ViewBooks.jsp").forward(req, res);
	 }
 }
}
