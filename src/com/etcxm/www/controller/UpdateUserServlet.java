package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.User;
import com.etcxm.www.service.UserService;
import com.etcxm.www.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateuser.ado")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String picFile = request.getParameter("picFile");
		String id = request.getParameter("userId");
		
		int iId = Integer.parseInt(id);
		//System.out.println("updateadoid:"+iId);
		
		User user = new User(iId, username, password, realname, phone, type, address, null, picFile);
		
		UserService userService = new UserServiceImpl();
		User ruser = userService.findById(iId);
		
		request.setAttribute("user", ruser);
		
		boolean isok = userService.update(user);
		
		String msg = "";
		String jumpUrl = "";
		if (isok) {
			msg = "用户修改成功";
			jumpUrl = "login-guest.jsp";// 成功后跳转的地址
		} else {
			msg = "用户修改失败";
			jumpUrl = "register-guest.jsp";// 失败后跳转的地址
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(jumpUrl).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
