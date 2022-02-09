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

		//设置编码
//		request.setCharacterEncoding("utf-8");
		//拿参数,opadd.jsp中获取参数，是一致的。
		String shopName=request.getParameter("shopName");
    	String shopKeeper=request.getParameter("shopKeeper");
    	String address=request.getParameter("address");
    	String connectPhone=request.getParameter("connectPhone");
    	String avgPrice=request.getParameter("avgPrice");
    	double dAvgPrice=Double.parseDouble(avgPrice);
    	String shopPicFile=request.getParameter("shopPicFile");
    	String shopStar=request.getParameter("shopStar");
    	double iShopStar=Double.parseDouble(shopStar);
    	//实例一个Entity：Product
    	ShopService shopService=new ShopServiceImpl();
    	Shop shop=new Shop(null,shopName,shopKeeper,address,connectPhone, dAvgPrice, shopPicFile, iShopStar);
    	
    	boolean isok = shopService.add(shop);
    	
    	String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//成功
    		msg="新增店铺成功！";
    		url="allshopspage.do";		//跳转的是servlet地址。为了获取数据。
    		jumpUrl="view/success.jsp";
    	}else{	//失败
    		msg="新增店铺失败！";
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute保存属性，第一个参数是属性的名字，第二个参数是属性的值。
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
    	
	
	}

}
