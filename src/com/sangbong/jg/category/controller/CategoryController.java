package com.sangbong.jg.category.controller;

import java.util.List;

import com.sangbong.jg.category.model.service.CategoryService;
import com.sangbong.jg.model.dto.CategoryDTO;

public class CategoryController {

	public List<CategoryDTO> getCategoryList() {

		List<CategoryDTO> ctgList = new CategoryService().getAllCategory();
		
		return ctgList;
	}

	public CategoryDTO getOneCategoryByName(String ctgName) {

		CategoryDTO category = new CategoryService().getOneCategoryByName(ctgName);
		
		return category;
	}

	public CategoryDTO getOneCategoryByCode(String superCategory) {
		
		CategoryDTO category = new CategoryService().getOneCategoryByCode(superCategory);
		
		return category;
	}

}
