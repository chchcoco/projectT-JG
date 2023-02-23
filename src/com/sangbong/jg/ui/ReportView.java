package com.sangbong.jg.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.member.controller.MemberInfoController;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.ReportDTO;
import com.sangbong.jg.report.controller.ReportController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

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
		bodyPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		
		ReportPanelMaker reportPanel = new ReportPanelMaker();
		/* 리스트로 가지러 갈 예정 */
		ReportController reportController = new ReportController();
		List<ReportDTO> reportList = reportController.findReportList();
		
		for (int i = 0; i < 5; i++) {
			reportPanel.PanelMaker(bodyPanel, reportList.get(i));
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(372, 600, 248, 54);
		mainPanel.add(panel);
		
		JButton page1 = new JButton("1");
		panel.add(page1);
		
		JButton page2 = new JButton("2");
		panel.add(page2);
	}
}
