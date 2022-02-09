package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/edt.do")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String shopName=request.getParameter("shopName");		//��ȡshopName
		request.setAttribute("shopName", shopName);
		//��ȡid
		String id=request.getParameter("id");
		request.setAttribute("id", id);
		//ͨ��id��ȡ������Ʒ����Ϣ
		//1. ʵ��Service
		ShopProductService productService=new ShopProductServiceImpl();
		try {
			//2. ��idװ������
			int iId=Integer.parseInt(id);	//�п�����ɿ�ָ�����
			//3. ���÷�������ȡ������Ʒ
			ShopProduct product = productService.findById(shopName,iId);
			//��product������Ӧjspҳ��
			request.setAttribute("product", product);
			request.getRequestDispatcher("view/editproduct.jsp")
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
