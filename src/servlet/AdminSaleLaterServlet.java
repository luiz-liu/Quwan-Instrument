package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SaleBeforeDao;
import dao.SaleLaterDao;
import entity.SaleBefore;
import entity.SaleLater;

public class AdminSaleLaterServlet extends HttpServlet {
	
	private String action; // ��ʾ��������Ա����
	private SaleLaterDao  salelaterdao= new SaleLaterDao();// �ۺ�����߼���Ķ���
	/**
	 * Constructor of the object.
	 */
	public AdminSaleLaterServlet() {
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
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			System.out.println(request.getParameter("action"));
			if(action.equals("show")) //��ȡ�����ۺ��������
			{
				request.getRequestDispatcher("#").forward(request,
						response);
			}
			if(action.equals("handle")) //�Ѵ����ۺ��������
			{
				if (SaleLaterHandle(request, response)) {
					request.getRequestDispatcher("#").forward(request,
							response);
				} else {
					request.getRequestDispatcher("#").forward(request,
							response);
			}
			}
			if(action.equals("select1")) //�����ۺ��������
			{
				if (SaleLaterSelect(request, response)) {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
				} else {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
				}
			}
			if(action.equals("delete")) //ɾ���ۺ��������
			{
				if (SaleLaterDelete(request, response)) {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
				} else {
					request.getRequestDispatcher("../ServerManage.jsp").forward(request,
							response);
			}
			
			}
		}
	}


	//ɾ���ۺ�����
	private boolean SaleLaterDelete(HttpServletRequest request,
		HttpServletResponse response) {
		String id = request.getParameter("salelater_id");
		if(salelaterdao.deleteSaleLater(Integer.parseInt(id))){
		return true;
		}else
			return false;
	}	
	//�Ѵ����ۺ�����
	private boolean SaleLaterHandle(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("salelater_id");
		if (salelaterdao.changeSalerLaterBit(Integer.parseInt(id))) {
			return true;
		} else {
			return false;
		}
	}	
	//�����ۺ�����
		private boolean SaleLaterSelect(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
			List<SaleLater> salelaterlist;
			System.out.println(request.getParameter("select1"));
			if(salelaterdao.getSaleLaterByService(request.getParameter("select1"))!=null){
				salelaterlist = salelaterdao.getSaleLaterByService(request.getParameter("select1"));
				System.out.println(salelaterlist);
			request.getSession().setAttribute("salelaterlist", salelaterlist);
			return true;
			}return false;
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
