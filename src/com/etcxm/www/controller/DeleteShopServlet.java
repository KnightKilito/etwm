package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class DelectShopServlet
 */
@WebServlet("/delshop.do")
public class DeleteShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ShopService shopService=new ShopServiceImpl();
		String id=request.getParameter("id");		//��ȡid
		boolean isok=false;
		//���ַ���idת������
		try {
			int iId=Integer.parseInt(id);
			isok=shopService.delete(iId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//�ɹ�
    		msg="ɾ�����̳ɹ���";
    		url="allshopspage.do";		//��ת����servlet��ַ��Ϊ�˻�ȡ���ݡ�
    		jumpUrl="view/success.jsp";
    	}else{	//ʧ��
    		msg="ɾ������ʧ�ܣ�";
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute�������ԣ���һ�����������Ե����֣��ڶ������������Ե�ֵ��
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
