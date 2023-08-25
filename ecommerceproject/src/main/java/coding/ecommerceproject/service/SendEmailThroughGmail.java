package coding.ecommerceproject.service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import coding.ecommerceproject.entity.OrderDetail;

public class SendEmailThroughGmail {
	public static void SendVerifyEmail(String email, String token) {
		final String username = "ntran25021988@gmail.com"; // Your Gmail email address
		final String password = "hekkuygowmnnaqgs"; // Your Gmail password or app-specific password

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
			String emailContent = "\r\n"
					+ "Hey "+email+" ,\r\n"
					+ "\r\n"
					+ "We're so happy you've chosen our store!\r\n"
					+ "\r\n"
			
					+ "To get started¸ please verify your email address. This is so you can keep up to date with your important service updates. \r\n"
					+ "\r\n"
					+ "Please click following link or simply copy and paste this URL into your web browser: "+activationLink+"\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "Thanks,"
					+ "\r\n"
					+ "Admin"
					+ "" ;

			
			message.setText(emailContent);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void SendForgetEmail(String email, String token) {
		final String username = "ntran25021988@gmail.com"; // Your Gmail email address
		final String password = "hekkuygowmnnaqgs"; //  Gmail  app-specific password

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
			String emailContent = "\r\n"
					+ "Hey "+email+" ,\r\n"
					+ "\r\n"
					+ "We received the request to reset the account password!\r\n"
					+ "\r\n"
					+ "To reset it, please click following link or simply copy and paste this URL into your web browser: "+activationLink+"\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "Thanks,"
					+ "\r\n"
					+ "Admin"
					+ "" ;
			message.setText(emailContent);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void SendOrderConfirmation(String email) {
		final String username = "ntran25021988@gmail.com"; // Your Gmail email address
		final String password = "hekkuygowmnnaqgs"; //  Gmail  app-specific password

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
			message.setSubject("Order Confirmation");
			String emailContent = "\r\n"
					+ "Hey "+email+" ,\r\n"
					+ "\r\n"
					+ "We received your order and will process it as soon as possible !!!\r\n"
				
					+ "\r\n"
					+ "Thanks,"
					+ "\r\n"
					+ "Admin"
					+ "" ;
			message.setText(emailContent);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
