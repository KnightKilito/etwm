package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etcxm.www.entity.User;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.ado")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
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
		try {

			// 所有转向jsp的servlet都要获取username避免页面显示名字异常,后期可扩展增加头像
			HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
			HttpSession session = httpServletRequest.getSession(); // 获取session
			String userId = session.getAttribute("userId").toString();

			// System.out.println("username:" + user.getRealname());
			session.removeAttribute("userId");//删除数据

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("allShop.do").forward(request, response);
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
