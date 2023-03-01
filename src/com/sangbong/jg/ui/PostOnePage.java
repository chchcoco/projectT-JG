package com.sangbong.jg.ui;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.img.controller.ImgController;
import com.sangbong.jg.member.controller.MemberInfoController;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.ImgDTO;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;

/**
 * <pre>
 * Class : PostOnePage
 * Comment : 회원이 자기 자신의 글을 조회하는 화면 UI를 구현한다. 
 * History
 * 2023/02/16 (김유현) 처음 작성함
 * 2023/02/17 (김유현) 프로젝트 내부의 폰트, 이미지 파일과 연결
 * 2023/02/26 (손동필, 신예찬) 수정, 삭제시 본인이 작성한 글이 아니면 수정/삭제 할 수 없게 if문 추가
 * 2023/02/27 (신예찬) 이미지 불러오기 기능 추가
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
	private PostDTO postDTO;
	private MemberDTO loginInfo;
	private PostRightAsset rightAsset;
	private JLabel imgLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PostOnePage frame = new PostOnePage(null, null);
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
	public PostOnePage(MemberDTO loginInfo, PostDTO postDTO) {
		
		this.postDTO = postDTO;
		this.loginInfo = loginInfo;
		List<ImgDTO> imgList = new ImgController().getAllImgByPost(postDTO);
		
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
		
		CategoryDTO ctgDTO = new CategoryController().getOneCategoryByCode(postDTO.getCategoryCode());
		JLabel categoryLabel = new JLabel(ctgDTO.getCategoryName());
		categoryLabel.setForeground(new Color(70, 70, 70));
		categoryLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 18f));
		categoryLabel.setBounds(12, 10, 678, 35);
		topPanel.add(categoryLabel);
		
		JButton deleteButton = new JButton("삭제");
		deleteButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(loginInfo.getEmail().equals(postDTO.getWriter())) {
					new PostDelete(loginInfo, postDTO).setVisible(true);
					dispose();

				}  else {

					JOptionPane.showMessageDialog(null, "회원님이 작성한 글이 아닙니다.",
							"삭제할 권한이 없습니다.", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		deleteButton.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		deleteButton.setForeground(new Color(70, 70, 70));
		deleteButton.setBackground(new Color(241, 87, 87));
		deleteButton.setBounds(848, 76, 120, 72);
		topPanel.add(deleteButton);
		
		JButton editButton = new JButton("수정");
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(loginInfo.getEmail().equals(postDTO.getWriter())) {
					new PostEdit(loginInfo, postDTO).setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원님이 작성한 글이 아닙니다.",
							"수정할 권한이 없습니다.", JOptionPane.DEFAULT_OPTION);
				}

			}
		});
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editButton.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		editButton.setForeground(new Color(70, 70, 70));
		editButton.setBackground(new Color(212, 212, 212));
		editButton.setBounds(716, 76, 120, 72);
		topPanel.add(editButton);
		
		JLabel postTitleLabel = new JLabel(postDTO.getItemName());
		postTitleLabel.setForeground(new Color(70, 70, 70));
		postTitleLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 32f));
		postTitleLabel.setBounds(12, 76, 678, 50);
		topPanel.add(postTitleLabel);
		
		JLabel dateLabel = new JLabel(new StringBuilder().append(postDTO.getPostDate()).toString());
		dateLabel.setForeground(new Color(70, 70, 70));
		dateLabel.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 14f));
		dateLabel.setBounds(12, 128, 250, 20);
		topPanel.add(dateLabel);
		
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
		
		JLabel myName = new JLabel(loginInfo.getMemName());
		myName.setHorizontalAlignment(SwingConstants.RIGHT);
		myName.setForeground(new Color(70, 70, 70));
		myName.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 16f));
		myName.setBounds(784, 25, 128, 20);
		topPanel.add(myName);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(12, 178, 980, 493);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JLabel priceLabel = new JLabel(new StringBuilder().append(postDTO.getPrice()).toString());

		priceLabel.setForeground(new Color(70, 70, 70));
		priceLabel.setFont(notoSansRegular("Black").deriveFont(Font.PLAIN, 40f));
		priceLabel.setBounds(467, 10, 501, 50);
		bodyPanel.add(priceLabel);
		
		JLabel authorEmailLabel = new JLabel(postDTO.getWriter());
		authorEmailLabel.setForeground(new Color(70, 70, 70));
		authorEmailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorEmailLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 14f));
		authorEmailLabel.setBounds(467, 84, 501, 25);
		bodyPanel.add(authorEmailLabel);
		
		JTextArea textContext = new JTextArea();
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 15f));
		textContext.setText(postDTO.getPostContext());
		textContext.setLineWrap(true);
		textContext.setBounds(467, 116, 501, 287);
		bodyPanel.add(textContext);
		
		/*==============================================================================================================================*/
		System.out.println("준비");
		
		imgLabel = new JLabel("image");
		if(imgList != null && imgList.size() > 0) {
			System.out.println("이미지 넣기");
			ImageIcon icon = new ImageIcon(imgList.get(0).getImgUrl());
			Image img = icon.getImage();
			icon = new ImageIcon(img.getScaledInstance(390, 390, Image.SCALE_SMOOTH));
			imgLabel = new JLabel(icon);
			
		}
		System.out.println("끝");
		imgLabel.setBackground(new Color(255, 255, 255));
		imgLabel.setForeground(new Color(0, 0, 0));
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setBounds(12, 10, 394, 394);
		bodyPanel.add(imgLabel);
		
	}
	
	public JLabel inputLabel(JLabel imgLabel, ImgDTO img) {
		
		System.out.println("이미지 넣기");
		ImageIcon icon = new ImageIcon(img.getImgUrl());
		Image image = icon.getImage();
		icon = new ImageIcon(image.getScaledInstance(390, 390, Image.SCALE_SMOOTH));
		imgLabel = new JLabel(icon);
			
		return imgLabel;
	}
}


