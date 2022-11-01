package com.LGQ.service.impl;

import java.sql.SQLException;

import java.util.List;

import org.apache.log4j.Logger;

import com.LGQ.dao.TrainDao;
import com.LGQ.dao.impl.TrainDaoImpl;
import com.LGQ.domain.PageTool;
import com.LGQ.domain.Train;
import com.LGQ.service.TrainService;

/**
 * 
 * @ClassName: TrainServiceImpl 
 * @Description: TrainService的实现类
 * @author: 刘国强
 * @date: 2022年6月1日 下午10:47:50
 */
public class TrainServiceImpl implements TrainService {
	
	private TrainDao trainDao = new TrainDaoImpl();
	private static Logger logger = Logger.getLogger(TrainServiceImpl.class);
	
    public int queryCount() {
    	int count=0;
        try {
			count= trainDao.queryCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
    }
    @Override
    public List<Train> findAllByPage(PageTool pageTool) {
    	List<Train> list = null;
        try {
			  list = trainDao.findAllByPage(pageTool);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }



	@Override
	public int add(Train train) {
		int recordNumber = 0;
		if(train!=null) {
			try {
				recordNumber = trainDao.add(train);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.add 中 train为null");
		}
		return recordNumber;
	}

	@Override
	public int delete(Integer trainId) {
		int recordNumber = 0;
		if(trainId!=null && trainId!=0) {
			try {
				recordNumber = trainDao.delete(trainId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.delete 中 trainId为null或0");
		}
		return recordNumber;
	}

	@Override
	public int update(Train train) {
		int recordNumber = 0;
		if(train!=null) {
			try {
				recordNumber = trainDao.update(train);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.update 中 train为null");
		}
		return recordNumber;
	}

	@Override
	public List<Train> getAll() {
		List<Train> list = null;
		try {
			list = trainDao.getAll();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Train getById(Integer trainId) {
		Train train = null;
		if(trainId!=null && trainId!=0) {
			try {
				train = trainDao.getById(trainId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("TrainServiceImpl.getById 中 trainId为null或0");
		}
		return train;
	}

	@Override
	public List<Train> getByTrainNumber(String trainNumber) {
		List<Train> list = null;
		if(trainNumber!=null && !"".equals(trainNumber)) {
			try {
				list = trainDao.getByTrainNumber(trainNumber);		
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Train> getByStartEndStation(String startStation, String endStation, String startTime) {
		List<Train> list = null;
		if(startStation!=null && !"".equals(startStation) && endStation!=null && !"".equals(endStation) 
				&& startTime!=null && !"".equals(startTime)) {
			
			try {
				list = trainDao.getByStartEndStation(startStation, endStation, startTime);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
			
		} else {
			logger.debug("TrainServiceImpl.getByStartEndStation: 信息不完整！！！");
		}
		return list;
	}

	@Override
	public List<Train> getAllStartStation() {
		List<Train> list = null;
		try {
			list = trainDao.getAllStartStation();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Train> getAllEndStation() {
		List<Train> list = null;
		try {
			list = trainDao.getAllEndStation();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}
	
    

}
