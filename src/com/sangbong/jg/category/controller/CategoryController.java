package com.sangbong.jg.category.controller;

import java.util.List;

import com.sangbong.jg.category.model.service.CategoryService;
import com.sangbong.jg.model.dto.CategoryDTO;

public class CategoryController {

	public List<CategoryDTO> getCategoryList() {

		List<CategoryDTO> ctgList = new CategoryService().getAllCategory();
		
		return ctgList;
	}

}
