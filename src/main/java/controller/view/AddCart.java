package controller.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;
import model.ProductDao;
@WebServlet("/cart")
public class AddCart extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("loggedInId");
		if (email!=null) {
			System.out.println(id+"fk");
			System.out.println(email);
			System.out.println(id);
			Product pr= new ProductDao().getProductRecordById(id);
			new ProductDao().addProductToCart(pr, email);
			ArrayList<Cart> cartlist =new ProductDao().fetchCartRecordById(email);
			session.setAttribute("cartlist", cartlist);
			session.setAttribute("product", pr);
			resp.sendRedirect("view/Cart.jsp");
			resp.getWriter().println("<a href=\"/logout\">Logout</a>");
		}else {
			resp.sendRedirect("view/Login.jsp");
		}
		
	}
}
