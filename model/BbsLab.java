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
	
	final String DATABASE_DIR = "c:/temp2/mybbs"; //������ ���丮
	final String DATABASE_NAME = "mybbs.db"; //���ϸ�
	final String DATABASE_SEPARATOR = "::"; //���� ������
	final String DATABASE_COUNT = "bbscount.db"; //�� ��ȣ �����
	final String RECORD_SEPERATOR = "\r\n"; //�����Ͱ� �� ������ ���� �ǵ��� �ϴ� ������
	boolean APPENDABALE = true; //append ���� ����.
	
	//�� �� File�� �����ϱ�
	@Override
	public void writer(Bbs bbs) {
		
		//��� ����
		BbsUtil.makeDir(DATABASE_DIR);
		
		//���� ����
		File file = BbsUtil.makeFile(DATABASE_DIR + DATABASE_NAME);
		
		//������ �־��ֱ�-�����ڸ� ���� �ϳ��ϳ��� �Ӽ���(������)�� �����ϰ�, �������� �� �����ڸ� �־ ���پ� �����Ͱ� ������ �Ѵ�.
		String data = bbs.getId()+DATABASE_SEPARATOR + bbs.getTitle()+DATABASE_SEPARATOR
						+ bbs.getAuthor()+DATABASE_SEPARATOR + bbs.getDate()+DATABASE_SEPARATOR
						+ bbs.getContent()+DATABASE_SEPARATOR + bbs.getView() + RECORD_SEPERATOR;
		try {
			//append���� true�� �־� ���پ� �����Ͱ� ���̵��� �Ѵ�
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
			out.append(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	//File���� �о����
	@Override
	public ArrayList<Bbs> reader() {
		ArrayList<Bbs> readList = new ArrayList<>(); //Bbs ��ü�� ������ �ӽ� ����
		File file = new File(DATABASE_DIR + DATABASE_NAME); //���� ��������
		if(file.exists()){ //������ ������ ��� ����
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String temp = "";
				while((temp = br.readLine()) != null){ //�о�� ���� ���� ������ ����ؼ� ��ȯ�Ѵ�.
					Bbs bbs = new Bbs(); //�о�� ���� Bbs��ü�� �־��ְ�
					String[] bbsTemp = temp.split(DATABASE_SEPARATOR); //split�޼ҵ�� �����ڸ� ���� �и��� ���� �迭�� �����Ѵ�.
					bbs.setId(Integer.parseInt(bbsTemp[0])); //�迭�� ����� ���� ������� ������ �� �ִ�.
					bbs.setTitle(bbsTemp[1]);
					bbs.setAuthor(bbsTemp[2]);
					bbs.setDate(bbsTemp[3]);
					bbs.setContent(bbsTemp[4]);
					bbs.setView(Integer.parseInt(bbsTemp[5]));
					readList.add(bbs);  //���������� ����Ʈ�� �߰��� ��
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return readList; //����Ʈ�� ��ȯ�Ѵ�.
	}

	//������ ��� ������Ʈ �ϱ�
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
	
	
	//�� ��ȣ �����ϱ�
	//�� ��ȣ�� �����ϴ� ����� Present�� �ִ� number ������ ī��Ʈ�� �÷����� ����ε�
	//������ init���� �ʱ�ȭ�� �� 0���� ���� �ʱ�ȭ �ȴ�. ��, ���α׷��� �����ϰ� �ٽ� �����ϸ� �� ��ȣ�� 0���� �����Ѵ�.
	//�̸� ���� �� ��ȣ�� ���� �����ϴ� ���� ����� �д�.
	public int count(){
		
		//����� �ҷ�����
		BbsUtil.makeDir(DATABASE_DIR);
		
		//���� �����
		File file = BbsUtil.makeFile(DATABASE_DIR + DATABASE_COUNT);
		
		//����� ������ count 1�� �ø���
		int result = 0;
		result = BbsUtil.reader(file);
		
		//���ο� ����ҿ� �� �����ϱ�
		BbsUtil.writer(file, result);
		
		return result;
	}
	
}
