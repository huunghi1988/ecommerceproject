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
 * Servlet implementation class Paging
 */
@WebServlet("/Paging")
public class Paging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paging() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
				
				RequestDispatcher rd = request.getRequestDispatcher("shop-grid.jsp");
				RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
				request.setAttribute("categoryList", categoryList);
				request.setAttribute("productListByCategoryId", productList);
				request.setAttribute("productListBySearch", productList);
				request.setAttribute("totalPage", productService.getTotalPage());
				request.setAttribute("currentPage", currentPage);
				rd.forward(request, response);
				rd1.forward(request, response);
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
