package com.sangbong.jg.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.member.controller.MemberInfoController;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

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
	private PostRightAsset rightAsset;

	/**
	 * Create the frame.
	 * @param memberFound 
	 */
	public MemberInfoView(MemberDTO loginInfo) {

		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* 우측의 카테고리를 출력하는 메소드 */
		rightAsset = new PostRightAsset(loginInfo, this);
		JPanel ctgPanel = rightAsset.getCtgPanel();
		contentPane.add(ctgPanel);

		JLabel writeReportLabel = new JLabel("신고글 작성하기");
		writeReportLabel.setBounds(24, 630, 200, 28);
		writeReportLabel.setForeground(new Color(255, 0, 0));
		writeReportLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		ctgPanel.add(writeReportLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 154, 224, 456);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ctgPanel.add(scrollPane);

		JLabel titleLabel = new JLabel("New label");
		titleLabel.setBounds(24, 10, 204, 67);
		titleLabel.setIcon(new ImageIcon("images//title.png"));
		ctgPanel.add(titleLabel);
		titleLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new PostCategory(loginInfo).setVisible(true);
				dispose();
			}
		});

		JLabel viewAllLabel = new JLabel("전체 게시판");
		viewAllLabel.setBounds(27, 111, 200, 33);
		viewAllLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
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
		viewTitle.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		viewTitle.setBounds(12, 10, 678, 35);
		topPanel.add(viewTitle);

		JButton deactivateButton = new JButton("탈퇴");
		deactivateButton.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		deactivateButton.setForeground(new Color(70, 70, 70));
		deactivateButton.setBackground(new Color(241, 87, 87));
		deactivateButton.setBounds(848, 50, 120, 72);
		topPanel.add(deactivateButton);
		deactivateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int var = JOptionPane.showConfirmDialog(null, "정말로 탈퇴를 진행하시겠습니까?", "회원 탈퇴 재확인"
						, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

				if(var == 0) {
					MemberInfoController memberInfoController = new MemberInfoController();
					if(memberInfoController.deactivateMember(loginInfo) > 0) {
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다. 로그인 화면으로 돌아갑니다.", "탈퇴 완료", JOptionPane.PLAIN_MESSAGE);
						new LogIn().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "탈퇴가 성공적으로 진행되지 못했습니다.", "탈퇴 실패", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		JLabel postTitleLabel = new JLabel(loginInfo.getMemName() + "님, 안녕하세요!");
		postTitleLabel.setForeground(new Color(70, 70, 70));
		postTitleLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
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
		authorEmailLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		authorEmailLabel.setBounds(12, 10, 501, 25);
		bodyPanel.add(authorEmailLabel);

		JLabel emailTitle = new JLabel("이메일");
		emailTitle.setHorizontalAlignment(SwingConstants.LEFT);
		emailTitle.setForeground(new Color(121, 121, 121));
		emailTitle.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 16f));
		emailTitle.setBounds(12, 58, 84, 25);
		bodyPanel.add(emailTitle);

		JLabel memberEmail = new JLabel(loginInfo.getEmail());
		memberEmail.setHorizontalAlignment(SwingConstants.LEFT);
		memberEmail.setForeground(new Color(70, 70, 70));
		memberEmail.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 16f));
		memberEmail.setBounds(12, 93, 427, 25);
		bodyPanel.add(memberEmail);

		JLabel nameTitle = new JLabel("닉네임");
		nameTitle.setHorizontalAlignment(SwingConstants.LEFT);
		nameTitle.setForeground(new Color(121, 121, 121));
		nameTitle.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 16f));
		nameTitle.setBounds(12, 149, 84, 25);
		bodyPanel.add(nameTitle);

		JLabel memberName = new JLabel(loginInfo.getMemName());
		memberName.setHorizontalAlignment(SwingConstants.LEFT);
		memberName.setForeground(new Color(70, 70, 70));
		memberName.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 16f));
		memberName.setBounds(12, 184, 427, 25);
		bodyPanel.add(memberName);

		JButton editNameButton = new JButton("닉네임 수정");
		editNameButton.setForeground(new Color(70, 70, 70));
		editNameButton.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 20f));
		editNameButton.setBackground(new Color(212, 212, 212));
		editNameButton.setBounds(824, 149, 144, 60);
		bodyPanel.add(editNameButton);
		editNameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String input = JOptionPane.showInputDialog(null, "변경할 닉네임을 입력해주세요 : ", "닉네임 변경", JOptionPane.QUESTION_MESSAGE);

				MemberInfoController memberInfoController = new MemberInfoController();
				if(memberInfoController.changeMemberName(input, loginInfo) > 0) {
					JOptionPane.showMessageDialog(null, "닉네임이 성공적으로 변경 되었습니다.", "닉네임 변경 완료", JOptionPane.PLAIN_MESSAGE);
					new MemberInfoView(memberInfoController.findMemberInfo(loginInfo)).setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "닉네임 변경에 실패했습니다.", "닉네임 변경 실패", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton editPwdButton = new JButton("비밀번호 수정");
		editPwdButton.setForeground(new Color(70, 70, 70));
		editPwdButton.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 20f));
		editPwdButton.setBackground(new Color(212, 212, 212));
		editPwdButton.setBounds(811, 244, 157, 60);
		bodyPanel.add(editPwdButton);
		editPwdButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MemberInfoController memberInfoController = new MemberInfoController();

				String inputOldPwd = JOptionPane.showInputDialog(null, "현재 비밀번호를 입력해주세요 : ", "비밀번호 확인", JOptionPane.QUESTION_MESSAGE);

				if(memberInfoController.confirmPwd(inputOldPwd, loginInfo) != null) {

					String inputNewPwd = JOptionPane.showInputDialog(null, "변경할 비밀번호를 입력해주세요 : ", "닉네임 변경", JOptionPane.QUESTION_MESSAGE);

					if(memberInfoController.changePwd(inputNewPwd, loginInfo) > 0) {
						JOptionPane.showMessageDialog(null, "비밀번호가 성공적으로 변경 되었습니다.", "닉네임 변경 완료", JOptionPane.PLAIN_MESSAGE);
						new MemberInfoView(memberInfoController.findMemberInfo(loginInfo)).setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호 변경에 실패했습니다.", "비밀번호 변경 실패", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.", "비밀번호 불일치", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JLabel pwd = new JLabel("비밀번호");
		pwd.setHorizontalAlignment(SwingConstants.LEFT);
		pwd.setForeground(new Color(121, 121, 121));
		pwd.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 16f));
		pwd.setBounds(12, 260, 84, 25);
		bodyPanel.add(pwd);
		
		JButton toMemberPostViewButton = new JButton("내가 쓴 글 보러가기");
		toMemberPostViewButton.setForeground(new Color(70, 70, 70));
		toMemberPostViewButton.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 20f));
		toMemberPostViewButton.setBackground(new Color(212, 212, 212));
		toMemberPostViewButton.setBounds(757, 457, 209, 60);
		bodyPanel.add(toMemberPostViewButton);
		toMemberPostViewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MemberInfoController memberInfoController = new MemberInfoController();
				List<PostDTO> myPostList = memberInfoController.findMyPostList(loginInfo);
				
				if(myPostList.size() != 0) {
					new MemberPostView(loginInfo).setVisible(true);;
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "아직 게시글을 작성하지 않으셨습니다.", "게시글 존재하지 않음", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
