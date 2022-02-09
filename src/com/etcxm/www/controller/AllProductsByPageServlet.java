package com.etcxm.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.www.entity.ShopProduct;
import com.etcxm.www.service.ShopProductService;
import com.etcxm.www.service.impl.ShopProductServiceImpl;

/**
 * Servlet implementation class AllProductsByPageServlet
 */
@WebServlet("/allpage.do")
public class AllProductsByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProductsByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String shopName=request.getParameter("shopName");		//��ȡshopName
		request.setAttribute("shopName", shopName);
		//String shopProductName=request.getParameter("shopProductName");		//��ȡshopProductName
		String pageNum=request.getParameter("pageNum");		//����ڼ�ҳ
		String pageSize=request.getParameter("pageSize");	//ÿҳ��С
		
		int iPageNum=1;			//��ʼ��ҳ��Ϊ��һҳ��
		int iPageSize=5;
		
		try{
			if(pageNum!=null)iPageNum=Integer.parseInt(pageNum);		//���ַ���ǿ��ת��Ϊ����
			if(pageSize!=null)iPageSize=Integer.parseInt(pageSize);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(iPageNum<1)iPageNum=1;	//���ҳ�������ܵ��ڵ�1ҳ��
		request.setAttribute("currPage", iPageNum);		//�ѵ�ǰ�����ҳ��д�뵽request��
		
		ShopProductService shopproductService=new ShopProductServiceImpl();
		//��ȡ�ܹ���������¼
		int allCount=shopproductService.count(shopName);
		request.setAttribute("allCount", allCount);
		//�����ܹ�����ҳ
		int allPage=1;
		if(allCount%iPageSize>0){
			allPage=allCount/iPageSize+1;
		}else{
			allPage=allCount/iPageSize;
		}
		
		//List<ShopProduct> list=shopproductService.findByShopProductNamePage(shopName,shopProductName,iPageNum, iPageSize);
		List<ShopProduct> list=shopproductService.findAllShopProductByPage(shopName,iPageNum, iPageSize);
		request.setAttribute("list", list);
		request.setAttribute("allPage", allPage);
		//��ÿҳ����д�뵽request�У����͵�jsp����
		request.setAttribute("pageNum", iPageNum);
		request.setAttribute("pageSize", iPageSize);
		
		request.getRequestDispatcher("view/allproductspage.jsp").forward(request, response);
		
	}

	private int countFindByShopProductName(String shopName, String shopProductName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
