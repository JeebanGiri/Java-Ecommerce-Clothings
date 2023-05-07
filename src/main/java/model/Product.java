package model;
public class Product{
	private int productID;
	private String productName;
	private String productDescripiton;
	private String productPrice;
	private String productCategory;
	private int productRating;
	private String imageName;
	public Product(int productID, String productName, String productDescripiton, String productPrice,
			String productCategory,int productRating, String imageName) {
		this.productID = productID;
		this.productName = productName;
		this.productDescripiton = productDescripiton;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productRating=productRating;
		this.imageName = imageName;
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
	public String getProductDescripiton() {
		return productDescripiton;
	}
	public void setProductDescripiton(String productDescripiton) {
		this.productDescripiton = productDescripiton;
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
}