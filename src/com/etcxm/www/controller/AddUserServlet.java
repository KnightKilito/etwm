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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");
		User user = new User(null,username,password,realname,phone,type,null,null,null);
	
		
		
		UserService userService = new UserServiceImpl();
		boolean isok = userService.save(user);
		
		String msg = "";
		String jumpUrl = "";
		if(isok){
			msg="�û�ע��ɹ�";
			jumpUrl="login-guest.jsp";//�ɹ�����ת�ĵ�ַ
		}else{
			msg="ע��ʧ��";
			jumpUrl="register-guest.jsp";//ʧ�ܺ���ת�ĵ�ַ
		}
		request.setAttribute("msg", msg);
		response.sendRedirect(jumpUrl);
	}

}
