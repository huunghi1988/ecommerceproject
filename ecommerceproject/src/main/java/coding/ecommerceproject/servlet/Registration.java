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
import coding.ecommerceproject.service.LoginService;
import coding.ecommerceproject.service.RegistrationService;
import coding.ecommerceproject.service.ScheduledDeleteTask;
import coding.ecommerceproject.service.SendEmailThroughGmail;
import coding.ecommerceproject.service.UserService;

import java.util.Timer;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		try {
			int isExisted = LoginService.checkDuplicateUser(email);

			if (isExisted == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				request.setAttribute("errorMessage", "Email is already used. Please login.");
				request.setAttribute("email", email);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				RegistrationService.registerNewUser(email, password, username, firstName, lastName);
		        Timer timer = new Timer();
		        timer.schedule( new ScheduledDeleteTask(email), 0, 24 * 60 * 60 * 1000);
				request.setAttribute("SuccessMessage",
						"Account is created successfully. Please check your email and active before login.");
				rd.forward(request, response);

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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		try {
			int isExisted = LoginService.checkDuplicateUser(email);

			if (isExisted == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				request.setAttribute("errorMessage", "Email is already used. Please login.");
				request.setAttribute("email", email);
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				RegistrationService.registerNewUser(email, password, username, firstName, lastName);
				UserService userService = new UserService();
				Token token = userService.getToken(email);

				SendEmailThroughGmail.SendVerifyEmail(email, token.getToken());
				request.setAttribute("SuccessMessage",
						"Account is created successfully. Please check your email and active before login.");
				rd.forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
