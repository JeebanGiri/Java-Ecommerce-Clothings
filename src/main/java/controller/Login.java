package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDao;
import model.UserDao.LoginResult;	
@WebServlet("/userLogin")
public class Login extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDao userDao = new UserDao();
		LoginResult result = userDao.checkLogin(email, password);
		boolean isValid = result.isValid();
		boolean isAdmin = result.isAdmin();

		System.out.println(isValid);
		System.out.println(isAdmin);
		HttpSession session = request.getSession();
		if(isValid == true) {
			session.setAttribute("loggedInId",email);
			request.getRequestDispatcher("/products").forward(request, response);

			
		}
		if(isAdmin==true) {
			System.out.println("Admin khul");
			request.getRequestDispatcher("/admin").forward(request, response);
		}
		else {
			session.setAttribute("loginError","Invalid username or password");
//			request.getRequestDispatcher("view/Login.jsp").forward(request, response);
			response.sendRedirect("/view/Login.jsp");
		}
	}
}
