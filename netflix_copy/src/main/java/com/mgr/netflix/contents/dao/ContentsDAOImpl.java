package com.mgr.netflix.contents.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mgr.netflix.client.vo.ClientVO;
import com.mgr.netflix.contents.vo.ContentsVO;


@Repository
public class ContentsDAOImpl implements ContentsDAO{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Contents";

	@Override
	public List<ContentsVO> selectAllContents() {
		
		return sqlSession.selectList(namespace +".SelectAll"); 
	}
	

}
