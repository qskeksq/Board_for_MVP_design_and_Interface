package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.InputInterface;

public class BbsInput implements InputInterface{

	//�Է��� �� �ʿ��� ������ �Է¹޴´�
	
	public void inputTitle() {
		System.out.print("���� : ");	
	}

	public void inputAuthor() {
		System.out.print("�ۼ��� : ");	
	}

	public void inputContent() {
		System.out.print("���� : ");
	}
	
	public void endInput(){
		System.out.println("<<<�Է� �Ϸ�>>>");
		System.out.println();
	}

}
