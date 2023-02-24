package com.sangbong.jg.member.model.dao;

import java.util.Map;

import com.sangbong.jg.model.dto.MemberDTO;

public interface MemberInfoMapper {

	MemberDTO selectMemberById(Map<String, String> map);

	int updateMemberName(Map<String, String> map);

	MemberDTO selectMemberByEmailAndPwd(Map<String, String> map);

	int updatePwd(Map<String, String> map);

	int deleteMember(Map<String, String> map);

	int updatePenaltyCnt(Map<String, String> map);

}
