package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Pmember;
import com.LGQ.service.MemberService;
import com.LGQ.service.PmemberService;
import com.LGQ.service.impl.MemberServiceImpl;
import com.LGQ.service.impl.PmemberServiceImpl;

/**
 * 
 * @ClassName: DeleteMemberAdminServlet 
 * @Description: 管理员 删除会员
 * @author: 刘国强
 * @date: 2022年6月2日 下午9:31:52
 */
public class DeleteMemberAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteMemberAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		
		PmemberService pmemberService = new PmemberServiceImpl();
		MemberService memberService = new MemberServiceImpl();
		// 先删除pmember表(会员个人信息)内的会员个人信息
		Pmember pmember = pmemberService.getPmemberByMemberId(memberId);
		int recordNumber = pmemberService.delete(pmember.getPmemberId());
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			// 后删除member表(会员登录信息)内的会员信息
			int recordNumber1 = memberService.deleteMember(memberId);
			
			if(recordNumber1 == 1) {
				out.write("<script>alert('删除会员成功！');"
				    + "window.location.href='MemberCenterServlet'</script>");
			}else {
				out.write("<script>alert('很抱歉,删除会员失败！');"
					    + "window.location.href='MemberCenterServlet'</script>");
			}
			
		}else {
			out.write("<script>alert('很抱歉,删除会员失败！');"
				    + "window.location.href='MemberCenterServlet'</script>");
		}
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
