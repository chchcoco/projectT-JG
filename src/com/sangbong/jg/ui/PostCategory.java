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

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.common.PostListReturn;
import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.run.Application;


/**
 * <pre>
 * Class : PostCategory
 * Comment : 게시글들을 최신 등록순으로 볼 수 있는 전체 페이지를 구현 
 * History
 * 2023/02/18 (신예찬) 처음 작성함
 * 2023/02/23 (신예찬) 우측 카테고리, 로고 등의 에셋을 별도의 클래스로 분리함. 분리한 클래스는 common폴더의 PostRightAsset 클래스에서 메소드 호출시 받아올 수 있음
 * 					 Post 요청시 해당 카테고리에 맞는 게시글들을 12개 가져와 Panel에 추가하는 메소드 구현 및 클래스 분리. common폴더의 PostListReturn 클래스
 * 2023/02/25 (신예찬) 카테고리 조회시, 상위 카테고리가 코드로 출력되는 부분 수정
 * </pre>
 * @author 신예찬
 * @version 1.0.3
 * @see 
 * */
public class PostCategory extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;
	private PostRightAsset rightAsset;
	private PostListReturn postListReturn;
	private CategoryDTO category;
	private List<PostDTO> postList;
	private int page = 0;
	private MemberDTO loginInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostCategory frame = new PostCategory(null, null);
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
	public PostCategory(MemberDTO loginInfo, CategoryDTO category) {
		
		this.loginInfo = loginInfo;
		this.category = category;
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* 우측의 카테고리를 출력하는 메소드. */
		rightAsset = new PostRightAsset(loginInfo);
		JPanel ctgPanel = rightAsset.getCtgPanel(this);
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
		
		/*카테고리 라벨에 등록*/
//		CategoryDTO ctgDTO = null;
//		if(category != null) {
//			ctgDTO = new CategoryController().getOneCategoryByCode(category.getSuperCategory());
//		}
		JLabel categoryLabel = new JLabel(category == null ? "전체게시글" : category.getCategoryName());
		categoryLabel.setForeground(new Color(70, 70, 70));
		categoryLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		categoryLabel.setBounds(12, 10, 678, 35);
		topPanel.add(categoryLabel);
		
		JButton memberInfoButton = new JButton("회원정보");
		memberInfoButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				new MemberInfoView(loginInfo).setVisible(true);
				
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
				 
				new PostWrite(loginInfo).setVisible(true);
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
		
//		JLabel juniorCategoryLabel = new JLabel(category == null ? "전체게시글" : category.getCategoryName());
//		juniorCategoryLabel.setForeground(new Color(70, 70, 70));
//		juniorCategoryLabel.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
//		juniorCategoryLabel.setBounds(12, 46, 678, 20);
//		topPanel.add(juniorCategoryLabel);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 112, 980, 559);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		
		/* 게시글을 추가하는 메소드 */
		postListReturn = new PostListReturn(loginInfo, this);
		
		if(this.category == null) {
			postList = postListReturn.getAllPost();
		} else {
			postList = postListReturn.getCtgPost(category);
		}
		
		List<JPanel> postPanel = new ArrayList<>();
		for(int i = 0 + 12*page; i < 12*(page+1); i++) {
			if(i>=postList.size()) {
				break;
			}
			postPanel.add(postListReturn.getPost(postList.get(i)));
		}
		
		postListReturn.locatePostList(postPanel, bodyPanel);

//		System.out.println(Application.shutdown);
//		Thread thread = new Thread(this);
//		thread.start();

	}
	
	
	public PostCategory(MemberDTO loginInfo) {
		this(loginInfo, null);
	}

	
	public PostCategory() {
		this(null);
	}
	
//	public void run() {
//		while(true) {
//			if(Application.shutdown == 1) {
//				System.out.println("스레드");
//				Application.shutdown = 0;
//				dispose();
//			}
//		}
//	}

	
	/* 해당 기능 PostListReturn클래스로 다시 옮김 */
//	public void goPost(MemberDTO loginInfo, PostDTO postInfo) {
//		// 게시글 상세조회 페이지로 이동
//		new PostOnePage(loginInfo, postInfo).setVisible(true);
//		disposePage(this);
//	}
	
//	private void disposePage(JFrame page) {
//		page.dispose();
//	}


}