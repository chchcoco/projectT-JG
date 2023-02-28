package com.sangbong.jg.report.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.model.dao.ReportNewMapper;


public class ReportNewService {
	
	ReportNewMapper mapper;
	
	public ReportDTO reportNew(ReportDTO report) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ReportNewMapper.class);
		
		int result = mapper.reportNew(report);
		ReportDTO resultReport = mapper.reportGet(report);
		
		if(result > 0 && report != null) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return resultReport;
		

	}


}
