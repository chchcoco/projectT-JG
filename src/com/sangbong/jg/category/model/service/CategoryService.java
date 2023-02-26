package com.sangbong.jg.category.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.category.model.dao.CategoryMapper;
import com.sangbong.jg.model.dto.CategoryDTO;

public class CategoryService {

	private CategoryMapper mapper;
	
	public List<CategoryDTO> getAllCategory() {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(CategoryMapper.class);
		
		List<CategoryDTO> ctgList = mapper.getAllCategory();
		
		return ctgList;
	}

	public CategoryDTO getOneCategoryByName(String ctgName) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(CategoryMapper.class);
		
		CategoryDTO category = mapper.getOneCategory(ctgName);
		
		return category;
	}

	public CategoryDTO getOneCategoryByCode(String superCategory) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(CategoryMapper.class);
		
		CategoryDTO category = mapper.getOneCategoryByCode(superCategory);
		
		return null;
	}

}
