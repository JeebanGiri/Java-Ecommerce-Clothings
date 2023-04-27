package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/ecommerce";
		String username="root";
		String password="";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection(url,username,password);
		return con;
	}
	public String addUser(User user) {
		String message="";
		String query="Insert into user (Name,Phone,Email,Address,Password,UserImagePath)values(?,?,?,?,?,?)";
		try {
			Connection con=getConnection();
			PreparedStatement pobj=con.prepareStatement(query);
			pobj.setString(1, user.getUserName());
			pobj.setString(2, user.getUserContact());
			pobj.setString(3, user.getUserEmail());
			pobj.setString(4, user.getUserAddress());
			pobj.setString(5, user.getUserPassword());
			pobj.setString(6, user.getUserImage());
			int rows=pobj.executeUpdate();
			if(rows==1) {
				message="Succesfully Registered";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message=e.getMessage();
		}
		return message;
	}
}
