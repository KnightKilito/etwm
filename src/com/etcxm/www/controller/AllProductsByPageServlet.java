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
		
		String shopName=request.getParameter("shopName");		//获取shopName
		request.setAttribute("shopName", shopName);
		//String shopProductName=request.getParameter("shopProductName");		//获取shopProductName
		String pageNum=request.getParameter("pageNum");		//请求第几页
		String pageSize=request.getParameter("pageSize");	//每页大小
		
		int iPageNum=1;			//初始化页面为第一页。
		int iPageSize=5;
		
		try{
			if(pageNum!=null)iPageNum=Integer.parseInt(pageNum);		//把字符串强制转换为整数
			if(pageSize!=null)iPageSize=Integer.parseInt(pageSize);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(iPageNum<1)iPageNum=1;	//检查页数，不能低于第1页。
		request.setAttribute("currPage", iPageNum);		//把当前请求的页面写入到request中
		
		ShopProductService shopproductService=new ShopProductServiceImpl();
		//获取总共多少条记录
		int allCount=shopproductService.count(shopName);
		request.setAttribute("allCount", allCount);
		//计算总共多少页
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
		//把每页多少写入到request中，发送到jsp里面
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
