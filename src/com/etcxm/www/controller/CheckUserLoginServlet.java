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
			msg="��¼ʧ��";
			jumpUrl="view/fail.jsp";//ʧ�ܺ���ת�ĵ�ַ
		}
		else if(user.getUsername().equals(ruser.getUsername())||user.getPassword().equals(ruser.getPassword())){
			msg="��¼�ɹ�";
			HttpSession session=request.getSession();
			session.setAttribute("userId", ruser.getId());//�洢����
			//?userId="+ruser.getId()+"&pageNum=1&pageSize=8
			System.out.println("userId:"+ruser.getId());
			if(type.equals("guest")) {
				jumpUrl="allShop.do";//�ɹ�����ת�ĵ�ַ
			}
			else {
				jumpUrl="main.do";//�ɹ�����ת�ĵ�ַ
			}
		}else{
			msg="��¼ʧ��";
			jumpUrl="view/fail.jsp";//ʧ�ܺ���ת�ĵ�ַ
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
