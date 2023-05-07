package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Product;
import model.ProductDao;

@WebServlet("/addProduct")
@MultipartConfig
public class AddProduct extends HttpServlet{
  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get form data
        int productID = Integer.parseInt(req.getParameter("pid"));
        String productName = req.getParameter("pname");
        String productDescription = req.getParameter("pdesc");
        String productPrice = req.getParameter("price");
        String productCategory = req.getParameter("pcategory");
        int productRating=Integer.parseInt(req.getParameter("rate"));
        Part productImage = req.getPart("product_image");
        String imageName = "Product"+productID+".png";
        
        Product addProduct = new Product( productID, productName, productDescription,  productPrice, productCategory, productRating, imageName);
        String message=new ProductDao().addProduct(addProduct);
        // Get image data
        
        HttpSession session=req.getSession();
        
       if(message.equals("Succesfully Registered")&& productImage!=null && productImage.getInputStream().available()>0) {
    	   
    	   String imagePath=getServletContext().getInitParameter("productImagePath");
    	   String fullpath= imagePath+imageName;
    	   productImage.write(fullpath);
    	   
       }
       session.setAttribute("registeredmessage", message);
	   resp.sendRedirect("view/AddProduct.jsp");
        
        
       
		
        
	}
}
