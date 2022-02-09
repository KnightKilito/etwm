package com.etcxm.www.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;
import com.etcxm.www.utils.DBUtil;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add.do")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		String shopName=request.getParameter("shopName");		//��ȡshopName
		request.setAttribute("shopName", shopName);
		//�ò���,opadd.jsp�л�ȡ��������һ�µġ�
		String shopproductName=request.getParameter("productName");
    	String shopproductPrice=request.getParameter("productPrice");
    	//תΪDouble
    	double dshopProductPrice=Double.parseDouble(shopproductPrice);
    	String productIntroduction=request.getParameter("productIntroduction");
    	String productPicFile=request.getParameter("productPicFile");
    	String productStar=request.getParameter("productStar");
    	double iproductStar=Double.parseDouble(productStar);

    	//ʵ��һ��Entity��Product
    	ShopProduct product=new ShopProduct(null, shopproductName, dshopProductPrice, productIntroduction,productPicFile,iproductStar,null,null,null,null,null,null);
    	
    	ShopProductService productService=new ShopProductServiceImpl();
    	boolean isok = productService.add(shopName,product);
    	
    	String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//�ɹ�
    		msg="������Ʒ�ɹ���";
    		url="allpage.do";		//��ת����servlet��ַ��Ϊ�˻�ȡ���ݡ�
    		jumpUrl="view/success.jsp";
    	}else{	//ʧ��
    		msg="������Ʒʧ�ܣ�";
    		
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute�������ԣ���һ�����������Ե����֣��ڶ������������Ե�ֵ��
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
    	
	
	}

}
