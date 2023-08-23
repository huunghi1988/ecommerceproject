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
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private final String RENDER_HOME_PAGE = "getProductsAndCategoriesForHomePage";
	//private final String REQUEST_FROM_SEARCH = "SEARCH";
	// private final String REQUEST_FROM_PAGE = "PAGE";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
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
			String categoryId = request.getParameter("categoryId");
			CategoryService service = new CategoryService();
			ProductService productService = new ProductService();
			
			List<Category> categoryList = service.getAllCategories();
			List<Product> productListByCategoryId = new ArrayList<Product>();
			
			if (categoryId == null) {
				//GET ALL PRODUCTS 
				productListByCategoryId = productService.getAllProducts();

			} else {
				//GET PRODUCTS BY CATEGORY

				productListByCategoryId = productService.getProductsByCategoryId(Integer.parseInt(categoryId));
			}
			
			
			//GET LASTEST 10 PRODUCT FOR HOME PAGE
			List<Product> lastest10ProductList= new ArrayList<Product>();
			lastest10ProductList=productService.getLastestProduct();
			
			//GET LASTEST DISCOUNT PRODUCT FOR HOME PAGE
			List<Product> discountProductsList= new ArrayList<Product>();
			discountProductsList=productService.getDiscountProducts();
			
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("lastest10ProductList", lastest10ProductList);
			request.setAttribute("discountProductsList", discountProductsList);

			request.setAttribute("productListByCategoryId", productListByCategoryId);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void getProductsAndCategoriesForHomePage(String categoryId,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * ServletException, IOException {
	 * 
	 * try { CategoryService service = new CategoryService(); ProductService
	 * productService = new ProductService(); List<Category> categoryList =
	 * service.getAllCategories(); List<Product> productListByCategoryId = new
	 * ArrayList<Product>(); List<Product> lastest10ProductList= new
	 * ArrayList<Product>(); List<Product> discountProductsList= new
	 * ArrayList<Product>();
	 * 
	 * lastest10ProductList=productService.getLastestProduct();
	 * discountProductsList=productService.getDiscountProducts();
	 * 
	 * if (categoryId == null) { productListByCategoryId =
	 * productService.getAllProducts();
	 * System.out.println(productListByCategoryId.size());
	 * 
	 * } else { productListByCategoryId =
	 * productService.getProductsByCategoryId(Integer.parseInt(categoryId)); }
	 * 
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	 * request.setAttribute("categoryList", categoryList);
	 * request.setAttribute("lastest10ProductList", lastest10ProductList);
	 * request.setAttribute("discountProductsList", discountProductsList);
	 * 
	 * request.setAttribute("productListByCategoryId", productListByCategoryId);
	 * rd.forward(request, response); } catch (Exception e) { e.printStackTrace(); }
	 * }
	 */
//no need, use ProductListService
	/*
	 * public void getProductsBySearch(String keyword, HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try {
	 * ProductService productService = new ProductService(); CategoryService service
	 * = new CategoryService();
	 * 
	 * List<Category> categoryList = service.getAllCategories(); List<Product>
	 * productList = new ArrayList<Product>(); if (keyword != null &&
	 * !keyword.isEmpty()) { productList =
	 * productService.getProductsBySearch(keyword); } RequestDispatcher rd =
	 * request.getRequestDispatcher("shop-grid.jsp");
	 * request.setAttribute("categoryList", categoryList);
	 * request.setAttribute("productListByCategoryId", productList);
	 * request.setAttribute("productListBySearch", productList); rd.forward(request,
	 * response); System.out.println(keyword + " ");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
	
	
	
	
	/*
	 * public void getProductsByPage(String page,HttpServletRequest request,
	 * HttpServletResponse response )throws ServletException, IOException { try {
	 * int currentPage =1; if(request.getParameter("page") !=null) { currentPage =
	 * Integer.parseInt(request.getParameter("page")); } CategoryService service =
	 * new CategoryService(); ProductService productService = new ProductService();
	 * List<Category> categoryList = service.getAllCategories();
	 * 
	 * List<Product> productList = new ArrayList<Product>(); productList=
	 * productService.getProductsByPage(currentPage);
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	 * request.setAttribute("categoryList", categoryList);
	 * request.setAttribute("productListByCategoryId", productList);
	 * request.setAttribute("productListBySearch", productList);
	 * request.setAttribute("totalPage", ProductService.getTotalPage());
	 * rd.forward(request, response); } catch (Exception e) { e.printStackTrace(); }
	 * }
	 */

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
