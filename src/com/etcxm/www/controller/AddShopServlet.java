package com.etcxm.www.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class AddShopServlet
 */
@WebServlet("/addshops.do")
public class AddShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//���ñ���
//		request.setCharacterEncoding("utf-8");
		//�ò���,opadd.jsp�л�ȡ��������һ�µġ�
		String shopName=request.getParameter("shopName");
    	String shopKeeper=request.getParameter("shopKeeper");
    	String address=request.getParameter("address");
    	String connectPhone=request.getParameter("connectPhone");
    	String avgPrice=request.getParameter("avgPrice");
    	double dAvgPrice=Double.parseDouble(avgPrice);
    	String shopPicFile=request.getParameter("shopPicFile");
    	String shopStar=request.getParameter("shopStar");
    	double iShopStar=Double.parseDouble(shopStar);
    	//ʵ��һ��Entity��Product
    	ShopService shopService=new ShopServiceImpl();
    	Shop shop=new Shop(null,shopName,shopKeeper,address,connectPhone, dAvgPrice, shopPicFile, iShopStar);
    	
    	boolean isok = shopService.add(shop);
    	
    	String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//�ɹ�
    		msg="�������̳ɹ���";
    		url="allshopspage.do";		//��ת����servlet��ַ��Ϊ�˻�ȡ���ݡ�
    		jumpUrl="view/success.jsp";
    	}else{	//ʧ��
    		msg="��������ʧ�ܣ�";
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute�������ԣ���һ�����������Ե����֣��ڶ������������Ե�ֵ��
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
    	
	
	}

}
