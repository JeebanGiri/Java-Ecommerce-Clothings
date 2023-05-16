package model;

public class Cart {
	private int productID;
	private String productName;
	private String productPrice;
	private String productCategory;
	private String productImage;
	private String addedby;
	public Cart(int productID, String productName, String productPrice, String productCategory, String productImage,
			String addedby) {
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productImage = productImage;
		this.addedby = addedby;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getAddedby() {
		return addedby;
	}
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}
	
}
