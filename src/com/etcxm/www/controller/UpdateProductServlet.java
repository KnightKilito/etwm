package com.etcxm.www.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/upt.do")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		String shopName=request.getParameter("shopName");		//��ȡshopName
		request.setAttribute("shopName", shopName);
		//��ȡ��Ӧ���Ĳ���
		String id=request.getParameter("id");
		int iId=Integer.parseInt(id);
		String shopproductName=request.getParameter("productName");
    	String shopproductPrice=request.getParameter("productPrice");
    	//תΪDouble
    	double dshopProductPrice=Double.parseDouble(shopproductPrice);
    	String productIntroduction=request.getParameter("productIntroduction");
    	String productPicFile=request.getParameter("productPicFile");
    	String productStar=request.getParameter("productStar");
    	double iproductStar=Double.parseDouble(productStar);
		//ʵ��ProductService
		ShopProductService productService=new ShopProductServiceImpl();
		//ʵ��һ��Product
		ShopProduct shopproduct=new ShopProduct(iId, shopproductName, dshopProductPrice, productIntroduction,productPicFile,iproductStar,null,null,null,null, null,null);
		//�ύ����
		boolean isok=productService.update(shopName,shopproduct);
		//System.out.println(isok);
		//���ݽ��������ת����ʾ��
		String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//�ɹ�
    		msg="�޸Ĳ�Ʒ�ɹ���";
    		url="allpage.do?shopName="+shopName;		//��ת����servlet��ַ��Ϊ�˻�ȡ���ݡ�
    		jumpUrl="view/success.jsp";
    	}else{	//ʧ��
    		msg="�޸Ĳ�Ʒʧ�ܣ�";
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
