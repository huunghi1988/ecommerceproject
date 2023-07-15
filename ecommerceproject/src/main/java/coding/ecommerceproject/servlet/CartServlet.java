package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;

import coding.ecommerceproject.entity.CartSession;
import coding.ecommerceproject.entity.Product;
import coding.ecommerceproject.entity.ProductInCart;
import coding.ecommerceproject.service.ProductService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		ProductService productService = new ProductService();

		try {
			String command = request.getParameter("command");
			//String productId = request.getParameter("productId");
			//String quantity = request.getParameter("quantity");

			int productId = 0;
			int quantity = 1;
			double totalPrice = 0;

			double totalCartPrice = 0;

			HttpSession session = request.getSession();

			Map<Integer, ProductInCart> cart = (Map<Integer, ProductInCart>) session.getAttribute("cart");
			if(request.getParameter("quantity")!= null &&!request.getParameter("quantity").isEmpty()) {
				quantity = Integer.parseInt(request.getParameter("quantity"));
		
			}
				
			if (command != null && command.equals("ADD_TO_CART")) {
				productId = Integer.parseInt(request.getParameter("productId"));

				if (cart == null) {
					cart = new HashMap<Integer, ProductInCart>();
				}
				if (cart.containsKey(productId)) {


					ProductInCart productInCart = cart.get(productId);
					if (quantity > 1) {
						productInCart.setQuantity(productInCart.getQuantity() + quantity);

					} else {
						productInCart.setQuantity(productInCart.getQuantity() + 1);

					}
					productInCart.setTotalPrice((double) Math
							.round(productInCart.getQuantity() * productInCart.getProduct().getPrice() * 100) / 100);

					totalCartPrice = totalCartPrice + productInCart.getTotalPrice();

					request.setAttribute("productInCart", productInCart);
				} else {
					Product product = productService.getProductsByProductId(productId);
					ProductInCart newProductInCart = new ProductInCart(product, quantity,
							product.getPrice() * quantity);
					cart.put(productId, newProductInCart);
					if (session.getAttribute("totalCartPrice") == null)
						totalCartPrice = newProductInCart.getTotalPrice();
					else
						totalCartPrice = newProductInCart.getTotalPrice()
								+ (Double) session.getAttribute("totalCartPrice");

					request.setAttribute("productInCart", newProductInCart);

				}
				session.setAttribute("totalCartPrice", totalCartPrice);

				session.setAttribute("cart", cart);

				response.sendRedirect(request.getHeader("referer"));
			
			
			// add multiple value
			

			} else if (command != null && command.equals("VIEW_CART")) {

				RequestDispatcher rd = request.getRequestDispatcher("shoping-cart.jsp");

				rd.forward(request, response);

			} else if (command != null && command.equals("REMOVE")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				totalCartPrice = (Double) session.getAttribute("totalCartPrice") - cart.get(productId).getTotalPrice();
				session.setAttribute("totalCartPrice", totalCartPrice);

				cart.remove(productId);
				response.sendRedirect(request.getHeader("referer"));

			} else if (command != null && command.equals("SUBMIT")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				cart.remove(productId);
				response.sendRedirect(request.getHeader("referer"));

			}
			else if (command==null&&quantity>=1) {
				productId = Integer.parseInt(request.getParameter("productId"));

				if (cart == null) {
					cart = new HashMap<Integer, ProductInCart>();
				}
				if (cart.containsKey(productId)) {


					ProductInCart productInCart = cart.get(productId);
					if (quantity > 1) {
						productInCart.setQuantity(productInCart.getQuantity() + quantity);

					} else {
						productInCart.setQuantity(productInCart.getQuantity() + 1);

					}
					productInCart.setTotalPrice((double) Math
							.round(productInCart.getQuantity() * productInCart.getProduct().getPrice() * 100) / 100);

					totalCartPrice = totalCartPrice + productInCart.getTotalPrice();

					request.setAttribute("productInCart", productInCart);
				} else {
					Product product = productService.getProductsByProductId(productId);
					ProductInCart newProductInCart = new ProductInCart(product, quantity,
							product.getPrice() * quantity);
					cart.put(productId, newProductInCart);
					if (session.getAttribute("totalCartPrice") == null)
						totalCartPrice = newProductInCart.getTotalPrice();
					else
						totalCartPrice = newProductInCart.getTotalPrice()
								+ (Double) session.getAttribute("totalCartPrice");

					request.setAttribute("productInCart", newProductInCart);

				}
				session.setAttribute("totalCartPrice", totalCartPrice);

				session.setAttribute("cart", cart);

				response.sendRedirect(request.getHeader("referer"));
			}
			
		} catch (Exception e) {
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
