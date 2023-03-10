package com.sangbong.jg.post.model.service;

import static com.sangbong.jg.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.model.dto.PostImgDTO;
import com.sangbong.jg.post.model.dao.PostBoardMapper;

public class PostBoardService {
	
	PostBoardMapper mapper;

	public List<PostDTO> getAllPost() {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostBoardMapper.class);
		
		List<PostDTO> postList = mapper.selectAllPost();
		
		if(postList != null) {
			System.out.println("서비스 작동 정상");
		} else {
			System.out.println("서비스 오류");
		}
		
		sqlSession.close();
		
		return postList;
	}

	public List<PostDTO> getAllPost(CategoryDTO category) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostBoardMapper.class);
		
		List<PostDTO> postList=mapper.selectAllPostByCtg(category);
		
		if(postList != null) {
			System.out.println("서비스 작동 정상");
		} else {
			System.out.println("서비스 오류");
		}
		
		sqlSession.close();
		
		return postList; 
	}

	public List<PostImgDTO> getAllPostWithImg() {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostBoardMapper.class);
		
		List<PostImgDTO> postImgList = mapper.selectAllPostWithImg();
		
		return postImgList;
	}

	public List<PostImgDTO> getAllPostWithImg(CategoryDTO category) {

		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(PostBoardMapper.class);
		
		List<PostImgDTO> postImgList = mapper.selectAllPostWithImgByCtg(category);
		
		return postImgList;
	}

}
