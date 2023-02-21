package com.sangbong.jg.member.model.dao;

import java.util.Map;

import com.sangbong.jg.model.dto.MemberDTO;

public interface MemberInfoMapper {

	MemberDTO selectMemberById(Map<String, String> map);

}
