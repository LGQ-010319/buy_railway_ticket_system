package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Member;
import com.LGQ.service.MemberService;
import com.LGQ.service.impl.MemberServiceImpl;

/**
 * 
 * @ClassName: UpdateMemberAdminServlet 
 * @Description: 管理员修改会员
 * @author: 刘国强
 * @date: 2022年6月3日 下午9:38:55
 */
public class UpdateMemberAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 从数据库获取这个会员的信息转发到修改界面
		
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		
		MemberService memberService = new MemberServiceImpl();//接口的实例化，新声明一个memberService，他可以调用MemberServiceImpl()中的所有方法
		Member member = memberService.getMemberById(memberId);//调用MemberServiceImpl()里的getMemberById()
		
		request.setAttribute("member", member);//将member获取的数据保存到request域中
		//重定向pages/admin/right/updateMember.jsp
		request.getRequestDispatcher("pages/admin/right/updateMember.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 将修改后的数据更新到数据库
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 从数据库中拉取原数据
		MemberService memberService = new MemberServiceImpl();
		Member member = memberService.getMemberById(memberId);
		// 更新数据
		member.setUserName(userName);
		member.setPassword(password);
		int recordNumber = memberService.updateMember(member);
		
		PrintWriter out = response.getWriter();//获取流
		if(recordNumber == 1) {
			out.write("<script>alert('修改会员成功！');"
			    + "window.location.href='MemberCenterServlet'</script>");
		}else {
			out.write("<script>alert('很抱歉,修改会员失败！');"
				    + "window.location.href='MemberCenterServlet'</script>");
		}
		
		out.close();
	}

}
