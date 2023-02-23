package com.sangbong.jg.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.common.PostListReturn;
import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.model.dto.PostDTO;

/**
 * <pre>
 * Class : PostCategory
 * Comment : 게시글들을 최신 등록순으로 볼 수 있는 전체 페이지를 구현 
 * History
 * 2023/02/18 (신예찬) 처음 작성함
 * 2023/02/23 (신예찬) 우측 카테고리, 로고 등의 에셋을 별도의 클래스로 분리함. 분리한 클래스는 common폴더의 PostRightAsset 클래스에서 메소드 호출시 받아올 수 있음
 * 					 Post 요청시 해당 카테고리에 맞는 게시글들을 12개 가져와 Panel에 추가하는 메소드 구현 및 클래스 분리. common폴더의 PostListReturn 클래스
 * </pre>
 * @author 신예찬
 * @version 1.0.1
 * @see 
 * */
public class PostCategory extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;
	private PostRightAsset rightAsset;
	private PostListReturn postListReturn;
	private String categoryName;
	private List<PostDTO> postList;
	private int page = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostCategory frame = new PostCategory();
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
	public PostCategory() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* 우측의 카테고리를 출력하는 메소드. */
		rightAsset = new PostRightAsset();
		JPanel ctgPanel = rightAsset.getCtgPanel();
		contentPane.add(ctgPanel);

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
		
		JButton memberInfoButton = new JButton("회원정보");
		memberInfoButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
//				new MemberInfoView(member).setVisible(true);
				
				dispose();
			}
		});
		
		memberInfoButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		memberInfoButton.setForeground(new Color(70, 70, 70));
		memberInfoButton.setBackground(new Color(0, 255, 128));
		memberInfoButton.setBounds(848, 10, 120, 72);
		topPanel.add(memberInfoButton);
		
		JButton writeButton = new JButton("글쓰기");
		writeButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				new PostWrite().setVisible(true);
				dispose();
			}
		});
		writeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		writeButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		writeButton.setForeground(new Color(70, 70, 70));
		writeButton.setBackground(new Color(212, 212, 212));
		writeButton.setBounds(716, 10, 120, 72);
		topPanel.add(writeButton);
		
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
		postListReturn = new PostListReturn();
		
		if(this.categoryName == null) {
			postList = postListReturn.getAllPost();
		} else {
			postList = postListReturn.getCtgPost(categoryName);
		}
		
		List<JPanel> postPanel = new ArrayList<>();
		for(int i = 0 + 12*page; i < 12*(page+1); i++) {
			if(i>=postList.size()) {
				break;
			}
			postPanel.add(postListReturn.getPost(postList.get(i)));
		}
		
		postListReturn.locatePostList(postPanel, bodyPanel);
//		bodyPanel.add(postListReturn.getPost());
//
//		
//
//		/* 여기 아래부터는 UI상으로 보여주기 위한 post들.
//		 * 구현단계에서 사라질 내용들이다.
//		 * */


		/* 여기까지 화면상으로 보여주기 위한 Post들.
		 * 추후 for문으로 List<PostDTO>를 받아와서
		 * 12개의 post를 mainPanel에 등록할 예정
		 * */
		
	}
	
	public void goPost(PostDTO postInfo) {
		// 게시글 상세조회 페이지로 이동
		new PostOnePage().setVisible(true);
		this.dispose();
	}


}