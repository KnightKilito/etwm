package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class EditShopServlet
 */
@WebServlet("/edtshop.do")
public class EditShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡid
		String id=request.getParameter("id");
		//ͨ��id��ȡ������Ʒ����Ϣ
		//1. ʵ��Service
		ShopService shopService=new ShopServiceImpl();
		try {
			//2. ��idװ������
			int iId=Integer.parseInt(id);	//�п�����ɿ�ָ�����
			//3. ���÷�������ȡ������Ʒ
			Shop shop = shopService.findById(iId);
			//��product������Ӧjspҳ��
			request.setAttribute("shop", shop);
			request.getRequestDispatcher("view/editshop.jsp")
			.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			//��ת��������ʾҳ��
			String msg="��������ȷ�Ĳ�����";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("view/fail.jsp")
			.forward(request, response);
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
