package com.sangbong.jg.img.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.sangbong.jg.img.model.service.ImgService;
import com.sangbong.jg.model.dto.ImgDTO;
import com.sangbong.jg.model.dto.PostDTO;

public class ImgController {

	private ImgService imgService = new ImgService();

	public List<ImgDTO> getAllImgByPost(PostDTO postInfo) {
		// TODO Auto-generated method stub
		List<ImgDTO> imgList = imgService.getAllImgByPost(postInfo.getPostCode());

		return imgList;
	}

	public boolean insertImgPost(List<String> imgUrlList, PostDTO postInfo) {
		// TODO Auto-generated method stub
		List<ImgDTO> imgList = new ArrayList<>();
		boolean result = false;
		int i = 0;
		for(String imgUrl: imgUrlList) {
			
			imgList.add(new ImgDTO());
			imgList.get(i).setPostCode(postInfo.getPostCode());
			imgList.get(i++).setImgUrl(imgUrl);
		
		} 
		if(imgUrlList == null) {
			return true;
		}
		
		result = imgService.saveImgList(imgList);
		
		return result;
	}

}
