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
 * Servlet implementation class CheckUserLoginServlet
 */
@WebServlet("/chkuserlog.do")
public class CheckUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		User user = new User(null, username,password, null, null, type, null, null, null);
		
		UserService userService = new UserServiceImpl();
		User ruser = userService.findByUsernameAndPassword(user);
		
		String msg = "";
		String jumpUrl = "";
		if(ruser==null) {
			msg="登录失败";
			jumpUrl="view/fail.jsp";//失败后跳转的地址
		}
		else if(user.getUsername().equals(ruser.getUsername())||user.getPassword().equals(ruser.getPassword())){
			msg="登录成功";
			HttpSession session=request.getSession();
			session.setAttribute("userId", ruser.getId());//存储数据
			//?userId="+ruser.getId()+"&pageNum=1&pageSize=8
			System.out.println("userId:"+ruser.getId());
			if(type.equals("guest")) {
				jumpUrl="allShop.do";//成功后跳转的地址
			}
			else {
				jumpUrl="main.do";//成功后跳转的地址
			}
		}else{
			msg="登录失败";
			jumpUrl="view/fail.jsp";//失败后跳转的地址
		}
		request.setAttribute("msg", msg);
		response.sendRedirect(jumpUrl);
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
