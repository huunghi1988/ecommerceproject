package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.ecommerceproject.entity.Product;
import coding.ecommerceproject.entity.ProductInCart;
import coding.ecommerceproject.entity.User;
import coding.ecommerceproject.service.ProductService;
import coding.ecommerceproject.service.UserService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADD_PRODUCT_TO_CART = "ADD_TO_CART";
	private final String VIEW_CART = "VIEW_CART";
	private final String SUBMIT = "SUBMIT";
	private final String REMOVE = "REMOVE";
	private final String UPDATE = "UPDATE";
	private final String CHECKOUT = "CHECKOUT";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
			ProductService productService = new ProductService();
			int productId;
			int quantity;
			String command = request.getParameter("command");

			double subTotalPrice = 0;

			double totalPrice = 0;

			HttpSession session = request.getSession();

			Map<Integer, ProductInCart> cart = (Map<Integer, ProductInCart>) session.getAttribute("cart");

			if (request.getParameter("quantity") != null && !request.getParameter("quantity").isEmpty()) {
				quantity = Integer.parseInt(request.getParameter("quantity"));
			} else {
				quantity = 1;
			}

			if (request.getParameter("productId") != null && !request.getParameter("productId").isEmpty()) {
				productId = Integer.parseInt(request.getParameter("productId"));
			} else {
				productId = 0;
			}

			switch (command) {
			case ADD_PRODUCT_TO_CART: {
				addProductToCart(cart, productId, quantity, productService, totalPrice, session, subTotalPrice, request,
						response);
				return;
			}
			case VIEW_CART: {
				showCartDetail(cart, session, request, response);
				return;
			}
			case REMOVE: {
				removeItemFromCart(cart, productId, quantity, totalPrice, session, request, response);
				return;
			}
			case SUBMIT: {
				submitCart(cart, productId, quantity, totalPrice, session, request, response);
				return;
			}
			case UPDATE: {
				updateCart(cart, session, request, response);
				return;
			}
			case CHECKOUT: {
				checkoutCart(cart, session, request, response);
				return;
			}

			}

		}

		catch (NumberFormatException e) {
			e.printStackTrace();
		}

		
	}

	public void addProductToCart(Map<Integer, ProductInCart> cart, int productId, int quantity,
			ProductService productService, double totalPrice, HttpSession session, double subTotalPrice,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (cart == null) {
				cart = new HashMap<Integer, ProductInCart>();
			}
			if (cart.containsKey(productId)) {

				ProductInCart productInCart = cart.get(productId);

				productInCart.setQuantity(productInCart.getQuantity() + quantity);

				productInCart.setSubTotalPrice(productInCart.getProduct().getPrice() * productInCart.getQuantity());

				totalPrice = (double) session.getAttribute("totalPrice")
						+ productInCart.getProduct().getPrice() * quantity;
				totalPrice=Math.round(totalPrice*100.0)/100.0;

				request.setAttribute("productInCart", productInCart);
			} else {
				Product product = productService.getProductsByProductId(productId);
				subTotalPrice = product.getPrice() * quantity;
				subTotalPrice=Math.round(subTotalPrice*100.0)/100.0;

				ProductInCart newProductInCart = new ProductInCart(product, quantity, subTotalPrice);
				cart.put(productId, newProductInCart);

				if (session.getAttribute("totalPrice") == null) {
					totalPrice = newProductInCart.getSubTotalPrice();
					totalPrice=Math.round(totalPrice*100.0)/100.0;

				} else {

					totalPrice = newProductInCart.getProduct().getPrice() * quantity
							+ (double) session.getAttribute("totalPrice");
					totalPrice=Math.round(totalPrice*100.0)/100.0;

				}

				request.setAttribute("productInCart", newProductInCart);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("totalPrice", totalPrice);

		session.setAttribute("cart", cart);

		response.sendRedirect(request.getHeader("referer"));

	}

	public void showCartDetail(Map<Integer, ProductInCart> cart, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("shoping-cart.jsp");
		request.setAttribute("cart", cart);


		rd.forward(request, response);

	}

	public void removeItemFromCart(Map<Integer, ProductInCart> cart, int productId, int quantity, double totalPrice,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		productId = Integer.parseInt(request.getParameter("productId"));
		totalPrice = (Double) session.getAttribute("totalPrice") - cart.get(productId).getSubTotalPrice();
		totalPrice=Math.round(totalPrice*100.0)/100.0;

		session.setAttribute("totalPrice", totalPrice);

		cart.remove(productId);
		response.sendRedirect(request.getHeader("referer"));

	}

	public void submitCart(Map<Integer, ProductInCart> cart, int productId, int quantity, double totalPrice,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		productId = Integer.parseInt(request.getParameter("productId"));
		totalPrice = (Double) session.getAttribute("totalPrice") - cart.get(productId).getSubTotalPrice();
		totalPrice=Math.round(totalPrice*100.0)/100.0;

		session.setAttribute("totalPrice", totalPrice);

		cart.remove(productId);
		response.sendRedirect(request.getHeader("referer"));

	}
	
	public void checkoutCart(Map<Integer, ProductInCart> cart, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService userService = new UserService();
			User user = userService.getUserDetail((int)session.getAttribute("userId"));
			RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
			request.setAttribute("cart", cart);
			request.setAttribute("user", user);
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public void updateCart(Map<Integer, ProductInCart> cart, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		double totalPrice=0;
		for (Integer cartProductId : cart.keySet()) {
			String updatedQuantityStr = request.getParameter("quantity_" + cartProductId);
			int updatedQuantity = 0;
			updatedQuantity = Integer.parseInt(updatedQuantityStr);
			ProductInCart productInCart = cart.get(cartProductId);
			 productInCart.setQuantity(updatedQuantity);
             productInCart.setSubTotalPrice(productInCart.getProduct().getPrice()*productInCart.getQuantity());
             totalPrice=totalPrice+  productInCart.getSubTotalPrice();
				totalPrice=Math.round(totalPrice*100.0)/100.0;


			cart.put(cartProductId, productInCart);

		}
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getHeader("referer"));

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
