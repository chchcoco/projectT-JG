package com.sangbong.jg.img.controller;

import java.util.ArrayList;
import java.util.List;

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
		
		List<ImgDTO> imgList = new ArrayList<>();
		boolean result = false;
		int i = 0;
		for(String imgUrl: imgUrlList) {
			
			if(imgUrl.equals("")) {
				System.out.println("imgUrl null");
				continue;
			}
			
			System.out.println("imgUrl : " + imgUrl);
			imgList.add(new ImgDTO());
			imgList.get(i).setPostCode(postInfo.getPostCode());
			imgList.get(i++).setImgUrl(imgUrl);
		
		} 
		
		if(imgUrlList != null && imgUrlList.size() != 0) {
			
			result = imgService.saveImgList(imgList);
			System.out.println("result : " + result);
			return result;
		}
		
		System.out.println("컨트롤 탈출");
		
		return true;
	}
}
