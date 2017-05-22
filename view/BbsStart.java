package com.nadan.java.mybbs.view;

public class BbsStart {
	
	//시작할 때 첫 화면
	public void intro(){
		System.out.println("----------------------------------------------------");
		System.out.println("명령어를 입력하세요[l:목록 | w:새 글 | r:상세보기 | d:삭제  | e:종료]");
		System.out.println("----------------------------------------------------");
	}
	
	//어떤 값을 입력받을지 결정
	public void num(){
		System.out.print("입력>");
	}

}
