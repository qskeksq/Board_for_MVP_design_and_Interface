package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.ExitInterface;

public class BbsExit implements ExitInterface {

	@Override
	public void info() {
		System.out.println("프로그램을 종료하시겠습니까? [ y:네 | n:아니오 ]");
	}
	
	
	public void cancel(){
		System.out.println("<<<종료 취소>>>");
		System.out.println();
	}
	
	public void complete(){
		System.out.println("<<<프로그램 종료>>>");
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
