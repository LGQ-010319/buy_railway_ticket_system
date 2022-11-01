package com.LGQ.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Prep;
import com.LGQ.service.PrepService;
import com.LGQ.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: UpdatePrepServlet 
 * @Description: 会员 判断是改签还是付款，如果是付款的话实现付款业务，改签的话跳转到ChangePrepServlet
 * @author: 刘国强
 * @date: 2022年6月3日 下午8:24:24
 */
public class UpdatePrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdatePrepServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer prepId = Integer.valueOf(request.getParameter("prepId"));
		Integer temp = Integer.valueOf(request.getParameter("temp"));
		
		PrepService prepService = new PrepServiceImpl();//接口的实例化，新声明一个prepService，他可以调用PrepServiceImpl()中的所有方法
		Prep prep = prepService.getById(prepId); //调用PrepServiceImpl()里的
												//Prep getById(Integer prepId)方法
		
		// 付款业务(temp为1)
		if(temp == 1) {
			prep.setWay(true);
			int recordNumber = prepService.update(prep);
			//付款成功(recordNumber为1)
			if(recordNumber == 1) {
				request.setAttribute("msg", "付款成功！");
			} else {
				request.setAttribute("msg", "付款失败！");
			}
			request.getRequestDispatcher("MyPrepServlet").forward(request, response);
		}
		
		// 改签业务(先将prepId转发到ChangePrepServlet)
		if(temp == 2) {
			request.setAttribute("prepId", prepId);
			request.getRequestDispatcher("ChangePrepServlet").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
