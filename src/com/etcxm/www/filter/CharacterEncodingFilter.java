package com.etcxm.www.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
@WebFilter("*.do")
public class CharacterEncodingFilter implements Filter{

	@Override
	public void destroy() {
		//���ٷ���
		System.out.println("CharacterEncoding��������������");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("CharacterEncoding��������ִ���ˣ�");
		//ʵ�ֹ��˵ķ���
		servletRequest.setCharacterEncoding("utf-8");
//		HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
//		httpServletResponse.sendRedirect("login.jsp");
		filterChain.doFilter(servletRequest, servletResponse);	//���ù����������Ѵ�������һ����������ִ�У�һ������ø÷������ڴ�֮��request�����þ�û��̫���ô���
//		servletRequest.setCharacterEncoding("iso-8859-1");	//�þ��ô�����
		servletResponse.setCharacterEncoding("utf-8");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//��ʼ������
		System.out.println("CharacterEncoding����������ʼ���ˣ�");
	}

}
