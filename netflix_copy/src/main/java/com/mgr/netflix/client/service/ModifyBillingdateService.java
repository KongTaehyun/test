package com.mgr.netflix.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.netflix.client.dao.ClientDAOImpl;
import com.mgr.netflix.client.vo.ClientVO;

@Service
public class ModifyBillingdateService {
	
	@Autowired
	private ClientDAOImpl clientDaoImpl;
	
	public void modifyBillingDate(String email, String newBillingDay) {
		ClientVO clientVO = new ClientVO();
		clientVO.setEmail(email);
		clientVO.setBillingDate(newBillingDay);
		clientDaoImpl.modifybillingDate(clientVO);
	}

	
}
