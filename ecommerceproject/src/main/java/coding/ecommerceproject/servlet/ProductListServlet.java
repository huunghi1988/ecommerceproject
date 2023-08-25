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
@WebServlet("/ProductList")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String GET_ALL_PRODUCTS = "GET_ALL_PRODUCTS";
	private final String GET_PRODUCTS_BY_CATEGORY_ID = "GET_PRODUCTS_BY_CATEGORY_ID";
	private final String GET_PRODUCTS_BY_SEARCH = "SEARCH";
	private final String GET_PRODUCTS_BY_MAXMIN = "GET_PRODUCTS_BY_MAXMIN";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductListServlet() {
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
			ProductService productService = new ProductService();
			List<Category> categoryList = service.getAllCategories();
			String command;
			if (request.getParameter("command") != null) {
				command = request.getParameter("command");
			} else {
				command = "GET_ALL_PRODUCTS";

			}
			double maxPrice = productService.getMaxPrice();
			double minPrice = productService.getMinPrice();
			System.out.println("max" + maxPrice + "  min" + minPrice);

			List<Product> productListByDiscount = new ArrayList<Product>();
			productListByDiscount = productService.getDiscountProducts();
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productListByDiscount", productListByDiscount);
			request.setAttribute("maxPrice", maxPrice);
			request.setAttribute("minPrice", minPrice);

			List<Product> lastest10ProductList = new ArrayList<Product>();
			lastest10ProductList = productService.getLastestProduct();
			request.setAttribute("lastest10ProductList", lastest10ProductList);

			
			int currentPage = 1;
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			

			List<Product> productList = new ArrayList<Product>();
			productList = productService.getProductsByPage(currentPage);

			
			request.setAttribute("productListByCategoryId", productList);
			request.setAttribute("productListBySearch", productList);
			request.setAttribute("totalPage", ProductService.getTotalPage());
			switch (command) {
			case GET_PRODUCTS_BY_CATEGORY_ID: {
				getProductsByCategory(service, productService, request, response);
				return;
			}
			case GET_PRODUCTS_BY_SEARCH: {
				getProductBySearch(service, productService, request, response);
				return;
			}
			case GET_PRODUCTS_BY_MAXMIN: {
				getProductsByMaxMin(service, productService, request, response);
				return;
			}
			case GET_ALL_PRODUCTS: {
				getAllProducts(currentPage,service, productService, request, response);
				return;
			}
			/*
			 * default:{ getProductsByPage(currentPage, request, response); return; }
			 */

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductsByPage(String page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int currentPage = 1;
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			CategoryService service = new CategoryService();
			ProductService productService = new ProductService();
			List<Category> categoryList = service.getAllCategories();

			List<Product> productList = new ArrayList<Product>();
			productList = productService.getProductsByPage(currentPage);

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productListByCategoryId", productList);
			request.setAttribute("productListBySearch", productList);
			request.setAttribute("totalPage", ProductService.getTotalPage());
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllProducts(int currentPage,	CategoryService service, ProductService productService, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			List<Product> productList = new ArrayList<Product>();

			//productList = productService.getAllProducts();
			productList = productService.getProductsByPage(currentPage);

			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("shop-grid.jsp");

			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductsByMaxMin(CategoryService service, ProductService productService, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			String maxValue = request.getParameter("maxValue");
			String minValue = request.getParameter("minValue");
			List<Product> productList = new ArrayList<Product>();

			productList = productService.getProductsByMaxMin(maxValue, minValue);

			request.setAttribute("productList", productList);
			request.setAttribute("maxValue", maxValue);
			request.setAttribute("minValue", minValue);
			RequestDispatcher rd = request.getRequestDispatcher("shop-grid.jsp");

			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductsByCategory(CategoryService service, ProductService productService,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String categoryId = request.getParameter("categoryId");
			List<Product> productList = new ArrayList<Product>();
			productList = productService.getProductsByCategoryId(Integer.parseInt(categoryId));
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("shop-grid.jsp");

			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductBySearch(CategoryService service, ProductService productService, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String keyword = request.getParameter("keyword");

			List<Product> productList = new ArrayList<Product>();

			productList = productService.getProductsBySearch(keyword);
			request.setAttribute("keyword", keyword);
			request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("shop-grid.jsp");

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
