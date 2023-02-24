package com.sangbong.jg.post.controller;

import java.util.List;

import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.model.service.PostBoardService;

public class PostBoardController {

	private PostBoardService postBoardServise= new PostBoardService();
	
	public List<PostDTO> getAllPost() {
		
		
		List<PostDTO> postList = postBoardServise.getAllPost();
		
		
		return postList;
	}
	
	public List<PostDTO> getAllPost(CategoryDTO category) {
		
		List<PostDTO> postList = postBoardServise.getAllPost(category);
		
		
		return postList;
	}

}
