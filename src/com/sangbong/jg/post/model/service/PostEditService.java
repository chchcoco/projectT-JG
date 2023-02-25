package com.sangbong.jg.post.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.dao.PostEditMapper;

public class PostEditService {
	
	PostEditMapper mapper;

	public PostDTO postEdit(PostDTO post) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostEditMapper.class);
		
		int result = mapper.postEdit(post);
		PostDTO resultPost = mapper.postGetByCode(post);
		
		if(result > 0 && resultPost != null) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return resultPost;
	}

}
