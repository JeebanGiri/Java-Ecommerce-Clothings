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
	public String addProductToCart(Product product,String email) {
		String query="Insert into cart (productID,productName,productPrice,productCategory,productImage,addedBy)values (?,?,?,?,?,?)";
		String messages="";
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setLong(1, product.getProductID());
			pst.setString(2, product.getProductName());
			pst.setString(3, product.getProductPrice());
			pst.setString(4, product.getProductCategory());
			pst.setString(5, product.getImageName());
			pst.setString(6, email);
			int rows=pst.executeUpdate();
			if(rows>=1) {
				messages="Successfully Added";
			}
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			messages=e.getMessage();
		}
		return messages;
	}
	public String deleteProduct(int productID) {
		String query="DELETE from product where productID = ?";
		String messages="";
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setLong(1, productID);
			 int rowsAffected = pst.executeUpdate();

		        if (rowsAffected > 0) {
		            messages = "Product deleted successfully";
		        } else {
		            messages = "Product not found";
		        }
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			messages=e.getMessage();
		}
		return messages;
	}
	public Product getProductRecordById(int id) {
		String query="Select * from product where productID = ?";
		String messages="";
		Product product=null;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1, id);
			ResultSet table=pst.executeQuery();
			while(table.next()) {
				int productID1= id;
				String productName=table.getString(2);
				String productDescription=table.getString(3);
				String productPrice=table.getString(4);
				String productCategory=table.getString(5);
				int productRating=table.getInt(6);
				String productImage=table.getString(7);
				
				product=new Product(productID1,productName,productDescription,productPrice,productCategory,productRating,productImage);
				
			}
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			messages=e.getMessage();
		}
		return product;
	}
	public ArrayList<Cart> fetchCartRecordById(String email) {
		ArrayList<Cart> cartlist=new ArrayList<>();
		String query="Select * from cart where addedBy = ?";
		try {
			Connection con=getConnection();
			PreparedStatement pobj=con.prepareStatement(query);
			pobj.setString(1, email);
			
			
			ResultSet table=pobj.executeQuery();
			while(table.next()) {
				int productID=table.getInt(2);
				String productName=table.getString(3);
				String productPrice=table.getString(4);
				String productCategory=table.getString(5);
				String productImage=table.getString(6);
				
				Cart product=new Cart(productID,productName,productPrice,productCategory,productImage, productImage);
				cartlist.add(product);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartlist;
	}
	public ArrayList<Product> getProductRecordByQuery(String squery){
		ArrayList<Product> productList= new ArrayList<>();
		Connection con=null;
		Product product=null;
		try {
			con=getConnection();
			String query="Select * from product where productName LIKE CONCAT('%',?,'%')";
			PreparedStatement pt= con.prepareStatement(query);
			pt.setString(1, squery);
			ResultSet table = pt.executeQuery();
			while(table.next()) {
				int id2=Integer.parseInt(table.getString(1));
				String name=table.getString(2);
				String description=table.getString(3);
				String price=table.getString(4);
				String category=table.getString(5);
				int rating=Integer.parseInt(table.getString(6));
				String imagePath=table.getString(7);
				 product=new Product(id2, name, description, price,category,rating,imagePath);
				 productList.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
}
