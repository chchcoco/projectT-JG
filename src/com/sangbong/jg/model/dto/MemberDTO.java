package com.sangbong.jg.model.dto;

import java.sql.Date;

public class MemberDTO {

	private String email;
	private String pwd;
	private String memName;
	private int penaltyCnt;
	private char activeYn;
	private char deacYn;
	private Date entDate;
	private Date deacDate;
	private String memType;
	
	public MemberDTO() {}

	public MemberDTO(String email, String pwd, String memName, int penaltyCnt, char activeYn, char deacYn, Date entDate,
			Date deacDate, String memType) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.memName = memName;
		this.penaltyCnt = penaltyCnt;
		this.activeYn = activeYn;
		this.deacYn = deacYn;
		this.entDate = entDate;
		this.deacDate = deacDate;
		this.memType = memType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getPenaltyCnt() {
		return penaltyCnt;
	}

	public void setPenaltyCnt(int penaltyCnt) {
		this.penaltyCnt = penaltyCnt;
	}

	public char getActiveYn() {
		return activeYn;
	}

	public void setActiveYn(char activeYn) {
		this.activeYn = activeYn;
	}

	public char getDeacYn() {
		return deacYn;
	}

	public void setDeacYn(char deacYn) {
		this.deacYn = deacYn;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public Date getDeacDate() {
		return deacDate;
	}

	public void setDeacDate(Date deacDate) {
		this.deacDate = deacDate;
	}

	public String getMemType() {
		return memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", pwd=" + pwd + ", memName=" + memName + ", penaltyCnt=" + penaltyCnt
				+ ", activeYn=" + activeYn + ", deacYn=" + deacYn + ", entDate=" + entDate + ", deacDate=" + deacDate
				+ ", memType=" + memType + "]";
	}
	
	
	
}
