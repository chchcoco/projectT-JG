package com.sangbong.jg.model.dto;

import java.sql.Date;

public class ReportDTO {

	private String reportCode;
	private String reporterEmail;
	private String reportedEmail;
	private String reportReason;
	private Date reportDate;
	private String repostContext;
	private char reportApproval;
	
	public ReportDTO() {}

	public ReportDTO(String reportCode, String reporterEmail, String reportedEmail, String reportReason,
			Date reportDate, String repostContext, char reportApproval) {
		super();
		this.reportCode = reportCode;
		this.reporterEmail = reporterEmail;
		this.reportedEmail = reportedEmail;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
		this.repostContext = repostContext;
		this.reportApproval = reportApproval;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getReporterEmail() {
		return reporterEmail;
	}

	public void setReporterEmail(String reporterEmail) {
		this.reporterEmail = reporterEmail;
	}

	public String getReportedEmail() {
		return reportedEmail;
	}

	public void setReportedEmail(String reportedEmail) {
		this.reportedEmail = reportedEmail;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getRepostContext() {
		return repostContext;
	}

	public void setRepostContext(String repostContext) {
		this.repostContext = repostContext;
	}

	public char getReportApproval() {
		return reportApproval;
	}

	public void setReportApproval(char reportApproval) {
		this.reportApproval = reportApproval;
	}

	@Override
	public String toString() {
		return "ReportDTO [reportCode=" + reportCode + ", reporterEmail=" + reporterEmail + ", reportedEmail="
				+ reportedEmail + ", reportReason=" + reportReason + ", reportDate=" + reportDate + ", repostContext="
				+ repostContext + ", reportApproval=" + reportApproval + "]";
	}
	
	
	
}
