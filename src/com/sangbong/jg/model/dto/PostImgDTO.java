package com.sangbong.jg.model.dto;

import java.sql.Date;

public class PostImgDTO {
	
	private String categoryCode;
	private String writer;
	private String postCode;
	private int price;
	private String itemName;
	private char deleteYn;
	private Date postDate;
    private String postContext;
	private String imgCode;
	private String imgUrl;

	public PostImgDTO() {}

	public PostImgDTO(String categoryCode, String writer, String postCode, int price, String itemName, char deleteYn,
			Date postDate, String postContext, String imgCode, String imgUrl) {
		super();
		this.categoryCode = categoryCode;
		this.writer = writer;
		this.postCode = postCode;
		this.price = price;
		this.itemName = itemName;
		this.deleteYn = deleteYn;
		this.postDate = postDate;
		this.postContext = postContext;
		this.imgCode = imgCode;
		this.imgUrl = imgUrl;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContext() {
		return postContext;
	}

	public void setPostContext(String postContext) {
		this.postContext = postContext;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "PostImgDTO [categoryCode=" + categoryCode + ", writer=" + writer + ", postCode=" + postCode + ", price="
				+ price + ", itemName=" + itemName + ", deleteYn=" + deleteYn + ", postDate=" + postDate
				+ ", postContext=" + postContext + ", imgCode=" + imgCode + ", imgUrl=" + imgUrl + "]";
	}
	
	
}
