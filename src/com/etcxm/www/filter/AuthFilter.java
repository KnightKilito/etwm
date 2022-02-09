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
 * ʵ���û�У�飬�赲����û�е�¼���û�
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
		// ͨ��session����У��
		// 1. ���session
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; // ǿ��ת������ΪHttpServletRequest
		HttpSession session = httpServletRequest.getSession(); // ��ȡsession
		// 2. ��sessionУ��user����
		
		String userId =null;
		try {
			userId = session.getAttribute("userId").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 3. У���Ƿ�Ϊ��
		if (userId == null || userId == "") {
			// �ж��Ƿ��Ƿ��ʵ�¼У���servlet->auth.do
			// 1. �÷��ʵ�ַ
			//String uri = httpServletRequest.getRequestURI();

			// û�е�¼����ת��login.jsp
			String msg = "���¼��";
			String url="login.jsp";
			request.setAttribute("url", url);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("view/fail.jsp").forward(request, response);

		} else { // ��¼���ˣ���������
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
