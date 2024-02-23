package test;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewAllBooksServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
 ServletException,IOException{	
	 HttpSession hs=req.getSession(false);
	 if(hs==null) {
		 req.setAttribute("msg", "Session expired...<br>");
		 req.getRequestDispatcher("Home.jsp").forward(req, res);
	 }else {
		 ArrayList<BookBean>al=new ViewAllBooksDAO().retrieve();
		 hs.setAttribute("alist", al);
		 req.getRequestDispatcher("ViewAllBooks.jsp").forward(req, res);
	 }
 }
}
