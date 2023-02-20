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

public class LogIn extends JFrame {
	private final JLabel lblNewLabel = new JLabel("Logo");
	
	public LogIn() {
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("이메일");
		label.setBounds(55, 122, 53, 15);
		JLabel pswrd = new JLabel("비밀번호");
		pswrd.setBounds(55, 183, 69, 15);
		JTextField txtID = new JTextField(10);
		txtID.setText("이메일");
		txtID.setToolTipText("");
		txtID.setBounds(65, 145, 452, 21);
		JPasswordField txtPass = new JPasswordField(10);
		txtPass.setToolTipText("");
		txtPass.setBounds(65, 208, 452, 21);
		JButton logBtn = new JButton("로그인");
		logBtn.setBounds(0, 263, 584, 39);
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
		btnNewButton.setBounds(0, 312, 584, 39);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 584, 112);
		panel.add(panel_1);
		panel_1.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 584, 112);
		panel_1.add(lblNewLabel);
		
		setSize(600,400);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LogIn();
	}
}
