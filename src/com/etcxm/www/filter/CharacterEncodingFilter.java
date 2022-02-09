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
		//销毁方法
		System.out.println("CharacterEncoding过滤器被销毁了");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("CharacterEncoding过滤器被执行了！");
		//实现过滤的方法
		servletRequest.setCharacterEncoding("utf-8");
//		HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
//		httpServletResponse.sendRedirect("login.jsp");
		filterChain.doFilter(servletRequest, servletResponse);	//调用过滤器链，把处理发给下一个过滤器来执行，一旦你调用该方法，在此之后request的设置就没有太大用处。
//		servletRequest.setCharacterEncoding("iso-8859-1");	//该句用处不大
		servletResponse.setCharacterEncoding("utf-8");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//初始化方法
		System.out.println("CharacterEncoding过滤器被初始化了！");
	}

}
