package com.sangbong.jg.common;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sangbong.jg.img.controller.ImgController;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.ImgDTO;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.model.dto.PostImgDTO;
import com.sangbong.jg.post.controller.PostBoardController;
import com.sangbong.jg.ui.PostOnePage;

/**
 * <pre>
 * Class : PostListReturn
 * Comment : 게시글들을 최신 등록순으로 볼 수 있는 전체 페이지를 구현 
 * History
 * 2023/02/23 (신예찬) 최초 작성. Post 요청시 해당 카테고리에 맞는 게시글들을 12개 가져와 Panel에 추가하는 메소드 구현 및 클래스 분리. common폴더의 PostListReturn 클래스
 * 					 현재 PostController, PostDTO 변경 이슈로 인해 미완 상태.
 * 2023/02/23 (신예찬) 기능 완성
 * 2023/02/25 (신예찬) PageOnePage이동시 MemberDTO를 함께 전송하도록 변경
 * 2023/02/27 (신예찬) 외부 창 호출 이벤트 작동시, 이 클래스를 사용하고 있는 page를 닫도록 수정
 * </pre>
 * @author 신예찬
 * @version 1.0.3
 * @see 
 * */
public class PostListReturn {

	private MemberDTO loginInfo;
	private JFrame page;

	public PostListReturn(MemberDTO loginInfo, JFrame page) {

		this.loginInfo = loginInfo;
		this.page = page;
	}

	public JPanel getPost(PostImgDTO postImgDTO) {	

		PostImgDTO postInfo = postImgDTO;

		JPanel post = new JPanel();
		post.setBounds(27, 10, 300, 130);
		//		bodyPanel.add(post);
		post.setLayout(null);

//		List<ImgDTO> imgList = new ImgController().getAllImgByPost(postInfo);
		JLabel postImage = new JLabel("이미지");
		if(postInfo.getImgCode() != null) {
			ImageIcon icon = new ImageIcon(postInfo.getImgUrl());
			Image img = icon.getImage();
			icon = new ImageIcon(img.getScaledInstance(110, 110, Image.SCALE_SMOOTH));
			postImage = new JLabel(icon);
		} else {
			postImage = new JLabel("이미지없음");
		}
		postImage.setOpaque(true);
		postImage.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		postImage.setHorizontalAlignment(JLabel.CENTER);
		postImage.setBackground(new Color(0, 255, 128));
		postImage.setBounds(10, 10, 110, 110);
		post.add(postImage);

		JLabel postTitleLabel_1 = new JLabel(postInfo.getItemName());
		postTitleLabel_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1.setFont(notoSansRegular("Black").deriveFont(Font.PLAIN, 20f));
		postTitleLabel_1.setBounds(132, 10, 168, 29);
		post.add(postTitleLabel_1);

		JLabel priceLabel = new JLabel(postInfo.getPrice()+" 원");
		priceLabel.setForeground(new Color(70, 70, 70));
		priceLabel.setFont(notoSansRegular("Black").deriveFont(Font.PLAIN, 20f));
		priceLabel.setBounds(132, 91, 168, 29);
		post.add(priceLabel);

		JLabel postWriterEmail = new JLabel(postInfo.getWriter());
		postWriterEmail.setHorizontalAlignment(SwingConstants.LEFT);
		postWriterEmail.setForeground(new Color(70, 70, 70));
		postWriterEmail.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		postWriterEmail.setBounds(134, 49, 166, 16);
		post.add(postWriterEmail);

		post.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				goPost(loginInfo, postInfo);
			}
		});

		return post;
	}

	public List<PostImgDTO> getAllPost(){
		
		PostBoardController postBoardController = new PostBoardController();
		List<PostImgDTO> postImgList = postBoardController.getAllPostWithImg();

		return postImgList;
	}

	public List<PostImgDTO> getCtgPost(CategoryDTO category){

		PostBoardController postBoardController = new PostBoardController();
		List<PostImgDTO> postImgList = postBoardController.getAllPostWithImg(category);

		return postImgList;
	}

	public void locatePostList(List<JPanel> postList, JPanel bodyPanel) {
		
		int x;
		int y;
		for(int i = 0; i < postList.size(); i++) {
			x = i % 3;
			y = (int)(i / 3);
			postList.get(i).setLocation(29 + x * 310, 10 + 140 * y);
			bodyPanel.add(postList.get(i));
		}
	}

	public void goPost(MemberDTO loginInfo, PostImgDTO postInfo) {
		
		PostDTO postData = new PostDTO(postInfo.getCategoryCode()
				, postInfo.getWriter(), postInfo.getPostCode()
				, postInfo.getPrice(), postInfo.getItemName()
				, postInfo.getDeleteYn(), postInfo.getPostDate()
				, postInfo.getPostContext());
		// 게시글 상세조회 페이지로 이동
		new PostOnePage(loginInfo, postData).setVisible(true);
		page.dispose();
	}
}
