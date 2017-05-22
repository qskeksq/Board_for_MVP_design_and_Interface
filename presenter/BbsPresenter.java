package com.nadan.java.mybbs.presenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.nadan.java.mybbs.draft.PresentInterface;
import com.nadan.java.mybbs.model.Bbs;
import com.nadan.java.mybbs.model.BbsLab;
import com.nadan.java.mybbs.view.BbsDelete;
import com.nadan.java.mybbs.view.BbsDetail;
import com.nadan.java.mybbs.view.BbsExit;
import com.nadan.java.mybbs.view.BbsInput;
import com.nadan.java.mybbs.view.BbsList;
import com.nadan.java.mybbs.view.BbsStart;

public class BbsPresenter implements PresentInterface {
	
	//프로그램이 계속 진행될 것인지 boolean 값으로 통제한다.
	final boolean START = true;
	final boolean END = false;
	boolean run = START;
	
	//전역변수로 선언함으로써 클래스 내부 모든 곳에서 사용할 수 있고, 최신 데이터를 유지할 수 있다.
	Scanner scanner;
	BbsStart start;
	ArrayList<Bbs> datas;  //Bbs객체의 임시 저장소이자, 가장 최신의 정보가 저장되는 곳
	BbsList list;
	BbsInput newArticle;
	int viewCount;
	BbsDetail detail;
	BbsDelete delete;
	BbsExit end;
	BbsLab lab;
	
	//초기화 메소드-초기화를 메소드에 함으로써 함수간 독립성을 높인다.
	public void init(){
		start = new BbsStart();
		scanner = new Scanner(System.in);
		datas = new ArrayList<>();
		list = new BbsList();
		newArticle = new BbsInput();
		viewCount = 0;
		detail = new BbsDetail();
		delete = new BbsDelete();
		end = new BbsExit();
		lab = new BbsLab();
	}
	
	//메소드는 호출하지 않으면 작동하지 않는다. 시작할 때 자동으로 시작하도록 해 주려면 생성자에 
	public BbsPresenter(){
		init();
	}
	
	//프로그램 시작
	@Override
	public void start() {
		while(run){
			start.intro(); //첫 화면 View
			start.num(); //입력 번호
			String inputString = scanner.nextLine();
			switch(inputString){
				case "l": //목록
					datas = lab.reader(); //프로그램이 종료된 후 목록을 불러올 때 최신 데이터로 업로드 해 준다.
					showList();
					break;
				case "w": //새글
					newArticle();
					break;
				case "r": //상세보기
					datas = lab.reader(); //프로그램이 종료된 후 상세보기를 불러올 때 최신 데이터로 업로드 해 준다.
					showDetail();
					break;
				case "d": //삭제
					delete();
//					showList()해 본 결과 지우는 데까지 문제 없음
					break;
				case "e": //종료
					end();
					break;
			}
		}
	}

	//목록 보여주기
	@Override
	public void showList() {
		int datas_size = datas.size(); //저장된 개수만큼 순환하면서 필요한 정보를 불러온다.
		for(int i=0; i<datas_size; i++){
			list.showId(datas.get(i).getId()); //글 번호
			list.showTitle(datas.get(i).getTitle()); //제목
			list.showAuthor(datas.get(i).getAuthor()); //작성자
			list.showView(datas.get(i).getView()); //조회수
		}
		list.endShow();
	}
	
	//새 글
	@Override 
	public void newArticle() {
		//입력 받기
		newArticle.inputTitle(); //제목
		String title = scanner.nextLine();
		newArticle.inputAuthor(); //작성자
		String author = scanner.nextLine();
		newArticle.inputContent(); //내용
		String content = scanner.nextLine();
		newArticle.endInput();
		
		//게시글 번호 구하기
		viewCount = lab.count(); //글 번호는 입력받는 것이 아니라 자동으로 입력된다.
		
		//넣어주기
		Bbs bbs = new Bbs();
		bbs.setId(viewCount);
		bbs.setTitle(title);
		bbs.setAuthor(author);
		bbs.setDate(getDate());
//		bbs.setView();
		bbs.setContent(content); 
		datas.add(bbs); //하나의 새 객체를 만들고 난 후 임시 저장소인 리스트에 저장한다.
		
		lab.writer(bbs); //임시 저장소에 저장한 것으로는 프로그램이 종료될 때 없어지기 때문에 files 영구 저장소에 보내준다.
		
	}
	
	//날짜 생성-글을 생성하는 순간 최신의 날짜를 넣어주도록 메소드로 날짜를 생성한다.
	public String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		long systemTime = System.currentTimeMillis();
		String date = sdf.format(systemTime);
		return date;
	}
	
	//상세보기
	@Override
	public void showDetail() {
		Bbs bbs = new Bbs();
		detail.num(); //입력 값
		String inputString = scanner.nextLine();
		int inputNumber = Integer.parseInt(inputString); //몇 번 글을 볼지 입력받는다.
		for(Bbs item : datas){ //받아온 값과 비교해서 일치하면 값을 넘겨주는 방식으로 원하는 개체를 찾는다.
			if(item.getId() == inputNumber){
				bbs = item;
			}
		}
		detail.showId(bbs.getId()); //글 번호
		detail.showTitle(bbs.getTitle()); //제목
		detail.showAuthor(bbs.getAuthor()); //작성자
		detail.showDate(bbs.getDate()); //날짜
		detail.showContent(bbs.getContent()); //내용
		detail.showView(bbs.getView()); //조회수
	}

	//삭제
	@Override
	public void delete() {
		delete.num(); //삭제할 번호 입력
		String inputString = scanner.nextLine();
		delete.info(); //삭제할 것인지 확인
		String yesOrNo = scanner.nextLine();
//		if(yesOrNo == "n"){
//			delete.cancel();
//		} else if(yesOrNo == "y"){
//			int inputNumber = Integer.parseInt(inputString);
//			for(Bbs item : datas){
//				if(item.getId() == inputNumber){
//					deleteNumber = item.getId();
//				}
//			}
//			datas.remove(deleteNumber-1);
//			delete.complete();
//		}
		switch(yesOrNo){
			case "n" : //삭제 취소
				delete.cancel();
				break;
			case "y" : //삭제
				Bbs bbs = new Bbs();
				int inputNumber = Integer.parseInt(inputString);
				for(Bbs item : datas){ //입력받은 값으로 직접 삭제를 할 경우 리스트의 항목 수와 글 번호가 일치하지 않을 수 있다.
										//따라서 상세보기와 같이 일치하는 값이 있으면 객체를 반환해준다.
					if(item.getId() == inputNumber){
						bbs = item;
						break;
					}
				}
				datas.remove(bbs); //임시 저장소에서 삭제한다.
				delete.complete(); 
				lab.update(datas); //영구 저장소에서 삭제한다.
				break;
		}
		
		
	}

	//프로그램 끝
	@Override
	public void end() { 
		end.info(); //프로그램을 종료할지 확인
		String yesOrNo = scanner.nextLine();
		switch(yesOrNo){
		case "n": //취소
			end.cancel(); 
			break;
		case "y": //확인
			end.complete();
			run = END;
		}

	}
	
}
