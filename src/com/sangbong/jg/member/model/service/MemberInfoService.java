package com.sangbong.jg.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.member.model.dao.MemberInfoMapper;
import com.sangbong.jg.model.dto.MemberDTO;

import static com.sangbong.jg.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.Map;

public class MemberInfoService {

	private MemberInfoMapper mapper;
	
	public MemberDTO findMemberInfo(String email) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberInfoMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		
		MemberDTO member = mapper.selectMemberById(map);
		
		sqlSession.close();
		
		return member;
	}

	
	
}
