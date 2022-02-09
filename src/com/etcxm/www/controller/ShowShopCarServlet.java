package com.etcxm.www.controller;

import java.awt.Window;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.entity.User;
import com.etcxm.www.service.ShopCarProductService;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.ShopCarProductServiceImpl;
import com.etcxm.www.service.impl.ShopServiceImpl;
import com.etcxm.www.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowShopCarServlet
 */
@WebServlet("/showshopcar.ado")
public class ShowShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowShopCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");

//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String category = request.getParameter("shopName");
//		String shopName = new String(category.getBytes("iso-8859-1"), "utf-8");
//		System.out.println("shopName"+shopName);
		
		String shopId = request.getParameter("shopId");
		int ishopId = Integer.parseInt(shopId);
		ShopService shopService = new ShopServiceImpl();
		Shop shop = shopService.findById(ishopId);
		String shopName = shop.getShopName();
		request.setAttribute("shopName", shopName);
		request.setAttribute("shop", shop);

		// System.out.println(shopName1);
		// String shopName = null;
		// shopName = URLDecoder.decode(shopName, "utf-8");
		
		// 所有转向jsp的servlet都要获取username避免页面显示名字异常,后期可扩展增加头像
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // 获取session
		String userId = session.getAttribute("userId").toString();
		int iuserId = Integer.parseInt(userId);
		request.setAttribute("userId", iuserId);
		UserService userService = new UserServiceImpl();
		User user = userService.findById(iuserId);
		request.setAttribute("username", user.getRealname());

		ShopCarProductService shopCarProductService = new ShopCarProductServiceImpl();
		// 添加完要查找所有购物车内的东西然后展示出来
		List<ShopProduct> list = shopCarProductService.findAll(iuserId, shopName);
		request.setAttribute("list", list);
		// 获取总共多少条记录
		int allCount = shopCarProductService.count(iuserId, shopName);
		request.setAttribute("allCount", allCount);
		request.getRequestDispatcher("shopcar.jsp").forward(request, response);

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
