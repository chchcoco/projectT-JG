package com.sangbong.jg.post.model.dao;

import com.sangbong.jg.model.dto.PostDTO;

public interface PostEditMapper {

	int postEdit(PostDTO post);

	PostDTO postGetByCode(PostDTO post);

}
