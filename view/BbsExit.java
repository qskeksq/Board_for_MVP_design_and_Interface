package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.ExitInterface;

public class BbsExit implements ExitInterface {

	@Override
	public void info() {
		System.out.println("���α׷��� �����Ͻðڽ��ϱ�? [ y:�� | n:�ƴϿ� ]");
	}
	
	
	public void cancel(){
		System.out.println("<<<���� ���>>>");
		System.out.println();
	}
	
	public void complete(){
		System.out.println("<<<���α׷� ����>>>");
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
