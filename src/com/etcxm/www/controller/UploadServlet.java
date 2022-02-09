package com.etcxm.www.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("不支持get方式提交！");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  	DiskFileItemFactory dfi = new DiskFileItemFactory();
	        //获得上传文件的存储路径
	        String path  = request.getRealPath("/upload");
	        //设置文件大小超过1024*1024就写到disk上
	        dfi.setSizeThreshold(1024*1024);
	        //设置存储的仓库
	        dfi.setRepository(new File(path));
	        //实例化一个servletFileUpload对象
	        ServletFileUpload sfu = new ServletFileUpload(dfi);
	        //解决上传文件乱码问题
	        sfu.setHeaderEncoding("utf-8");
	        try {
	            List<FileItem> list = sfu.parseRequest(request);
	            //遍历得到每个FileItem
	            for(FileItem item : list){
	                //取得表单文本框的名字
	                String name = item.getFieldName();
	                //如果上传的这个文件只是一个表单字段，而不是一个文件
	                if(item.isFormField()){
	                    //取得文本框输入的内容
	                    String value = item.getString("utf-8");
	                    //存储数据
	                    request.setAttribute(name, value);
	                }else{
	                    //如果上传的是一个文件
	                    //取得上传文件的名字，即上传框中的内容名字
	                    String value = item.getName();
	                    //因为在opera浏览器中文件上传item.geName()会得到具体路径而不止是名字,所以需要从路径中取出名字
	                    //取得文件路径名字开始的位置
	                    int start = value.lastIndexOf("\\");
	                    //得到文件名
	                    String fileName = value.substring(start+1);	//20210615142930cat.jpg
	                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
	                    String timeStamp=simpleDateFormat.format(new Date());
	                    fileName=timeStamp+fileName;
	                    //读取文件的内容，写入到服务器硬盘
	                    item.write(new File(path,fileName));
	                    //存入到数据库中
	                    //session，session中有用户信息
	                    //update tuser set photo=xxxx where username=?
	                    //存储数据
	                    request.setAttribute(name, fileName);

	                }   
	            }

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        //请求转发到另一个页面，在另一个页面取出上传文件的信息
	        request.getRequestDispatcher("view/fileInfo.jsp").forward(request, response);
		
		
	}

}
