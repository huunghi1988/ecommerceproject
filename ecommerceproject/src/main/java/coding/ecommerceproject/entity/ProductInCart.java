package coding.ecommerceproject.entity;

import java.math.BigDecimal;

public class ProductInCart {
	private Product product;
	private int quantity;
	private BigDecimal subTotalPrice;
	public ProductInCart(Product product, int quantity, BigDecimal subTotalPrice) {
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
	public BigDecimal getSubTotalPrice() {
		return subTotalPrice;
	}
	public void setSubTotalPrice(BigDecimal subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	
	
	
	
}
