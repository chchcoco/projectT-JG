package com.sangbong.jg.post.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.dao.PostNewMapper;

public class PostNewService {

	PostNewMapper mapper;
	
	public boolean postNew(PostDTO post) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostNewMapper.class);
		
		int result = mapper.postNew(post);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result>0? true: false;
		
	}

}
