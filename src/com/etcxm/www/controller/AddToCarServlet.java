package com.etcxm.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopCarProductService;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopCarProductServiceImpl;
import com.etcxm.www.service.impl.ShopProductServiceImpl;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class AddToCarServlet
 */
@WebServlet("/addtocar.ado")
public class AddToCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 添加产品到购物车
		String productId = request.getParameter("productId");
		int iproductId = Integer.parseInt(productId);
		ShopProductService shopProductService = new ShopProductServiceImpl();
		
		String shopId = request.getParameter("shopId");
		int ishopId=Integer.parseInt(shopId);
		ShopService shopService=new ShopServiceImpl();
		Shop shop = shopService.findById(ishopId);
		String shopName=shop.getShopName();
		
		ShopProduct shopProduct = shopProductService.findById(shopName, iproductId);
		ShopCarProductService shopCarProductService = new ShopCarProductServiceImpl();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // 获取session
		String userId = session.getAttribute("userId").toString();
		int iuserId=Integer.parseInt(userId);
		//往数据库添加产品信息
		shopCarProductService.add(iuserId, shopName, shopProduct);
		//跳转到专门的showshopcar.ado，它会专门再次读取数据库里的东西展示出来
		response.sendRedirect("showshopcar.ado?userId="+iuserId+"&shopId="+shopId);
		//request.getRequestDispatcher("showshopcar.ado").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
