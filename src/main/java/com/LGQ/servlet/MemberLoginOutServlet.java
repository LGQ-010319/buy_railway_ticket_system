package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: MemberLoginOutServlet
 * @Description: 会员 退出登陆
 * @author 刘国强
 * @date 2022年6月3日 下午3:37:12
 *
 */
public class MemberLoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 销毁session
		request.getSession().invalidate();

		// 提示信息，返回首页
		PrintWriter out = response.getWriter();
		out.write("<script>alert('注销成功！');" + "window.location.href='home.jsp'</script>");
		out.close();

	}

}
