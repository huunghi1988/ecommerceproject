package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.ecommerceproject.entity.Token;

import coding.ecommerceproject.service.ForgetPasswordService;
import coding.ecommerceproject.service.LoginService;

import coding.ecommerceproject.service.SendEmailThroughGmail;
import coding.ecommerceproject.service.UserService;

/**
 * Servlet implementation class ActiveAccount
 */
@WebServlet("/forgetpassword")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		
		try {
			int isExisted = LoginService.checkDuplicateUser(email);

			if (isExisted == 1) {
				ForgetPasswordService.setForgetPasswordToken(email);
				UserService userService = new UserService();
				Token token = userService.getToken(email);
				SendEmailThroughGmail.SendForgetEmail(email, token.getToken());

				RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");
				request.setAttribute("errorMessage", "Email sent. Please check your email for forget password link");
				request.setAttribute("email", email);
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("forgetpassword.jsp");

				request.setAttribute("errorMessage",
						"Account is not available. Please check your email again.");
				rd.forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
