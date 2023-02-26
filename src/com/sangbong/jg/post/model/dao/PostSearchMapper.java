package com.sangbong.jg.post.model.dao;

import java.util.List;
import java.util.Map;

import com.sangbong.jg.model.dto.PostDTO;

public interface PostSearchMapper {

	List<PostDTO> selectPostByEmail(Map<String, String> map);

}
