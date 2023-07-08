package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;

import coding.ecommerceproject.entity.Product;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//BookService bookService = new BookService();
		ProductService productService = new ProductService();
		
		try {
			String command = request.getParameter("command");
			int productId=0;
			if (command != null && command.equals("ADD_TO_CART")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				
				
				//Book book = bookService.getBookDetails(bookId);
				Product product = productService.getProductsByProductId(productId);
				HttpSession session = request.getSession();
				Map<Integer, Product> cart = (Map<Integer, Product>) session.getAttribute("cart");
				if (cart == null) {
					cart = new HashMap<Integer, Product>();
				}
				cart.put(product.getProductId(), product);
				session.setAttribute("cart", cart);
				request.setAttribute("product", product);;
				System.out.println(request.getContextPath()+"/"+request.getRequestURI());
				response.sendRedirect(request.getContextPath());
			} else if (command != null && command.equals("VIEW_CART")) {
				response.sendRedirect("shoping-cart.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
