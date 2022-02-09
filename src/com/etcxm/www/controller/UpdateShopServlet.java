package com.etcxm.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.Shop;
import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.ShopService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;
import com.etcxm.www.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class UpdateShopServlet
 */
@WebServlet("/uptshop.do")
public class UpdateShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ʵ�ָ��µĹ���
//		request.setCharacterEncoding("utf-8");		//���ı���
		String shopName=request.getParameter("shopName");
		String id=request.getParameter("id");//shopid
		int iId=Integer.parseInt(id);
    	String shopKeeper=request.getParameter("shopKeeper");
    	String address=request.getParameter("address");
    	String connectPhone=request.getParameter("connectPhone");
    	String avgPrice=request.getParameter("avgPrice");
    	double dAvgPrice=Double.parseDouble(avgPrice);
    	String shopPicFile=request.getParameter("shopPicFile");
    	String shopStar=request.getParameter("shopStar");
    	double iShopStar=Double.parseDouble(shopStar);
    	//ʵ��һ��Entity��Product
    	ShopService shopService=new ShopServiceImpl();
    	Shop shop=new Shop(iId,shopName,shopKeeper,address,connectPhone, dAvgPrice, shopPicFile, iShopStar);
		//�ύ����
		boolean isok=shopService.update(shop);
		//���ݽ��������ת����ʾ��
		String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//�ɹ�
    		msg="�޸ĵ��̳ɹ���";
    		url="allshopspage.do";		//��ת����servlet��ַ��Ϊ�˻�ȡ���ݡ�
    		jumpUrl="view/success.jsp";
    	}else{	//ʧ��
    		msg="�޸ĵ���ʧ�ܣ�";
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute�������ԣ���һ�����������Ե����֣��ڶ������������Ե�ֵ��
    	request.setAttribute("url",url);
    	request.getRequestDispatcher(jumpUrl).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
