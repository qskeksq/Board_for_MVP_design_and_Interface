package com.nadan.java.mybbs.draft;

public interface DetailInterface {
	
	//글의 상세한 속성을 알려준다.
	public void showId(int id);
	public void showTitle(String title);
	public void showAuthor(String author);
	public void showDate(String date);
	public void showContent(String content);
	public void showView(int view);

}
