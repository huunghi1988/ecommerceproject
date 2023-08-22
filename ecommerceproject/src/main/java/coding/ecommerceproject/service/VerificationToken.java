package coding.ecommerceproject.service;

import java.sql.Timestamp;
import java.util.UUID;

public class VerificationToken {
	private String token;
	private Timestamp expirationDateTime;
	public final int expirationHours= 12;// set exp 12hours

	    public VerificationToken() {
	        this.token = UUID.randomUUID().toString(); // Generate a random token
	        long currentTimeMillis = System.currentTimeMillis();
	        long expirationMillis = currentTimeMillis + (expirationHours * 60 * 60 * 1000);
	        this.expirationDateTime = new Timestamp(expirationMillis);  }

	    public String getToken() {
	        return token;
	    }

		public Timestamp getExpirationDateTime() {
			return expirationDateTime;
		}



}
