package com.LGQ.dao;

import java.sql.SQLException;
import java.util.List;

import com.LGQ.domain.PageTool;
import com.LGQ.domain.Train;

/**
 * 
 * @ClassName: TrainDao 
 * @Description: Train表(车票，火车)的数据持久层接口
 * @author: 刘国强
 * @date: 2022年6月1日 下午1:33:46
 */
public interface TrainDao {
	
	/**
	 * 添加车次
	 * @return 返回1为添加成功
	 * @throws SQLException
	 */
	int add(Train train) throws SQLException;
	
	/**
	 * 删除车次
	 * @return 返回1为删除成功
	 * @throws SQLException
	 */
	int delete(Integer trainId) throws SQLException;
	
	/**
	 * 修改车次
	 * @return 返回1为修改成功
	 * @throws SQLException
	 */
	int update(Train train) throws SQLException;
	
	/**
	 * 获取所有车次信息
	 * @return 返回元素为Train对象的list
	 * @throws SQLException
	 */
	List<Train> getAll() throws SQLException;
	
	/**
	 * 根据id查询车次信息
	 * @return Train的对象
	 * @throws SQLException
	 */
	Train getById(Integer trainId) throws SQLException;
	
	/**
	 * 根据车次查询车次信息
	 * @return 元素为Train的对象的list
	 * @throws SQLException
	 */
	List<Train> getByTrainNumber(String trainNumber) throws SQLException;
	
	/**
	 * 根据起始站、终点站、开车时间、查询车次信息
	 * @param startStation 起始站
	 * @param endStation 终点站
	 * @param startTime 传进去的时候没有时分秒
	 * @return Train的对象
	 * @throws SQLException
	 */
	List<Train> getByStartEndStation(String startStation, String endStation, String startTime) throws SQLException;
	
	/**
	 * 获取所有非重复的起始站
	 * @return
	 * @throws SQLException
	 */
	List<Train> getAllStartStation() throws SQLException;
	
	/**
	 * 获取所有非重复的终点站
	 * @return
	 * @throws SQLException
	 */
	List<Train> getAllEndStation() throws SQLException;

	int queryCount()throws SQLException;//统计数量
	
    List<Train> findAllByPage(PageTool pageTool)throws SQLException;//分页
}
