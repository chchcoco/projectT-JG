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
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

/**
 * <pre>
 * Class : PostCategoryNonMember
 * Comment : 비회원 (혹은 회원이 로그인하지 않았을 경우의) 시점에서의 게시글들을 최신 등록순으로 볼 수 있는 전체 페이지를 구현.
 * History
 * 2023/02/20 (김유현) 처음 작성함
 * </pre>
 * @author 김유현
 * @version 1.0.0
 * @see 
 * */
public class PostCategoryNonMember extends JFrame {

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
					PostCategoryNonMember frame = new PostCategoryNonMember();
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
	public PostCategoryNonMember() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* 우측의 카테고리를 출력하는 메소드. */
		JPanel ctgPanel = getCtgPanel();

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(260, 0, 1004, 681);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 255, 255));
		topPanel.setBounds(12, 10, 980, 92);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel superCategoryLabel = new JLabel("상위 카테고리명");
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		superCategoryLabel.setBounds(12, 10, 678, 35);
		topPanel.add(superCategoryLabel);
		
		JButton loginButton = new JButton("로그인");
		loginButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		loginButton.setForeground(new Color(70, 70, 70));
		loginButton.setBackground(new Color(0, 255, 128));
		loginButton.setBounds(848, 10, 120, 72);
		topPanel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new LogIn().setVisible(true);
				dispose();
				
			}
		});
		
		JLabel juniorCategoryLabel = new JLabel("> 하위 카테고리명");
		juniorCategoryLabel.setForeground(new Color(70, 70, 70));
		juniorCategoryLabel.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		juniorCategoryLabel.setBounds(12, 46, 678, 20);
		topPanel.add(juniorCategoryLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 112, 980, 559);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		
		/* 게시글을 추가하는 메소드 */
		bodyPanel.add(getPost());

		

		/* 여기 아래부터는 UI상으로 보여주기 위한 post들.
		 * 구현단계에서 사라질 내용들이다.
		 * */
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(339, 10, 300, 130);
		bodyPanel.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_1.setBounds(10, 10, 110, 110);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel postTitleLabel_1_1 = new JLabel("게시글 제목");
		postTitleLabel_1_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_1.setBounds(132, 10, 168, 29);
		panel_1.add(postTitleLabel_1_1);
		
		JLabel priceLabel_1_1 = new JLabel("999,999,000 원");
		priceLabel_1_1.setForeground(new Color(70, 70, 70));
		priceLabel_1_1.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_1.setBounds(132, 91, 168, 29);
		panel_1.add(priceLabel_1_1);
		
		JLabel lblemailnevereverland_1 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_1.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_1.setBounds(134, 49, 166, 16);
		panel_1.add(lblemailnevereverland_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(649, 10, 300, 130);
		bodyPanel.add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_2.setBounds(10, 10, 110, 110);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel postTitleLabel_1_2 = new JLabel("게시글 제목");
		postTitleLabel_1_2.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_2.setBounds(132, 10, 168, 29);
		panel_2.add(postTitleLabel_1_2);
		
		JLabel priceLabel_1_2 = new JLabel("999,999,000 원");
		priceLabel_1_2.setForeground(new Color(70, 70, 70));
		priceLabel_1_2.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_2.setBounds(132, 91, 168, 29);
		panel_2.add(priceLabel_1_2);
		
		JLabel lblemailnevereverland_2 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_2.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_2.setBounds(134, 49, 166, 16);
		panel_2.add(lblemailnevereverland_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(27, 150, 300, 130);
		bodyPanel.add(panel_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_3.setBounds(10, 10, 110, 110);
		panel_3.add(lblNewLabel_1_3);
		
		JLabel postTitleLabel_1_3 = new JLabel("게시글 제목");
		postTitleLabel_1_3.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_3.setBounds(132, 10, 168, 29);
		panel_3.add(postTitleLabel_1_3);
		
		JLabel priceLabel_1_3 = new JLabel("999,999,000 원");
		priceLabel_1_3.setForeground(new Color(70, 70, 70));
		priceLabel_1_3.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_3.setBounds(132, 91, 168, 29);
		panel_3.add(priceLabel_1_3);
		
		JLabel lblemailnevereverland_3 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_3.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_3.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_3.setBounds(134, 49, 166, 16);
		panel_3.add(lblemailnevereverland_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(339, 150, 300, 130);
		bodyPanel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_1_1.setBounds(10, 10, 110, 110);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel postTitleLabel_1_1_1 = new JLabel("게시글 제목");
		postTitleLabel_1_1_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_1_1.setBounds(132, 10, 168, 29);
		panel_1_1.add(postTitleLabel_1_1_1);
		
		JLabel priceLabel_1_1_1 = new JLabel("999,999,000 원");
		priceLabel_1_1_1.setForeground(new Color(70, 70, 70));
		priceLabel_1_1_1.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_1_1.setBounds(132, 91, 168, 29);
		panel_1_1.add(priceLabel_1_1_1);
		
		JLabel lblemailnevereverland_1_1 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_1_1.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_1_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_1_1.setBounds(134, 49, 166, 16);
		panel_1_1.add(lblemailnevereverland_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(649, 150, 300, 130);
		bodyPanel.add(panel_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("New label");
		lblNewLabel_1_2_1.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_2_1.setBounds(10, 10, 110, 110);
		panel_2_1.add(lblNewLabel_1_2_1);
		
		JLabel postTitleLabel_1_2_1 = new JLabel("게시글 제목");
		postTitleLabel_1_2_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_2_1.setBounds(132, 10, 168, 29);
		panel_2_1.add(postTitleLabel_1_2_1);
		
		JLabel priceLabel_1_2_1 = new JLabel("999,999,000 원");
		priceLabel_1_2_1.setForeground(new Color(70, 70, 70));
		priceLabel_1_2_1.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_2_1.setBounds(132, 91, 168, 29);
		panel_2_1.add(priceLabel_1_2_1);
		
		JLabel lblemailnevereverland_2_1 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_2_1.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_2_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_2_1.setBounds(134, 49, 166, 16);
		panel_2_1.add(lblemailnevereverland_2_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(27, 290, 300, 130);
		bodyPanel.add(panel_3_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("New label");
		lblNewLabel_1_3_1.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_3_1.setBounds(10, 10, 110, 110);
		panel_3_1.add(lblNewLabel_1_3_1);
		
		JLabel postTitleLabel_1_3_1 = new JLabel("게시글 제목");
		postTitleLabel_1_3_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_3_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_3_1.setBounds(132, 10, 168, 29);
		panel_3_1.add(postTitleLabel_1_3_1);
		
		JLabel priceLabel_1_3_1 = new JLabel("999,999,000 원");
		priceLabel_1_3_1.setForeground(new Color(70, 70, 70));
		priceLabel_1_3_1.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_3_1.setBounds(132, 91, 168, 29);
		panel_3_1.add(priceLabel_1_3_1);
		
		JLabel lblemailnevereverland_3_1 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_3_1.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_3_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_3_1.setBounds(134, 49, 166, 16);
		panel_3_1.add(lblemailnevereverland_3_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBounds(27, 429, 300, 130);
		bodyPanel.add(panel_3_1_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("New label");
		lblNewLabel_1_3_1_1.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_3_1_1.setBounds(10, 10, 110, 110);
		panel_3_1_1.add(lblNewLabel_1_3_1_1);
		
		JLabel postTitleLabel_1_3_1_1 = new JLabel("게시글 제목");
		postTitleLabel_1_3_1_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_3_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_3_1_1.setBounds(132, 10, 168, 29);
		panel_3_1_1.add(postTitleLabel_1_3_1_1);
		
		JLabel priceLabel_1_3_1_1 = new JLabel("999,999,000 원");
		priceLabel_1_3_1_1.setForeground(new Color(70, 70, 70));
		priceLabel_1_3_1_1.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_3_1_1.setBounds(132, 91, 168, 29);
		panel_3_1_1.add(priceLabel_1_3_1_1);
		
		JLabel lblemailnevereverland_3_1_1 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_3_1_1.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_3_1_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_3_1_1.setBounds(134, 49, 166, 16);
		panel_3_1_1.add(lblemailnevereverland_3_1_1);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBounds(339, 290, 300, 130);
		bodyPanel.add(panel_3_1_2);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("New label");
		lblNewLabel_1_3_1_2.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_3_1_2.setBounds(10, 10, 110, 110);
		panel_3_1_2.add(lblNewLabel_1_3_1_2);
		
		JLabel postTitleLabel_1_3_1_2 = new JLabel("게시글 제목");
		postTitleLabel_1_3_1_2.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_3_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_3_1_2.setBounds(132, 10, 168, 29);
		panel_3_1_2.add(postTitleLabel_1_3_1_2);
		
		JLabel priceLabel_1_3_1_2 = new JLabel("999,999,000 원");
		priceLabel_1_3_1_2.setForeground(new Color(70, 70, 70));
		priceLabel_1_3_1_2.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_3_1_2.setBounds(132, 91, 168, 29);
		panel_3_1_2.add(priceLabel_1_3_1_2);
		
		JLabel lblemailnevereverland_3_1_2 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_3_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_3_1_2.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_3_1_2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_3_1_2.setBounds(134, 49, 166, 16);
		panel_3_1_2.add(lblemailnevereverland_3_1_2);
		
		JPanel panel_3_1_3 = new JPanel();
		panel_3_1_3.setLayout(null);
		panel_3_1_3.setBounds(649, 290, 300, 130);
		bodyPanel.add(panel_3_1_3);
		
		JLabel lblNewLabel_1_3_1_3 = new JLabel("New label");
		lblNewLabel_1_3_1_3.setBackground(new Color(0, 255, 128));
		lblNewLabel_1_3_1_3.setBounds(10, 10, 110, 110);
		panel_3_1_3.add(lblNewLabel_1_3_1_3);
		
		JLabel postTitleLabel_1_3_1_3 = new JLabel("게시글 제목");
		postTitleLabel_1_3_1_3.setForeground(new Color(70, 70, 70));
		postTitleLabel_1_3_1_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1_3_1_3.setBounds(132, 10, 168, 29);
		panel_3_1_3.add(postTitleLabel_1_3_1_3);
		
		JLabel priceLabel_1_3_1_3 = new JLabel("999,999,000 원");
		priceLabel_1_3_1_3.setForeground(new Color(70, 70, 70));
		priceLabel_1_3_1_3.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel_1_3_1_3.setBounds(132, 91, 168, 29);
		panel_3_1_3.add(priceLabel_1_3_1_3);
		
		JLabel lblemailnevereverland_3_1_3 = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		lblemailnevereverland_3_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemailnevereverland_3_1_3.setForeground(new Color(70, 70, 70));
		lblemailnevereverland_3_1_3.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		lblemailnevereverland_3_1_3.setBounds(134, 49, 166, 16);
		panel_3_1_3.add(lblemailnevereverland_3_1_3);
		/* 여기까지 화면상으로 보여주기 위한 Post들.
		 * 추후 for문으로 List<PostDTO>를 받아와서
		 * 12개의 post를 mainPanel에 등록할 예정
		 * */
		
	}
	
	public JPanel getCtgPanel() {
		
		JPanel ctgPanel = new JPanel();
		ctgPanel.setBackground(new Color(245, 245, 245));
		ctgPanel.setBounds(0, 0, 248, 681);
		contentPane.add(ctgPanel);
		ctgPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 154, 224, 456);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ctgPanel.add(scrollPane);
		
		JLabel titleLabel = new JLabel("New label");
		titleLabel.setBounds(24, 10, 204, 67);
		titleLabel.setIcon(new ImageIcon("C:\\Users\\tjoeun\\Downloads\\title (1).png"));
		ctgPanel.add(titleLabel);
		
		JLabel viewAllLabel = new JLabel("전체 게시판");
		viewAllLabel.setBounds(27, 111, 200, 33);
		viewAllLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		ctgPanel.add(viewAllLabel);
		
		return ctgPanel;
	}
	
	public JPanel getPost() {
		
		JPanel post = new JPanel();
		post.setBounds(27, 10, 300, 130);
//		bodyPanel.add(post);
		post.setLayout(null);
		
		JLabel postImage = new JLabel("Image is null");
		postImage.setIcon(null);
		postImage.setOpaque(true);
		postImage.setBackground(new Color(0, 255, 128));
		postImage.setBounds(10, 10, 110, 110);
		post.add(postImage);
		
		JLabel postTitleLabel_1 = new JLabel("게시글 제목");
		postTitleLabel_1.setForeground(new Color(70, 70, 70));
		postTitleLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		postTitleLabel_1.setBounds(132, 10, 168, 29);
		post.add(postTitleLabel_1);
		
		JLabel priceLabel = new JLabel("999,999,000 원");
		priceLabel.setForeground(new Color(70, 70, 70));
		priceLabel.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
		priceLabel.setBounds(132, 91, 168, 29);
		post.add(priceLabel);
		
		JLabel postWriterEmail = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
		postWriterEmail.setHorizontalAlignment(SwingConstants.LEFT);
		postWriterEmail.setForeground(new Color(70, 70, 70));
		postWriterEmail.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		postWriterEmail.setBounds(134, 49, 166, 16);
		post.add(postWriterEmail);
		
		return post;
	}
}