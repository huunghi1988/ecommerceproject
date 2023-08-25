package coding.ecommerceproject.entity;

import java.sql.Date;

public class Order {

	private int orderId;
	private int userId;
	private Date orderDate;
	private double totalAmount;
	private String shippingAddress;
	private String shippingSuburb;
	private String shippingState;
	private String shippingPostcode;
	private String paymentMethod;
	private String email;

	private boolean paymentStatus;
	private boolean fullfillmentStatus;
	
	
	
	public Order(int userId,Date orderDate, double totalAmount, String shippingAddress, String shippingSuburb, String shippingState,
			String shippingPostcode,String email) {
		super();
		this.userId = userId;
		this.orderDate = orderDate;

		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.shippingSuburb = shippingSuburb;
		this.shippingState = shippingState;
		this.shippingPostcode = shippingPostcode;
		this.email = email;


	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingSuburb() {
		return shippingSuburb;
	}
	public void setShippingSuburb(String shippingSuburb) {
		this.shippingSuburb = shippingSuburb;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public String getShippingPostcode() {
		return shippingPostcode;
	}
	public void setShippingPostcode(String shippingPostcode) {
		this.shippingPostcode = shippingPostcode;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public boolean getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public boolean getFullfillmentStatus() {
		return fullfillmentStatus;
	}
	public void setFullfillmentStatus(boolean fullfillmentStatus) {
		this.fullfillmentStatus = fullfillmentStatus;
	}

	



	
	
	
	
	
}
