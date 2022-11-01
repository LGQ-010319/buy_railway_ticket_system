package com.LGQ.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Member;

/**
 * 
 * @ClassName: GetMyMemberServlet 
 * @Description: 会员 将member信息转发到我的中心界面
 * @author: 刘国强
 * @date: 2022年6月3日 下午10:17:33
 */
public class GetMyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetMyMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从Session中获取登录对象，将其转发到界面
		Member member = (Member) request.getSession().getAttribute("member");
		request.setAttribute("member", member);
		request.getRequestDispatcher("pages/user/myCenter/right/myMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
