package com.nadan.java.mybbs.model;

//데이터를 모아놓은 모델 클래스
public class Bbs {
	
	//하나의 게시글에 필요한 데이터들. 캡슐화를 통해 데이터를 보호한다.
	private int id;
	private String title;
	private String author;
	private String date;
	private String content;
	private int view;
	
	//getter와 setter를 통해 값을 넣어주고 불러온다.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	

}
