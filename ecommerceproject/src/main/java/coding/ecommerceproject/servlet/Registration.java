package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.ecommerceproject.service.LoginService;
import coding.ecommerceproject.service.RegistrationService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		try {
			int isExisted=LoginService.checkDuplicateUser(email);

			if (isExisted==1)
			{
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			request.setAttribute("errorMessage", "Email is already used. Please login.");
		    request.setAttribute("email", email);
			rd.forward(request, response);
			}
			else {		
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			RegistrationService.registerNewUser(email, password, username, first_name, last_name);
			request.setAttribute("SuccessMessage", "Account is created successfully. Please login.");
			rd.forward(request, response);

}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
