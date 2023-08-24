package coding.ecommerceproject.entity;


public class ProductInCart {
	private Product product;
	private int quantity;
	private double subTotalPrice;
	
	public ProductInCart(Product product, int quantity, double subTotalPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.subTotalPrice = subTotalPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubTotalPrice() {
		return subTotalPrice;
	}
	public void setSubTotalPrice(double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	
	
	
	
}
