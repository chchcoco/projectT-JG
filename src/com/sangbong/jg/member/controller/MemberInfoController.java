package com.sangbong.jg.member.controller;

import java.util.List;
import java.util.Map;

import com.sangbong.jg.member.model.service.MemberInfoService;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostSearchService;
import com.sangbong.jg.ui.MemberInfoView;

public class MemberInfoController {

	private final MemberInfoService memberInfoService;
	private final PostSearchService postSearchService;
	
	public MemberInfoController() {
		this.memberInfoService = new MemberInfoService();
		this.postSearchService = new PostSearchService();
	}

	public MemberDTO findMemberInfo(MemberDTO member) {

		String email = member.getEmail();
		
		MemberDTO memberFound = memberInfoService.findMemberInfo(email);
		
		return memberFound;
	}

	public int changeMemberName(String input, MemberDTO member) {
		
		String email = member.getEmail();

		int result = memberInfoService.changeMemberName(input, email);

		return result;
	}

	public MemberDTO confirmPwd(String inputOldPwd, MemberDTO member) {

		String email = member.getEmail();
		
		MemberDTO memberFound = memberInfoService.confirmPwd(inputOldPwd, email);
		
		return memberFound;
	}

	public int changePwd(String inputNewPwd, MemberDTO member) {

		String email = member.getEmail();
		
		int result = memberInfoService.changePwd(inputNewPwd, email);
		
		return result;
	}

	public int deactivateMember(MemberDTO member) {

		String email = member.getEmail();
		
		int result = memberInfoService.deactivateMember(email);
		
		return result;
	}

	public List<PostDTO> findMyPostList(MemberDTO loginInfo) {

		List<PostDTO> myPostList = postSearchService.findMyPostList(loginInfo);
		
		return myPostList;
	}
}
