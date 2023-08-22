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
 * Servlet implementation class Home1
 */
@WebServlet("/Home1")
public class Home1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String REQUEST_FROM_CATEGORYID = "GetProductsByCategoryId";
	private final String REQUEST_FROM_SEARCH = "SEARCH";
	private final String REQUEST_FROM_PAGE= "PAGE";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String categoryId = request.getParameter("categoryId");
			String command = request.getParameter("Command");
			String keyword = request.getParameter("keyword");
			String page = request.getParameter("page");
		
			
			switch (command) {
			case REQUEST_FROM_CATEGORYID:{
				getProductsByCategoryId(categoryId,request,response);
				return;
			}case REQUEST_FROM_SEARCH:{
				getProductsBySearch(keyword,request,response);
				return;
			}case REQUEST_FROM_PAGE:{
				getProductsByPage(page,request,response);
			}
			}
		}
		
			catch(NumberFormatException e) {
				e.printStackTrace();
			}
		
		}
	public void getProductsByCategoryId(String categoryId,HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
	
		try {
			CategoryService service = new CategoryService();
			ProductService productService  = new ProductService();
			List<Category> categoryList = service.getAllCategories();
			List<Product> productList  = new ArrayList<Product>();
			if(categoryId!=null) {
				productList= productService.getProductsByCategoryId(Integer.parseInt(categoryId));
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productListByCategoryId", productList);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getProductsBySearch(String keyword,HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		try{
			ProductService productService  = new ProductService();
			CategoryService service = new CategoryService();
		
			List<Category> categoryList = service.getAllCategories();
			List<Product> productList  = new ArrayList<Product>();
			if(keyword != null && !keyword.isEmpty()) {
				productList = productService.getProductsBySearch(keyword);
			}
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("categoryList", categoryList);
				request.setAttribute("productListByCategoryId", productList);
				request.setAttribute("productListBySearch", productList);
				rd.forward(request, response);
				System.out.println(keyword + " " );
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void getProductsByPage(String page,HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		try {
			int currentPage =1;
			if(request.getParameter("page") !=null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			CategoryService service = new CategoryService();
			ProductService productService  = new ProductService();
			List<Category> categoryList = service.getAllCategories();
			
			List<Product> productList  = new ArrayList<Product>();
			productList= productService.getProductsByPage(currentPage); 
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productListByCategoryId", productList);
			request.setAttribute("productListBySearch", productList);
			request.setAttribute("totalPage", ProductService.getTotalPage());
			rd.forward(request, response);
		}
		 catch (Exception e) {
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
