package com.sangbong.jg.img.model.dao;

import java.util.List;

import com.sangbong.jg.model.dto.ImgDTO;

public interface ImgMapper {

	List<ImgDTO> selectAllByPost(String postCode);

	int insertImg(ImgDTO img);
	
	int deleteImgByPost(ImgDTO imgDTO);

}
