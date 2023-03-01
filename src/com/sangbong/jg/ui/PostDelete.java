package com.sangbong.jg.ui;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.controller.PostDeleteController;

/**
 * <pre>
 * Class : PostDelete
 * Comment : 게시글 삭제 화면 구현
 * History
 * 2023/02/20 (손동필) 처음 작성함
 * </pre>
 * @author 손동필
 * @version 1.0.0
 * @see 
 * */
public class PostDelete extends JFrame {
	private JLabel lblNewLabel = new JLabel("Logo");
	private MemberDTO loginInfo;
	
	public PostDelete(MemberDTO loginInfo, PostDTO postDTO) {
		
		this.loginInfo = loginInfo;
		
		setSize(1280, 720);
		
		JPanel panel = new JPanel();
		JButton logBtn = new JButton("취소");
		logBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PostOnePage(loginInfo, postDTO).setVisible(true);
				dispose();
			}
		});
		logBtn.setBounds(351, 570, 300, 50);
		panel.setLayout(null);
		panel.add(logBtn);
	
		
		
		logBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean result = new PostDeleteController().deletePost(postDTO);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "삭제완료");
					new PostCategory(loginInfo).setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "삭제실패");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(663, 570, 300, 50);
		panel.add(btnNewButton);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(340, 0, 600, 150);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("게시글 삭제를 진행하시겠습니까?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 15f));
		lblNewLabel_1.setBounds(490, 307, 300, 30);
		panel.add(lblNewLabel_1);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new PostDelete(null, null);
	}
}