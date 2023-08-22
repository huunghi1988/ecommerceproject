package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.ecommerceproject.entity.User;
import coding.ecommerceproject.service.LoginService;
import coding.ecommerceproject.service.SendEmailThroughGmail;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			LoginService loginService = new LoginService();
			User user = loginService.getUserByEmailAndPassword(email, password);
		
			
			
			if (user == null) {
				String errorMessage = "Incorrect email or password, please re-enter.";
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("email", email);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			} else if(user.getIsActive()==0){
				String errorMessage = "Account is not active, please active before login";
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("email", email);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}
			
			else {
				
				HttpSession session = request.getSession(false);
				session.setAttribute("name", user.getFirstName() + " " + user.getLastName());
				session.setAttribute("userId", user.getUserId());
				response.sendRedirect("Home");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
