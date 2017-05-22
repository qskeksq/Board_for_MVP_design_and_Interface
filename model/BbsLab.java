package com.nadan.java.mybbs.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.nadan.java.mybbs.draft.LabInterface;

public class BbsLab implements LabInterface{
	
	final String DATABASE_DIR = "c:/temp2/mybbs"; //저장할 디렉토리
	final String DATABASE_NAME = "mybbs.db"; //파일명
	final String DATABASE_SEPARATOR = "::"; //내용 구분자
	final String DATABASE_COUNT = "bbscount.db"; //글 번호 저장소
	final String RECORD_SEPERATOR = "\r\n"; //데이터가 줄 단위로 띄어쓰기 되도록 하는 구분자
	boolean APPENDABALE = true; //append 여부 결정.
	
	//새 글 File에 저장하기
	@Override
	public void writer(Bbs bbs) {
		
		//경로 설정
		BbsUtil.makeDir(DATABASE_DIR);
		
		//파일 생성
		File file = BbsUtil.makeFile(DATABASE_DIR + DATABASE_NAME);
		
		//데이터 넣어주기-구분자를 통해 하나하나의 속성값(데이터)를 구분하고, 마지막에 줄 구분자를 넣어서 한줄씩 데이터가 들어가도록 한다.
		String data = bbs.getId()+DATABASE_SEPARATOR + bbs.getTitle()+DATABASE_SEPARATOR
						+ bbs.getAuthor()+DATABASE_SEPARATOR + bbs.getDate()+DATABASE_SEPARATOR
						+ bbs.getContent()+DATABASE_SEPARATOR + bbs.getView() + RECORD_SEPERATOR;
		try {
			//append값에 true를 주어 한줄씩 데이터가 쌓이도록 한다
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
			out.append(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	//File에서 읽어오기
	@Override
	public ArrayList<Bbs> reader() {
		ArrayList<Bbs> readList = new ArrayList<>(); //Bbs 객체를 저장할 임시 공간
		File file = new File(DATABASE_DIR + DATABASE_NAME); //파일 가져오기
		if(file.exists()){ //파일이 존재할 경우 진행
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String temp = "";
				while((temp = br.readLine()) != null){ //읽어올 값이 없을 때까지 계속해서 순환한다.
					Bbs bbs = new Bbs(); //읽어온 값을 Bbs객체에 넣어주고
					String[] bbsTemp = temp.split(DATABASE_SEPARATOR); //split메소드와 구분자를 통해 분리한 값을 배열에 저정한다.
					bbs.setId(Integer.parseInt(bbsTemp[0])); //배열에 저장된 값을 순서대로 꺼내올 수 있다.
					bbs.setTitle(bbsTemp[1]);
					bbs.setAuthor(bbsTemp[2]);
					bbs.setDate(bbsTemp[3]);
					bbs.setContent(bbsTemp[4]);
					bbs.setView(Integer.parseInt(bbsTemp[5]));
					readList.add(bbs);  //마지막으로 리스트에 추가한 후
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return readList; //리스트를 반환한다.
	}

	//삭제한 경우 업데이트 하기
	public void update(ArrayList<Bbs> list){
		Bbs bbs = new Bbs();
		int datas_size = list.size();
		File file = new File(DATABASE_DIR + DATABASE_NAME);
		String data = "";
		if(file.exists()){
			for(int i=0; i<datas_size; i++){
				bbs = list.get(i);
				data += (bbs.getId()+DATABASE_SEPARATOR + bbs.getTitle()+DATABASE_SEPARATOR
						+ bbs.getAuthor()+DATABASE_SEPARATOR + bbs.getDate()+DATABASE_SEPARATOR
						+ bbs.getContent()+DATABASE_SEPARATOR + bbs.getView() + RECORD_SEPERATOR);
			}
			try {
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
				out.write(data);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	//글 번호 저장하기
	//글 번호를 저장하는 방식이 Present에 있는 number 값으로 카운트를 올려가는 방식인데
	//문제는 init으로 초기화할 때 0으로 값이 초기화 된다. 즉, 프로그램을 종료하고 다시 시작하면 글 번호가 0으로 시작한다.
	//이를 위해 글 번호를 따로 저장하는 곳을 만들어 둔다.
	public int count(){
		
		//저장소 불러오기
		BbsUtil.makeDir(DATABASE_DIR);
		
		//파일 만들기
		File file = BbsUtil.makeFile(DATABASE_DIR + DATABASE_COUNT);
		
		//저장될 때마다 count 1씩 올리기
		int result = 0;
		result = BbsUtil.reader(file);
		
		//새로운 저장소에 값 저장하기
		BbsUtil.writer(file, result);
		
		return result;
	}
	
}
