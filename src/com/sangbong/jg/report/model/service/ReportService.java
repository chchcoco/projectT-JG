package com.sangbong.jg.report.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.model.dao.ReportMapper;

import static com.sangbong.jg.common.Template.getSqlSession;

public class ReportService {
	
	private ReportMapper mapper;

	public List<ReportDTO> findReportList() {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ReportMapper.class);
		
		List<ReportDTO> reportList = mapper.selectAllReport();
		
		return reportList;
	}

}
