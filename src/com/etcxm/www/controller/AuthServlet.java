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
 * Servlet implementation class AuthServlet
 */
@WebServlet("/auth.do")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserService userService=new UserServiceImpl();
		
		User rUser=userService.findByUsernameAndPassword(user);
		if(rUser==null){	//验证失败
			String msg="用户名或者密码错误！请重试！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("view/fail.jsp").forward(request, response);
		}else{//验证成功！
			//把rUser保存到session中
			HttpSession session=request.getSession();
			session.setAttribute("user", rUser);
			request.getRequestDispatcher("view/main.jsp").forward(request, response);
		}
	
	
	}

}
