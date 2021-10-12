package com.mgr.netflix.client.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mgr.netflix.client.service.AuthService;
import com.mgr.netflix.client.service.JoinService;
import com.mgr.netflix.client.vo.AuthInfo;
import com.mgr.netflix.client.vo.ClientJoinVO;

@Controller
@RequestMapping("/join/")
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	@Autowired
	private AuthService authService;
	
	
	
	@RequestMapping(value="step1.do",method = RequestMethod.GET)
	public String handleStep1() {
		return "join/1";
	}
	
	@RequestMapping(value="step2.do", method=RequestMethod.GET) 
	public String handleStep2(Model model) {
		model.addAttribute("formData", new ClientJoinVO());
		return "join/2";
	}
	
	@RequestMapping(value="step3.do", method = RequestMethod.POST)
	public String handleStep3(@RequestParam(value="pipcConsent", defaultValue = "false")boolean agree,
							  @RequestParam(value="emailPreference", defaultValue = "false")boolean sms,
							  @ModelAttribute(value = "formData")ClientJoinVO joinVO, HttpSession session){
		
		if(!agree) {
			return "redirect:/join/step2.do";
		}
		try {
			joinService.nomembership_join(joinVO);//여긴 지금 회원정보에 아이디, 비밀번호 밖에 안들어가 있음 나머지는 결제할때 update!
			AuthInfo authInfo = authService.authenticate(joinVO.getEmail(), joinVO.getPassword());//가입하자마자 바로 로그인됨
			session.setAttribute("authInfo", authInfo);//세션등록, 멤버쉽 부분은 null인 상태기 때문에 멤버쉽 가입후에 다시 세션등록 
		}catch (Exception e) {
			System.out.println("아이디중복!");//이미 있는 계정일 경우 오류를 던지도록 설계 JoinService참고
			return "redirect:/join/step2.do";//step2로 보내는데 메세지를 띄워야한다.
		}
		
		return "join/3";
	}
	
	//url로 직접 접근했을경우 전페이지로redirect
	@RequestMapping(value="step3.do", method = RequestMethod.GET)
	public String handleStep3(){
			return "redirect:/join/step2.do";
	}
	@RequestMapping(value="step4.do", method = RequestMethod.GET)
	public String handleStep4() {
		return "join/4"; 
	}
	
	@RequestMapping(value="step5.do", method = RequestMethod.POST)
	public String handleStep5(@RequestParam(value="planChoice")String membership, HttpSession session) {
		AuthInfo authInfo =  (AuthInfo)session.getAttribute("authInfo");//세션에서 정보를 얻어온다.
		authInfo.setMembership(membership); //일단 세션 회원정보에는 멤버쉽을 넣어줌 -> 이후 결제 완료시 db 입력
		session.setAttribute("authInfo", authInfo);//세션재등록 
		return "join/5";
	}
	
}
