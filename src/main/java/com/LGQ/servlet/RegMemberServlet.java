package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.dao.MemberDao;
import com.LGQ.dao.impl.MemberDaoImpl;
import com.LGQ.domain.Member;
import com.LGQ.domain.Pmember;
import com.LGQ.service.MemberService;
import com.LGQ.service.PmemberService;
import com.LGQ.service.impl.MemberServiceImpl;
import com.LGQ.service.impl.PmemberServiceImpl;
import com.LGQ.util.DateUtil;

/**
 * 
 * @ClassName: BookingServlet 
 * @Description:注册 Servlet
 * @author: 刘国强
 * @date: 2022年6月1日 下午11:23:41
 */
public class RegMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username"); //从登录表单获取username的值
		String password = request.getParameter("password");//获取password
		
        PrintWriter out = response.getWriter();  //获取流
		MemberDao memberDao = new MemberDaoImpl(); //接口的实例化，也就是新声明一个memberDao，他可以调用MemberDaoImpl()中的所有方法
		MemberService memberService = new MemberServiceImpl(memberDao);//声明一个memberService，他可以调用MemberServiceImpl(memberDao)中的所有方法
		
		//校验用户名是否已经存在
		if(memberService.getMemberByName(userName) == null) {
			//用户名不存在，可以创建
		    Member member = new Member(userName, password, DateUtil.now(), 0, DateUtil.now());
		    int countNumber = memberService.addMember(member);
		    //用户名存在
		    if(countNumber == 1) {
			    // 将个人信息存储到pmember
			    Pmember pmember = new Pmember();
			    Integer memberId = memberService.getMemberByName(userName).getMemberId();
			    pmember.setMemberId(memberId);
			    //从客户端获取
			    String realName = request.getParameter("realName");//获取客户端的realName
			    String sex = request.getParameter("sex");
			    Integer age = Integer.valueOf(request.getParameter("age"));
			    String idCard = request.getParameter("idCard");
			    //更新数据
			    pmember.setRealName(realName);
			    pmember.setSex(sex);
			    pmember.setAge(age);
			    pmember.setIdCard(idCard);
			    //接口的实例化，也就是新声明一个pmemberService，他可以调用PmemberServiceImpl()中的所有方法
			    PmemberService pmemberService = new PmemberServiceImpl();
			    //调用PmemberServiceImpl()里的add(),添加会员
			    pmemberService.add(pmember);
			
			    out.write("<script>alert('注册成功，点击登录！');window.location.href='pages/user/memberLogin.jsp'</script>");
		    } else {
			    out.write("<script>alert('注册失败！');window.location.href='pages/user/memberReg.jsp'</script>");
		    } 
        } else {
			// 存在
			out.write("<script>alert('用户名已存在，请重新输入！');window.location.href='pages/admin/right/addMember.jsp'</script>");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
