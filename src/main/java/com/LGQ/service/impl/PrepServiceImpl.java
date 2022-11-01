package com.LGQ.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.LGQ.dao.PrepDao;
import com.LGQ.dao.impl.PrepDaoImpl;
import com.LGQ.domain.Prep;
import com.LGQ.domain.Train;
import com.LGQ.service.PrepService;

/**
 * 
 * @ClassName: PrepServiceImpl 
 * @Description: PrepService的实现类
 * @author: 刘国强
 * @date: 2022年6月1日 下午10:46:51
 */
public class PrepServiceImpl implements PrepService {
	
	private PrepDao prepDao = new PrepDaoImpl();
	private static Logger logger = Logger.getLogger(PrepServiceImpl.class);

	@Override
	public int add(Prep prep) {
		int recordNumber = 0;
		if(prep!=null) {
			try {
				recordNumber = prepDao.add(prep);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PrepServiceImpl.add 中 prep为null");
		}
		return recordNumber;
	}

	@Override
	public int delete(Integer prepId) {
		int recordNumber = 0;
		if(prepId!=null && prepId!=0) {
			try {
				recordNumber = prepDao.delete(prepId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PrepServiceImpl.delete 中 prepId为null或0");
		}
		return recordNumber;
	}

	@Override
	public int update(Prep prep) {
		int recordNumber = 0;
		if(prep!=null) {
			try {
				recordNumber = prepDao.update(prep);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PrepServiceImpl.update 中 prep为null");
		}
		return recordNumber;
	}

	@Override
	public List<Prep> getAll() {
		List<Prep> list = null;
		try {
			list = prepDao.getAll();
		} catch (SQLException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Prep> getPrepByPmemberId(Integer pmemberId) {
		List<Prep> list = null;
		if(pmemberId!=null && pmemberId!=0) {
			try {
				list = prepDao.getPrepByPmemberId(pmemberId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		} else {
			logger.debug("PrepServiceImpl.getPrepByPmemberId 中 pmemberId为null或0");
		}		
		return list;
	}

	@Override
	public Prep getById(Integer prepId) {
		Prep prep = null;
		if(prepId!=null && prepId!=0) {
			try {
				prep = prepDao.getById(prepId);
			} catch (SQLException e) {
				logger.error(e.toString());
				e.printStackTrace();
			}
		}else {
			logger.debug("PrepServiceImpl.getById 中 prepId为null或0");
		}
		return prep;
	}

}
