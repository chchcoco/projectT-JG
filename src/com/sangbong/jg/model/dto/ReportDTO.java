package com.sangbong.jg.model.dto;

public class ReportDTO {

	private String reportCode;
	private String reporterEmail;
	private String reportedEmail;
	private String reportReason;
	
	public ReportDTO() {}

	public ReportDTO(String reportCode, String reporterEmail, String reportedEmail, String reportReason) {
		super();
		this.reportCode = reportCode;
		this.reporterEmail = reporterEmail;
		this.reportedEmail = reportedEmail;
		this.reportReason = reportReason;
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

	@Override
	public String toString() {
		return "ReportDTO [reportCode=" + reportCode + ", reporterEmail=" + reporterEmail + ", reportedEmail="
				+ reportedEmail + ", reportReason=" + reportReason + "]";
	}
	
	
	
}
