# 어서오GO
## 프로젝트 개요
* 회원제 중고 거래 게시판 구현
* backend와 frontend의 기본을 맛보기
* 프로젝트와 협력에 대해 익숙해지기

## 기획과 목적
* 판매희망자가 자신이 팔고자 하는 물건의 관련 정보 (ex. 사진, 상세 정보, 희망 가격) 등을 게시글의 형태로 업로드 하여 홍보할 수 있도록 공간 제공
* 구매희망자가 게시판 열람 중 마음에 드는 물건을 발견하였을 경우 게시글에 기재된 판매자의 e-mail을 통해 연락을 취할 수 있도록 공간을 제공

## 프로젝트의 전체적인 구조
(이벤트스토밍이라거나... DB 논리모델이라거나)
![토이프로젝트_논리데이터2](https://user-images.githubusercontent.com/117333258/222628070-34ef86ed-c98a-4ecc-9d1f-48a2150b958b.png)


## 프로젝트 주요 기능
- DB와의 데이터 요청 및 등록 위주의 기능
    - 게시글/회원 정보 조회, 등록, 갱신, 삭제

## 구현에 사용된 기술
> java 11    
myBatis 3.1
oracle
    


## 겪은 문제와 해결 방법
- 화면 구현시 클래스 분리로 인해 화면 전환시 이전 페이지를 닫는 메서드 dispose()를 제대로 적용시키지 못하는 문제 발생
    >닫아야 하는 창에서 dispose를 실행시켜야 하는데, 페이지 이동이 분리된 별도의 클래스에서 발생하여 생긴 문제      
    멀티 스레드로 다른 페이지 이동시 이전 창에서 이벤트를 받아서 닫아야 하나 하며 시도했으나 역시 제대로 된 구현은 되지 않았다.     
    dispose()가 window의 내장 메소드임을 떠올렸고, 과거 python에서 self 키워드를 통해 자기 자신(클래스)을 매개변수로 전달했던 것을 떠올려서 분리한 클래스를 선언시, 호출한 클래스를 this로 매개변수로 받아 이벤트에서 실행되는 메서드에서 그 창을 닫도록 작성
    - 기존 클래스에서 별도의 클래스로 분리한 클래스의 생성자
    ```
    public PostRightAsset(MemberDTO loginInfo, JFrame page) {

		this.loginInfo = loginInfo;
		this.page = page;
	}
    ```
    - 해당 클래스의 외부 창 호출과 기존 창을 닫는 메소드
    ```
    public void goCtgPostBoard(String ctgName, JFrame page) {

		CategoryDTO category = null;
		if(ctgName != null) {
			category = new CategoryController().getOneCategoryByName(ctgName);
		}

		new PostCategory(loginInfo, category).setVisible(true);
		page.dispose();

	}
    ```
    - 기존 클래스에서 분리한 클래스를 사용하는 모습
    ```
        rightAsset = new PostRightAsset(loginInfo, this);
		JPanel ctgPanel = rightAsset.getCtgPanel();
		contentPane.add(ctgPanel);
    ```


## 이후 추가하고 싶은 기능
* 기획 단계에서는 존재했으나 현재 단계에서는 구현되지 못한/일부 구현되었으나 연결되지 못한 기능들
  - 관리자 기능
    + 관리자로 로그인할 경우 접속하는 전용 랜딩 페이지
    + 회원 정보 목록 조회
    + 신고글 조회 및 처리
    + 신고 3회 누적시 회원 자동 탈퇴 전환 시스템
    + 이미지 다중 첨부 기능 

