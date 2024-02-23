package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyBookServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
 ServletException,IOException{
	 HttpSession hs=req.getSession(false);
	 if(hs==null) {
		 req.setAttribute("msg", "Session expired");
		 req.getRequestDispatcher("Home.jsp").forward(req, res);
	 }
	 else {
		 String bCode=req.getParameter("bcode");
		 ArrayList<BookBean>al=(ArrayList<BookBean>)hs.getAttribute("alist");
		 BookBean bb=null;
		 Iterator<BookBean>it=al.iterator();
		 while(it.hasNext()) {
			 bb=it.next();
			 if(bCode.equals(bb.getCode())) {
				 break;
			 }
		 }
		 req.setAttribute("bbean", bb);
		 req.getRequestDispatcher("BuyBook.jsp").forward(req, res);
	 }
 }
}
