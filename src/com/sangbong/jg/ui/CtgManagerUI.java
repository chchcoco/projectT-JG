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
import javax.swing.JTextPane;
import javax.swing.JTextField;

/**
 * <pre>
 * Class : CtgManagerUI
 * Comment : 관리자가 게시글 카테고리를 생성, 수정, 삭제하는 페이지의 UI를 구현
 * History
 * 2023/02/19 (신예찬) 처음 작성함
 * </pre>
 * @author 신예찬
 * @version 1.0.0
 * @see 
 * */
public class CtgManagerUI extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;
	private JTextField chooseCtgText;
	private JTextField addOrEditCtgText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CtgManagerUI frame = new CtgManagerUI();
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
	public CtgManagerUI() {
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
		
		JLabel superCategoryLabel = new JLabel("카테고리 수정");
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		superCategoryLabel.setBounds(12, 10, 558, 35);
		topPanel.add(superCategoryLabel);
		
		JButton postManagerButton = new JButton("신고관리");
		postManagerButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		postManagerButton.setForeground(new Color(70, 70, 70));
		postManagerButton.setBackground(new Color(255, 128, 128));
		postManagerButton.setBounds(848, 10, 120, 72);
		topPanel.add(postManagerButton);
		
		JButton memberManagerButton = new JButton("회원관리");
		memberManagerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		memberManagerButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		memberManagerButton.setForeground(new Color(70, 70, 70));
		memberManagerButton.setBackground(new Color(212, 212, 212));
		memberManagerButton.setBounds(716, 10, 120, 72);
		topPanel.add(memberManagerButton);
		
		JLabel subCategoryLabel = new JLabel("관리자 모드");
		subCategoryLabel.setForeground(new Color(0, 0, 0));
		subCategoryLabel.setFont(new Font("굴림", Font.BOLD, 12));
		subCategoryLabel.setBounds(12, 55, 176, 15);
		topPanel.add(subCategoryLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 112, 980, 559);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(132, 56, 237, 456);
		bodyPanel.add(scrollPane);
		
		chooseCtgText = new JTextField();
		chooseCtgText.setBounds(494, 82, 278, 21);
		bodyPanel.add(chooseCtgText);
		chooseCtgText.setColumns(10);
		
		JLabel chooseCtgLabel = new JLabel("선택한 카테고리");
		chooseCtgLabel.setBounds(494, 56, 137, 15);
		bodyPanel.add(chooseCtgLabel);
		
		JButton ctgAddButton = new JButton("추가");
		ctgAddButton.setForeground(new Color(70, 70, 70));
		ctgAddButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctgAddButton.setBackground(new Color(128, 255, 128));
		ctgAddButton.setBounds(494, 136, 73, 47);
		bodyPanel.add(ctgAddButton);
		
		JButton ctgEditButton = new JButton("수정");
		ctgEditButton.setForeground(new Color(70, 70, 70));
		ctgEditButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctgEditButton.setBackground(new Color(255, 255, 128));
		ctgEditButton.setBounds(598, 136, 73, 47);
		bodyPanel.add(ctgEditButton);
		
		JButton ctgDeleteButton = new JButton("삭제");
		ctgDeleteButton.setForeground(new Color(70, 70, 70));
		ctgDeleteButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctgDeleteButton.setBackground(new Color(255, 128, 128));
		ctgDeleteButton.setBounds(699, 136, 73, 47);
		bodyPanel.add(ctgDeleteButton);
		
		JLabel addOrEditCtgLabel = new JLabel("추가/변경할 카테고리");
		addOrEditCtgLabel.setBounds(494, 227, 137, 15);
		bodyPanel.add(addOrEditCtgLabel);
		
		addOrEditCtgText = new JTextField();
		addOrEditCtgText.setColumns(10);
		addOrEditCtgText.setBounds(494, 253, 278, 21);
		bodyPanel.add(addOrEditCtgText);
		
		JButton ctgSaveButton = new JButton("변경사항 저장");
		ctgSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ctgSaveButton.setForeground(new Color(70, 70, 70));
		ctgSaveButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctgSaveButton.setBackground(new Color(255, 128, 128));
		ctgSaveButton.setBounds(598, 465, 174, 47);
		bodyPanel.add(ctgSaveButton);
	
		
	}
	
	public JPanel getCtgPanel() {
		
		JPanel ctgPanel = new JPanel();
		ctgPanel.setBackground(new Color(245, 245, 245));
		ctgPanel.setBounds(0, 0, 248, 681);
		contentPane.add(ctgPanel);
		ctgPanel.setLayout(null);
		
		JLabel writeReportLabel = new JLabel("신고글 작성하기");
		writeReportLabel.setBounds(24, 630, 200, 28);
		writeReportLabel.setForeground(new Color(255, 0, 0));
		writeReportLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
//		writeReportLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
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
		
		return ctgPanel;
	}
	
//	public JPanel getPost() {
//		
//		JPanel post = new JPanel();
//		post.setBounds(27, 10, 300, 130);
////		bodyPanel.add(post);
//		post.setLayout(null);
//		
//		JLabel postImage = new JLabel("Image is null");
//		postImage.setIcon(null);
//		postImage.setOpaque(true);
//		postImage.setBackground(new Color(0, 255, 128));
//		postImage.setBounds(10, 10, 110, 110);
//		post.add(postImage);
//		
//		JLabel postTitleLabel_1 = new JLabel("게시글 제목");
//		postTitleLabel_1.setForeground(new Color(70, 70, 70));
//		postTitleLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
//		postTitleLabel_1.setBounds(132, 10, 168, 29);
//		post.add(postTitleLabel_1);
//		
//		JLabel priceLabel = new JLabel("999,999,000 원");
//		priceLabel.setForeground(new Color(70, 70, 70));
//		priceLabel.setFont(new Font("나눔스퀘어 네오 ExtraBold", Font.PLAIN, 20));
//		priceLabel.setBounds(132, 91, 168, 29);
//		post.add(priceLabel);
//		
//		JLabel postWriterEmail = new JLabel("작성자 이름(EMAIL@NEVEREVER.LAND)");
//		postWriterEmail.setHorizontalAlignment(SwingConstants.LEFT);
//		postWriterEmail.setForeground(new Color(70, 70, 70));
//		postWriterEmail.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
//		postWriterEmail.setBounds(134, 49, 166, 16);
//		post.add(postWriterEmail);
//		
//		return post;
//	}
}