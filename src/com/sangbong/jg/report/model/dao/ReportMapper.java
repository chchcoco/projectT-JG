package com.sangbong.jg.report.model.dao;

import java.util.List;
import java.util.Map;

import com.sangbong.jg.model.dto.ReportDTO;

public interface ReportMapper {

	List<ReportDTO> selectAllReport();

	int updateReportStatus(Map<String, String> map);

}
