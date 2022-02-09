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
 * Servlet implementation class AllShopsByPageServlet
 */
@WebServlet("/allshopspage.do")
public class ManageAllShopsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAllShopsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");		//����ڼ�ҳ
		String pageSize=request.getParameter("pageSize");	//ÿҳ��С
		//String realname = request.getParameter("realname");
		
		int iPageNum=1;			//��ʼ��ҳ��Ϊ��һҳ��
		int iPageSize=5;
		
		try {
			if(pageNum!=null)iPageNum = Integer.parseInt(pageNum); // ���ַ���ǿ��ת��Ϊ����
			if(pageSize!=null)iPageSize = Integer.parseInt(pageSize);
			// ����ת��jsp��servlet��Ҫ��ȡusername����ҳ����ʾ�����쳣,���ڿ���չ����ͷ��
			HttpServletRequest httpServletRequest = (HttpServletRequest) request; // ǿ��ת������ΪHttpServletRequest
			HttpSession session = httpServletRequest.getSession(); // ��ȡsession
			String userId = session.getAttribute("userId").toString();
			if(userId!=null) {
				int iuserId = Integer.parseInt(userId);
				request.setAttribute("userId", iuserId);
				UserService userService = new UserServiceImpl();
				User user = userService.findById(iuserId);
				request.setAttribute("username", user.getRealname());
				//System.out.println("username:" + user.getRealname());
				if(iPageNum<1)iPageNum=1;	//���ҳ�������ܵ��ڵ�1ҳ��
				request.setAttribute("currPage", iPageNum);		//�ѵ�ǰ�����ҳ��д�뵽request��
				
				ShopService shopService=new ShopServiceImpl();
				//��ȡ�ܹ���������¼
				int allCount=shopService.countFindByUserName(user.getRealname());
				request.setAttribute("allCount", allCount);
				//�����ܹ�����ҳ
				int allPage=1;
				if(allCount%iPageSize>0){
					allPage=allCount/iPageSize+1;
				}else{
					allPage=allCount/iPageSize;
				}
				
				List<Shop> list=shopService.findAllShopByShopkeeper(user.getRealname(),iPageNum, iPageSize);
				request.setAttribute("list", list);
				request.setAttribute("allPage", allPage);
				//��ÿҳ����д�뵽request�У����͵�jsp����
				request.setAttribute("pageNum", iPageNum);
				request.setAttribute("pageSize", iPageSize);
				request.setAttribute("realname",user.getRealname());
				request.getRequestDispatcher("view/allshops.jsp").forward(request, response);
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
