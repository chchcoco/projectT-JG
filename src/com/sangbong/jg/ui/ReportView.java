package com.sangbong.jg.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.common.PostListReturn;
import com.sangbong.jg.common.PostRightAsset;
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
import java.awt.Component;

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
	private ReportView view;
	private JPanel contentPane;
	private PostRightAsset rightAsset;
	private MemberDTO loginInfo;
	
//	private static MemberDTO loginInfo = new MemberDTO("nyang@gmail.com", "12345", "김냥냥", 0, 'Y', 'N', null, null, "ADMIN");

	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//			
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						ReportView frame = new ReportView(loginInfo);
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

	/**
	 * Create the frame.
	 */
	public ReportView(MemberDTO loginInfo) {
		
		this.loginInfo = loginInfo;


		/* 기본 프레임 생성 */
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* 우측의 카테고리를 출력하는 메소드. */
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
				if(memberInfoController.findMemberInfo(loginInfo) != null) {
					new MemberInfoView(loginInfo).setVisible(true);
					dispose();
				}
			}

		});

		JLabel myName = new JLabel("ADMIN " + loginInfo.getMemName() + " 님");
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

		/* 필요 페이지 수를 알아낸 후 */
		int pageNumber = 0;
		if((reportList.size() % 5) == 0) {
			pageNumber = reportList.size() / 5;
		} else {
			pageNumber = (reportList.size() / 5) + 1;
		}

		/* 페이지 이동용 버튼을 담을 패널을 생성하고 */
		JPanel pageNavPanel = new JPanel();
		pageNavPanel.setBounds(372, 600, 248, 54);
		mainPanel.add(pageNavPanel);

		/* 반복문을 통해 맞는 갯수의 버튼을 생성하고 패널에 담는다 */
		for (int i = 1; i <= pageNumber; i++) {
			String panelName = "page" + i;
			JButton button = new JButton(String.valueOf(i));
			pageNavPanel.add(button);
			button.setName(panelName);

			int n = i;
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Component[] componentList = bodyPanel.getComponents();

					//Loop through the components
					for(Component c : componentList){

						//Find the components you want to remove
						if(c instanceof JPanel){

							//Remove it
							bodyPanel.remove(c);
						}
					}	

					//IMPORTANT
					bodyPanel.revalidate();
					bodyPanel.repaint();
					for (int i = (n * 5 - 5); (n * 5 - 6) < i && i < (n * 5) && i < reportList.size(); i++) {
						reportPanel.PanelMaker(loginInfo, bodyPanel, reportList.get(i));
					}
				}
			});
		}

		for (int i = 0; i < 5; i++) {
			reportPanel.PanelMaker(loginInfo, bodyPanel, reportList.get(i));
		}
	}
}
