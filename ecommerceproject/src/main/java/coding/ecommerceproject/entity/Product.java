package coding.ecommerceproject.entity;

import java.util.Date;
import java.sql.Timestamp;
public class Product {

	private int product_id;
	private String product_name;
	private String description;
	private String dimensions;
	private int price;
	private int discount_price;
	private int stock_quantity;
	private String weight;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String image_url;
	private int category_id;

	
	
	public Product(int product_id, String product_name, String description, String dimensions, int price,
			int discount_price, int stock_quantity, String weight, Timestamp created_at, Timestamp updated_at,
			String image_url, int category_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.dimensions = dimensions;
		this.price = price;
		this.discount_price = discount_price;
		this.stock_quantity = stock_quantity;
		this.weight = weight;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.image_url = image_url;
		this.category_id = category_id;
	}

	
	
	public int getCategory_id() {
		return category_id;
	}



	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}



	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(int discount_price) {
		this.discount_price = discount_price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	
}
