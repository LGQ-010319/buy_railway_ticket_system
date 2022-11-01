package com.LGQ.service;

import java.util.List;

import com.LGQ.domain.Member;

/**
 * @description 操作会员登录/注册的业务层接口
 * @author 刘国强
 * @version 1.0
 * @since 1.0
 * @date 2022年6月1日
 */
public interface MemberService {
	
	int addMember(Member member);//会员注册
	
	int deleteMember(int memberId);//删除
	
	int updateMember(Member member);//修改会员个人信息
	
	List<Member> getAllMember();//得到所有会员信息
	
	Member getMemberById(int memberId);
	
	Member getMemberByName(String userName);
}
