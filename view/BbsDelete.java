package com.nadan.java.mybbs.view;

import com.nadan.java.mybbs.draft.DeleteInterface;

//ȭ�鿡 ����ϴ� ��� ������ View�� ��´�. �� �ϳ��� System.out.println�� Presenter�� �ڵ����� �ʵ��� �Ѵ�.
public class BbsDelete implements DeleteInterface {

	public void num(){
		System.out.print("�� ��ȣ>");
	}
	
	@Override
	public void info() {
		System.out.println("�����Ͻðڽ��ϱ�? [ y:�� | n:�ƴϿ� ]");
	}
	
	public void cancel(){
		System.out.println("<<<���� ���>>>");
		System.out.println();
	}
	
	public void complete(){
		System.out.println("<<<���� �Ϸ�>>>");
		System.out.println();
	}
	
}
