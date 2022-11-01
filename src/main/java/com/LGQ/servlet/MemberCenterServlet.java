package com.LGQ.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Member;
import com.LGQ.service.MemberService;
import com.LGQ.service.impl.MemberServiceImpl;

/**
 * 
 * @ClassName: MemberCenterServlet 
 * @Description: 会员中心的Servlet，获取所有会员信息
 * @author: 刘国强
 * @date: 2022年6月3日 下午3:17:34
 */
public class MemberCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberCenterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取所有会员的信息
		MemberService memberService = new MemberServiceImpl();//实例化
		List<Member> memberList =  memberService.getAllMember();//调用MemberServiceImpl()里的getAllMember()
		
		if(memberList!=null && memberList.size()>0) {
			request.setAttribute("memberList", memberList);
		} else {
			request.setAttribute("msg", "暂时没有任何会员！");
		}
		
		request.getRequestDispatcher("pages/admin/right/memberCenter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
