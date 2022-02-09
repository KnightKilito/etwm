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
		//实现更新的功能
//		request.setCharacterEncoding("utf-8");		//中文编码
		String shopName=request.getParameter("shopName");		//获取shopName
		request.setAttribute("shopName", shopName);
		//读取对应表单的参数
		String id=request.getParameter("id");
		int iId=Integer.parseInt(id);
		String shopproductName=request.getParameter("productName");
    	String shopproductPrice=request.getParameter("productPrice");
    	//转为Double
    	double dshopProductPrice=Double.parseDouble(shopproductPrice);
    	String productIntroduction=request.getParameter("productIntroduction");
    	String productPicFile=request.getParameter("productPicFile");
    	String productStar=request.getParameter("productStar");
    	double iproductStar=Double.parseDouble(productStar);
		//实例ProductService
		ShopProductService productService=new ShopProductServiceImpl();
		//实例一个Product
		ShopProduct shopproduct=new ShopProduct(iId, shopproductName, dshopProductPrice, productIntroduction,productPicFile,iproductStar,null,null,null,null, null,null);
		//提交更新
		boolean isok=productService.update(shopName,shopproduct);
		//System.out.println(isok);
		//根据结果进行跳转，提示。
		String msg="";
    	String url="";
    	String jumpUrl="";
    	if(isok){	//成功
    		msg="修改产品成功！";
    		url="allpage.do?shopName="+shopName;		//跳转的是servlet地址。为了获取数据。
    		jumpUrl="view/success.jsp";
    	}else{	//失败
    		msg="修改产品失败！";
    		jumpUrl="view/fail.jsp";
    	}
    	request.setAttribute("msg", msg);	//setAttribute保存属性，第一个参数是属性的名字，第二个参数是属性的值。
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
