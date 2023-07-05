package coding.ecommerceproject.entity;

import java.sql.Timestamp;

public class User {
private int user_id;
private String username;
private String password;
private String email;
private String first_name;
private String last_name;
private String address;
private String city;
private String state;
private String postcode;
private String phone_number;
private Timestamp created_at;
private Timestamp updated_at;

public User(int user_id, String username, String password, String email, String first_name, String last_name,
		String address, String city, String state, String postcode, String phone_number, Timestamp created_at,
		Timestamp updated_at) {
	super();
	this.user_id = user_id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.first_name = first_name;
	this.last_name = last_name;
	this.address = address;
	this.city = city;
	this.state = state;
	this.postcode = postcode;
	this.phone_number = phone_number;
	this.created_at = created_at;
	this.updated_at = updated_at;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
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
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
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
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
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
