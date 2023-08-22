package coding.ecommerceproject.entity;


public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String postcode;
	private int isActive;
	private int forgetPassword;
	private String phoneNumber;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getForgetPassword() {
		return forgetPassword;
	}
	public void setForgetPassword(int forgetPassword) {
		this.forgetPassword = forgetPassword;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public User(int userId, String username, String password, String email, String firstName, String lastName,
			String address, String city, String state, String postcode, int isActive, int forgetPassword,
			String phoneNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.isActive = isActive;
		this.forgetPassword = forgetPassword;
		this.phoneNumber = phoneNumber;
	}
	
}
