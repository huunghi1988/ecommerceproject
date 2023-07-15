package coding.ecommerceproject.entity;

import java.util.Set;

public class CartSession {
	private Set<ProductInCart> productInCart;
	private double totalCart;
	public CartSession(Set<ProductInCart> productInCart, double totalCart) {
		super();
		this.productInCart = productInCart;
		this.totalCart = totalCart;
	}
	public Set<ProductInCart> getProductInCart() {
		return productInCart;
	}
	public void setProductInCart(Set<ProductInCart> productInCart) {
		this.productInCart = productInCart;
	}
	public double getTotalCart() {
		return totalCart;
	}
	public void setTotalCart(double totalCart) {
		this.totalCart = totalCart;
	}
	
	

}
