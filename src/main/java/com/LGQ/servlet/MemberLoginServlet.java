package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LGQ.domain.Admin;
import com.LGQ.domain.Member;
import com.LGQ.service.AdminService;
import com.LGQ.service.MemberService;
import com.LGQ.service.impl.AdminServiceImpl;
import com.LGQ.service.impl.MemberServiceImpl;
import com.LGQ.util.DateUtil;

/**
 * 
 * @ClassName: MemberLoginServlet
 * @Description: 会员/管理员登录的Servlet
 * @author:刘国强
 * @date: 2022年6月3日 下午10:58:30
 */
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从客户端获取输入的值
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String code = request.getParameter("vcode");
		HttpSession session = request.getSession();//创建session
		String vcode = (String) session.getAttribute("vcode");
		
		
		//接口的实例化
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.getAdminByName(userName);

		// 创建Session，存储登录的用户对象
		session.setMaxInactiveInterval(30 * 60);

		PrintWriter out = response.getWriter();//获取流

		// 判断是否是管理员账号
		if (admin != null&& code.equalsIgnoreCase(vcode)) {
			if (admin.getPassword().equals(passWord)) {
				// 更新登录状态和登录时间
				admin.setIsUse(1);
				admin.setLoginTime(DateUtil.now());
				adminService.updateAdmin(admin);
				// 将登录对象存入session
				session.setAttribute("admin", admin);
				// 跳转到管理界面
				out.write("<script>alert('登录成功！欢迎你," + admin.getUserName() + "');"
						+ "window.location.href='pages/admin/adminMain.jsp'</script>");
			} else {
				out.write(
						"<script>alert('密码错误，请重新输入！');" + "window.location.href='pages/user/memberLogin.jsp'</script>");
			}
		} else {
			// 判断是否是会员账号
			MemberService memberService = new MemberServiceImpl();
			Member member = memberService.getMemberByName(userName);
			
			if (member != null && code.equalsIgnoreCase(vcode)) {
				// 密码正确，转到首页
				if (passWord.equals(member.getPassword())) {

					// 先修改数据库登录状态和登录时间
					member.setIfUse(1);//1为在线
					member.setLogintimes(DateUtil.now());//设置登录时间
					memberService.updateMember(member);//执行更新

					// 将登录信息存入session
					/*
					 * HttpSession session = request.getSession();
					 * session.setMaxInactiveInterval(30 * 60);
					 */
					session.setAttribute("member", member);

					// 跳转到首页
					out.write("<script>alert('登录成功！欢迎你," + member.getUserName() + "');"
							+ "window.location.href='pages/user/home.jsp'</script>");
				} else {
					out.write("<script>alert('密码错误，请重新输入！');"
							+ "window.location.href='pages/user/memberLogin.jsp'</script>");
				}
			} else {
				out.write("<script>alert('该用户不存在！');" + "window.location.href='pages/user/memberLogin.jsp'</script>");
			}
		}
		out.close();
	}
}
