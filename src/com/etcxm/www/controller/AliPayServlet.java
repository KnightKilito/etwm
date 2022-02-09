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
 * Servlet implementation class AliPayServlet
 */
@WebServlet("/alipay.ado")
public class AliPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AliPayServlet() {
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
		// ����ת��jsp��servlet��Ҫ��ȡusername����ҳ����ʾ�����쳣,���ڿ���չ����ͷ��
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // ǿ��ת������ΪHttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // ��ȡsession
		String userId = session.getAttribute("userId").toString();
		int iuserId = Integer.parseInt(userId);
		request.setAttribute("userId", iuserId);
		UserService userService = new UserServiceImpl();
		User user = userService.findById(iuserId);
		
		String msg1=null;
		String msg2=null;
		String msg3=null;
		
		String addresseename = user.getRealname();
		String phonenumber = user.getPhone();
		String address = user.getAddress();
		if(addresseename==null||addresseename.equals("")||phonenumber==null||phonenumber.equals("")||address==null||address.equals("")) {
			if(addresseename==null||addresseename.equals("")) {
				msg1="�������ռ���������";
			}
			if(phonenumber==null||phonenumber.equals("")) {
				msg2="�������ռ��˵绰���룡";
			}
			if(address==null||address.equals("")) {
				
				msg3="�������ռ���ַ��";
			}
//			request.setAttribute("addressname", addresseename);
//			request.setAttribute("phonenumber", phonenumber);
//			request.setAttribute("address", address);
			request.setAttribute("username", user.getRealname());
			request.setAttribute("msg1", msg1);
			request.setAttribute("msg2", msg2);
			request.setAttribute("msg3", msg3);
			request.getRequestDispatcher("settlefail.jsp").forward(request, response);
		}else {
			userService.updateOrderId(iuserId);// �û���������һ
			request.setAttribute("username", user.getRealname());
			ShopCarProductService shopCarProductService = new ShopCarProductServiceImpl();
			//�ѱ��ι���Ĳ�Ʒ������ʷ���ﳵ��
			List<ShopProduct> list = shopCarProductService.findAll(iuserId, shopName);
			shopCarProductService.insertHistory(iuserId, shopName, list);

			boolean destroyok = shopCarProductService.wipeShopCar(iuserId, shopName);
			// System.out.println("destroyok:"+destroyok);
			request.getRequestDispatcher("settlesuccess.jsp").forward(request, response);
		}
		
		
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
