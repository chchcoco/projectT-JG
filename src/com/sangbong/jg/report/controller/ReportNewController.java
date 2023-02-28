package com.sangbong.jg.report.controller;

import javax.swing.JOptionPane;

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.model.service.ReportNewService;

public class ReportNewController {

	ReportNewService reportNewService = new ReportNewService();
	ReportDTO report;
	ReportDTO result;
	
	public ReportDTO newReport(/*String categoryCode,*/ String email, /*String reportCode,*/ String reportedEmail, String reportReason, String repostContext) {

//		CategoryDTO ctgDTO = new CategoryController().getOneCategoryByName(categoryCode);


		if(/*categoryCode != null &&*/ email != null /*&& reportCode != null*/ && reportedEmail != null && reportReason != null && repostContext != null ){

			report = new ReportDTO();

//			report.setCategoryCode(ctgDTO.getCategoryCode());
			report.setReporterEmail(email);
			report.setReportedEmail(reportedEmail);;
			report.setReportReason(reportReason);
			report.setRepostContext(repostContext);

			result = reportNewService.reportNew(report);

		} else {
			JOptionPane.showMessageDialog(null, "필수정보를 모두 입력해야합니다.");
		}

		return result;
	}

}
