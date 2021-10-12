package com.mgr.netflix.client.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mgr.netflix.client.vo.ClientPaymentVO;
import com.mgr.netflix.client.vo.ClientVO;
import com.mgr.netflix.client.vo.ModifyClientVO;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace="Client";
	

	@Override
	public ClientVO AuthForLogin(String email) {
		
		return sqlSession.selectOne(namespace+".SelectByEmail", email);		
	}


	@Override
	public void NoMembershipJoin(ClientVO newClient) {
		sqlSession.insert(namespace+".InsertNoMembership", newClient);
	}


	@Override
	public void MembershipJoin(ClientVO clientVO) {
		
	}


	@Override
	public int changePwService(ModifyClientVO modifyVO) {
		return sqlSession.update(namespace+".ChangePassword", modifyVO);
	}


	@Override
	public String loadMembership(String email) {
		return sqlSession.selectOne(namespace+".LoadMembership", email);
	}


	@Override
	public int changeMembership(ClientVO clientVO) {
		return sqlSession.update(namespace + ".ChangeMembership", clientVO);
	}


	@Override
	public void modifybillingDate(ClientVO clientVO) {
		sqlSession.update(namespace+".ModifyBillindDate", clientVO);
		
	}


	@Override
	public void changePaymentInfo(ClientPaymentVO clientPaymentVO) {
		sqlSession.update(namespace+".ChangePaymentInfo", clientPaymentVO);
		
	}



}
