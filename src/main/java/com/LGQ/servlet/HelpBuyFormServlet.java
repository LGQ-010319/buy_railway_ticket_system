package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Member;
import com.LGQ.domain.Pmember;
import com.LGQ.domain.Prep;
import com.LGQ.domain.Train;
import com.LGQ.service.PmemberService;
import com.LGQ.service.PrepService;
import com.LGQ.service.TrainService;
import com.LGQ.service.impl.PmemberServiceImpl;
import com.LGQ.service.impl.PrepServiceImpl;
import com.LGQ.service.impl.TrainServiceImpl;

public class HelpBuyFormServlet extends HttpServlet{

	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据火车Id获取火车信息
		Integer trainId = Integer.valueOf(request.getParameter("TrainId"));
		TrainService trainService = new TrainServiceImpl();
		Train train = trainService.getById(trainId);
		// 根据会员ID获取会员个人信息
		Integer memberId = Integer.valueOf(request.getParameter("memberId"));
		PmemberService pmemberService = new PmemberServiceImpl();
		Pmember pmember = pmemberService.getPmemberByMemberId(memberId);
		/**
		 * 	将数据存入数据库,并返回是否成功的结果
		 */
		Prep prep = new Prep();
		prep.setTrainId(train.getTrainId());
		prep.setPmemberId(pmember.getPmemberId());
		prep.setStartStation(train.getStartStation());
		prep.setEndStation(train.getEndStation());
		prep.setTrainNumber(train.getTrainNumber());
		prep.setStartTime(train.getStartTime());
		prep.setEndTime(train.getEndTime());
		prep.setPrice(train.getPrice());
		prep.setWay(false);
		prep.setBooktime(new Timestamp(new Date().getTime()));
		
		
		PrepService prepService = new PrepServiceImpl();
		int recordNumber = prepService.add(prep);
		
		PrintWriter out = response.getWriter();
		if(recordNumber == 1) {
			// 先将座位数量-1
			train.setSeatNumber(train.getSeatNumber()-1);
			trainService.update(train);
			out.write("<script>alert('帮购成功！记得提醒会员付款呦。');"
				    + "window.location.href='HelpBuyServlet'</script>");
		}
	}
}
