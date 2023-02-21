package com.sangbong.jg.member.model.dao;

import com.sangbong.jg.model.dto.MemberDTO;

public interface MemberLoginMapper {

	MemberDTO loginCheckMember(MemberDTO member);

}
