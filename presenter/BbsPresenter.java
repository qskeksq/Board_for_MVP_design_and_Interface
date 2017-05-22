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
	
	//���α׷��� ��� ����� ������ boolean ������ �����Ѵ�.
	final boolean START = true;
	final boolean END = false;
	boolean run = START;
	
	//���������� ���������ν� Ŭ���� ���� ��� ������ ����� �� �ְ�, �ֽ� �����͸� ������ �� �ִ�.
	Scanner scanner;
	BbsStart start;
	ArrayList<Bbs> datas;  //Bbs��ü�� �ӽ� ���������, ���� �ֽ��� ������ ����Ǵ� ��
	BbsList list;
	BbsInput newArticle;
	int viewCount;
	BbsDetail detail;
	BbsDelete delete;
	BbsExit end;
	BbsLab lab;
	
	//�ʱ�ȭ �޼ҵ�-�ʱ�ȭ�� �޼ҵ忡 �����ν� �Լ��� �������� ���δ�.
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
	
	//�޼ҵ�� ȣ������ ������ �۵����� �ʴ´�. ������ �� �ڵ����� �����ϵ��� �� �ַ��� �����ڿ� 
	public BbsPresenter(){
		init();
	}
	
	//���α׷� ����
	@Override
	public void start() {
		while(run){
			start.intro(); //ù ȭ�� View
			start.num(); //�Է� ��ȣ
			String inputString = scanner.nextLine();
			switch(inputString){
				case "l": //���
					datas = lab.reader(); //���α׷��� ����� �� ����� �ҷ��� �� �ֽ� �����ͷ� ���ε� �� �ش�.
					showList();
					break;
				case "w": //����
					newArticle();
					break;
				case "r": //�󼼺���
					datas = lab.reader(); //���α׷��� ����� �� �󼼺��⸦ �ҷ��� �� �ֽ� �����ͷ� ���ε� �� �ش�.
					showDetail();
					break;
				case "d": //����
					delete();
//					showList()�� �� ��� ����� ������ ���� ����
					break;
				case "e": //����
					end();
					break;
			}
		}
	}

	//��� �����ֱ�
	@Override
	public void showList() {
		int datas_size = datas.size(); //����� ������ŭ ��ȯ�ϸ鼭 �ʿ��� ������ �ҷ��´�.
		for(int i=0; i<datas_size; i++){
			list.showId(datas.get(i).getId()); //�� ��ȣ
			list.showTitle(datas.get(i).getTitle()); //����
			list.showAuthor(datas.get(i).getAuthor()); //�ۼ���
			list.showView(datas.get(i).getView()); //��ȸ��
		}
		list.endShow();
	}
	
	//�� ��
	@Override 
	public void newArticle() {
		//�Է� �ޱ�
		newArticle.inputTitle(); //����
		String title = scanner.nextLine();
		newArticle.inputAuthor(); //�ۼ���
		String author = scanner.nextLine();
		newArticle.inputContent(); //����
		String content = scanner.nextLine();
		newArticle.endInput();
		
		//�Խñ� ��ȣ ���ϱ�
		viewCount = lab.count(); //�� ��ȣ�� �Է¹޴� ���� �ƴ϶� �ڵ����� �Էµȴ�.
		
		//�־��ֱ�
		Bbs bbs = new Bbs();
		bbs.setId(viewCount);
		bbs.setTitle(title);
		bbs.setAuthor(author);
		bbs.setDate(getDate());
//		bbs.setView();
		bbs.setContent(content); 
		datas.add(bbs); //�ϳ��� �� ��ü�� ����� �� �� �ӽ� ������� ����Ʈ�� �����Ѵ�.
		
		lab.writer(bbs); //�ӽ� ����ҿ� ������ �����δ� ���α׷��� ����� �� �������� ������ files ���� ����ҿ� �����ش�.
		
	}
	
	//��¥ ����-���� �����ϴ� ���� �ֽ��� ��¥�� �־��ֵ��� �޼ҵ�� ��¥�� �����Ѵ�.
	public String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		long systemTime = System.currentTimeMillis();
		String date = sdf.format(systemTime);
		return date;
	}
	
	//�󼼺���
	@Override
	public void showDetail() {
		Bbs bbs = new Bbs();
		detail.num(); //�Է� ��
		String inputString = scanner.nextLine();
		int inputNumber = Integer.parseInt(inputString); //�� �� ���� ���� �Է¹޴´�.
		for(Bbs item : datas){ //�޾ƿ� ���� ���ؼ� ��ġ�ϸ� ���� �Ѱ��ִ� ������� ���ϴ� ��ü�� ã�´�.
			if(item.getId() == inputNumber){
				bbs = item;
			}
		}
		detail.showId(bbs.getId()); //�� ��ȣ
		detail.showTitle(bbs.getTitle()); //����
		detail.showAuthor(bbs.getAuthor()); //�ۼ���
		detail.showDate(bbs.getDate()); //��¥
		detail.showContent(bbs.getContent()); //����
		detail.showView(bbs.getView()); //��ȸ��
	}

	//����
	@Override
	public void delete() {
		delete.num(); //������ ��ȣ �Է�
		String inputString = scanner.nextLine();
		delete.info(); //������ ������ Ȯ��
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
			case "n" : //���� ���
				delete.cancel();
				break;
			case "y" : //����
				Bbs bbs = new Bbs();
				int inputNumber = Integer.parseInt(inputString);
				for(Bbs item : datas){ //�Է¹��� ������ ���� ������ �� ��� ����Ʈ�� �׸� ���� �� ��ȣ�� ��ġ���� ���� �� �ִ�.
										//���� �󼼺���� ���� ��ġ�ϴ� ���� ������ ��ü�� ��ȯ���ش�.
					if(item.getId() == inputNumber){
						bbs = item;
						break;
					}
				}
				datas.remove(bbs); //�ӽ� ����ҿ��� �����Ѵ�.
				delete.complete(); 
				lab.update(datas); //���� ����ҿ��� �����Ѵ�.
				break;
		}
		
		
	}

	//���α׷� ��
	@Override
	public void end() { 
		end.info(); //���α׷��� �������� Ȯ��
		String yesOrNo = scanner.nextLine();
		switch(yesOrNo){
		case "n": //���
			end.cancel(); 
			break;
		case "y": //Ȯ��
			end.complete();
			run = END;
		}

	}
	
}
