package com.sangbong.jg.model.dto;

public class PostDTO {

	private String categoryCode;
	private String writer;
	private String postCode;
	private int price;
	private String itemName;
	private char deleteYn;
	
	public PostDTO() {}

	public PostDTO(String categoryCode, String writer, String postCode, int price, String itemName, char deleteYn) {
		super();
		this.categoryCode = categoryCode;
		this.writer = writer;
		this.postCode = postCode;
		this.price = price;
		this.itemName = itemName;
		this.deleteYn = deleteYn;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public char getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(char deleteYn) {
		this.deleteYn = deleteYn;
	}

	@Override
	public String toString() {
		return "PostDTO [categoryCode=" + categoryCode + ", writer=" + writer + ", postCode=" + postCode + ", price="
				+ price + ", itemName=" + itemName + ", deleteYn=" + deleteYn + "]";
	}

	public void setPostContext(String postContext) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
