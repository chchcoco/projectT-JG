package com.sangbong.jg.member.controller;

import com.sangbong.jg.member.model.service.MemberJoinService;
import com.sangbong.jg.model.dto.MemberDTO;

public class MemberController {
	
	MemberJoinService memberJoinService = new MemberJoinService();
	MemberDTO member;

	public String joinMember(String email, String nickname, char[] pwd, char[] pwdCheck) {

		String strPwd = new StringBuilder().append(pwd).toString();
		String strPwdCheck = new StringBuilder().append(pwdCheck).toString();
		
		if(strPwd != null && strPwd != "" && email != "") {
			if(strPwd.equals(strPwdCheck)) {

				member = new MemberDTO();
				member.setEmail(email);
				member.setMemName(nickname);
				member.setPwd(strPwdCheck);

			}
		} else {
			/*회원가입 실패*/
		}
		
		
		
		
		
		
		
		return member.toString();
	}

}