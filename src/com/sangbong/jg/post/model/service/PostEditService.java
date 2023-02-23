package com.sangbong.jg.post.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.dao.PostEditMapper;

public class PostEditService {
	
	PostEditMapper mapper;

	public boolean postEdit(PostDTO post) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostEditMapper.class);
		
		int result = mapper.postEdit(post);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result>0? true: false;
	}

}
