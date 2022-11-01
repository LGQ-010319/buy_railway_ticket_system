package com.LGQ.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 软件1班 刘国强 20号
 * 登录过滤，过滤未登录状态,当路径为"pages/admin/adminMain.jsp","/psges/user/user.jsp"时过滤，重定向至登录页面
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/pages/admin/adminMain.jsp","/psges/user/user.jsp"})
public class LoginFilter extends HttpFilter implements Filter {

	public LoginFilter() {
		super();
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginnFilter初始化成功");
	}
	public void destroy() {
		System.out.println("LoginFiler销毁");
	}
	public void doFilter(ServletRequest request0, ServletResponse response0, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) request0;
		HttpServletResponse response = (HttpServletResponse) response0;
		// 获取请求资源路径
		HttpSession session = request.getSession();
		Object member = session.getAttribute("member");	
		Object admin = session.getAttribute("admin");	
		String path = request.getRequestURI();
		System.out.println(path);
		if (path.contains("/MemberLoginServlet") || path.contains("/code") || path.contains("/home.jsp")) {// 此处为要放行
			System.out.println("放行");
			chain.doFilter(request0, response0);
		} else if (admin!= null || member!=null) {
			System.out.println("已登录--------48");
			//已经登录，放行
			chain.doFilter(request0, response0);
			} else {
				System.out.println("未登录----------52");
				//未登录
//				request.getRequestDispatcher("/login.jsp").forward(request, response);
			response.sendRedirect("/dome4/home.jsp");
				
			}
		
	//	chain.doFilter(request0, response0);
	}
	
}
