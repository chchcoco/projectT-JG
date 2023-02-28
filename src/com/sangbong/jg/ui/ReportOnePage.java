package com.sangbong.jg.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.common.PostListReturn;
import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.controller.ReportController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * Class : ReportOnePage
 * Comment : 관리자가 회원이 작성한 신고글 내용을 조회하는 화면 UI를 구현한다. 
 * History
 * 2023/02/16 (김유현) 처음 작성함
 * </pre>
 * @author 김유현
 * @version 1.1.0
 * @see 
 * */
public class ReportOnePage extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;
	private PostRightAsset rightAsset;
	private PostListReturn postListReturn;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					ReportOnePage frame = new ReportOnePage();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public ReportOnePage(MemberDTO loginInfo, ReportDTO report) {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		rightAsset = new PostRightAsset(loginInfo, this);
		JPanel ctgPanel = rightAsset.getCtgPanel();
		contentPane.add(ctgPanel);

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

		JLabel superCategoryLabel = new JLabel("신고 게시판");
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		superCategoryLabel.setBounds(12, 10, 678, 35);
		topPanel.add(superCategoryLabel);

		JButton discardButton = new JButton("미승인");
		discardButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		discardButton.setForeground(new Color(70, 70, 70));
		discardButton.setBackground(new Color(241, 87, 87));
		discardButton.setBounds(848, 76, 120, 72);
		topPanel.add(discardButton);
		discardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ReportController reportController = new ReportController();
				int result = reportController.discardReport(report);
				if(result > 0) {
					new ReportView(loginInfo).setVisible(true);
					dispose();
				} else {
					System.out.println("실패");
				}
			}
		});

		JButton approveButton = new JButton("승인");
		approveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportController reportController = new ReportController();
				int result1 = reportController.approveReport(report);
				int result2 = reportController.addPenaltyToMember(report);
				if(result1 > 0 && result2 > 0) {

					new ReportView(loginInfo).setVisible(true);
					dispose();
				} else {
					System.out.println("실패");
				}
			}
		});
		approveButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		approveButton.setForeground(new Color(70, 70, 70));
		approveButton.setBackground(new Color(136, 219, 98));
		approveButton.setBounds(716, 76, 120, 72);
		topPanel.add(approveButton);

		JLabel postTitleLabel = new JLabel(report.getReportCode());
		postTitleLabel.setForeground(new Color(70, 70, 70));
		postTitleLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 32));
		postTitleLabel.setBounds(12, 76, 678, 50);
		topPanel.add(postTitleLabel);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format(report.getReportDate());
		JLabel dateLabel = new JLabel(date);
		dateLabel.setForeground(new Color(70, 70, 70));
		dateLabel.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		dateLabel.setBounds(12, 128, 250, 20);
		topPanel.add(dateLabel);

		String approval = "";
		switch(report.getReportApproval()) {
		case 'Y':
			approval = "[ 승인 ]";
			break;
		case 'N':
			approval = "[ 미승인 ]";
			break;
		case '-':
			approval = "[ 보류 ]";
			break;
		}
		JLabel reportStatusLabel = new JLabel(approval);
		reportStatusLabel.setForeground(new Color(70, 70, 70));
		reportStatusLabel.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		reportStatusLabel.setBounds(12, 46, 678, 20);
		topPanel.add(reportStatusLabel);

		JLabel profilePic = new JLabel("");
		profilePic.setIcon(new ImageIcon("images/profilePic.png"));
		profilePic.setBounds(924, 10, 44, 44);
		topPanel.add(profilePic);

		JLabel myName = new JLabel("ADMIN " + loginInfo.getMemName() + " 님");
		myName.setHorizontalAlignment(SwingConstants.RIGHT);
		myName.setForeground(new Color(70, 70, 70));
		myName.setFont(new Font("Dialog", Font.PLAIN, 16));
		myName.setBounds(784, 25, 128, 20);
		topPanel.add(myName);

		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 178, 980, 493);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(12, 10, 394, 394);
		bodyPanel.add(btnNewButton_2);

		JLabel authorEmailLabel = new JLabel("작성자 : " + report.getReporterEmail());
		authorEmailLabel.setForeground(new Color(70, 70, 70));
		authorEmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorEmailLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		authorEmailLabel.setBounds(467, 208, 501, 25);
		bodyPanel.add(authorEmailLabel);

		JTextArea textContext = new JTextArea();
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		textContext.setText(report.getRepostContext());
		textContext.setLineWrap(true);
		textContext.setBounds(467, 243, 501, 160);
		bodyPanel.add(textContext);

		JLabel lblNewLabel_9 = new JLabel("1");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(162, 425, 14, 15);
		bodyPanel.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("2");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_1.setBounds(188, 425, 14, 15);
		bodyPanel.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("3");
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_2.setBounds(214, 425, 14, 15);
		bodyPanel.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("4");
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_3.setBounds(240, 425, 14, 15);
		bodyPanel.add(lblNewLabel_9_3);

		JLabel lblNewLabel_9_4 = new JLabel("5");
		lblNewLabel_9_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_4.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 16));
		lblNewLabel_9_4.setBounds(266, 425, 14, 15);
		bodyPanel.add(lblNewLabel_9_4);

		JLabel backButton = new JLabel("돌아가기");
		backButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setBounds(454, 456, 100, 27);
		bodyPanel.add(backButton);
		backButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				dispose();
			}

		});

//		JLabel nextButton = new JLabel("다음 페이지  >");
//		nextButton.setHorizontalAlignment(SwingConstants.RIGHT);
//		nextButton.setFont(new Font("Dialog", Font.PLAIN, 20));
//		nextButton.setBounds(563, 456, 128, 27);
//		bodyPanel.add(nextButton);
//		nextButton.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e) {
//			}
//
//		});
//
//		JLabel previousButton = new JLabel("<  이전 페이지");
//		previousButton.setHorizontalAlignment(SwingConstants.LEFT);
//		previousButton.setFont(new Font("Dialog", Font.PLAIN, 20));
//		previousButton.setBounds(318, 456, 128, 27);
//		bodyPanel.add(previousButton);
//		previousButton.addMouseListener(new MouseAdapter() {
//
//			public void mouseClicked(MouseEvent e) {
//
//			}
//
//		});

		JLabel authorEmailLabel_1 = new JLabel("신고대상 이메일");
		authorEmailLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		authorEmailLabel_1.setForeground(new Color(70, 70, 70));
		authorEmailLabel_1.setFont(new Font("나눔스퀘어 네오 OTF Bold", Font.PLAIN, 16));
		authorEmailLabel_1.setBounds(467, 10, 501, 25);
		bodyPanel.add(authorEmailLabel_1);

		JLabel authorEmailLabel_1_1 = new JLabel(report.getReportedEmail());
		authorEmailLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		authorEmailLabel_1_1.setForeground(new Color(128, 128, 128));
		authorEmailLabel_1_1.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		authorEmailLabel_1_1.setBounds(467, 45, 501, 25);
		bodyPanel.add(authorEmailLabel_1_1);

		JLabel authorEmailLabel_1_2 = new JLabel("신고 사유");
		authorEmailLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		authorEmailLabel_1_2.setForeground(new Color(70, 70, 70));
		authorEmailLabel_1_2.setFont(new Font("나눔스퀘어 네오 OTF Bold", Font.PLAIN, 16));
		authorEmailLabel_1_2.setBounds(467, 105, 501, 25);
		bodyPanel.add(authorEmailLabel_1_2);

		JLabel authorEmailLabel_1_1_1 = new JLabel(report.getReportReason());
		authorEmailLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		authorEmailLabel_1_1_1.setForeground(Color.GRAY);
		authorEmailLabel_1_1_1.setFont(new Font("나눔스퀘어 네오 OTF Regular", Font.PLAIN, 16));
		authorEmailLabel_1_1_1.setBounds(467, 140, 501, 25);
		bodyPanel.add(authorEmailLabel_1_1_1);
	}
}
