package com.sangbong.jg.member.controller;

import java.util.Map;

import com.sangbong.jg.member.model.service.MemberInfoService;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.ui.MemberInfoView;

public class MemberInfoController {

	private final MemberInfoService memberInfoService;
	private MemberInfoView memberInfoView;
	
	public MemberInfoController() {
		this.memberInfoService = new MemberInfoService();
	}

	public MemberDTO findMemberInfo(Map<String, String> member) {

		String email = member.get("email");
		
		MemberDTO memberFound = memberInfoService.findMemberInfo(email);
		this.memberInfoView = new MemberInfoView(memberFound);
		
		return memberFound;
	}

	public int changeMemberName(MemberDTO member) {

		int result = memberInfoService.changeMemberName(member);

		return result;
	}
	
	
	
}
