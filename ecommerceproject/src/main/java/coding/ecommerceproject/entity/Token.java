package coding.ecommerceproject.entity;

import java.sql.Timestamp;

public class Token {
	private String email;
	private String token;
	private Timestamp expiration;
	public Token(String email, String token, Timestamp expiration) {
		super();
		this.email = email;
		this.token = token;
		this.expiration = expiration;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getExpiration() {
		return expiration;
	}
	public void setExpiration(Timestamp expiration) {
		this.expiration = expiration;
	}
	
	
}
