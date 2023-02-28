package com.sangbong.jg.member.controller;


import com.sangbong.jg.member.model.service.MemberLoginService;

import javax.swing.JOptionPane;

import com.sangbong.jg.member.model.service.MemberJoinService;

import com.sangbong.jg.model.dto.MemberDTO;

public class MemberController {
	
	MemberLoginService memberLoginService = new MemberLoginService();
	MemberJoinService memberJoinService = new MemberJoinService();
	MemberDTO member;

	public boolean joinMember(String email, String nickname, char[] pwd, char[] pwdCheck) {

		String strPwd = new StringBuilder().append(pwd).toString();
		String strPwdCheck = new StringBuilder().append(pwdCheck).toString();
		boolean result = false;
		
		if(strPwd != null && strPwd != "" && email != "") {
			if(strPwd.equals(strPwdCheck)) {

				member = new MemberDTO();
				member.setEmail(email);
				member.setMemName(nickname);
				member.setPwd(strPwdCheck);
				
				result = memberJoinService.memberJoin(member);
			} else {
				JOptionPane.showMessageDialog(null, "입력한 비밀번호와 비밀번호 확인이 일치하지 않습니다.",
						"비밀번호 재입력!", JOptionPane.DEFAULT_OPTION);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "이메일, 닉네임, 비밀번호 중 하나를 비워두었습니다.",
					"모든 항목을 작성해주세요", JOptionPane.DEFAULT_OPTION);
		}
		
		return result;
	}

	public MemberDTO loginMember(String email, char[] pw) {
		

		MemberDTO member = new MemberDTO();
		
		member.setEmail(email);
		member.setPwd(new StringBuilder().append(pw).toString());
		
		MemberDTO result = memberLoginService.loginCheck(member);
		
		return result;
	}

}
