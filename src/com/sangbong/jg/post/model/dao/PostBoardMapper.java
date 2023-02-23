package com.sangbong.jg.post.model.dao;

import java.util.List;

import com.sangbong.jg.model.dto.PostDTO;

public interface PostBoardMapper {

	List<PostDTO> selectAllPost();

}
