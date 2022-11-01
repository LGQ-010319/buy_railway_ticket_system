package com.LGQ.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LGQ.domain.Member;
import com.LGQ.domain.Pmember;
import com.LGQ.service.PmemberService;
import com.LGQ.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: GetPmemberByMemberIdServlet 
 * @Description: 根据MemberId获取会员/管理员个人信息，展示到myPmember.jsp/updatePmember.jsp界面
 * @author: 刘国强
 * @date: 2022年6月3日 上午2:44:30
 */
public class GetPmemberByMemberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetPmemberByMemberIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temp = request.getParameter("temp");//从客户端获取
		
		PmemberService pmemberService = new PmemberServiceImpl();//实例化
		
		// 判断是否为管理员
		if(temp!=null && !"".equals(temp) && "admin".equals(temp)) {
			// 管理员查询会员个人信息
			Integer memberId = Integer.valueOf(request.getParameter("memberId"));
			Pmember pmember = pmemberService.getPmemberByMemberId(memberId);
			request.setAttribute("pmember", pmember);
			request.getRequestDispatcher("pages/admin/right/updatePmember.jsp").forward(request, response);
			
		} else {
			// 会员查询个人信息
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			if(member != null) {
				Pmember pmember = pmemberService.getPmemberByMemberId(member.getMemberId());
				request.setAttribute("pmember", pmember);
				request.getRequestDispatcher("pages/user/myCenter/right/myPmember.jsp").forward(request, response);
			} else {
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
