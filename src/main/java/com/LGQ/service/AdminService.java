package com.LGQ.service;

import java.sql.SQLException;
import java.util.List;

import com.LGQ.domain.Admin;

/**
 * @description 操作管理员的业务层接口
 * @author 刘国强
 * @version 1.0
 * @since 1.0
 * @date 2022年6月1日
 */
public interface AdminService {
	/**
	 * 添加管理员
	 * @return 返回1为添加管理员成功
	 * @throws SQLException
	 */
	int addAdmin(Admin admin);//添加管理员
	
	/**
	 * 删除管理员
	 * @return 返回1为删除管理员成功
	 * @throws SQLException
	 */
	int deleteAdmin(int adminId);//删除管理员
	
	/**
	 * 修改管理员个人信息
	 * @return 返回1为修改管理员个人信息成功
	 * @throws SQLException
	 */
	int updateAdmin(Admin admin);//修改管理员个人信息
	
	/**
	 * 获取所有管理员信息
	 * @return 返回元素为Admin对象的list
	 */
	List<Admin> getAllAdmin();//得到所有管理员的信息

	/**
	 * 根据id查询管理员信息
	 * @return Admin的对象
	 */
	Admin getAdminById(int adminId);
	
	/**
	 * 根据userName查询管理员信息
	 * @return Admin的对象
	 */
	Admin getAdminByName(String userName);
}
