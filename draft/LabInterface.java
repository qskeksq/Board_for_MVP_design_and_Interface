package com.nadan.java.mybbs.draft;

import java.util.ArrayList;

import com.nadan.java.mybbs.model.Bbs;


public interface LabInterface {
	
	public ArrayList<Bbs> reader(); // files���� �о ����Ʈ�� ���� �� ����
	
	public void writer(Bbs bbs); // Bbs ��ü�� �޾� �����ؼ� files�� �ִ´�
	
	public void update(ArrayList<Bbs> list);  //���� �� ������ �����͸� �޾Ƽ� ������Ʈ
	
}
