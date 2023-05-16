package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDao;
@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("id"));
		ProductDao pdr =new ProductDao();
		pdr.deleteProduct(productId);
		resp.sendRedirect("view/Admin.jsp");
	}
}
