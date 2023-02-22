package com.sangbong.jg.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.member.controller.MemberInfoController;
import com.sangbong.jg.model.dto.MemberDTO;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class ReportView extends JFrame {

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
					ReportView frame = new ReportView();
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
	public ReportView() {
		
		/* 테스트용 임시 dto들 */
//		MemberDTO member = new MemberDTO("mung@gmail.com", "12345", "박멍멍", 0, 'Y', 'N', null, null, "MEMBER");
//		String testEmail = "mung@gmail.com";
		String adminEmail = "nyang@gmail.com";
		MemberDTO member = new MemberDTO("nyang@gmail.com", "12345", "김냥냥", 0, 'Y', 'N', null, null, "ADMIN");
		
		/* 기본 프레임 생성 */
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* 카테고리 패널 - 추후 메소드로 분리할 듯 */
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
		topPanel.setBounds(12, 10, 980, 76);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel superCategoryLabel = new JLabel("신고 게시판");
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		superCategoryLabel.setBounds(12, 10, 678, 35);
		topPanel.add(superCategoryLabel);
		
		JLabel profilePic = new JLabel("");
		profilePic.setIcon(new ImageIcon("images/profilePic.png"));
		profilePic.setBounds(924, 10, 44, 44);
		topPanel.add(profilePic);
		profilePic.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberInfoController memberInfoController = new MemberInfoController();
				if(memberInfoController.findMemberInfo(member) != null) {
					new MemberInfoView(member).setVisible(true);
					dispose();
				}
			}
			
		});
		
		JLabel myName = new JLabel("홍길동 님");
		myName.setHorizontalAlignment(SwingConstants.RIGHT);
		myName.setForeground(new Color(70, 70, 70));
		myName.setFont(new Font("Dialog", Font.PLAIN, 16));
		myName.setBounds(784, 25, 128, 20);
		topPanel.add(myName);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 96, 980, 484);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JPanel reportPanel = new JPanel();
		reportPanel.setBounds(12, 10, 956, 84);
		bodyPanel.add(reportPanel);
		reportPanel.setLayout(null);
		
		JLabel reportReasonLabel = new JLabel("신고 사유 : ");
		reportReasonLabel.setBounds(10, 42, 436, 16);
		reportPanel.add(reportReasonLabel);
		reportReasonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel.setForeground(new Color(70, 70, 70));
		reportReasonLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		
		JLabel reportTitleLabel = new JLabel("신고글 제목 [승인여부]");
		reportTitleLabel.setForeground(new Color(70, 70, 70));
		reportTitleLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		reportTitleLabel.setBounds(0, 0, 446, 35);
		reportPanel.add(reportTitleLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(872, 0, 84, 84);
		reportPanel.add(btnNewButton);
		
		JLabel reportedEmailLabel = new JLabel("신고 대상");
		reportedEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel.setForeground(new Color(70, 70, 70));
		reportedEmailLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportedEmailLabel.setBounds(10, 68, 436, 16);
		reportPanel.add(reportedEmailLabel);
		
		JTextArea textContext = new JTextArea();
		textContext.setBounds(448, 10, 412, 64);
		reportPanel.add(textContext);
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		textContext.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext.setLineWrap(true);
		
		JPanel reportPanel_1 = new JPanel();
		reportPanel_1.setLayout(null);
		reportPanel_1.setBounds(12, 104, 956, 84);
		bodyPanel.add(reportPanel_1);
		
		JLabel reportReasonLabel_1 = new JLabel("신고 사유 : ");
		reportReasonLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel_1.setForeground(new Color(70, 70, 70));
		reportReasonLabel_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportReasonLabel_1.setBounds(10, 42, 436, 16);
		reportPanel_1.add(reportReasonLabel_1);
		
		JLabel reportTitleLabel_1 = new JLabel("신고글 제목 [승인여부]");
		reportTitleLabel_1.setForeground(new Color(70, 70, 70));
		reportTitleLabel_1.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		reportTitleLabel_1.setBounds(0, 0, 446, 35);
		reportPanel_1.add(reportTitleLabel_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(872, 0, 84, 84);
		reportPanel_1.add(btnNewButton_1);
		
		JLabel reportedEmailLabel_1 = new JLabel("신고 대상");
		reportedEmailLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel_1.setForeground(new Color(70, 70, 70));
		reportedEmailLabel_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportedEmailLabel_1.setBounds(10, 68, 436, 16);
		reportPanel_1.add(reportedEmailLabel_1);
		
		JTextArea textContext_1 = new JTextArea();
		textContext_1.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext_1.setLineWrap(true);
		textContext_1.setForeground(new Color(70, 70, 70));
		textContext_1.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		textContext_1.setBounds(448, 10, 412, 64);
		reportPanel_1.add(textContext_1);
		
		JPanel reportPanel_2 = new JPanel();
		reportPanel_2.setLayout(null);
		reportPanel_2.setBounds(12, 198, 956, 84);
		bodyPanel.add(reportPanel_2);
		
		JLabel reportReasonLabel_2 = new JLabel("신고 사유 : ");
		reportReasonLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel_2.setForeground(new Color(70, 70, 70));
		reportReasonLabel_2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportReasonLabel_2.setBounds(10, 42, 436, 16);
		reportPanel_2.add(reportReasonLabel_2);
		
		JLabel reportTitleLabel_2 = new JLabel("신고글 제목 [승인여부]");
		reportTitleLabel_2.setForeground(new Color(70, 70, 70));
		reportTitleLabel_2.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		reportTitleLabel_2.setBounds(0, 0, 446, 35);
		reportPanel_2.add(reportTitleLabel_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(872, 0, 84, 84);
		reportPanel_2.add(btnNewButton_2);
		
		JLabel reportedEmailLabel_2 = new JLabel("신고 대상");
		reportedEmailLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel_2.setForeground(new Color(70, 70, 70));
		reportedEmailLabel_2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportedEmailLabel_2.setBounds(10, 68, 436, 16);
		reportPanel_2.add(reportedEmailLabel_2);
		
		JTextArea textContext_2 = new JTextArea();
		textContext_2.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext_2.setLineWrap(true);
		textContext_2.setForeground(new Color(70, 70, 70));
		textContext_2.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		textContext_2.setBounds(448, 10, 412, 64);
		reportPanel_2.add(textContext_2);
		
		JPanel reportPanel_3 = new JPanel();
		reportPanel_3.setLayout(null);
		reportPanel_3.setBounds(12, 292, 956, 84);
		bodyPanel.add(reportPanel_3);
		
		JLabel reportReasonLabel_3 = new JLabel("신고 사유 : ");
		reportReasonLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel_3.setForeground(new Color(70, 70, 70));
		reportReasonLabel_3.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportReasonLabel_3.setBounds(10, 42, 436, 16);
		reportPanel_3.add(reportReasonLabel_3);
		
		JLabel reportTitleLabel_3 = new JLabel("신고글 제목 [승인여부]");
		reportTitleLabel_3.setForeground(new Color(70, 70, 70));
		reportTitleLabel_3.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		reportTitleLabel_3.setBounds(0, 0, 446, 35);
		reportPanel_3.add(reportTitleLabel_3);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(872, 0, 84, 84);
		reportPanel_3.add(btnNewButton_3);
		
		JLabel reportedEmailLabel_3 = new JLabel("신고 대상");
		reportedEmailLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel_3.setForeground(new Color(70, 70, 70));
		reportedEmailLabel_3.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportedEmailLabel_3.setBounds(10, 68, 436, 16);
		reportPanel_3.add(reportedEmailLabel_3);
		
		JTextArea textContext_3 = new JTextArea();
		textContext_3.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext_3.setLineWrap(true);
		textContext_3.setForeground(new Color(70, 70, 70));
		textContext_3.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		textContext_3.setBounds(448, 10, 412, 64);
		reportPanel_3.add(textContext_3);
		
		JPanel reportPanel_4 = new JPanel();
		reportPanel_4.setLayout(null);
		reportPanel_4.setBounds(12, 386, 956, 84);
		bodyPanel.add(reportPanel_4);
		
		JLabel reportReasonLabel_4 = new JLabel("신고 사유 : ");
		reportReasonLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel_4.setForeground(new Color(70, 70, 70));
		reportReasonLabel_4.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportReasonLabel_4.setBounds(10, 42, 436, 16);
		reportPanel_4.add(reportReasonLabel_4);
		
		JLabel reportTitleLabel_4 = new JLabel("신고글 제목 [승인여부]");
		reportTitleLabel_4.setForeground(new Color(70, 70, 70));
		reportTitleLabel_4.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		reportTitleLabel_4.setBounds(0, 0, 446, 35);
		reportPanel_4.add(reportTitleLabel_4);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(872, 0, 84, 84);
		reportPanel_4.add(btnNewButton_4);
		
		JLabel reportedEmailLabel_4 = new JLabel("신고 대상");
		reportedEmailLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel_4.setForeground(new Color(70, 70, 70));
		reportedEmailLabel_4.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportedEmailLabel_4.setBounds(10, 68, 436, 16);
		reportPanel_4.add(reportedEmailLabel_4);
		
		JTextArea textContext_4 = new JTextArea();
		textContext_4.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext_4.setLineWrap(true);
		textContext_4.setForeground(new Color(70, 70, 70));
		textContext_4.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		textContext_4.setBounds(448, 10, 412, 64);
		reportPanel_4.add(textContext_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(372, 600, 248, 54);
		mainPanel.add(panel);
		
		JButton page1 = new JButton("1");
		panel.add(page1);
		
		JButton page2 = new JButton("2");
		panel.add(page2);
	}
}
