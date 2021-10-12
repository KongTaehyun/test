package com.mgr.netflix.client.dao;



import java.util.List;
import java.util.Map;

import com.mgr.netflix.client.vo.ClientPaymentVO;
import com.mgr.netflix.client.vo.ClientVO;
import com.mgr.netflix.client.vo.ModifyClientVO;

public interface ClientDAO {
	
	
	public ClientVO AuthForLogin(String email);
	
	public void NoMembershipJoin(ClientVO newClient);
	
	public void MembershipJoin(ClientVO clientVO);
	
	public int changePwService(ModifyClientVO modifyVO);
	
	public String loadMembership(String email);
	
	public int changeMembership(ClientVO clientVO);
	
	public void modifybillingDate(ClientVO clientVO);
	
	public void changePaymentInfo(ClientPaymentVO clientPaymentVO);
	
}
