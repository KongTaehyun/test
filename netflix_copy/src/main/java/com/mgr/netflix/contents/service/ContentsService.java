package com.mgr.netflix.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgr.netflix.contents.dao.ContentsDAOImpl;
import com.mgr.netflix.contents.vo.ContentsVO;

@Service
public class ContentsService {
	@Autowired
	private ContentsDAOImpl contentsDaoImpl;
	
	public List<ContentsVO> ContentsList() {
		return contentsDaoImpl.selectAllContents();
	}
}
