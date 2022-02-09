package com.etcxm.www.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello")			//����ע��ķ�ʽ��������ӳ���ַ,Web3.1
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        System.out.println("HelloServlet ��ʵ���ˣ�");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("HelloServlet ����ʼ����");
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("HelloServlet �������ˣ�");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("<html>\r\n");
		response.getWriter().append("<head>\r\n");
		response.getWriter().append("<title>���</title>\r\n");
		response.getWriter().append("<meta charset=\"utf-8\">");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("���");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
		System.out.println("doGet�����������ˣ�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
