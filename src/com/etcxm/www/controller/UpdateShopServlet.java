package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class UpdateShopServlet
 */
@WebServlet("/uptshop.do")
public class UpdateShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//实现更新的功能
//		request.setCharacterEncoding("utf-8");		//中文编码
		String shopName=request.getParameter("shopName");
		String id=request.getParameter("id");//shopid
		int iId=Integer.parseInt(id);
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
    	Shop shop=new Shop(iId,shopName,shopKeeper,address,connectPhone, dAvgPrice, shopPicFile, iShopStar);
		//提交更新
		boolean isok=shopService.update(shop);
		//根据结果进行跳转，提示。
		String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//成功
    		msg="修改店铺成功！";
    		url="allshopspage.do";		//跳转的是servlet地址。为了获取数据。
    		jumpUrl="view/success.jsp";
    	}else{	//失败
    		msg="修改店铺失败！";
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute保存属性，第一个参数是属性的名字，第二个参数是属性的值。
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
