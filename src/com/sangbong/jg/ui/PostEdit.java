package com.sangbong.jg.ui;

import static com.sangbong.jg.common.SetFont.notoSansRegular;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.common.PostRightAsset;
import com.sangbong.jg.img.controller.ImgController;
import com.sangbong.jg.img.view.ImgView;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.model.dto.ImgDTO;
import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.PostDTO;
import com.sangbong.jg.post.controller.PostEditController;

/**
 * <pre>
 * Class : PostEdit
 * Comment : 게시글 수정 페이지 화면 구현
 * History
 * 2023/02/20 (손동필) 처음 작성함
 * 2023/02/26 (신예찬) 이미지 등록 기능 추가
 * </pre>
 * 
 * @author 손동필
 * @version 1.0.0
 * @see
 */
public class PostEdit extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭
	 * 참고할 것!
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private MemberDTO email;
	private PostDTO postInfo;
	private PostRightAsset rightAsset;
	private List<String> imgUrlList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostEdit frame = new PostEdit(null, null);
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
	public PostEdit(MemberDTO loginInfo, PostDTO postInfo) {
		this.email = loginInfo;
		this.postInfo = postInfo;

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

		JLabel superCategoryLabel = new JLabel("게시판 글쓰기");
		superCategoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 40f));
		superCategoryLabel.setBounds(12, 19, 258, 35);
		topPanel.add(superCategoryLabel);

		textField = new JTextField();
		textField.setText(postInfo.getItemName());
		textField.setBounds(12, 113, 956, 35);
		topPanel.add(textField);
		textField.setColumns(10);

		int index = 0;
		List<CategoryDTO> categoryList = new CategoryController().getCategoryList();

		String[] sList = new String[categoryList.size()];

		for (int i = 0; i < sList.length; i++) {
			if (categoryList.get(i).getCategoryCode().equals(postInfo.getCategoryCode())) {

				index = i;
			}
			sList[i] = categoryList.get(i).getCategoryName();
		}


		JComboBox comboBox = new JComboBox(sList);

		comboBox.setSelectedIndex(index);
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {" 등록된 카테고리"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(12, 83, 139, 23);
		topPanel.add(comboBox);

		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(245, 245, 245));
		bodyPanel.setBounds(22, 178, 980, 493);
		mainPanel.add(bodyPanel);
		bodyPanel.setLayout(null);

		JTextArea textContext = new JTextArea();
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textContext.setFont(notoSansRegular("Regular").deriveFont(Font.PLAIN, 15f));
		textContext.setText(postInfo.getPostContext());
		textContext.setLineWrap(true);
		textContext.setBounds(12, 10, 948, 388);
		bodyPanel.add(textContext);

		/*img의 url을 저장하는 list*/
		JButton btnNewButton_2_3 = new JButton("등록한 이미지 유지");
		btnNewButton_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String imgUrl = new ImgView().getImgUrl();
				if (imgUrl != null ? true : false) {
					if(imgUrlList.size() > 0) {
						imgUrlList.set(0, imgUrl);
					} else {
						imgUrlList.add(imgUrl);
					}
				}
			}
		});
		btnNewButton_2_3.setBounds(780, 432, 180, 37);
		bodyPanel.add(btnNewButton_2_3);

		/* 게시글에 저장된 이미지가 있다면 불러오는 코드*/
		List<ImgDTO> imgList = new ImgController().getAllImgByPost(postInfo);
		if (imgList != null) {
			for (int i = 0; i < imgList.size(); i++) {
					btnNewButton_2_3.setIcon(new ImageIcon(imgList.get(i).getImgUrl()));
				}
			}
		

		textField_1 = new JTextField();
		textField_1.setText(postInfo.getPrice() + "");
		textField_1.setBounds(12, 432, 370, 37);
		bodyPanel.add(textField_1);
		textField_1.setColumns(10);

		JButton editButton = new JButton("저장");
		editButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				PostDTO resultPost = new PostEditController().EditPost(comboBox.getSelectedItem().toString(),
						textField_1.getText(), textField.getText(), textContext.getText(), postInfo);
				boolean isImgUpload = new ImgController().insertImgPost(imgUrlList, postInfo);
				boolean result = (resultPost != null)&& isImgUpload ? true : false;

				/**/
				if (result) {
					JOptionPane.showMessageDialog(null, "수정완료");
					new PostOnePage(email, resultPost).setVisible(true);
					dispose();
				} else {
					/* 변경사항이 없을경우 저장 버튼을 비활성화 처리 */
				}

			}
		});
		editButton.setBounds(848, 10, 120, 72);
		topPanel.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editButton.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		editButton.setForeground(new Color(70, 70, 70));
		editButton.setBackground(new Color(212, 212, 212));
	}
}