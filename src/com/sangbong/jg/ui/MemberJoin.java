package com.sangbong.jg.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sangbong.jg.member.controller.MemberController;
/**
 * <pre>
 * Class : MemberJoinView
 * Comment : 카테고리별로 게시글을 조회하는 페이지.
 * History
 * 2023/02/19 (신예찬) 처음 작성함
 * 2023/02/25 (신예찬) 로고 부분 이미지 추가, 회원가입 성공시 로그인 페이지로 이동하는 이벤트 추가
 * </pre>
 * @author 신예찬
 * @version 1.0.2
 * @see 
 * */
public class MemberJoin extends JFrame{
	
	private String email;
	private String nickname;
	private String pwd;
	private String pwdCheck;
	private JPasswordField pwdField;
	private JPasswordField pwdCheckField;
	
	public MemberJoin()  {
		setResizable(false);
		setSize(1280, 720);
//		this.setL
//		JPanel panel = new Jpanel();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(1280, 720);
		
//		JButton logo = new JButton("로고");
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("images//title.png"));
		logo.setHorizontalAlignment(JLabel.CENTER);
		logo.setLocation(342, 0);
		logo.setSize(600, 150);
		logo.setBackground(Color.GREEN);
		
		
		JLabel email = new JLabel();
		email.setFont(new Font("굴림", Font.PLAIN, 15));
		email.setText("이메일");
		email.setBounds(390, 177, 250, 25);
		
		JTextField t1 = new JTextField();
		t1.setBounds(390, 200, 500, 40);
		
		JLabel nickname = new JLabel();
		nickname.setFont(new Font("굴림", Font.PLAIN, 15));
		nickname.setText("닉네임");
		nickname.setBounds(390, 276, 250, 25);
		
		JTextField t2 = new JTextField();
		t2.setBounds(390, 300, 500, 40);
		
		JLabel pwd = new JLabel();
		pwd.setFont(new Font("굴림", Font.PLAIN, 15));
		pwd.setText("비밀번호");
		pwd.setBounds(390, 376, 250, 25);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(390, 500, 500, 40);
		
		JLabel pwdCheck = new JLabel();
		pwdCheck.setFont(new Font("굴림", Font.PLAIN, 15));
		pwdCheck.setText("비밀번호 확인");
		pwdCheck.setBounds(390, 474, 250, 25);
		
		pwdCheckField = new JPasswordField();
		pwdCheckField.setBounds(390, 398, 500, 40);
		
		panel.add(logo);
		panel.add(email);
		panel.add(t1);
		panel.add(nickname);
		panel.add(t2);
		panel.add(pwd);
		panel.add(pwdField);
		panel.add(pwdCheck);
		panel.add(pwdCheckField);
		
		JButton join = new JButton("가입완료");
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

			 
				boolean result = new MemberController().joinMember(t1.getText(), t2.getText(), pwdField.getPassword(), pwdCheckField.getPassword());

				
				if(result) {
					JOptionPane.showMessageDialog(null, "축하합니다",
							"회원가입에 성공하셨습니다", JOptionPane.DEFAULT_OPTION);
					System.out.println("성공");
					new LogIn().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.",
							"다시 입력해주세요", JOptionPane.DEFAULT_OPTION);
					System.out.println("실패");
				}
			}
		});
		join.setFont(new Font("굴림", Font.PLAIN, 17));
		join.setBackground(new Color(128, 255, 128));
		join.setBounds(365, 600, 550, 50);
		panel.add(join);
		
		getContentPane().add(panel);
		
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MemberJoin();
	}
}

