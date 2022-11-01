package com.LGQ.dao;

import java.sql.SQLException;
import java.util.List;

import com.LGQ.domain.Member;

/**
 * @description Member(会员登录信息)数据表持久层接口
 * @version 1.0
 * @since 1.0  
 * @author 20软件技术1班刘国强20号
 * @date 2022年6月1日
 */
public interface MemberDao {
	int add(Member member) throws SQLException;
	
	int delete(int memberId) throws SQLException;
	
	int update(Member member) throws SQLException;
	
	
	List<Member> getAll() throws SQLException;
	
	Member getMemberById(int memberId) throws SQLException;
	
	Member getMemberByName(String userName) throws SQLException;
}
