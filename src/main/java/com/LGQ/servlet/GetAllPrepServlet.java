package com.LGQ.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Prep;
import com.LGQ.service.PrepService;
import com.LGQ.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: GetAllPrepServlet 
 * @Description: 管理员获取所有订单信息
 * @author: 刘国强
 * @date: 2022年6月3日 下午7:44:25
 */
public class GetAllPrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrepService prepService = new PrepServiceImpl();
		List<Prep> prepList = prepService.getAll();
		request.setAttribute("prepList", prepList);
		request.getRequestDispatcher("pages/admin/right/prepCenter.jsp").forward(request, response);
	}



}
