package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.ecommerceproject.entity.Token;
import coding.ecommerceproject.service.UserService;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String token = request.getParameter("token");
		String email = request.getParameter("email");
		String command = request.getParameter("command");
		String password = request.getParameter("password");

		UserService userService = new UserService();

		try {
			Token savedToken = userService.getToken(email);
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			if (savedToken== null) {
				String errorMessage = "Invalid verification token.";
				RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");
				request.setAttribute("errorMessage", errorMessage);
				rd.forward(request, response);
				System.out.println("Invalid verification token.");
			}
			
			
			boolean isExpired = currentTimestamp.after(savedToken.getExpiration());

			if(command !=null) {
			if (command.equals("update") && password != null) {
				String errorMessage = " Password is updated . Please login";

				UserService.setNewPassword(email, password);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("email", email);

				rd.forward(request, response);
			}
			}

			if (token != null && email != null && !isExpired && savedToken!= null) {

				if (savedToken.getToken().equals(token)) {

					String errorMessage = email + " has been successfully verified.Please set new password";
					RequestDispatcher rd = request.getRequestDispatcher("updatepassword.jsp");
					request.setAttribute("errorMessage", errorMessage);
					request.setAttribute("email", email);

					rd.forward(request, response);
					System.out.println("User " + email + " has been successfully verified and activated.");
				} else {
					String errorMessage = "Invalid verification token.";
					RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");
					request.setAttribute("errorMessage", errorMessage);
					rd.forward(request, response);
					System.out.println("Invalid verification token.");
				}
			} else if (token != null && currentTimestamp.after(savedToken.getExpiration())) {
				String errorMessage = "Token has expired. Request a new verification link.";
				RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");
				request.setAttribute("errorMessage", errorMessage);
				rd.forward(request, response);
				System.out.println("Token has expired. Request a new verification link.");
			} else {
				String errorMessage = "Invalid verification token";
				RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");
				request.setAttribute("errorMessage", errorMessage);
				rd.forward(request, response);
				System.out.println("Invalid verification token.");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
