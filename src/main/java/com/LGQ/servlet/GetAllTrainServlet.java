package com.LGQ.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.PageTool;
import com.LGQ.domain.Train;
import com.LGQ.service.TrainService;
import com.LGQ.service.impl.TrainServiceImpl;

/**
 * 
 * @ClassName: GetAllTrainServlet 
 * @Description: 获取所有车次信息的Servlet
 * @author: 刘国强
 * @date: 2022年6月3日 下午4:45:31
 */
public class GetAllTrainServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllTrainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainService trainService = new TrainServiceImpl();
		
		
		int totalCount=trainService.queryCount();
        //获取的当前页码,这个是从页面获取的
        String currentPage = request.getParameter("currentPage");
        //进行封装
        PageTool pageTool=new PageTool(totalCount, currentPage);
//		List<Train> trainList = trainService.getAll();
        List<Train> trainList=trainService.findAllByPage(pageTool);
        //将分页信息存储
        request.setAttribute("pageTool", pageTool);
		if(trainList != null) {
			 //存储到域对象中
			request.setAttribute("trainList", trainList);
		}else {
			System.out.println("没有任何站点信息");
		}
		//转发
		request.getRequestDispatcher("pages/admin/right/getAllTrain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
