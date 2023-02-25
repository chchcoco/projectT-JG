package com.sangbong.jg.member.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.member.model.dao.MemberLoginMapper;
import com.sangbong.jg.model.dto.MemberDTO;

public class MemberLoginService {

	public MemberDTO loginCheck(MemberDTO member) {
		
		SqlSession sqlSession = getSqlSession();
		
		MemberLoginMapper memberMapper = sqlSession.getMapper(MemberLoginMapper.class);
		
		MemberDTO result = memberMapper.loginCheckMember(member);
		
		sqlSession.close();
		
//		return result != null? true: false;
		return result;
	}

	
}
