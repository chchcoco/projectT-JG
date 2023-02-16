package com.sangbong.jg.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberJoin extends JFrame{
	
	private String email;
	private String nickname;
	private String pwd;
	private String pwdCheck;
	
	public MemberJoin()  {
		setSize(600, 1000);
//		this.setL
//		JPanel panel = new Jpanel();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(600, 1000);
		
		JButton logo = new JButton("로고");
		logo.setSize(600, 250);
		logo.setBackground(Color.GREEN);
		
		
		
		JLabel email = new JLabel();
		email.setText("이메일");
		email.setBounds(30, 275, 250, 25);
		
		JTextField t1 = new JTextField();
		t1.setBounds(50, 300, 500, 40);
		
		JLabel nickname = new JLabel();
		nickname.setText("닉네임");
		nickname.setBounds(30, 375, 250, 25);
		
		JTextField t2 = new JTextField();
		t2.setBounds(50, 400, 500, 40);
		
		JLabel pwd = new JLabel();
		pwd.setText("비밀번호");
		pwd.setBounds(30, 475, 250, 25);
		
		JTextField t3 = new JTextField();
		t3.setBounds(50, 500, 500, 40);
		
		JLabel pwdCheck = new JLabel();
		pwdCheck.setText("비밀번호 확인");
		pwdCheck.setBounds(30, 575, 250, 25);
		
		JTextField t4 = new JTextField();
		t4.setBounds(50, 600, 500, 40);
		
		panel.add(logo);
		panel.add(email);
		panel.add(t1);
		panel.add(nickname);
		panel.add(t2);
		panel.add(pwd);
		panel.add(t3);
		panel.add(pwdCheck);
		panel.add(t4);
		
		JButton join = new JButton("가입완료");
		join.setBounds(18, 700, 550, 50);
		panel.add(join);
		
		add(panel);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		new MemberJoin();
//	}
}

