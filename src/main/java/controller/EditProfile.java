package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegisterUser;
import model.UserDao;
@WebServlet("/edit")
public class EditProfile extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		RegisterUser user = new UserDao().getUserRecordById(id);
		req.setAttribute("user",user);
		RequestDispatcher rd = req.getRequestDispatcher("view/Editprofilr.jsp");
		rd.forward(req, resp);
	}
}
