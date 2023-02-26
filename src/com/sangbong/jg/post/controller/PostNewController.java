package com.sangbong.jg.post.controller;

import javax.swing.JOptionPane;

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostNewService;

public class PostNewController {
	
	PostNewService postNewService = new PostNewService();
	PostDTO post;
	PostDTO result;
	
	public PostDTO newPost(String categoryCode, String email, String price, String itemName, String postContext) {
		
		int strPrice = Integer.parseInt(price);
		
		 CategoryDTO ctgDTO = new CategoryController().getOneCategoryByName(categoryCode);
		
		if(categoryCode != null && email != null && strPrice != 0 && itemName != null && postContext != null){
			
			post = new PostDTO();
			post.setCategoryCode(ctgDTO.getCategoryCode());
			post.setWriter(email);
			post.setPrice(strPrice);
			post.setItemName(itemName);
			post.setPostContext(postContext);
			
			result = postNewService.postNew(post);
			
		} else {
			JOptionPane.showMessageDialog(null, "필수정보를 모두 입력해야합니다.");
		}
		
		return result;
	}

}
