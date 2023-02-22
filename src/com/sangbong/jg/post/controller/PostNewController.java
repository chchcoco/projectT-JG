package com.sangbong.jg.post.controller;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostNewService;

public class PostNewController {
	
	PostNewService postNewService = new PostNewService();
	PostDTO post;
	
	public boolean newPost(String categoryCode, /*MemberDTO email,*/ String price, String itemName, String postContext) {
		
		int strPrice = Integer.parseInt(price);
		boolean result = false;
		
		if(categoryCode != null /*&& email != null*/ && strPrice != 0 && itemName != null && postContext != null){
			
			post = new PostDTO();
			post.setCategoryCode(categoryCode);
			post.setPrice(strPrice);
			post.setItemName(itemName);
			post.setPostContext(postContext);
			
			result = postNewService.postNew(post);
			
		} else {
			/*필수 정보를 입력해야한다는 코드*/
		}
		
		return result;
	}

}
