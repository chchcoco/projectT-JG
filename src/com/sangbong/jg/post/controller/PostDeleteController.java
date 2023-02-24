package com.sangbong.jg.post.controller;

import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostDeleteService;

public class PostDeleteController {
	
	PostDeleteService postDeleteService = new PostDeleteService();
	
	public boolean deletePost(PostDTO postDTO) {
		
		boolean result = postDeleteService.postDelete(postDTO);
		
		return result;
	}

}
