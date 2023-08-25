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

import coding.ecommerceproject.service.UserService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String GET_USER_DETAIL = "GET_USER_DETAIL";
	private final String UPDATE_USER_DETAIL = "UpdateUserDetail";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
			
			String command = request.getParameter("command");
			HttpSession session = request.getSession();

			switch (command) {
		
			case GET_USER_DETAIL: {
				getUserdetail(session, request, response);
				return;
			}
			case UPDATE_USER_DETAIL: {
				updateUserdetail(session, request, response);
				return;
			}

			}

		}

		catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	

	public void getUserdetail( HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService userService = new UserService();
			if(session.getAttribute("userId") !=null) {
				User user = userService.getUserDetail((int) session.getAttribute("userId"));
				request.setAttribute("user", user);

			}
			RequestDispatcher rd = request.getRequestDispatcher("UserDetail.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void updateUserdetail( HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService userService = new UserService();
			User user = userService.getUserDetail((int) session.getAttribute("userId"));
			System.out.println((int) session.getAttribute("userId"));
			System.out.println(request.getParameter("firstName"));

			userService.updateUserDetail((int) session.getAttribute("userId"), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("address"), request.getParameter("city"), request.getParameter("state"), request.getParameter("postcode"), request.getParameter("phone"), request.getParameter("email"));
			RequestDispatcher rd = request.getRequestDispatcher("UserServlet?command=GET_USER_DETAIL");
			request.setAttribute("user", user);
			rd.forward(request, response);

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
