package com.sangbong.jg.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JButton logo = new JButton("로고");
		logo.setIcon(null);
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
				
			 t1.getText();
				
				
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

