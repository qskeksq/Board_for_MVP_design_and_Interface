package com.nadan.java.mybbs.draft;

public interface PresentInterface {
	
	//��ü ���α׷��� ��ϱ� ���ؼ�, Ȥ�� View�� Model�� �����ϱ� ���� �޼ҵ�.
	public void start();  // ���α׷��� ������ �޼ҵ�
	public void end();  // ���α׷� ���� �޼ҵ�
	
	public void showDetail(); // �� �׸� �޼ҵ�
	public void showList(); // ��� �޼ҵ�
	public void newArticle(); // �Է� �޼ҵ�
	public void delete(); //���� �޼ҵ�

}
