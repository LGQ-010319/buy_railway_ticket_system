package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Admin;
import com.LGQ.service.AdminService;
import com.LGQ.service.impl.AdminServiceImpl;

/**
 * 
 * @ClassName: UpdateAdminPassword 
 * @Description: 修改管理员密码
 * @author: 刘国强
 * @date: 2022年6月3日 下午11:45:50
 */
public class UpdateAdminPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oldPassword = request.getParameter("oldPassword");//从客户端获取管理员旧密码
		String newPassword = request.getParameter("newPassword");//从客户端获取新密码
		
		Admin admin = (Admin) request.getSession().getAttribute("admin");//获取Session里的admin值
		
		PrintWriter out = response.getWriter();//获取流
		
		// 先判断原密码是否正确
		if(oldPassword!=null && oldPassword.equals(admin.getPassword())) {
			// 原密码正确，修改密码
			admin.setPassword(newPassword);//设置该管理员密码为输入的新密码
			AdminService adminService = new AdminServiceImpl();
			int recordNumber = adminService.updateAdmin(admin);
			
			if(recordNumber == 1) {
				out.write("<script>alert('修改密码成功！');"
				    + "window.self.href='pages/admin/adminMain.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉,修改密码失败！');"
					    + "window.self.href='pages/admin/adminMain.jsp'</script>");
			}	
			
		} else {
			// 原密码错误
			out.write("<script>alert('原密码错误，请重新输入！');"
				    + "window.self.href='pages/admin/adminMain.jsp'</script>");
		}
		
		out.close();
		
	}

}
