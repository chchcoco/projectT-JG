package com.sangbong.jg.report.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		sqlSession.close();

		return reportList;
	}

	public int approveReport(ReportDTO report) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ReportMapper.class);

		Map<String, String> map = new HashMap<>();
		map.put("reportCode", report.getReportCode());

		int result = mapper.updateReportStatusApprove(map);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result;
	}

	public int discardReport(ReportDTO report) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ReportMapper.class);

		Map<String, String> map = new HashMap<>();
		map.put("reportCode", report.getReportCode());

		int result = mapper.updateReportStatusDiscard(map);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();

		return result;
	}


}
