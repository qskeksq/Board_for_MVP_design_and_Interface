package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.ListInterface;

public class BbsList implements ListInterface{

	//리스트에서 출력할 값들
	
	@Override
	public void showId(int id) {
		System.out.print("[ "+id+"번 | ");
	}

	@Override
	public void showTitle(String title) {
		System.out.print(title+" | ");	
	}

	@Override
	public void showAuthor(String author) {
		System.out.print(author+" | ");
	}

	@Override
	public void showView(int view) {
		System.out.println(view+" ]");
	}
	
	public void endShow(){
		System.out.println();
	}
	
}
