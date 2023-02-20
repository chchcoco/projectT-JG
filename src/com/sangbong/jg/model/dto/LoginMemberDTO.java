package com.sangbong.jg.model.dto;

public class LoginMemberDTO {

	private String email;
	private String memName;
	private String memType;
	
	public LoginMemberDTO() {}

	public LoginMemberDTO(String email, String memName, String memType) {
		super();
		this.email = email;
		this.memName = memName;
		this.memType = memType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemType() {
		return memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	@Override
	public String toString() {
		return "LoginMemberDTO [email=" + email + ", memName=" + memName + ", memType=" + memType + "]";
	}
	
	
	
}
