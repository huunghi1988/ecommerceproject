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
 * Servlet implementation class ActiveAccount
 */
@WebServlet("/activate")
public class ActiveAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActiveAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = request.getParameter("token");
		String email = request.getParameter("email");
		UserService userService = new UserService();

		try {
			Token savedToken = userService.getToken(email);
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			boolean isExpired=currentTimestamp.after(savedToken.getExpiration());
		
			if (token != null && email != null && !isExpired) {

				if (savedToken.getToken().equals(token)) {
					userService.setUserActive(email);
					String successMessage =  email + " has been successfully verified and activated.Please login";
					RequestDispatcher rd = request.getRequestDispatcher("ActiveAccount.jsp");
					request.setAttribute("success", successMessage);
					rd.forward(request, response);
					System.out.println(  email + " has been successfully verified and activated.");
				} else {
					String tokenExpireMessage = "Invalid verification token.";
					RequestDispatcher rd = request.getRequestDispatcher("ActiveAccount.jsp");
					request.setAttribute("tokenExpireMessage", tokenExpireMessage);
					rd.forward(request, response);
					System.out.println("Invalid verification token.");
				}
			} else if (token != null && currentTimestamp.after(savedToken.getExpiration())) {
				String tokenExpireMessage = "Token has expired. Request a new verification link.";
				RequestDispatcher rd = request.getRequestDispatcher("ActiveAccount.jsp");
				request.setAttribute("tokenExpireMessage", tokenExpireMessage);
				rd.forward(request, response);
				System.out.println("Token has expired. Request a new verification link.");
			} else {
				String tokenInvalidMessage = "Invalid verification token";
				RequestDispatcher rd = request.getRequestDispatcher("ActiveAccount.jsp");
				request.setAttribute("tokenInvalidMessage", tokenInvalidMessage);
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
