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
		response.getWriter().append("��֧��get��ʽ�ύ��");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  	DiskFileItemFactory dfi = new DiskFileItemFactory();
	        //����ϴ��ļ��Ĵ洢·��
	        String path  = request.getRealPath("/upload");
	        //�����ļ���С����1024*1024��д��disk��
	        dfi.setSizeThreshold(1024*1024);
	        //���ô洢�Ĳֿ�
	        dfi.setRepository(new File(path));
	        //ʵ����һ��servletFileUpload����
	        ServletFileUpload sfu = new ServletFileUpload(dfi);
	        //����ϴ��ļ���������
	        sfu.setHeaderEncoding("utf-8");
	        try {
	            List<FileItem> list = sfu.parseRequest(request);
	            //�����õ�ÿ��FileItem
	            for(FileItem item : list){
	                //ȡ�ñ��ı��������
	                String name = item.getFieldName();
	                //����ϴ�������ļ�ֻ��һ�����ֶΣ�������һ���ļ�
	                if(item.isFormField()){
	                    //ȡ���ı������������
	                    String value = item.getString("utf-8");
	                    //�洢����
	                    request.setAttribute(name, value);
	                }else{
	                    //����ϴ�����һ���ļ�
	                    //ȡ���ϴ��ļ������֣����ϴ����е���������
	                    String value = item.getName();
	                    //��Ϊ��opera��������ļ��ϴ�item.geName()��õ�����·������ֹ������,������Ҫ��·����ȡ������
	                    //ȡ���ļ�·�����ֿ�ʼ��λ��
	                    int start = value.lastIndexOf("\\");
	                    //�õ��ļ���
	                    String fileName = value.substring(start+1);	//20210615142930cat.jpg
	                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
	                    String timeStamp=simpleDateFormat.format(new Date());
	                    fileName=timeStamp+fileName;
	                    //��ȡ�ļ������ݣ�д�뵽������Ӳ��
	                    item.write(new File(path,fileName));
	                    //���뵽���ݿ���
	                    //session��session�����û���Ϣ
	                    //update tuser set photo=xxxx where username=?
	                    //�洢����
	                    request.setAttribute(name, fileName);

	                }   
	            }

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        //����ת������һ��ҳ�棬����һ��ҳ��ȡ���ϴ��ļ�����Ϣ
	        request.getRequestDispatcher("view/fileInfo.jsp").forward(request, response);
		
		
	}

}
