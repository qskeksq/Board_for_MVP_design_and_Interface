package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.DetailInterface;

public class BbsDetail implements DetailInterface{

	//�󼼺��⿡���� ��� �Ӽ���(������)�� �ҷ��� �����ش�
	
	public void num(){
		System.out.print("�� ��ȣ>");
	}

	@Override
	public void showId(int id) {
		System.out.println("��ȣ : "+id);
	}

	@Override
	public void showTitle(String title) {
		System.out.println("���� : "+title);
	}

	@Override
	public void showAuthor(String author) {
		System.out.println("�ۼ��� : "+author);
	}

	@Override
	public void showDate(String date) {
		System.out.println("�ۼ��� : "+date);
	}

	@Override
	public void showContent(String content) {
		System.out.println("���� : "+content);
	}

	@Override
	public void showView(int view) {
		System.out.println("��ȸ�� : "+view);
		System.out.println();
	}

}
