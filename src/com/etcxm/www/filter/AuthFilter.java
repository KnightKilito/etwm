package com.etcxm.www.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 实现用户校验，阻挡所有没有登录的用户
 */
@WebFilter("*.ado")
public class AuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 通过session进行校验
		// 1. 获得session
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // 强制转换类型为HttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // 获取session
		// 2. 从session校验user对象。
		
		String userId =null;
		try {
			userId = session.getAttribute("userId").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 3. 校验是否为空
		if (userId == null || userId == "") {
			// 判断是否是访问登录校验的servlet->auth.do
			// 1. 拿访问地址
			//String uri = httpServletRequest.getRequestURI();

			// 没有登录，跳转到login.jsp
			String msg = "请登录！";
			String url="login.jsp";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("view/fail.jsp").forward(request, response);

		} else { // 登录过了，正常放行
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
