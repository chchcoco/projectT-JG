package com.sangbong.jg.common;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
* <pre>
* Class : SetFont
* Comment : 사용자마다 달라질 수 있는 기기 내 설치된 폰트 리스트 대신 
* 			프로젝트 파일 내 첨부된 폰트 파일을 (.ttf 혹은 .otf)
* 			이용하기 위해 만들어진 클래스
* 
* 			해당 클래스와 포함 메소드를 사용하여 적용할 경우 결과가
* 			WindowBuilder의 design 탭에 곧바로 보이지는 않으나
* 			compile 하면 확인할 수 있다.
* 
* 			[사용 예시]
* 			label.setFont(notoSansRegular("Bold").deriveFont(Font.PLAIN, 20f)); 
* History
* 2023/02/17 (김유현) 첫 작성
* </pre>
* @version 1
* @author 김유현
* @see 
*
*/
public class SetFont {

	/**
	 * Noto_Sans_KR 폰트의 폰트 패밀리 중 원하는 폰트 (.otf)를 불러와 적용할 수 있는 메소드
	 * @param style 글자의 스타일 (ex. Bold, Regular 등등) 을 스트링으로 받아 폰트의 파일명을 완성시킨다.
	 * @return 지정된 파일명을 가진 폰트를 Font 클래스의 새 객체로 생성해 반환한다.
	 * @exception FileInputStream에 예외처리가 발생하여 try-catch 구문으로 감싸주었다.
	 */
	public static Font notoSansRegular(String style) {
		
		String fontPath = "font/Noto_Sans_KR/NotoSansKR-" + style + ".otf";
		Font font = null;
		
		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(fontPath));
			font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return font;
	}
	
}
