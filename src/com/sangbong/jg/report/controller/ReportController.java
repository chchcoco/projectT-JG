package com.sangbong.jg.report.controller;

import java.util.List;

import com.sangbong.jg.member.model.service.MemberInfoService;
import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.model.service.ReportService;

public class ReportController {

	private final ReportService reportService = new ReportService();
	private final MemberInfoService memberInfoService = new MemberInfoService();

	public List<ReportDTO> findReportList() {

		List<ReportDTO> reportList = reportService.findReportList();

		return reportList;
	}

	public int approveReport(ReportDTO report) {

		int result = reportService.approveReport(report);

		return result;
	}

	public int discardReport(ReportDTO report) {

		int result = reportService.discardReport(report);

		return result;
	}

	public int addPenaltyToMember(ReportDTO report) {

		int result = memberInfoService.addPenaltyToMember(report);
		
		return result;
	}

}
