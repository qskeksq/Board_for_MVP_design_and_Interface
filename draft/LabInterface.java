package com.nadan.java.mybbs.draft;

import java.util.ArrayList;

import com.nadan.java.mybbs.model.Bbs;


public interface LabInterface {
	
	public ArrayList<Bbs> reader(); // files에서 읽어서 리스트에 넣은 후 리턴
	
	public void writer(Bbs bbs); // Bbs 객체를 받아 분해해서 files에 넣는다
	
	public void update(ArrayList<Bbs> list);  //삭제 후 삭제된 데이터를 받아서 업데이트
	
}
