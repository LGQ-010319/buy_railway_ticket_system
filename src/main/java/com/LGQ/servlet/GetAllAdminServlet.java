package com.LGQ.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Admin;
import com.LGQ.service.AdminService;
import com.LGQ.service.impl.AdminServiceImpl;

/**
 * 
 * @ClassName: GetAllAmdinServlet 
 * @Description: 管理员  获取所有管理员
 * @author: 刘国强
 * @date: 2022年6月3日 下午12:55:22
 */
public class GetAllAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private AdminService adminService = new AdminServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Admin> adminList = adminService.getAllAdmin();
		request.setAttribute("adminList", adminList);
		
		request.getRequestDispatcher("pages/admin/right/getAllAdmin.jsp").forward(request, response);
		
	}



}
