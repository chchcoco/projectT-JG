package com.sangbong.jg.post.model.dao;

import java.util.List;

import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.PostDTO;

public interface PostBoardMapper {

	List<PostDTO> selectAllPost();

	List<PostDTO> selectAllPostByCtg(CategoryDTO category);

}
