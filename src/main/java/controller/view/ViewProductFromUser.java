package controller.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDao;
@WebServlet("/products")
public class ViewProductFromUser extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao pdao=new ProductDao();
		ArrayList<Product> productList = pdao.fetchProducts();
		req.setAttribute("productList",productList);
		RequestDispatcher rd= req.getRequestDispatcher("view/Products.jsp");
		rd.forward(req, resp);
	}
}
