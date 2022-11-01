package com.LGQ.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Pmember;
import com.LGQ.service.PmemberService;
import com.LGQ.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: GetPmemberByPmemberIdServlet 
 * @Description: 根据pmemberId获取会员个人信息
 * @author: 刘国强
 * @date: 2022年6月3日 上午2:45:08
 */
public class GetPmemberByPmemberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPmemberByPmemberIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pmemberId = Integer.valueOf(request.getParameter("pmemberId"));
		PmemberService pmemberService = new PmemberServiceImpl();
		Pmember pmember = pmemberService.getById(pmemberId);
		if(pmember != null) {
			request.setAttribute("pmember", pmember);
		} else {
			request.setAttribute("msg", "没有个人信息！");
		}
		
		request.getRequestDispatcher("pages/admin/right/pmember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}

