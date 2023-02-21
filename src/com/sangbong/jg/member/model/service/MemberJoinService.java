package com.sangbong.jg.member.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.member.model.dao.MemberJoinMapper;
import com.sangbong.jg.model.dto.MemberDTO;

public class MemberJoinService {
	MemberJoinMapper mapper;
	
	public boolean memberJoin(MemberDTO member) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberJoinMapper.class);
		
		int result = mapper.memberJoin(member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result>0? true: false;
		
	}

}
