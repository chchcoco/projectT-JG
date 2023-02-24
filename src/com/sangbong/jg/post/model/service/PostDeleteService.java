package com.sangbong.jg.post.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.dao.PostDeleteMapper;

public class PostDeleteService {
	
	PostDeleteMapper mapper;
	
	public boolean postDelete(PostDTO post) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostDeleteMapper.class);
		
		int result = mapper.postDelete(post);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result>0? true: false;
		
	}

}
