package com.mgr.netflix.client.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.netflix.client.dao.ClientDAOImpl;
import com.mgr.netflix.client.vo.AuthInfo;
import com.mgr.netflix.client.vo.ClientVO;

@Service
public class AuthService {
	@Autowired
	private ClientDAOImpl clientDAOImpl;
	
	public AuthInfo authenticate(String email, String password) throws Exception {
		ClientVO client = clientDAOImpl.AuthForLogin(email);

		if(client==null) {
			throw new Exception("회원이 없습니다.");
		}
		if(!client.CheckPassword(password)) {
			throw new Exception("비밀번호가 맞지 않습니다");
		}
		return new AuthInfo(client.getEmail(), client.getMembership(), client.getPassword(), client.getName(), client.getBirthYear(),client.getBirthMonth(), client.getBirthDay());
		//생성자 에메일 멤버쉽 비밀번호 이름 생년월일 등록
	}
	
	
}
