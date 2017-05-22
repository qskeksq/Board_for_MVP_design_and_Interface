package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.DetailInterface;

public class BbsDetail implements DetailInterface{

	//상세보기에서는 모든 속성값(데이터)를 불러와 보여준다
	
	public void num(){
		System.out.print("글 번호>");
	}

	@Override
	public void showId(int id) {
		System.out.println("번호 : "+id);
	}

	@Override
	public void showTitle(String title) {
		System.out.println("제목 : "+title);
	}

	@Override
	public void showAuthor(String author) {
		System.out.println("작성자 : "+author);
	}

	@Override
	public void showDate(String date) {
		System.out.println("작성일 : "+date);
	}

	@Override
	public void showContent(String content) {
		System.out.println("내용 : "+content);
	}

	@Override
	public void showView(int view) {
		System.out.println("조회수 : "+view);
		System.out.println();
	}

}
