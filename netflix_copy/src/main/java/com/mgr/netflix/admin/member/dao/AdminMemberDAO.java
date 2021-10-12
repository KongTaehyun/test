package com.mgr.netflix.admin.member.dao;


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mgr.netflix.admin.member.vo.AdminMemberVO;



@Repository
public class AdminMemberDAO {
	
	@Autowired
    private SqlSessionTemplate mybatis;
	
	public List<AdminMemberVO> getAllMember(HashMap<String, Object> map){
		System.out.println("member-MyBatis - 회원 전체 목록");
		return mybatis.selectList("Member.getAllMember",map);
	}
	
	public AdminMemberVO getOneMember(AdminMemberVO vo)throws Exception{
		System.out.println("member-MyBatis - 회원 하나 목록(수정)");
		return mybatis.selectOne("Member.getOneMember",vo);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		System.out.println("member-MyBatis - 회원 수");
		return mybatis.selectOne("Member.getTotalCount");
	}
	
	public int insertMember(AdminMemberVO vo) {
		System.out.println("member-MyBatis - 회원 추가");
		return mybatis.insert("Member.insertMember",vo);
	}
	
	public int deleteMember(AdminMemberVO vo) {
		System.out.println("member-MyBatis - 회원 삭제");
		return mybatis.delete("Member.deleteMember",vo);
	}
	
	public int modifyMember(AdminMemberVO vo) {
		System.out.println("member-MyBatis - 회원 수정");
		return mybatis.update("Member.modifyMember",vo);
	}
	

}
