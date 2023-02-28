package com.sangbong.jg.ui;

import java.awt.Color;
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
		//      panel.setSize(1280, 720);

		lblNewLabel.setBounds(340, 0, 600, 150);
		lblNewLabel.setIcon(new ImageIcon("images/title.png"));

		JLabel label = new JLabel("이메일");
		label.setBounds(390, 229, 53, 15);
		JLabel pswrd = new JLabel("비밀번호");
		pswrd.setBounds(390, 322, 69, 15);
		emailText.setToolTipText("이메일");
		emailText.setBounds(390, 254, 500, 40);

		pwText.setToolTipText("비밀번호");
		pwText.setBounds(390, 347, 500, 40);

		JButton logBtn = new JButton("로그인");
		//      logBtn.addActionListener(new ActionListener() {
		//         public void actionPerformed(ActionEvent e) {
		//         }
		//      });

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
					//               JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					return;
				} else { 
					System.out.println(3);
					MemberDTO loginInfo = memberController.loginMember(email, pw);
					boolean result = (loginInfo != null)? true: false;   
					//               System.out.println(email + pw);

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

				//            if(email.equals("test") && pw.equals("test1")) {
				//
				//               JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				//
				//               return;
				//
				//               }

			}
		});

		logBtn.setBounds(340, 505, 600, 50);
		panel.setLayout(null);

		panel.add(label);
		panel.add(emailText);
		panel.add(pswrd);
		panel.add(pwText);
		panel.add(logBtn);


		//      
		//      loginBtn.addMouseListener(new MouseAdapter(){
		//         
		//         @Override
		//         public void mousePressed (MouseEvent e) {
		//            
		//            String email = emailText.getText()/*.trim()*/;
		//            String pw = pwText.getText()/*.trim()*/;
		//            
		//            System.out.println(email + 0 + pw);
		//            
		//            
		//            if(email.equals("") || pw.equals("")) {
		//               JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.",
		//               "아이디나 비밀번호를 입력!", JOptionPane.DEFAULT_OPTION);
		//               return;
		//            }
		//            
		//            if(email.equals("test") && pw.equals("test1")) {
		//
		//               JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
		//
		//               return;
		//
		//            }
		//            
		//            JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
		//            
		//         }
		//      });

		getContentPane().add(panel);

		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new MemberJoin().setVisible(true);
				dispose();
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

	//   public static void main(String[] args) {
	//      new LogIn();
	//   }

}
