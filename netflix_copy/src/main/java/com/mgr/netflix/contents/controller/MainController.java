package com.mgr.netflix.contents.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mgr.netflix.contents.service.ContentsService;
import com.mgr.netflix.contents.vo.ContentsVO;

@Controller
public class MainController {
	
	@Autowired
	private ContentsService contentsService;
	
	@RequestMapping(value="/main.cdo", method = RequestMethod.GET)
	public String Main01(HttpSession session) {
		List<ContentsVO> contentsList=contentsService.ContentsList();
		session.setAttribute("contentsList", contentsList);
		for(ContentsVO i : contentsList) {
			System.out.println(i.toString());
			
		}
		
		return "main";
	}
}
