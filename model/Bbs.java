package com.nadan.java.mybbs.model;

//�����͸� ��Ƴ��� �� Ŭ����
public class Bbs {
	
	//�ϳ��� �Խñۿ� �ʿ��� �����͵�. ĸ��ȭ�� ���� �����͸� ��ȣ�Ѵ�.
	private int id;
	private String title;
	private String author;
	private String date;
	private String content;
	private int view;
	
	//getter�� setter�� ���� ���� �־��ְ� �ҷ��´�.
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
