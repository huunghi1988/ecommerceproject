package coding.ecommerceproject.servlet;

import java.io.IOException;
import java.util.List;

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
			CategoryService categoryService = new CategoryService();
			List<Category> categoryList = categoryService.getBooksByCategory();
			
			BookService bookService = new BookService();
			List<Book> bookList1= new ArrayList<Book>();
			
			bookList1=bookService.getAllBooks();
			
			int page, numPerPage=3;
			int size = bookList1.size();
			int num=(size%3==0? (size/3):((size/3))+1);
			String xpage=request.getParameter("page");
			if(xpage==null) {
				page=1;
			}else {
				page=Integer.parseInt(xpage);
			}
			int start, end;
			start=(page-1)*numPerPage;
			end=Math.min(page*numPerPage,size);
			List<Book> list=bookService.getListByPage(bookList1,start,end);
			
			RequestDispatcher rd =request.getRequestDispatcher("paging.jsp");
			//request.setAttribute("categoryList", categoryList);
			request.setAttribute("bookList",list);
			request.setAttribute("page", page);
			request.setAttribute("num", num);
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
