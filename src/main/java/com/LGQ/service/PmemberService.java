package com.LGQ.service;

import java.sql.SQLException;
import java.util.List;

import com.LGQ.domain.Pmember;

/**
 * 
 * @ClassName: PmemberService 
 * @Description: 操作会员个人信息的业务层接口
 * @author: 刘国强
 * @date: 2022年6月1日 下午10:49:46
 */
public interface PmemberService {
	/**
	 * 添加个人信息
	 * @return 返回1为添加成功
	 * @throws SQLException
	 */
	int add(Pmember pmember);
	
	/**
	 * 删除个人信息
	 * @return 返回1为删除成功
	 * @throws SQLException
	 */
	int delete(Integer pmemberId);
	
	/**
	 * 修改个人信息
	 * @return 返回1为修改成功
	 * @throws SQLException
	 */
	int update(Pmember pmember);
	
	/**
	 * 根据会员ID查询这个会员的个人信息
	 * @param memberId 会员ID
	 * @return
	 * @throws SQLException
	 */
	Pmember getPmemberByMemberId(Integer memberId);
	
	/**
	 * 根据id查询会员个人信息
	 * @return Pmember的对象
	 * @throws SQLException
	 */
	Pmember getById(Integer pmemberId);
}
