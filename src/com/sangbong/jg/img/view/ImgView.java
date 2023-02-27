package com.sangbong.jg.img.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.sangbong.jg.model.dto.ImgDTO;
import com.sangbong.jg.model.dto.PostDTO;

public class ImgView {

	public static void main(String[] args) {
		/* 이미지를 저장하는 코드 */
		JFileChooser ch = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		ch.setFileFilter(new FileNameExtensionFilter("img file", "jpg", "jpeg", "png"));
		ch.setDialogTitle("사진 등록");
		ch.setMultiSelectionEnabled(false);
		ch.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = ch.showOpenDialog(null);
		String img = null;
		boolean canSave = false;
		if (result == JFileChooser.APPROVE_OPTION) {
			img = ch.getSelectedFile().toString();
			canSave = true;
		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("취소쓰");
			img = "";
		}

//		System.out.println(img == null ? "null" : img);

		
		/* 파일 주소를 받아와 images 폴더에 저장하는 코드 */
		String extension = null;
		extension =  img.substring(img.indexOf('.')+1);
		if (canSave) {
//			System.out.println(1);
			try {
				BufferedImage image = ImageIO.read(new File(img));
				
				File imgFile = new File("images//"+img.substring(img.lastIndexOf("\\")));
//				System.out.println("images//"+img.substring(img.lastIndexOf("\\")));
				
				ImageIO.write(image, extension, imgFile);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("저장완료");

		}
	}


	public void saveImg() {

	}

	public String getImgUrl() {
		// TODO Auto-generated method stub
		JFileChooser ch = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		ch.setFileFilter(new FileNameExtensionFilter("img file", "jpg", "jpeg", "png"));
		ch.setDialogTitle("사진 등록");
		ch.setMultiSelectionEnabled(false);
		ch.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = ch.showOpenDialog(null);
		String img = null;
		boolean canSave = false;
		if (result == JFileChooser.APPROVE_OPTION) {
			img = ch.getSelectedFile().toString();
			canSave = true;
		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("취소쓰");
			img = null;
		}

		return img;
	}
}
