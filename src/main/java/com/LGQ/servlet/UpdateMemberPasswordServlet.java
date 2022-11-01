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
 * @ClassName: UpdateMemberPasswordServlet 
 * @Description: 会员 修改密码
 * @author: 刘国强
 * @date: 2022年6月3日 下午11:01:33
 */
public class UpdateMemberPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberPasswordServlet() {
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
		
		String oldPassword = request.getParameter("oldPassword");//从客户端获取旧密码
		String newPassword = request.getParameter("newPassword");//获取新密码
		
		Member member = (Member) request.getSession().getAttribute("member");//获取Session里的member值
		
		PrintWriter out = response.getWriter();//获取流
		
		// 判断原密码是否正确
		if(oldPassword!=null && member.getPassword().equals(oldPassword)) {
			// 原密码正确，修改密码
			member.setPassword(newPassword);//设置该会员密码为输入的新密码
			MemberService memberService = new MemberServiceImpl();
			int recordNumber = memberService.updateMember(member);
			
			if(recordNumber == 1) {
				out.write("<script>alert('修改成功！');"
				    + "window.location.href='pages/user/myCenter/right/updateMemberPassword.jsp'</script>");
			}else {
				out.write("<script>alert('很抱歉,修改失败！');"
					    + "window.location.href='pages/user/myCenter/right/updateMemberPassword.jsp'</script>");
			}
			
		} else {
			out.write("<script>alert('很抱歉,修改失败！');"
				    + "window.location.href='pages/user/myCenter/right/updateMemberPassword.jsp'</script>");
		}
		
		out.close();
		
		
		
	
	}

}
