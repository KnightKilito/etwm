package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etcxm.www.entity.User;
import com.etcxm.www.service.ShopCarProductService;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.ShopCarProductServiceImpl;
import com.etcxm.www.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateaddress.ado")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAddressServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 所有转向jsp的servlet都要获取username避免页面显示名字异常,后期可扩展增加头像
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // 获取session
		String userId = session.getAttribute("userId").toString();
		String addresseename=request.getParameter("addresseename");
		String phonenumber=request.getParameter("phonenumber");
		String address=request.getParameter("address");
		int iuserId = Integer.parseInt(userId);
		request.setAttribute("userId", iuserId);
		UserService userService = new UserServiceImpl();
		User user = userService.findById(iuserId);
		user.setRealname(addresseename);
		user.setPhone(phonenumber);
		user.setAddress(address);
		
		userService.update(user);
		
		request.setAttribute("user", user);
		
		request.setAttribute("username", user.getRealname());
		String shopName = request.getParameter("shopName");
		request.setAttribute("shopName", shopName);
		ShopCarProductService shopCarProductService = new ShopCarProductServiceImpl();
		double totalPrice=shopCarProductService.settleShopCar(iuserId, shopName);
		request.setAttribute("totalPrice", totalPrice);

		request.getRequestDispatcher("settlement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
