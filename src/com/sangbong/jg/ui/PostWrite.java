package com.sangbong.jg.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * <pre>
 * Class : PostWrite
 * Comment : 게시글 작성 페이지 화면 구현
 * History
 * 2023/02/20 (손동필) 처음 작성함
 * </pre>
 * @author 손동필
 * @version 1.0.0
 * @see 
 * */
public class PostWrite extends JFrame {

	/**
	 * Windowbuilder GUI Plugin을 사용하여 만들어졌다. open with > windowbuilder 선택하여 하단 디자인 탭 참고할 것! 
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostWrite frame = new PostWrite();
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
	public PostWrite() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ctgPanel = new JPanel();
		ctgPanel.setBackground(new Color(245, 245, 245));
		ctgPanel.setBounds(0, 0, 248, 681);
		contentPane.add(ctgPanel);
		ctgPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 154, 224, 517);
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
		topPanel.setBounds(12, 10, 980, 158);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel superCategoryLabel = new JLabel("게시판 글쓰기");
		superCategoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		superCategoryLabel.setForeground(new Color(70, 70, 70));
		superCategoryLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
		superCategoryLabel.setBounds(12, 19, 258, 35);
		topPanel.add(superCategoryLabel);
		
		JLabel profilePic = new JLabel("");
		profilePic.setIcon(new ImageIcon("images/profilePic.png"));
		profilePic.setBounds(924, 10, 44, 44);
		topPanel.add(profilePic);
		
		JButton editButton = new JButton("등록");
		editButton.setBounds(848, 10, 120, 72);
		topPanel.add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editButton.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		editButton.setForeground(new Color(70, 70, 70));
		editButton.setBackground(new Color(212, 212, 212));
		
		textField = new JTextField();
		textField.setBounds(12, 113, 956, 35);
		topPanel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"카테고리"}));
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
		textContext.setText("상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context 상세 내용 Context ");
		textContext.setLineWrap(true);
		textContext.setBounds(12, 10, 948, 287);
		bodyPanel.add(textContext);
		
		JButton btnNewButton_2_3 = new JButton("image");
		btnNewButton_2_3.setBounds(12, 353, 180, 130);
		bodyPanel.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_3_1 = new JButton("image");
		btnNewButton_2_3_1.setBounds(204, 353, 180, 130);
		bodyPanel.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_3_1_1 = new JButton("image");
		btnNewButton_2_3_1_1.setBounds(396, 353, 180, 130);
		bodyPanel.add(btnNewButton_2_3_1_1);
		
		JButton btnNewButton_2_3_1_2 = new JButton("image");
		btnNewButton_2_3_1_2.setBounds(588, 353, 180, 130);
		bodyPanel.add(btnNewButton_2_3_1_2);
		
		JButton btnNewButton_2_3_1_3 = new JButton("image");
		btnNewButton_2_3_1_3.setBounds(780, 353, 180, 130);
		bodyPanel.add(btnNewButton_2_3_1_3);
		
		textField_1 = new JTextField();
		textField_1.setText("가격");
		textField_1.setBounds(12, 308, 370, 37);
		bodyPanel.add(textField_1);
		textField_1.setColumns(10);
	}
}