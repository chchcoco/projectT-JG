package com.sangbong.jg.report.model.dao;

import com.sangbong.jg.model.dto.ReportDTO;

public interface ReportNewMapper {
	
	int reportNew(ReportDTO report); //insert
	
	ReportDTO reportGet(ReportDTO report); //select
}
