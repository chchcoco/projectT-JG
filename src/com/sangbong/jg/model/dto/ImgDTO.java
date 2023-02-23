package com.sangbong.jg.model.dto;

public class ImgDTO {

	private String imgUrl;
	private String altText;
	private String postCode;
	private String imgCode;
	private String reportCode;
	
	public ImgDTO() {}

	public ImgDTO(String imgUrl, String altText, String postCode, String imgCode, String reportCode) {
		super();
		this.imgUrl = imgUrl;
		this.altText = altText;
		this.postCode = postCode;
		this.imgCode = imgCode;
		this.reportCode = reportCode;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	@Override
	public String toString() {
		return "ImgDTO [imgUrl=" + imgUrl + ", altText=" + altText + ", postCode=" + postCode + ", imgCode=" + imgCode
				+ ", reportCode=" + reportCode + "]";
	}
	
	
	
}
