package com.LGQ.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Prep;
import com.LGQ.service.PrepService;
import com.LGQ.service.impl.PrepServiceImpl;

/**
 * 
 * @ClassName: CountPrepServlet 
 * @Description: 管理来员 销售统计
 * @author: 刘国强
 * @date: 2022年6月1日 下午4:38:07
 */
public class CountPrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PrepService prepService = new PrepServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 所有订单
		List<Prep> list = prepService.getAll();
		// 已付款的订单
		List<Prep> preps = new ArrayList<Prep>();
		for(Prep prep : list) {
			if(prep.isWay()) {
				preps.add(prep);
			}
		}
		// 统计
		Integer prepNumber = preps.size();	// 有效订单数
		Integer prepPrice = 0;	// 总销售额
		for(Prep prep : preps) {
			prepPrice += prep.getPrice();
		}
		
		request.setAttribute("prepNumber", prepNumber);
		request.setAttribute("prepPrice", prepPrice);
		request.getRequestDispatcher("pages/admin/right/countPrep.jsp").forward(request, response);
		
	}



}
