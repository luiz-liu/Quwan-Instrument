package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import entity.Cart;
import entity.Product;
import entity.Users;

public class CartServlet extends HttpServlet {

	private String action ; //��ʾ���ﳵ�Ķ��� ,add,show,delete
	//��Ʒҵ���߼���Ķ���
	private ProductDao pdao = new ProductDao();
	
	Users loginUser = null;
	
	public CartServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		

		if(request.getSession().getAttribute("user") != null)
		{
			loginUser = (Users)request.getSession().getAttribute("user");
		}
		
		if(request.getParameter("action")!=null)
		{
			this.action = request.getParameter("action");
			if(action.equals("add")) //����������Ʒ�����ﳵ
			{
				if(addToCart(request,response))
				{
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			if (action.equals("update"))
			{
				Cart cart = (Cart)request.getSession().getAttribute("cart");
				int num = Integer.parseInt(request.getParameter("num"));
				String id = request.getParameter("id");
				if (cart.updateCart(num, id, loginUser))
				{
					response.sendRedirect(request.getContextPath() + "/cart.jsp");
				}
			}
			if(action.equals("delete"))//�����ɾ�����ﳵ
			{
				deleteFromCart(request, response);			
				response.sendRedirect(request.getContextPath() + "/cart.jsp");
			}
		}
		
	}

	//�����Ʒ�����ﳵ�ķ���
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Product product = pdao.findProductById(id);
		
		//�Ƿ��ǵ�һ�θ����ﳵ�����Ʒ,��Ҫ��session�д���һ���µĹ��ﳵ����
		if(request.getSession().getAttribute("cart")==null)
		{
			Cart cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart.addProductInCart(product, Integer.parseInt(number), loginUser))
		{
			System.out.println("true");
			return true;		
		}
		else
		{
			System.out.println("false");
			return false;
		}
		
	}
	
	//�ӹ��ﳵ��ɾ����Ʒ
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
	    Product product = pdao.findProductById(id);
	    if(cart.removeProductFromCart(product, loginUser))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
