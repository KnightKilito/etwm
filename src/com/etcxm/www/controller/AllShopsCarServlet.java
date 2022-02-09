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
		int iPageNum = 1; // ��ʼ��ҳ��Ϊ��һҳ��
		int iPageSize = 8;
		String searchName = request.getParameter("search");
		String pageNum = request.getParameter("pageNum"); // ����ڼ�ҳ
		String pageSize = request.getParameter("pageSize"); // ÿҳ��С
		// ����ת��jsp��servlet��Ҫ��ȡusername����ҳ����ʾ�����쳣,���ڿ���չ����ͷ��
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // ǿ��ת������ΪHttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // ��ȡsession
		String userId = session.getAttribute("userId").toString();
		int iuserId = Integer.parseInt(userId);
		request.setAttribute("userId", iuserId);
		UserService userService = new UserServiceImpl();
		User user = userService.findById(iuserId);
		request.setAttribute("username", user.getRealname());
		

		try {
			if(pageNum!=null)iPageNum = Integer.parseInt(pageNum); // ���ַ���ǿ��ת��Ϊ����
			if(pageSize!=null)iPageSize = Integer.parseInt(pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (iPageNum < 1)
			iPageNum = 1; // ���ҳ�������ܵ��ڵ�1ҳ��
		ShopService shopService = new ShopServiceImpl();
		int allCount = 0;

		if (searchName == null) {
			List<Shop> list = shopService.findAllShopByPage(iPageNum, iPageSize);
			request.setAttribute("list", list);
			request.setAttribute("currPage", iPageNum); // �ѵ�ǰ�����ҳ��д�뵽request��

			// ��ȡ�ܹ���������¼
			allCount = shopService.count();

		} else {
			List<Shop> list = shopService.findByShopNamePage(searchName, iPageNum, iPageSize);
			request.setAttribute("list", list);
			request.setAttribute("currPage", iPageNum); // �ѵ�ǰ�����ҳ��д�뵽request��

			allCount = shopService.countFindByShopName(searchName);

		}
		request.setAttribute("allCount", allCount);
		// �����ܹ�����ҳ
		int allPage = 1;
		if (allCount % iPageSize > 0) {
			allPage = allCount / iPageSize + 1;
		} else {
			allPage = allCount / iPageSize;
		}

		request.setAttribute("searchName", searchName);
		request.setAttribute("allPage", allPage);
		// ��ÿҳ����д�뵽request�У����͵�jsp����
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
