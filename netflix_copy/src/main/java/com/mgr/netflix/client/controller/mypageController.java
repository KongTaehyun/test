package com.mgr.netflix.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mgr.netflix.client.dao.ClientDAOImpl;
import com.mgr.netflix.client.service.AuthService;
import com.mgr.netflix.client.service.ChangeMembership;
import com.mgr.netflix.client.service.ChangePasswordService;
import com.mgr.netflix.client.service.ChangePaymentInfoService;
import com.mgr.netflix.client.service.LoadMembershipService;
import com.mgr.netflix.client.service.ModifyBillingdateService;
import com.mgr.netflix.client.validator.ChangePaymentValidator;
import com.mgr.netflix.client.vo.AuthInfo;
import com.mgr.netflix.client.vo.ClientLoginVO;
import com.mgr.netflix.client.vo.ClientPaymentVO;
import com.mgr.netflix.client.vo.ClientVO;
import com.mgr.netflix.client.vo.ModifyClientVO;

@Controller
@RequestMapping("/mypage/")
public class mypageController {
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private LoadMembershipService loadMembershipService;
	@Autowired
	private ChangeMembership changeMembership;
	@Autowired
	private AuthService authService;
	@Autowired
	private ModifyBillingdateService modifyBillingDateService;
	@Autowired
	private ChangePaymentInfoService changePaymentInfoService;
	
	//로그인이 안돼있으면 모든기능에 접근하지못하도록 해야한다.	
	@RequestMapping(value="mypage.do", method = RequestMethod.GET)
	public String mypage() {
		return "mypage/mypage";
	}
	
	//비밀번호 변경
	@RequestMapping(value="changePw.do", method=RequestMethod.GET)
	public String changePwStep1(@ModelAttribute("ModifyClientVO")ModifyClientVO modifyClientVO, 
								@ModelAttribute("loginVo")ClientLoginVO loginVo,HttpSession session) {
		if((AuthInfo)session.getAttribute("authInfo")==null) {
			return "redirect:/clientLogin.do";
		}
		return "mypage/pwChange";
	}
	
	@ResponseBody
	@RequestMapping(value="changePw.do", method=RequestMethod.POST, produces = "application/json; charset=utf8")
	public int changePw(ModifyClientVO modifyClientVO, Errors errors, HttpSession session) {
		if(errors.hasErrors()) {
			System.out.println("error발생");
			return 0;
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		System.out.println(modifyClientVO.getCurrenPassword());
		try {
			if(modifyClientVO.getCurrenPassword().equals(authInfo.getPassword())) {//세션에 있는 정보의 비번이랑 일치하는지 확인
				modifyClientVO.setEmail(authInfo.getEmail());
				int result = changePasswordService.changePwService(modifyClientVO.getCurrenPassword(), modifyClientVO.getNewPassword(),modifyClientVO);
				authInfo.setPassword(modifyClientVO.getNewPassword());
				session.setAttribute("authInfo", authInfo);
				return result;
			}else {
				return 0;
			}
		}catch(Exception e){
			System.out.println("기존비밀번호가 일치하지 않습니다");
			return 0;
		}
	}
	
	//멤버쉽 바꾸기 
	@RequestMapping(value="changeplan.do", method=RequestMethod.GET)
	public String changePlan(HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try {
			String originMembership = loadMembershipService.loadMembership(authInfo.getEmail());
			if(authInfo.getMembership().equals(originMembership)) {
				return "mypage/changeplan";				
			}
		} catch (Exception e) {
			return "mypage/mypage";
		}
		return "mypage/mypage";
	}
	
	@ResponseBody
	@RequestMapping(value="changeplan.do", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public int changePlan2(@RequestParam Map<String, Object> item, HttpSession session) {
		System.out.println(item.get("select_item"));
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String email = authInfo.getEmail();
		int result = changeMembership.changeMembership(email, (String)item.get("select_item"));
		System.out.println(result);
		if(result==1) {
			authInfo.setMembership((String)item.get("select_item"));
			session.setAttribute("authInfo", authInfo);
		}else {
			return 0;
		}
	
		return result;
	}
	
	//결제일변경
	@RequestMapping(value="changepaymentdate.do", method = RequestMethod.GET)
	public String changePaymentDate() {
		return "mypage/Changepaymentdate_1";
	}
	
	
	@RequestMapping(value="changepaymentdate.do", method = RequestMethod.POST)
	public String changePaymentDate(@RequestParam("newBillingDay") String newBillingDay, HttpSession session, HttpServletResponse response) throws IOException {
		//System.out.println(newBillingDay);
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		modifyBillingDateService.modifyBillingDate(authInfo.getEmail(),newBillingDay);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('멤버쉽 변경이 완료됐습니다');</script>");
		out.flush();
		return "mypage/mypage";
	}
	
	//결제정보변경
	@RequestMapping(value="managePaymentInfo.do", method = RequestMethod.GET)
	public String managePaymentInfo(@ModelAttribute("clientPaymentVO")ClientPaymentVO clientPaymentVO) {
		return "mypage/Managepaymentinformation_1";
	}
	
	@RequestMapping(value="managePaymentInfo.do", method = RequestMethod.POST)
	public String managePaymentInfo2(@ModelAttribute("clientPaymentVO")ClientPaymentVO clientPaymentVO, HttpServletResponse response,HttpSession session, Errors errors) throws IOException  {
		
		
		new ChangePaymentValidator().validate(clientPaymentVO, errors);
		
		if(errors.hasErrors()) {
			return "mypage/Managepaymentinformation_1";
		}
		if(!clientPaymentVO.isAgree()) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('카드정보공유에 대한 동의를 해주세요.');</script>");
			out.flush();
			return "redirect:/mypage/Managepaymentinformation_1";
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		clientPaymentVO.setEmail(authInfo.getEmail());
		//서비스 통해서update
		System.out.println(clientPaymentVO);
		changePaymentInfoService.changePaymentInfo(clientPaymentVO);
		return "mypage/mypage";
	}
	
	//결제상세정보
	@RequestMapping(value="paymentdetail.do", method=RequestMethod.GET)
	public String paymentdetail() {
		return "mypage/payment_details";
	}
	
	//휴대폰 번호 변경
	@RequestMapping(value="changephone.do", method = RequestMethod.GET)
	public String phoneChange() {
		return "mypage/phoneChange";
	}
	
	//이메일 변경
	@RequestMapping(value="changeemail.do", method = RequestMethod.GET)
	public String emailChange() {
		return "mypage/emailChange";
	}
	//멤버쉽해지
	@RequestMapping(value="planCancel.do", method = RequestMethod.GET)
	public String planCancel() {
		return "mypage/planCancel";
	}
	
}
