package com.sangbong.jg.post.controller;

import javax.swing.JOptionPane;

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.model.dto.CategoryDTO;

import com.sangbong.jg.model.dto.MemberDTO;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostEditService;

public class PostEditController {

	PostEditService postEditService = new PostEditService();
	PostDTO post;
	PostDTO result;
	
	public PostDTO EditPost(String categoryCode, String price, String itemName, String postContext, PostDTO postInfo) {
		
		int strPrice = Integer.parseInt(price);
		
		CategoryDTO ctgDTO = new CategoryController().getOneCategoryByName(categoryCode);

		
		if(categoryCode != null && strPrice != 0 && itemName != null && postContext != null) {
			
			post = new PostDTO();
			post.setPostCode(postInfo.getPostCode());
			post.setCategoryCode(ctgDTO.getCategoryCode());
			post.setPrice(strPrice);
			post.setItemName(itemName);
			post.setPostContext(postContext);
			
			result = postEditService.postEdit(post);
			
		} else {
			
			JOptionPane.showMessageDialog(null, "필수정보를 모두 입력해야합니다.");
		}
		
		return result;
	}
}

