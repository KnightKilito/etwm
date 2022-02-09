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
import com.etcxm.www.entity.User;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.ShopServiceImpl;
import com.etcxm.www.service.impl.UserServiceImpl;

/**
 * Servlet implementation class SearchShopsServlet
 */
@WebServlet("/allshopcar.ado")
public class AllShopsCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllShopsCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iPageNum = 1; // 初始化页面为第一页。
		int iPageSize = 8;
		String searchName = request.getParameter("search");
		String pageNum = request.getParameter("pageNum"); // 请求第几页
		String pageSize = request.getParameter("pageSize"); // 每页大小
		// 所有转向jsp的servlet都要获取username避免页面显示名字异常,后期可扩展增加头像
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // 获取session
		String userId = session.getAttribute("userId").toString();
		int iuserId = Integer.parseInt(userId);
		request.setAttribute("userId", iuserId);
		UserService userService = new UserServiceImpl();
		User user = userService.findById(iuserId);
		request.setAttribute("username", user.getRealname());
		

		try {
			if(pageNum!=null)iPageNum = Integer.parseInt(pageNum); // 把字符串强制转换为整数
			if(pageSize!=null)iPageSize = Integer.parseInt(pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (iPageNum < 1)
			iPageNum = 1; // 检查页数，不能低于第1页。
		ShopService shopService = new ShopServiceImpl();
		int allCount = 0;

		if (searchName == null) {
			List<Shop> list = shopService.findAllShopByPage(iPageNum, iPageSize);
			request.setAttribute("list", list);
			request.setAttribute("currPage", iPageNum); // 把当前请求的页面写入到request中

			// 获取总共多少条记录
			allCount = shopService.count();

		} else {
			List<Shop> list = shopService.findByShopNamePage(searchName, iPageNum, iPageSize);
			request.setAttribute("list", list);
			request.setAttribute("currPage", iPageNum); // 把当前请求的页面写入到request中

			allCount = shopService.countFindByShopName(searchName);

		}
		request.setAttribute("allCount", allCount);
		// 计算总共多少页
		int allPage = 1;
		if (allCount % iPageSize > 0) {
			allPage = allCount / iPageSize + 1;
		} else {
			allPage = allCount / iPageSize;
		}

		request.setAttribute("searchName", searchName);
		request.setAttribute("allPage", allPage);
		// 把每页多少写入到request中，发送到jsp里面
		request.setAttribute("pageSize", iPageSize);
		request.getRequestDispatcher("chooseshopcar.jsp").forward(request, response);

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
