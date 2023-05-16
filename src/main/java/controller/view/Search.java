package controller.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ProductDao;
@WebServlet("/search")
public class Search extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query=req.getParameter("search");
		System.out.println(query);
		HttpSession session=req.getSession();
		String email =(String) session.getAttribute("loggedInId");
		ArrayList<Product> productList=new ProductDao().getProductRecordByQuery(query);
		session.setAttribute("productList", productList);
		resp.sendRedirect("./view/Products.jsp");
	}
}
