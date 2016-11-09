package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Properties;
import dao.SaleBeforeDao;
import dao.VipAdminDao;
import entity.SaleBefore;


public class AdminSaleBeforeServlet extends HttpServlet {

	private String action; // ��ʾ��������Ա����
	private SaleBeforeDao  salebeforedao= new SaleBeforeDao();// ��ǰ�����߼���Ķ���
	
	/**
	 * Constructor of the object.
	 */
	public AdminSaleBeforeServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if(action.equals("show")) //��ȡ������ǰ��������
			{
				request.getRequestDispatcher("#").forward(request,
						response);
			}
			if(action.equals("select")) //����������ǰ��������
			{
				
				if (SaleBeforeSelect(request, response)) {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
				} else {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
			}
			}
			if(action.equals("delete")) //ɾ����ǰ��������
			{
				if (SaleBeforeDelete(request, response)) {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
				} else {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
			}	
			}
			}
		}
		
	
	
	//������ǰ����
	private boolean SaleBeforeSelect(HttpServletRequest request,
		HttpServletResponse response) throws UnsupportedEncodingException {
		List<SaleBefore> salebeforelist;
		System.out.println(request.getParameter("select"));
		if(salebeforedao.getSaleBeforeByService(request.getParameter("select"))!=null){
			salebeforelist = salebeforedao.getSaleBeforeByService(request.getParameter("select"));
		request.getSession().setAttribute("salebeforelist", salebeforelist);
		return true;
		}return false;
	}	 
	//ɾ����ǰ����
	private boolean SaleBeforeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("salebefore_id");
		if (salebeforedao.deleteSaleBefore(Integer.parseInt(id))) {
			return true;
		} else {
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
