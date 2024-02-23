package test;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/updatedetails")
public class UpdateBuyBookServlet extends HttpServlet{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
 ServletException,IOException{
	HttpSession hs=req.getSession(false);
	if(hs==null) {
		req.setAttribute("msg", "Session Expired");
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
		   int p=Integer.parseInt(req.getParameter("bqty"));
		   bb.setQty(bb.getQty()-p);
		   int k= new UpdateBookDetailsDAO().update(bb);
		   if(k>0) {
			   float updatedPrice = bb.getPrice() * p; // Calculate updated price
               bb.setPrice(updatedPrice); // Set the updated price in BookBean
               req.setAttribute("updatedPrice", updatedPrice);
			   req.setAttribute("msg","Book purchased successfully...<br>");
			   req.getRequestDispatcher("UpdateBuyBook.jsp").forward(req, res);
		   }
     }
  }
}
