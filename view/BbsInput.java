package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.InputInterface;

public class BbsInput implements InputInterface{

	//입력할 때 필요한 값들을 입력받는다
	
	public void inputTitle() {
		System.out.print("제목 : ");	
	}

	public void inputAuthor() {
		System.out.print("작성자 : ");	
	}

	public void inputContent() {
		System.out.print("내용 : ");
	}
	
	public void endInput(){
		System.out.println("<<<입력 완료>>>");
		System.out.println();
	}

}
