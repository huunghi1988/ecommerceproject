package coding.ecommerceproject.entity;

public class Category {
	private int category_id;
	private String category_name;
	private String image_url;
	public Category(int category_id, String category_name, String image_url) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.image_url = image_url;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	

}
