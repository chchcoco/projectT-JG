package com.sangbong.jg.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

import static com.sangbong.jg.common.SetFont.notoSansRegular;
import javax.swing.JEditorPane;

/**
 * <pre>
 * Class : MemberInfoView
 * Comment : 회원이 자기 자신의 정보를 조회하는 화면 UI를 구현한다. 
 * History
 * 2023/02/19 (김유현) 처음 작성함
 * </pre>
 * @author 김유현
 * @version 1.1.0
 * @see 
 * */
public class MemberInfoView extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInfoView frame = new MemberInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberInfoView() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ctgPanel = new JPanel();
		ctgPanel.setBackground(new Color(245, 245, 245));
		ctgPanel.setBounds(0, 0, 248, 681);
		contentPane.add(ctgPanel);
		ctgPanel.setLayout(null);
		
		JLabel writeReportLabel = new JLabel("신고글 작성하기");
		writeReportLabel.setBounds(24, 630, 200, 28);
		writeReportLabel.setForeground(new Color(255, 0, 0));
//		writeReportLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		writeReportLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		ctgPanel.add(writeReportLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 154, 224, 456);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ctgPanel.add(scrollPane);
		
		JLabel titleLabel = new JLabel("New label");
		titleLabel.setBounds(24, 10, 204, 67);
		titleLabel.setIcon(new ImageIcon("images/title.png"));
		ctgPanel.add(titleLabel);
		
		JLabel viewAllLabel = new JLabel("전체 게시판");
		viewAllLabel.setBounds(27, 111, 200, 33);
		viewAllLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		ctgPanel.add(viewAllLabel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(260, 0, 1004, 681);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 255, 255));
		topPanel.setBounds(12, 10, 980, 132);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel viewTitle = new JLabel("내 정보 보기");
		viewTitle.setForeground(new Color(70, 70, 70));
		viewTitle.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		viewTitle.setBounds(12, 10, 678, 35);
		topPanel.add(viewTitle);
		
		JButton deactivateButton = new JButton("탈퇴");
		deactivateButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		deactivateButton.setForeground(new Color(70, 70, 70));
		deactivateButton.setBackground(new Color(241, 87, 87));
		deactivateButton.setBounds(848, 50, 120, 72);
		topPanel.add(deactivateButton);
		deactivateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int var = JOptionPane.showConfirmDialog(null, "정말로 탈퇴를 진행하시겠습니까?", "회원 탈퇴 재확인"
						, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				System.out.println("선택값 (0일 경우에만 진행) : " + var);
			}
		});
		
		JLabel postTitleLabel = new JLabel("홍길동 님, 안녕하세요!");
		postTitleLabel.setForeground(new Color(70, 70, 70));
		postTitleLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 32));
		postTitleLabel.setBounds(12, 76, 678, 50);
		topPanel.add(postTitleLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(12, 152, 980, 529);
		mainPanel.add(scrollPane_1);
		
		JPanel bodyPanel = new JPanel();
		scrollPane_1.setViewportView(bodyPanel);
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setLayout(null);
		
		JLabel authorEmailLabel = new JLabel("개인 정보");
		authorEmailLabel.setForeground(new Color(70, 70, 70));
		authorEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		authorEmailLabel.setFont(new Font("나눔스퀘어 네오 OTF Bold", Font.PLAIN, 20));
		authorEmailLabel.setBounds(12, 10, 501, 25);
		bodyPanel.add(authorEmailLabel);
		
		JButton editEmailButton = new JButton("이메일 수정");
		editEmailButton.setBounds(824, 58, 144, 60);
		bodyPanel.add(editEmailButton);
		editEmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = JOptionPane.showInputDialog("테스트");
				System.out.println(test);
			}
		});
		editEmailButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		editEmailButton.setForeground(new Color(70, 70, 70));
		editEmailButton.setBackground(new Color(212, 212, 212));
		
		JLabel emailTitle = new JLabel("이메일");
		emailTitle.setHorizontalAlignment(SwingConstants.LEFT);
		emailTitle.setForeground(new Color(121, 121, 121));
		emailTitle.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		emailTitle.setBounds(12, 58, 84, 25);
		bodyPanel.add(emailTitle);
		
		JLabel memberEmail = new JLabel("hong123@gmail.com");
		memberEmail.setHorizontalAlignment(SwingConstants.LEFT);
		memberEmail.setForeground(new Color(70, 70, 70));
		memberEmail.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		memberEmail.setBounds(12, 93, 427, 25);
		bodyPanel.add(memberEmail);
		
		JLabel nameTitle = new JLabel("닉네임");
		nameTitle.setHorizontalAlignment(SwingConstants.LEFT);
		nameTitle.setForeground(new Color(121, 121, 121));
		nameTitle.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		nameTitle.setBounds(12, 149, 84, 25);
		bodyPanel.add(nameTitle);
		
		JLabel memberName = new JLabel("홍길동");
		memberName.setHorizontalAlignment(SwingConstants.LEFT);
		memberName.setForeground(new Color(70, 70, 70));
		memberName.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		memberName.setBounds(12, 184, 427, 25);
		bodyPanel.add(memberName);
		
		JButton editNameButton = new JButton("닉네임 수정");
		editNameButton.setForeground(new Color(70, 70, 70));
		editNameButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		editNameButton.setBackground(new Color(212, 212, 212));
		editNameButton.setBounds(824, 149, 144, 60);
		bodyPanel.add(editNameButton);
		
		JButton editPwdButton = new JButton("비밀번호 수정");
		editPwdButton.setForeground(new Color(70, 70, 70));
		editPwdButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		editPwdButton.setBackground(new Color(212, 212, 212));
		editPwdButton.setBounds(811, 244, 157, 60);
		bodyPanel.add(editPwdButton);
		
		JLabel pwd = new JLabel("비밀번호");
		pwd.setHorizontalAlignment(SwingConstants.LEFT);
		pwd.setForeground(new Color(121, 121, 121));
		pwd.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		pwd.setBounds(12, 260, 84, 25);
		bodyPanel.add(pwd);
		
		JLabel myPostTitle = new JLabel("내가 쓴 게시글");
		myPostTitle.setHorizontalAlignment(SwingConstants.LEFT);
		myPostTitle.setForeground(new Color(70, 70, 70));
		myPostTitle.setFont(new Font("나눔스퀘어 네오 OTF Bold", Font.PLAIN, 20));
		myPostTitle.setBounds(12, 354, 501, 25);
		bodyPanel.add(myPostTitle);
		
		JLabel postTitle1 = new JLabel("게시글 제목");
		postTitle1.setHorizontalAlignment(SwingConstants.LEFT);
		postTitle1.setForeground(new Color(70, 70, 70));
		postTitle1.setFont(new Font("나눔스퀘어 네오 OTF Bold", Font.PLAIN, 16));
		postTitle1.setBounds(12, 401, 427, 25);
		bodyPanel.add(postTitle1);
		
		JButton btnNewButton = new JButton("이미지");
		btnNewButton.setBounds(878, 401, 88, 88);
		bodyPanel.add(btnNewButton);
		
		JLabel postTitle1_1 = new JLabel("본문본문본문본문ㅂ");
		postTitle1_1.setHorizontalAlignment(SwingConstants.LEFT);
		postTitle1_1.setForeground(new Color(70, 70, 70));
		postTitle1_1.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		postTitle1_1.setBounds(12, 464, 427, 25);
		bodyPanel.add(postTitle1_1);
		
		JLabel postTitle1_1_1 = new JLabel("카테고리 이름");
		postTitle1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		postTitle1_1_1.setForeground(new Color(121, 121, 121));
		postTitle1_1_1.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		postTitle1_1_1.setBounds(12, 433, 427, 25);
		bodyPanel.add(postTitle1_1_1);
		
	}
}