package com.sangbong.jg.post.model.dao;

import com.sangbong.jg.model.dto.PostDTO;

public interface PostNewMapper {

	int postNew(PostDTO post);

	PostDTO postGet(PostDTO post);

}
