package com.LGQ.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Member;
import com.LGQ.domain.Pmember;
import com.LGQ.domain.Prep;
import com.LGQ.service.PmemberService;
import com.LGQ.service.PrepService;
import com.LGQ.service.impl.PmemberServiceImpl;
import com.LGQ.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: MyPrepServlet 
 * @Description: 用户 我的订单
 * @author: 刘国强
 * @date: 2022年6月3日 下午3:30:45
 */
public class MyPrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MyPrepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取订单
		Member member = (Member) request.getSession().getAttribute("member");
		PmemberService pmemberService = new PmemberServiceImpl();
		Pmember pmember = pmemberService.getPmemberByMemberId(member.getMemberId());
		PrepService prepService = new PrepServiceImpl();
		List<Prep> prepList = prepService.getPrepByPmemberId(pmember.getPmemberId());
		//判断是否有订单
		if(prepList!=null && prepList.size()>0) {
			//将获取的数据保存到request域中
			request.setAttribute("prepList", prepList);
		} else {
			request.setAttribute("msg", "您没有任何订单！");
		}
		//重定向
		request.getRequestDispatcher("pages/user/myCenter/right/myPrep.jsp").forward(request, response);
		
	}



}
