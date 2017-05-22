package com.nadan.java.mybbs.draft;

public interface PresentInterface {
	
	//전체 프로그램을 운영하기 위해서, 혹은 View와 Model을 관리하기 위한 메소드.
	public void start();  // 프로그램을 시작할 메소드
	public void end();  // 프로그램 종료 메소드
	
	public void showDetail(); // 상세 항목 메소드
	public void showList(); // 목록 메소드
	public void newArticle(); // 입력 메소드
	public void delete(); //삭제 메소드

}
