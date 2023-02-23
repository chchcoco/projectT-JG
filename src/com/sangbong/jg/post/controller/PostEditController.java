package com.sangbong.jg.post.controller;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostEditService;

public class PostEditController {

	PostEditService postEditService = new PostEditService();
	PostDTO post;
	
	public boolean EditPost(String categoryCode, String email, String price, String itemName, String postContext) {
		
		int strPrice = Integer.parseInt(price);
		boolean result = false;
		
		if(categoryCode != null && email != null && strPrice != 0 && itemName != null && postContext != null) {
			
			post = new PostDTO();
			post.setCategoryCode(categoryCode);
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

