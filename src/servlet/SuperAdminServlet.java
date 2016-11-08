package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;

import dao.SuperAdminDao;
import entity.Admin;
import entity.DealShopping;

public class SuperAdminServlet extends HttpServlet {

	private String action; // ��ʾ��������Ա����
	private SuperAdminDao superadmindao = new SuperAdminDao();// ��������Ա�߼���Ķ���
	/**
	 * Constructor of the object.
	 */
	public SuperAdminServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("delede")) // ɾ������Ա
			{
				if (deleteAdmin(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(
							request, response);
				}
			}
			if (action.equals("show"))  //��ȡ���й���Ա
			{
				request.getRequestDispatcher("#").forward(request,
						response);	
			}
			if(action.equals("add"))	//���ӹ���Ա
			{
				
				if (addAdmin(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(
								request, response);
				}
				
			}
			if(action.equals("change"))		//�༭����Ա
			{
				if (ChangeAdmin(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(
							request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(
								request, response);
				}
					
			}
	
		}
	}
	
	//ɾ������Ա
	private boolean deleteAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("admin_id");
		if (superadmindao.deleteAdminById(Integer.parseInt(id))) {
			return true;
		} else {
			return false;
		}
	}
	//���ӹ���Ա
	private boolean addAdmin(HttpServletRequest request,
			HttpServletResponse response) {
			
			Admin admin =new Admin();
			
			if (request.getParameter("admin_id") != null)
				admin.setAdminId(Integer.parseInt(request.getParameter("admin_id")));
			else
				return false;
			if (request.getParameter("admin_username") != null)
				admin.setAdminUsername(request.getParameter("admin_username"));
			else
				return false;
			if (request.getParameter("admin_password") != null)
				admin.setAdminPassword(request.getParameter("admin_password"));
			else
				return false;
			if (request.getParameter("admin_dep") != null)
				admin.setAdminDep(request.getParameter("admin_dep"));
			else
				return false;
			if (request.getParameter("admin_level") != null)
				admin.setAdminLevel(Integer.parseInt(request.getParameter("admin_level")));
			else
				return false;
			superadmindao.saveAdmin(admin, Constants.ADD_ADMIN);
			return true;
	}
	//�༭����Ա
	private boolean ChangeAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		Admin admin =new Admin();
		
		if (request.getParameter("admin_id") != null)
			admin.setAdminId(Integer.parseInt(request.getParameter("admin_id")));
		else
			return false;
		if (request.getParameter("admin_username") != null)
			admin.setAdminUsername(request.getParameter("admin_username"));
		else
			return false;
		if (request.getParameter("admin_password") != null)
			admin.setAdminPassword(request.getParameter("admin_password"));
		else
			return false;
		if (request.getParameter("admin_dep") != null)
			admin.setAdminDep(request.getParameter("admin_dep"));
		else
			return false;
		if (request.getParameter("admin_level") != null)
			admin.setAdminLevel(Integer.parseInt(request.getParameter("admin_level")));
		else
			return false;
		superadmindao.saveAdmin(admin, Constants.CHANGE_ADMIN);
		return true;

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
