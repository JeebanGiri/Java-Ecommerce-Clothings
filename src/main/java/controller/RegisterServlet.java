package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.User;
import model.UserDao;

@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet{
  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get form data
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        Part imagePart = req.getPart("user-image");
        String imageName = "Profile"+name+".png";
        
        User user = new User( name, email, address,  phone, imageName,
   			 password);
        new UserDao().addUser(user);
        // Get image data
        
       
        
        String imagePath="D:\\E-commerce\\AdvanceProgrammingCourseWork\\src\\main\\webapp\\Images\\";
        String fullpath= imagePath+imageName;
        imagePart.write(fullpath);
        
       
		
        
	}
}
