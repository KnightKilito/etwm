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

		//设置编码
//		request.setCharacterEncoding("utf-8");
		String shopName=request.getParameter("shopName");		//获取shopName
		request.setAttribute("shopName", shopName);
		//拿参数,opadd.jsp中获取参数，是一致的。
		String shopproductName=request.getParameter("productName");
    	String shopproductPrice=request.getParameter("productPrice");
    	//转为Double
    	double dshopProductPrice=Double.parseDouble(shopproductPrice);
    	String productIntroduction=request.getParameter("productIntroduction");
    	String productPicFile=request.getParameter("productPicFile");
    	String productStar=request.getParameter("productStar");
    	double iproductStar=Double.parseDouble(productStar);

    	//实例一个Entity：Product
    	ShopProduct product=new ShopProduct(null, shopproductName, dshopProductPrice, productIntroduction,productPicFile,iproductStar,null,null,null,null,null,null);
    	
    	ShopProductService productService=new ShopProductServiceImpl();
    	boolean isok = productService.add(shopName,product);
    	
    	String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//成功
    		msg="新增产品成功！";
    		url="allpage.do";		//跳转的是servlet地址。为了获取数据。
    		jumpUrl="view/success.jsp";
    	}else{	//失败
    		msg="新增产品失败！";
    		
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute保存属性，第一个参数是属性的名字，第二个参数是属性的值。
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
    	
	
	}

}
