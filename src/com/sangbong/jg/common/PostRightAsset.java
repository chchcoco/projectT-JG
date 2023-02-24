package com.sangbong.jg.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.sangbong.jg.category.controller.CategoryController;
import com.sangbong.jg.model.dto.CategoryDTO;
import com.sangbong.jg.ui.PostCategory;

public class PostRightAsset {

	/**
	 * <pre>
	 * Class : PostCategory
	 * Comment : 게시글들을 최신 등록순으로 볼 수 있는 전체 페이지를 구현 
	 * History
	 * 2023/02/23 (신예찬) 최초 작성. 우측 카테고리, 로고 등의 에셋을 별도의 클래스로 분리함. 분리한 클래스는 common폴더의 PostRightAsset 클래스에서 메소드 호출시 받아올 수 있음
	 * </pre>
	 * @author 신예찬
	 * @version 1.0.1
	 * @see 
	 * */
public JPanel getCtgPanel() {
		
		JPanel ctgPanel = new JPanel();
		ctgPanel.setBackground(new Color(245, 245, 245));
		ctgPanel.setBounds(0, 0, 248, 681);
//		contentPane.add(ctgPanel);
		ctgPanel.setLayout(null);
		
		JLabel writeReportLabel = new JLabel("신고글 작성하기");
		writeReportLabel.setBounds(24, 630, 200, 28);
		writeReportLabel.setForeground(new Color(255, 0, 0));
		writeReportLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
//		writeReportLabel.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f));
		ctgPanel.add(writeReportLabel);
		

		/*이후 categoryDTO를 */
		List<CategoryDTO> categoryList = new CategoryController().getCategoryList();
		
		String[] sList = new String[categoryList.size()];
		for(int i = 0; i < sList.length; i++) {
			sList[i] = categoryList.get(i).getCategoryName();
		}
		
		JList ctgList = new JList(sList); 
		ctgList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String ctgName = (String) ctgList.getSelectedValue();
				goCtgPostBoard(ctgName);
			}

			
		});
		ctgList.setFont(new Font("굴림", Font.PLAIN, 20));
		ctgList.setVisibleRowCount(10);
		

		JScrollPane scrollPane = new JScrollPane(ctgList);
		
		scrollPane.setBounds(12, 154, 224, 456);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		ctgPanel.add(scrollPane);


		
		JLabel titleLabel = new JLabel("New label");
		titleLabel.setBounds(24, 10, 204, 67);
		titleLabel.setIcon(new ImageIcon("images//title.png"));
		ctgPanel.add(titleLabel);
		
		JLabel viewAllLabel = new JLabel("전체 게시판");
		viewAllLabel.setBounds(27, 111, 200, 33);
		viewAllLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 20));
		
		ctgPanel.add(viewAllLabel);
		
		return ctgPanel;
	}

	/*카테고리 리스트에서 카테고리 클릭시 해당 카테고리의 게시글들을 보여주는 게시판으로 이동하는 메소드*/
	public void goCtgPostBoard(String ctgName) {
		CategoryDTO category = new CategoryController().getOneCategoryByName(ctgName);
		
		new PostCategory(category).setVisible(true);
		
	}
}
