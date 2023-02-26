package com.sangbong.jg.post.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.dao.PostSearchMapper;

import static com.sangbong.jg.common.Template.getSqlSession;

public class PostSearchService {
	
	private PostSearchMapper mapper;

	public List<PostDTO> findMyPostList(MemberDTO loginInfo) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostSearchMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("email", loginInfo.getEmail());
		
		List<PostDTO> myPostList = mapper.selectPostByEmail(map);
		
		sqlSession.close();
		
		return myPostList;
	}

}
