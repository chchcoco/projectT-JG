package com.sangbong.jg.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.common.PostListReturn;
import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.member.controller.MemberInfoController;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

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
 * @see MyPostPanelMaker
 * */
public class MemberPostView extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;
	private PostRightAsset rightAsset;
	private PostListReturn postListReturn;

	/**
	 * Create the frame.
	 * @param memberFound 
	 */
	public MemberPostView(MemberDTO loginInfo) {

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
		topPanel.setBounds(12, 10, 980, 132);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);

		JLabel viewTitle = new JLabel("내 정보 보기");
		viewTitle.setForeground(new Color(70, 70, 70));
		viewTitle.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		viewTitle.setBounds(12, 10, 678, 35);
		topPanel.add(viewTitle);

		JLabel postTitleLabel = new JLabel(loginInfo.getMemName() + "님이 작성하신 게시글 목록");
		postTitleLabel.setForeground(new Color(70, 70, 70));
		postTitleLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 32));
		postTitleLabel.setBounds(12, 76, 678, 50);
		topPanel.add(postTitleLabel);

		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 152, 980, 428);
		bodyPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

		MyPostPanelMaker myPostPanel = new MyPostPanelMaker();
		/* 리스트로 가지러 갈 예정 */
		MemberInfoController memberInfoController = new MemberInfoController();
		List<PostDTO> myPostList = memberInfoController.findMyPostList(loginInfo);

		/* 필요 페이지 수를 알아낸 후 */
		int pageNumber = 0;
		if((myPostList.size() % 5) == 0) {
			pageNumber = myPostList.size() / 5;
		} else {
			pageNumber = (myPostList.size() / 5) + 1;
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
					for (int i = (n * 5 - 5); (n * 5 - 6) < i && i < (n * 5) && i < myPostList.size(); i++) {
						myPostPanel.PanelMaker(loginInfo, bodyPanel, myPostList.get(i));
					}

				}
			});
		}

		for (int i = 0; i < 5; i++) {
			myPostPanel.PanelMaker(loginInfo, bodyPanel, myPostList.get(i));
		}
	}
}
