package coding.ecommerceproject.entity;

import java.util.Date;
import java.sql.Timestamp;
public class Product {

	private int productId;
	private String productName;
	private String description;
	private String dimensions;
	private double price;
	private double discountPrice;
	private int stockQuantity;
	private String weight;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private String imageUrl;
	private int categoryId;
	public Product(int productId, String productName, String description, String dimensions, double price,
			double discountPrice, int stockQuantity, String weight, Timestamp createdAt, Timestamp updatedAt,
			String imageUrl, int categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.dimensions = dimensions;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stockQuantity = stockQuantity;
		this.weight = weight;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
