package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/ecommerce";
		String username="root";
		String password="";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection(url,username,password);
		return con;
	}
	public String addProduct(Product addProduct) {
		String message="";
		String query="Insert into product values(?,?,?,?,?,?,?)";
		try {
			Connection con=getConnection();
			PreparedStatement pobj=con.prepareStatement(query);
			pobj.setLong(1, addProduct.getProductID());
			pobj.setString(2, addProduct.getProductName());
			pobj.setString(3, addProduct.getProductDescripiton());
			pobj.setString(4, addProduct.getProductPrice());
			pobj.setString(5, addProduct.getProductCategory());
			pobj.setLong(6, addProduct.getProductRating());
			pobj.setString(7, addProduct.getImageName());
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
	public ArrayList<Product> fetchProducts() {
		ArrayList<Product> productList=new ArrayList<>();
		String query="Select * from product";
		try {
			Connection con=getConnection();
			PreparedStatement pobj=con.prepareStatement(query);
			
			ResultSet table=pobj.executeQuery();
			while(table.next()) {
				int productID=table.getInt(1);
				String productName=table.getString(2);
				String productDescription=table.getString(3);
				String productPrice=table.getString(4);
				String productCategory=table.getString(5);
				int productRating=table.getInt(6);
				String productImage=table.getString(7);
				
				Product product=new Product(productID,productName,productDescription,productPrice,productCategory,productRating,productImage);
				productList.add(product);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
}
