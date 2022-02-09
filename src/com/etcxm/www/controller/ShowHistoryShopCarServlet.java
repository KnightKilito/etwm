package com.etcxm.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.entity.User;
import com.etcxm.www.service.ShopCarProductService;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.ShopCarProductServiceImpl;
import com.etcxm.www.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowShopCarServlet
 */
@WebServlet("/showhistoryshopcar.ado")
public class ShowHistoryShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowHistoryShopCarServlet() {
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
		String shopName = request.getParameter("shopName");
		request.setAttribute("shopName", shopName);
		//����ת��jsp��servlet��Ҫ��ȡusername����ҳ����ʾ�����쳣,���ڿ���չ����ͷ��
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // ǿ��ת������ΪHttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // ��ȡsession
		String userId = session.getAttribute("userId").toString();
		int iuserId=Integer.parseInt(userId);
		request.setAttribute("userId", iuserId);
		UserService userService=new UserServiceImpl();
		User user=userService.findById(iuserId);
		request.setAttribute("username", user.getRealname());
		
		
		ShopCarProductService shopCarProductService = new ShopCarProductServiceImpl();
		// �����Ҫ�������й��ﳵ�ڵĶ���Ȼ��չʾ����
		List<ShopProduct> list = shopCarProductService.findAllHistory(iuserId, shopName);
		request.setAttribute("list", list);
		// ��ȡ�ܹ���������¼
		int allCount = shopCarProductService.countHistory(iuserId, shopName);
		request.setAttribute("allCount", allCount);
		request.getRequestDispatcher("historyshopcar.jsp").forward(request, response);
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
