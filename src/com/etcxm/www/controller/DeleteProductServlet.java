package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/del.do")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShopProductService productService=new ShopProductServiceImpl();
		String shopName=request.getParameter("shopName");		//��ȡshopName
		request.setAttribute("shopName", shopName);
		//��ȡid
		String id=request.getParameter("id");
		request.setAttribute("id", id);
		
		boolean isok=false;
		//���ַ���idת������
		try {
			int iId=Integer.parseInt(id);
			isok=productService.delete(shopName, iId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//�ɹ�
    		msg="ɾ����Ʒ�ɹ���";
    		url="allpage.do?shopName="+shopName;		//��ת����servlet��ַ��Ϊ�˻�ȡ���ݡ�
    		jumpUrl="view/success.jsp";
    	}else{	//ʧ��
    		msg="ɾ����Ʒʧ�ܣ�";
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
