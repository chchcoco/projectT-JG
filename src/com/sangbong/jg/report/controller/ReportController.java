package com.sangbong.jg.report.controller;

import java.util.List;

import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.model.service.ReportService;

public class ReportController {
	
	private final ReportService reportService = new ReportService();

	public List<ReportDTO> findReportList() {

		List<ReportDTO> reportList = reportService.findReportList();
		
		return reportList;
	}

	public int manageReport(ReportDTO report, String choice) {

		int result = reportService.manageReport(report, choice);
		
		return result;
	}

}
