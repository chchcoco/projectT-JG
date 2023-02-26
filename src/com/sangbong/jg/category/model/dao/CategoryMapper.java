package com.sangbong.jg.category.model.dao;

import java.util.List;

import com.sangbong.jg.model.dto.CategoryDTO;

public interface CategoryMapper {

	List<CategoryDTO> getAllCategory();

	CategoryDTO getOneCategory(String ctgName);

	CategoryDTO getOneCategoryByCode(String categoryCode);

}
