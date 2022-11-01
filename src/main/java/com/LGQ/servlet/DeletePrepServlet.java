package com.LGQ.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Train;
import com.LGQ.service.PrepService;
import com.LGQ.service.TrainService;
import com.LGQ.service.impl.PrepServiceImpl;
import com.LGQ.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: DeletePrepServlet
 * @Description: 会员退单，座位+1
 * @author: 刘国强
 * @date: 2022年6月2日 下午7:25:16
 */
public class DeletePrepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrepService prepService = new PrepServiceImpl();
		TrainService trainService = new TrainServiceImpl();
		int recordNumber = 0;

		// 这是从界面过来的，实现退票业务
		Integer prepId = Integer.valueOf(request.getParameter("prepId"));
		
		// 将订单信息中的trainID先拉取出来，下面更改车次座位数需要
		Integer trainId = prepService.getById(prepId).getTrainId();
				
		// 删除订单
		recordNumber = prepService.delete(prepId);

		PrintWriter out = response.getWriter();
		if (recordNumber == 1) {
			// 座位数+1
			Train train = trainService.getById(trainId);
			train.setSeatNumber(train.getSeatNumber() + 1);
			trainService.update(train);

			out.write("<script>alert('退票成功！');" + "window.location.href='MyPrepServlet'</script>");
		} else {
			out.write("<script>alert('很抱歉,退票失败！');" + "window.location.href='MyPrepServlet'</script>");
		}

		out.close();

	}

}
