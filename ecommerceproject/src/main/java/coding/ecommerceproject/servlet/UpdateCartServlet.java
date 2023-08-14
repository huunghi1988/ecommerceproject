package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.math.BigDecimal;
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

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        // Get the cart from the session

		Map<Integer, ProductInCart> cart = (Map<Integer, ProductInCart>) session.getAttribute("cart");
		if (cart != null) {
            // Iterate through the request parameters to update quantities
           
			for (Integer cartProductId : cart.keySet()) {
                String updatedQuantityStr = request.getParameter("quantity_" + cartProductId);
                int updatedQuantity = 0;
                    updatedQuantity = Integer.parseInt(updatedQuantityStr);
	                ProductInCart productInCart = cart.get(cartProductId);
	                productInCart.setQuantity(updatedQuantity);
	                productInCart.setTotalPrice(productInCart.getProduct().getPrice().multiply(BigDecimal.valueOf(productInCart.getQuantity())) );
                    cart.put(cartProductId, productInCart);

                }
			session.setAttribute("cart", cart);
            response.sendRedirect(request.getHeader("referer"));

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
