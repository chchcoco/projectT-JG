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
 * Class : PostOnePage
 * Comment : 회원이 자기 자신의 글을 조회하는 화면 UI를 구현한다. 
 * History
 * 2023/02/16 (김유현) 처음 작성함
 * 2023/02/17 (김유현) 프로젝트 내부의 폰트, 이미지 파일과 연결
 * </pre>
 * @author 김유현
 * @version 1.1.0
 * @see 
 * */
public class PostOnePage extends JFrame {

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
					PostOnePage frame = new PostOnePage();
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
	public PostOnePage() {
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
		titleLabel.setIcon(new ImageIcon("C:\\Users\\tjoeun\\Downloads\\title (1).png"));
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
		topPanel.setBounds(12, 10, 980, 158);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel superCategoryLabel = new JLabel("상위 카테고리명");
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		superCategoryLabel.setBounds(12, 10, 678, 35);
		topPanel.add(superCategoryLabel);
		
		JButton deleteButton = new JButton("삭제");
		deleteButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		deleteButton.setForeground(new Color(70, 70, 70));
		deleteButton.setBackground(new Color(241, 87, 87));
		deleteButton.setBounds(848, 76, 120, 72);
		topPanel.add(deleteButton);
		
		JButton editButton = new JButton("수정");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		editButton.setForeground(new Color(70, 70, 70));
		editButton.setBackground(new Color(212, 212, 212));
		editButton.setBounds(716, 76, 120, 72);
		topPanel.add(editButton);
		
		JLabel postTitleLabel = new JLabel("게시글 제목");
		postTitleLabel.setForeground(new Color(70, 70, 70));
		postTitleLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 32));
		postTitleLabel.setBounds(12, 76, 678, 50);
		topPanel.add(postTitleLabel);
		
		JLabel dateLabel = new JLabel("2000/10/10");
		dateLabel.setForeground(new Color(70, 70, 70));
		dateLabel.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		dateLabel.setBounds(12, 128, 250, 20);
		topPanel.add(dateLabel);
		
		JLabel juniorCategoryLabel = new JLabel("> 하위 카테고리명");
		juniorCategoryLabel.setForeground(new Color(70, 70, 70));
		juniorCategoryLabel.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		juniorCategoryLabel.setBounds(12, 46, 678, 20);
		topPanel.add(juniorCategoryLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 178, 980, 493);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(12, 10, 428, 428);
		bodyPanel.add(btnNewButton_2);
		
		JLabel priceLabel = new JLabel("999,999,999,000 원");
		priceLabel.setForeground(new Color(70, 70, 70));
		priceLabel.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 40));
		priceLabel.setBounds(467, 10, 501, 50);
		bodyPanel.add(priceLabel);
		
		JLabel authorEmailLabel = new JLabel("작성자 이름 (EMAIL@NEVEREVER.LAND)");
		authorEmailLabel.setForeground(new Color(70, 70, 70));
		authorEmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorEmailLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		authorEmailLabel.setBounds(467, 84, 501, 25);
		bodyPanel.add(authorEmailLabel);
		
		JTextArea textContext = new JTextArea();
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textContext.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext.setLineWrap(true);
		textContext.setBounds(467, 116, 501, 322);
		bodyPanel.add(textContext);
		
		JLabel lblNewLabel_9 = new JLabel("1");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(162, 454, 14, 15);
		bodyPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("2");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_1.setBounds(188, 454, 14, 15);
		bodyPanel.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("3");
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_2.setBounds(214, 454, 14, 15);
		bodyPanel.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_9_3 = new JLabel("4");
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_3.setBounds(240, 454, 14, 15);
		bodyPanel.add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_9_4 = new JLabel("5");
		lblNewLabel_9_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_4.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_4.setBounds(266, 454, 14, 15);
		bodyPanel.add(lblNewLabel_9_4);
		
		JLabel lblNewLabel = new JLabel("돌아가기");
		lblNewLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(454, 456, 100, 27);
		bodyPanel.add(lblNewLabel);
	}
}
