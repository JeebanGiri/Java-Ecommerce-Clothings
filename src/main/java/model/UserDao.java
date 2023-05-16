package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public String addUser(RegisterUser addUser) {
		String message="";
		String query="Insert into user (name,phone,email,address,password,userImagePath) values(?,?,?,?,?,?)";
		try {
			Connection con=getConnection();
			PreparedStatement pobj=con.prepareStatement(query);
			pobj.setString(1, addUser.getUname());
			pobj.setString(2, addUser.getUphone());
			pobj.setString(3, addUser.getUemail());
			pobj.setString(4, addUser.getUaddress());
			pobj.setString(5, addUser.getUpassword());
			pobj.setString(6, addUser.getImageName());
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
	public class LoginResult {
	    private boolean isValid;
	    private boolean isAdmin;
	    
	    public LoginResult(boolean isValid, boolean isAdmin) {
	        this.isValid = isValid;
	        this.isAdmin = isAdmin;
	    }
	    
	    public boolean isValid() {
	        return isValid;
	    }
	    
	    public boolean isAdmin() {
	        return isAdmin;
	    }
	}

	public LoginResult checkLogin(String email, String password) {
	    boolean isValid = false;
	    boolean isAdmin = false;
	    try {
	        Connection con = getConnection();
	        String userQuery = "SELECT * FROM user WHERE email=? AND password=?";
	        String adminQuery = "SELECT * FROM admin WHERE email=? AND password=?";
	        PreparedStatement userStmt = con.prepareStatement(userQuery);
	        PreparedStatement adminStmt = con.prepareStatement(adminQuery);
	        userStmt.setString(1, email);
	        userStmt.setString(2, password);
	        adminStmt.setString(1, email);
	        String dpsw=AESEncryption.decrypt(password);
	        adminStmt.setString(2, dpsw);
	        ResultSet userResult = userStmt.executeQuery();
	        ResultSet adminResult = adminStmt.executeQuery();
	        
	        if (userResult.next()) {
	            isValid = true;
	        }
	        else if (adminResult.next()) {
	            isAdmin = true;
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return new LoginResult(isValid, isAdmin);
	}
	public String updateUser(RegisterUser updateUser) {
		String message = "";
		try {
			
			Connection con =  getConnection();
			String query = "UPDATE registration SET name=?, phone=?,email=?,address=?,password=?,image-name=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, updateUser.getUname());
			pst.setString(2, updateUser.getUphone());
			pst.setString(3, updateUser.getUemail());
			pst.setString(4, updateUser.getUaddress());
			pst.setString(5, updateUser.getUpassword());
			pst.setString(6, updateUser.getImageName());
			int rows=pst.executeUpdate();

			if(rows >= 1) {
				message = "Successfully Updated";
			}
			con.close();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;	
	}
	public RegisterUser getUserRecordById(String id) {
		Connection con = null;
		RegisterUser user = null;
		try {
			con = getConnection();
			String query = "select * from registration where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,id);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String name = table.getString(1);
				String phone = table.getString(2);
				String email = table.getString(3);
				String address = table.getString(4);
				String upassword=table.getString(5);
				String dpassword=AESEncryption.decrypt(upassword);
				String image=table.getString(6);
				
				user = new RegisterUser(name,phone,email,address,dpassword,image);
						
			}			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return user;
		
	}

}
