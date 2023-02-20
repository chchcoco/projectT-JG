package com.sangbong.jg.model.dto;

public class CategoryDTO {

	private String categoryCode;
	private String categoryName;
	private String superCategory;
	
	public CategoryDTO() {}

	public CategoryDTO(String categoryCode, String categoryName, String superCategory) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.superCategory = superCategory;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(String superCategory) {
		this.superCategory = superCategory;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryCode=" + categoryCode + ", categoryName=" + categoryName + ", superCategory="
				+ superCategory + "]";
	}
	
	
	
}
