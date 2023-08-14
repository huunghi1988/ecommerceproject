package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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

			int productId = 0;
			int quantity = 1;
			BigDecimal subTotalPrice = new BigDecimal(BigInteger.ZERO, 2);

			BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO, 2);
			BigDecimal oldTotalPrice= new BigDecimal(BigInteger.ZERO, 2);

			HttpSession session = request.getSession();

			Map<Integer, ProductInCart> cart = (Map<Integer, ProductInCart>) session.getAttribute("cart");

			if (request.getParameter("quantity") != null && !request.getParameter("quantity").isEmpty()) {
				quantity = Integer.parseInt(request.getParameter("quantity"));
			}
			
			if (request.getParameter("productId") != null && !request.getParameter("productId").isEmpty()) {
				productId = Integer.parseInt(request.getParameter("productId"));
			}

			if (command != null && command.equals("ADD_TO_CART")) {

				if (cart == null) {
					cart = new HashMap<Integer, ProductInCart>();
				}
				if (cart.containsKey(productId)) {

					ProductInCart productInCart = cart.get(productId);

					productInCart.setQuantity(productInCart.getQuantity() + quantity);

					productInCart.setSubTotalPrice(productInCart.getProduct().getPrice()
							.multiply(BigDecimal.valueOf(productInCart.getQuantity())));

					totalPrice = totalPrice.add(productInCart.getSubTotalPrice());

					request.setAttribute("productInCart", productInCart);
				}

				else {
					Product product = productService.getProductsByProductId(productId);
					subTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
					ProductInCart newProductInCart = new ProductInCart(product, quantity, subTotalPrice);
					cart.put(productId, newProductInCart);

					if (session.getAttribute("totalPrice") == null)
						totalPrice = newProductInCart.getSubTotalPrice();
					else
						System.out.println(BigDecimal.valueOf((double)session.getAttribute("totalPrice")));
					System.out.println(newProductInCart.getSubTotalPrice());
						
						totalPrice = newProductInCart.getSubTotalPrice();

					request.setAttribute("productInCart", newProductInCart);

				}
				session.setAttribute("totalPrice", totalPrice);

				session.setAttribute("cart", cart);

				response.sendRedirect(request.getHeader("referer"));

			} else if (command != null && command.equals("VIEW_CART")) {

				RequestDispatcher rd = request.getRequestDispatcher("shoping-cart.jsp");

				rd.forward(request, response);

			} else if (command != null && command.equals("REMOVE")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				totalPrice = BigDecimal.valueOf((Double) session.getAttribute("totalPrice"))
						.subtract(cart.get(productId).getSubTotalPrice());
				session.setAttribute("totalPrice", totalPrice);

				cart.remove(productId);
				response.sendRedirect(request.getHeader("referer"));

			} else if (command != null && command.equals("SUBMIT")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				cart.remove(productId);
				response.sendRedirect(request.getHeader("referer"));

			}

			// add from item detail

			else if (command == null && quantity >= 1) {
				if (cart == null) {
					cart = new HashMap<Integer, ProductInCart>();
				}
				if (cart.containsKey(productId)) {

					ProductInCart productInCart = cart.get(productId);

					productInCart.setQuantity(productInCart.getQuantity() + quantity);

					productInCart.setSubTotalPrice(productInCart.getProduct().getPrice()
							.multiply(BigDecimal.valueOf(productInCart.getQuantity())));

					totalPrice = totalPrice.add(productInCart.getSubTotalPrice());

					request.setAttribute("productInCart", productInCart);
				}

				else {
					Product product = productService.getProductsByProductId(productId);
					subTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
					ProductInCart newProductInCart = new ProductInCart(product, quantity, subTotalPrice);
					cart.put(productId, newProductInCart);

					if (session.getAttribute("totalPrice") == null)
						totalPrice = newProductInCart.getSubTotalPrice();
					else
						oldTotalPrice = BigDecimal.valueOf((Double) session.getAttribute("totalCartPrice"));
						totalPrice = newProductInCart.getSubTotalPrice()
								.add(oldTotalPrice);

					request.setAttribute("productInCart", newProductInCart);

				}
				session.setAttribute("totalPrice", totalPrice);

				session.setAttribute("cart", cart);

				response.sendRedirect(request.getHeader("referer"));
			}

			if (cart != null) {
				// Iterate through the request parameters to update quantities
				for (Integer cartProductId : cart.keySet()) {
					String updatedQuantityStr = request.getParameter("quantity_" + cartProductId);
					int updatedQuantity = 0;
					updatedQuantity = Integer.parseInt(updatedQuantityStr);
					ProductInCart productInCart = cart.get(cartProductId);
					productInCart.setQuantity(updatedQuantity);

					cart.put(cartProductId, productInCart);

				}
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
