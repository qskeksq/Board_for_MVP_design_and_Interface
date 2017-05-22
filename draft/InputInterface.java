package com.nadan.java.mybbs.draft;

public interface InputInterface {
	
	/**
	*설계 잘못함. 여기는 입력 받는 곳이기 때문에 인자가 필요 없다 
	*public void inputTitle(String title);
	*public void inputAuthor(String author);
	*public void inputContent(String content);
	*
	**/

	//어떤 값을 입력받을 것일지 묻는다.
	public void inputTitle();
	public void inputAuthor();
	public void inputContent();
	
}
