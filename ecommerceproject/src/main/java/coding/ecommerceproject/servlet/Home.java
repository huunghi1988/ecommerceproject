package coding.ecommerceproject.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.ecommerceproject.entity.Category;
import coding.ecommerceproject.entity.Product;
import coding.ecommerceproject.service.CategoryService;
import coding.ecommerceproject.service.ProductService;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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
			CategoryService service = new CategoryService();
			ProductService productService  = new ProductService();
			List<Category> categoryList = service.getAllCategories();
			String categoryId = request.getParameter("categoryId");
			List<Product> productListByCategoryId = new ArrayList<Product>();
			System.out.println("categoryid" + categoryId);
			//Product List by id
			if(categoryId == null ) {
				productListByCategoryId = productService.getAllProducts();
				System.out.println(productListByCategoryId.size());
				
			} else {
				productListByCategoryId = productService.getProductsByCategoryId(Integer.parseInt(categoryId));
			}
			
			//ProductList  by search
			String keyword = request.getParameter("keyword");
			
			List<Product> productListBySearch = new ArrayList<Product>();
			
			
			if (keyword != null && !keyword.isEmpty()) {
	            productListBySearch = productService.getProductsBySearch(keyword);
	            request.setAttribute("keyword", keyword);
	           
	        }

			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productListByCategoryId", productListByCategoryId);
			request.setAttribute("productListBySearch", productListBySearch);
			rd.forward(request, response);
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
