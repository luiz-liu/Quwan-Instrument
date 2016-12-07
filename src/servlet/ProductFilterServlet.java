package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

import entity.Product;

public class ProductFilterServlet extends HttpServlet {

	public ProductFilterServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		
		// ��ȡ�������
		String search = request.getParameter("search");
		String type = request.getParameter("type");
		String size = request.getParameter("size");
		String level = request.getParameter("level");
		String action = request.getParameter("action");
		
		// session�б���ɸѡ������ֵ�Լ���
		if(request.getSession().getAttribute("pro") == null)
		{
			Properties pro = new Properties();
			request.getSession().setAttribute("pro",pro);			
		}
		
		Properties pro = (Properties)request.getSession().getAttribute("pro");
		
		// ����
		if (action.equals("query"))
		{
			pro.clear();
			// System.out.println(search);
			pro.setProperty("product_name", new String(search.getBytes("ISO-8859-1"), "utf-8"));
		}
		
		// ɸѡ
		if (action.equals("filter"))
		{
			if (type != null) // ��Ʒ����
			{
				pro.setProperty("product_type", new String(type.getBytes("ISO-8859-1"), "utf-8"));
				if (type.equals("all"))
				{
					pro.clear();
					pro.setProperty("product_name", " ");
				}					
			}
			
			if (size != null) // ��Ʒ�ߴ�
			{
				pro.setProperty("product_size", new String(size.getBytes("ISO-8859-1"), "utf-8"));
				if (size.equals("all"))
					pro.remove("product_size");
			}
			
			if (level != null) // ���ö���
			{
				pro.setProperty("product_level", new String(level.getBytes("ISO-8859-1"), "utf-8"));
				if (level.equals("all"))
					pro.remove("product_level");
			}
		}
		
		request.getSession().setAttribute("pro",pro);
		response.sendRedirect(request.getContextPath() + "/search.jsp");
		
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
