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
		try {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = LoginService.getUserByEmailAndPassword(email, password);
			System.out.println(email);
			System.out.println(password);
			if (user == null) {
				String errorMessage = "Incorrect username and password, please re-enter.";
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			} else {
				System.out.println(
						"gia tri la " + user.getEmail() + " " + user.getFirst_name() + "   " + user.getLast_name());
				HttpSession session = request.getSession(false);
				session.setAttribute("name", user.getFirst_name() + " " + user.getLast_name());
				session.setAttribute("userId", user.getUser_id());
				response.sendRedirect("index.jsp");

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
