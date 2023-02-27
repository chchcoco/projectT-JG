package com.sangbong.jg.img.model.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.ibatis.session.SqlSession;

import com.sangbong.jg.img.model.dao.ImgMapper;
import com.sangbong.jg.model.dto.ImgDTO;
import static com.sangbong.jg.common.Template.getSqlSession;;

public class ImgService {

	SqlSession sqlSession;
	ImgMapper mapper;

	public List<ImgDTO> getAllImgByPost(String postCode) {

		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ImgMapper.class);

		List<ImgDTO> imgList = mapper.selectAllByPost(postCode);

		return imgList;
	}

	public boolean saveImgList(List<ImgDTO> imgList) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(ImgMapper.class);

		int result = -10;

		/* 파일 주소를 받아와 images 폴더에 저장하는 코드 */
		String extension = null;
		String imgUrl = null;
		String resultImgUrl = null;
		
		int delete = mapper.deleteImgByPost(imgList.get(0));
		
		for (ImgDTO img : imgList) {
			imgUrl = img.getImgUrl();
			extension = imgUrl.substring(imgUrl.indexOf('.') + 1);

			try {
				BufferedImage image = ImageIO.read(new File(imgUrl));

				resultImgUrl = "images//" + imgUrl.substring(imgUrl.lastIndexOf('\\')+1);
				File imgFile = new File(resultImgUrl);
				
				ImageIO.write(image, extension, imgFile);
				
				System.out.println("저장완료");
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(result == -10 || result > 0) {
				img.setImgUrl(resultImgUrl);
				result = mapper.insertImg(img);
				System.out.println("result : " + result);
			} else {
				break;
			}
		}
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return (result > 0)? true: false;
	}

}
