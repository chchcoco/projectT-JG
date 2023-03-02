package com.sangbong.jg.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;

import com.sangbong.jg.common.HintTextField;
import com.sangbong.jg.member.controller.MemberController;
import com.sangbong.jg.model.dto.MemberDTO;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

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


	private JLabel lblNewLabel = new JLabel();
	private JLabel emailLabel = new JLabel("이메일 ");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField emailText = new HintTextField("email");
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인 ");

	MemberController memberController = new MemberController();

	public LogIn() {

		setSize(1280, 720);

		JPanel panel = new JPanel();

		lblNewLabel.setBounds(340, 0, 550, 150);
		lblNewLabel.setIcon(new ImageIcon("images/title.png"));

		JLabel label = new JLabel("이메일");
		label.setBounds(390, 229, 53, 15);
		label.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 12f));
		JLabel pswrd = new JLabel("비밀번호");
		pswrd.setBounds(390, 322, 69, 15);
		pswrd.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 12f));
		emailText.setToolTipText("이메일");
		emailText.setBounds(390, 254, 500, 40);

		pwText.setToolTipText("비밀번호");
		pwText.setBounds(390, 347, 500, 40);

		JButton logBtn = new JButton("로그인");
		logBtn.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		logBtn.setBackground(new Color(128, 255, 128));

		logBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println(1);
				String email = emailText.getText()/*.trim()*/;
				char[] pw = pwText.getPassword()/*.trim()*/;

				System.out.println(email + pw);
				String pwd = new StringBuilder().append(pw).toString();

				if(email.equals("email") || pwd.equals("")) {
					System.out.println(2);
					JOptionPane.showMessageDialog(null, "이메일 또는 비밀번호를 입력 하셔야 됩니다.",
							"아이디나 비밀번호를 입력!", JOptionPane.DEFAULT_OPTION);
					
					return;
				} else { 
					System.out.println(3);
					MemberDTO loginInfo = memberController.loginMember(email, pw);
					boolean result = (loginInfo != null)? true: false;   

					if(result && (loginInfo.getMemType().equals("MEMBER"))){
						new PostCategory(loginInfo).setVisible(true);	
						dispose();
					} else if(result && (loginInfo.getMemType().equals("ADMIN"))) {
						new PostCategoryAdmin(loginInfo).setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "회원가입 후 로그인해주세요!", "로그인 실패", JOptionPane.DEFAULT_OPTION);
						System.out.println("로그인정보가 일치하지 않습니다.");
					}
				}
			}
		});

		logBtn.setBounds(390, 505, 500, 50);
		panel.setLayout(null);

		panel.add(label);
		panel.add(emailText);
		panel.add(pswrd);
		panel.add(pwText);
		panel.add(logBtn);

		getContentPane().add(panel);

		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new MemberJoin().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(390, 574, 500, 50);
		panel.add(btnNewButton);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(340, 0, 600, 150);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
