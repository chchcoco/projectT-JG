package com.sangbong.jg.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.member.model.dao.MemberInfoMapper;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.ReportDTO;

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

	public int changeMemberName(String input, String email) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberInfoMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("newName", input);
		map.put("email", email);
		
		int result = mapper.updateMemberName(map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public MemberDTO confirmPwd(String inputOldPwd, String email) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberInfoMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("pwd", inputOldPwd);
		map.put("email", email);
		
		MemberDTO member = mapper.selectMemberByEmailAndPwd(map);
		
		sqlSession.close();
		
		return member;
	}

	public int changePwd(String inputNewPwd, String email) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberInfoMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("newPwd", inputNewPwd);
		map.put("email", email);
		
		int result = mapper.updatePwd(map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int deactivateMember(String email) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberInfoMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		
		int result = mapper.updateDeacYn(map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int addPenaltyToMember(ReportDTO report) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(MemberInfoMapper.class);
		
		Map<String, String> map = new HashMap<>();
		map.put("reportedEmail", report.getReportedEmail());
		
		int result = mapper.updatePenaltyCnt(map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	
	
}
