package com.sangbong.jg.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.sangbong.jg.model.dto.MemberDTO;
import com.sangbong.jg.model.dto.ReportDTO;

public class ReportPanelMaker {

	public void PanelMaker(MemberDTO loginInfo, JPanel bodyPanel, ReportDTO report) {
		
		JPanel reportPanel = new JPanel();
		reportPanel.setSize(956, 84);
		bodyPanel.add(reportPanel);
		reportPanel.setLayout(null);
		
		JLabel reportReasonLabel = new JLabel("신고 사유 : " + report.getReportReason());
		reportReasonLabel.setBounds(10, 42, 436, 16);
		reportPanel.add(reportReasonLabel);
		reportReasonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reportReasonLabel.setForeground(new Color(70, 70, 70));
		reportReasonLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		
		JLabel reportTitleLabel = new JLabel();
		String reportTitle = report.getReportCode();
		switch(report.getReportApproval()) {
		case 'Y':
			reportTitle += (" [승인]");
			break;
		case 'N':
			reportTitle += (" [거절]");
			break;
		case '-':
			reportTitle += (" [보류]");
			break;
		}
		reportTitleLabel.setText(reportTitle);
		reportTitleLabel.setForeground(new Color(70, 70, 70));
		reportTitleLabel.setFont(new Font("나눔스퀘어 네오 Bold", Font.PLAIN, 18));
		reportTitleLabel.setBounds(0, 0, 446, 35);
		reportPanel.add(reportTitleLabel);
		
		JButton btnNewButton = new JButton("이미지");
		btnNewButton.setBounds(872, 0, 84, 84);
		reportPanel.add(btnNewButton);
		
		JLabel reportedEmailLabel = new JLabel("신고 대상 : " + report.getReportedEmail());
		reportedEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		reportedEmailLabel.setForeground(new Color(70, 70, 70));
		reportedEmailLabel.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 14));
		reportedEmailLabel.setBounds(10, 68, 436, 16);
		reportPanel.add(reportedEmailLabel);
		
		JTextArea textContext = new JTextArea();
		textContext.setBounds(448, 10, 412, 64);
		reportPanel.add(textContext);
		textContext.setForeground(new Color(70, 70, 70));
		textContext.setFont(new Font("나눔스퀘어 네오 Regular", Font.PLAIN, 14));
		textContext.setText(report.getRepostContext());
		textContext.setLineWrap(true);
		textContext.setEditable(false);
		
		reportPanel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				new ReportOnePage(loginInfo, report).setVisible(true);
			}
		});
	}
}
