package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.RegisterUser;
import model.UserDao;


@WebServlet("/register")
@MultipartConfig
public class Register extends HttpServlet{
  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get form data
        String uname = req.getParameter("name");
        String uphone = req.getParameter("phone");
        String uemail = req.getParameter("email");
        String uaddress = req.getParameter("address");
        String upassword=req.getParameter("password");
        Part userImage = req.getPart("user-image");
        String imageName = "User"+uname+".png";
        
        RegisterUser user = new RegisterUser( uname, uphone, uemail,  uaddress, upassword, imageName);
        String message=new UserDao().addUser(user);
        
        RequestDispatcher rd;
        
        HttpSession session=req.getSession();
        
       if(message.equals("Succesfully Registered")&& userImage!=null && userImage.getInputStream().available()>0) {
    	   
    	   String imagePath=getServletContext().getInitParameter("userImagePath");
    	   String fullpath= imagePath+imageName;
    	   userImage.write(fullpath);
    	   
    	   req.setAttribute("status", "Successfully Resgited Login in now");
    	   rd=req.getRequestDispatcher("view/Login.jsp");
    	   rd.forward(req, resp);
    	   
    	   
       }
       else {
    	   rd=req.getRequestDispatcher("view/Register.jsp");
       }
       session.setAttribute("registeredmessage", message);
	   resp.sendRedirect("view/Register.jsp");
        
        
       
		
        
	}
}