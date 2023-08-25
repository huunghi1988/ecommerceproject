package coding.ecommerceproject.entity;

import java.math.BigDecimal;
public class Product {

	private int productId;
	private String productName;
	private String description;
	private String dimensions;
	private BigDecimal price;
	private BigDecimal discountPrice;
	private int stockQuantity;
	private String weight;
	private String imageUrl;
	private int categoryId;
	private String categoryName;
	
	
	
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) {
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Product(int productId, String productName, String description, String dimensions, BigDecimal price,
			BigDecimal discountPrice, int stockQuantity, String weight, String imageUrl, int categoryId,
			String categoryName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.dimensions = dimensions;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stockQuantity = stockQuantity;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public Product(int productId, String productName, String description, String dimensions, BigDecimal price,
			BigDecimal discountPrice, int stockQuantity, String weight, String imageUrl,
			String categoryName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.dimensions = dimensions;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stockQuantity = stockQuantity;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.categoryName = categoryName;
	}
}
