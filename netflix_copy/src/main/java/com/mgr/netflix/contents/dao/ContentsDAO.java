package com.mgr.netflix.contents.dao;

import java.util.List;


import com.mgr.netflix.contents.vo.ContentsVO;

public interface ContentsDAO {
	
	public List<ContentsVO> selectAllContents();
}
