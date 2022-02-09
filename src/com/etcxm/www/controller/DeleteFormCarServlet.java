package com.etcxm.www.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.service.ShopCarProductService;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopCarProductServiceImpl;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class AddToCarServlet
 */
@WebServlet("/deletefromcar.ado")
public class DeleteFormCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFormCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从购物车删除产品
		String shopCarProductId = request.getParameter("shopCarProductId");//获取该产品在购物车中的序号然后删除
		int ishopCarProductId = Integer.parseInt(shopCarProductId);
		ShopCarProductService shopCarProductService = new ShopCarProductServiceImpl();

		String shopId = request.getParameter("shopId");
		int ishopId=Integer.parseInt(shopId);
		ShopService shopService=new ShopServiceImpl();
		Shop shop = shopService.findById(ishopId);
		String shopName=shop.getShopName();
		
		
		//request.setAttribute("shopName", shopName);
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // 获取session
		String userId = session.getAttribute("userId").toString();
		int iuserId=Integer.parseInt(userId);
		//request.setAttribute("username", username);
		boolean deleteok = shopCarProductService.delete(iuserId, shopName, ishopCarProductId);
		//System.out.println("deleteok:"+deleteok);
		response.sendRedirect("showshopcar.ado?userId="+iuserId+"&shopId="+shopId);
		//待解决，sendRedirect只能传固定参数，传对象地址太复杂
		//已解决，只要这个界面传过去就行，showshopcar.ado照样用request
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
