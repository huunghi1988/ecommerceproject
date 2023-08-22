package coding.ecommerceproject.service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailThroughGmail {
	public static void SendVerifyEmail(String email, String token) {
		final String username = "huunghi1988@gmail.com"; // Your Gmail email address
		final String password = "shqabgyadtggjpkf"; // Your Gmail password or app-specific password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // Recipient's email address
			message.setSubject("Registration verification");
			String activationLink = "http://localhost:8080/ecommerceproject/activate?token=" + token+"&email="+email;
			String emailContent = "Click the following link to activate your account:\n" + activationLink;
			message.setText(emailContent);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void SendForgetEmail(String email, String token) {
		final String username = "huunghi1988@gmail.com"; // Your Gmail email address
		final String password = "shqabgyadtggjpkf"; // Your Gmail password or app-specific password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // Recipient's email address
			message.setSubject("Forget Password verification");
			String activationLink = "http://localhost:8080/ecommerceproject/UpdatePassword?token=" + token+"&email="+email;
			String emailContent = "Click the following link to set new password :\n" + activationLink;
			message.setText(emailContent);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
