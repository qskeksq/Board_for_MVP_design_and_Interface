package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.DeleteInterface;

//화면에 출력하는 모든 내용은 View에 담는다. 단 하나의 System.out.println도 Presenter에 코딩되지 않도록 한다.
public class BbsDelete implements DeleteInterface {

	public void num(){
		System.out.print("글 번호>");
	}
	
	@Override
	public void info() {
		System.out.println("삭제하시겠습니까? [ y:네 | n:아니오 ]");
	}
	
	public void cancel(){
		System.out.println("<<<삭제 취소>>>");
		System.out.println();
	}
	
	public void complete(){
		System.out.println("<<<삭제 완료>>>");
		System.out.println();
	}
	
}
