package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.DealShoppingDao;
import entity.Comment;
import entity.DealShopping;
import entity.Product;
import entity.Users;

public class CommentServlet extends HttpServlet {

	private String action; // ��ʾ�����Ķ��� ,add,show,delete
	private CommentDao commentDao = new CommentDao();// ����ҵ���߼���Ķ���
	private DealShoppingDao dealDao = new DealShoppingDao();// ��Ʒҵ���߼���Ķ���

	/**
	 * Constructor of the object.
	 */
	public CommentServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) // ������������
			{
				if (addComment(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(
							request, response);
				}
			}
			/*
			 * if (action.equals("show"))// �������ʾ���� {
			 * request.getRequestDispatcher("/.jsp").forward(request, response);
			 * }
			 */
		}

	}

	// ������۵ķ���
	private boolean addComment(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = null;
		String productName = null;
		Comment comment = new Comment();
		comment.setComment_date(new Date());
		if (request.getParameter("comment_content") != null) {
			comment.setComment_content(request.getParameter("comment_content"));
		}
		if (request.getParameter("comment_degree") != null) {
			comment.setComment_degree(request.getParameter("comment_degree"));
		}
		if (request.getParameter("user_name") != null) {
			userName = request.getParameter("user_name");
		}
		if (request.getParameter("product_name") != null) {
			productName = request.getParameter("product_name");
		}
		if (dealDao.DealComment(userName, productName, comment)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
