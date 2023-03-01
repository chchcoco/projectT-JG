package com.sangbong.jg.ui;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.sangbong.jg.img.controller.ImgController;
import com.sangbong.jg.model.dto.ImgDTO;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;

/**
 * <pre>
 * Class : MyPostPanelMaker
 * Comment : 회원 자기 자신의 게시글을 조회하는 화면을 위한 패널 생성 및 배치 클래스
 * History
 * 2023/02/25 (김유현) 처음 작성함
 * 2023/02/26 (김유현) 정돈 + 수정
 * </pre>
 * @author 김유현
 * @version 1.1.0
 * @see MemberPostView
 * */
public class MyPostPanelMaker {

public void PanelMaker(MemberDTO loginInfo, JPanel bodyPanel, PostDTO post) {
		
		JPanel reportPanel = new JPanel();
		reportPanel.setSize(956, 84);
		bodyPanel.add(reportPanel);
		reportPanel.setLayout(null);
		
		JLabel reportReasonLabel = new JLabel("가격 : " + post.getPrice());
		reportReasonLabel.setBounds(10, 42, 436, 16);
		reportPanel.add(reportReasonLabel);
		reportReasonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel.setForeground(new Color(70, 70, 70));
		reportReasonLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		
		JLabel reportTitleLabel = new JLabel();
		String reportTitle = post.getItemName();
		reportTitleLabel.setText(reportTitle);
		reportTitleLabel.setForeground(new Color(70, 70, 70));
		reportTitleLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 18f));
		reportTitleLabel.setBounds(0, 0, 446, 35);
		reportPanel.add(reportTitleLabel);
		
		JLabel postImage = new JLabel("이미지");
		postImage.setBounds(872, 0, 84, 84);
		ImgController imgController = new ImgController();
		ImgDTO imgDTO = new ImgDTO();
		imgDTO = imgController.getAllImgByPost(post).get(0);
		if(imgDTO.getImgCode() != null) {
			ImageIcon icon = new ImageIcon(imgDTO.getImgUrl());
			Image img = icon.getImage();
			icon = new ImageIcon(img.getScaledInstance(84, 84, Image.SCALE_SMOOTH));
			postImage = new JLabel(icon);
		} else {
			postImage = new JLabel("이미지없음");
		}
		postImage.setOpaque(true);
		postImage.setHorizontalAlignment(JLabel.CENTER);
		postImage.setBackground(new Color(0, 255, 128));
		reportPanel.add(postImage);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(post.getPostDate());
		JLabel reportedEmailLabel = new JLabel(date);
		reportedEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel.setForeground(new Color(70, 70, 70));
		reportedEmailLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		reportedEmailLabel.setBounds(10, 68, 436, 16);
		reportPanel.add(reportedEmailLabel);
		
		JTextArea textContext = new JTextArea();
		textContext.setBounds(448, 10, 412, 64);
		reportPanel.add(textContext);
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		textContext.setText(post.getPostContext());
		textContext.setLineWrap(true);
		textContext.setEditable(false);
		
		reportPanel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				new PostOnePage(loginInfo, post).setVisible(true);
			}
		});
	}
}
