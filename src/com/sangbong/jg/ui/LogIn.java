package com.sangbong.jg.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * <pre>
 * Class : Login
 * Comment : 로그인 화면 구현
 * History
 * 2023/02/19 (손동필) 처음 작성함
 * </pre>
 * @author 손동필
 * @version 1.0.0
 * @see 
 * */
public class LogIn extends JFrame {
	private JLabel lblNewLabel = new JLabel("Logo");
	
	public LogIn() {
		
		setSize(1280, 720);
		
		JPanel panel = new JPanel();
//		panel.setSize(1280, 720);
		
		JLabel label = new JLabel("이메일");
		label.setBounds(390, 229, 53, 15);
		JLabel pswrd = new JLabel("비밀번호");
		pswrd.setBounds(390, 322, 69, 15);
		JTextField txtID = new JTextField(10);
		txtID.setText("이메일");
		txtID.setToolTipText("");
		txtID.setBounds(390, 254, 500, 40);
		JPasswordField txtPass = new JPasswordField(10);
		txtPass.setToolTipText("");
		txtPass.setBounds(390, 347, 500, 40);
		JButton logBtn = new JButton("로그인");
		logBtn.setBounds(340, 505, 600, 50);
		panel.setLayout(null);
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
	
		
		
		logBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(340, 574, 600, 50);
		panel.add(btnNewButton);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(340, 0, 600, 150);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LogIn();
	}
}
