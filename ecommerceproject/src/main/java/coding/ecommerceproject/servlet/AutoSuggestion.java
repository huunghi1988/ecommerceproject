package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
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
import coding.ecommerceproject.service.LoginService;
import coding.ecommerceproject.service.ProductService;
import coding.ecommerceproject.service.AutoSuggestionService;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/AutoSuggession")
public class AutoSuggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoSuggestion() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			AutoSuggestionService keywordService = new AutoSuggestionService();
			
			String keyword = request.getParameter("itemsPerPage");
			int totalPage;
			
			BigDecimal maxPrice = productService.getMaxPrice();
			BigDecimal minPrice = productService.getMinPrice();
			System.out.println("max" + maxPrice + "  min" + minPrice);
//get all
			List<Category> categoryList = service.getAllCategories();
			String categoryId = request.getParameter("categoryId");

			List<Product> productListByCategoryId = new ArrayList<Product>();
			if (categoryId == null) {
				productListByCategoryId = productService.getAllProducts();
				//totalPage=(int) Math.ceil((double)productListByCategoryId.size()/Integer.parseInt(itemsPerPage));
				
			} else {
				productListByCategoryId = productService.getProductsByCategoryId(Integer.parseInt(categoryId));
				//totalPage=(int) Math.ceil((double)productListByCategoryId.size()/Integer.parseInt(itemsPerPage));

			}

//by keyword
			String keyword = request.getParameter("keyword");
			List<Product> productListBySearch = new ArrayList<Product>();

			if (keyword != null && !keyword.isEmpty()) {
				productListBySearch = productService.getProductsBySearch(keyword);
				//totalPage=(int) Math.ceil((double)productListBySearch.size()/Integer.parseInt(itemsPerPage));
				

				request.setAttribute("keyword", keyword);
			}
// by sort  max min
			String maxValue = request.getParameter("maxValue");
			String minValue = request.getParameter("minValue");
			List<Product> productListByMaxMin = new ArrayList<Product>();

			if (maxValue != null && !maxValue.isEmpty()) {
				productListByMaxMin = productService.getProductsByMaxMin(maxValue,
						minValue);
			}

//discountProduct
			List<Product> productListByDiscount = new ArrayList<Product>();
			productListByDiscount = productService.getDiscountProducts();
			
			//paging
			
			
		

			RequestDispatcher rd = request.getRequestDispatcher("shop-grid.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productListByCategoryId", productListByCategoryId);
			request.setAttribute("productListBySearch", productListBySearch);
			request.setAttribute("productListByDiscount", productListByDiscount);

			request.setAttribute("maxValue", maxValue);
			request.setAttribute("minValue", minValue);
			request.setAttribute("maxPrice", maxPrice);
			request.setAttribute("minPrice", minPrice);
			request.setAttribute("productListByMaxMin", productListByMaxMin);
			//request.setAttribute("totalPage", totalPage);
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
