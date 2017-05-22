package com.nadan.java.mybbs.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BbsUtil {
	
	//��� ����� �޼ҵ�
	public static void makeDir(String file){
		File dir = new File(file);
		if(!dir.exists()){ //���ٸ� �����.
			dir.mkdirs();
		}
	}
	
	//������ �����ϰų� �ҷ����� �޼ҵ�
	public static File makeFile(String path){
		File file = new File(path);
		if(!file.exists()){
			try {
				file.createNewFile(); //������ ���ٸ� ���� �����.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	//���� ���� �־��ָ� ������ �о��ִ� �޼ҵ�
	public static int reader(File file){
		int result = 0;
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = br.readLine(); //ī��Ʈ ���� �о�´�.
			
			if(temp == null){ //�ƹ� ���� ���ٸ� 1�� ����(ù ���̱� ����)
				result = 1;
			} else {
				result = Integer.parseInt(temp) + 1; //�̹� ���� ���� �ִٸ� +1
			}
			br.close();
		} catch(Exception e){
			
		}
		return result;
	}

	//���� �־��ָ� ���Ͽ� ���� �����ϴ� �޼ҵ�
	public static void writer(File path, int result){
		try{
			FileWriter fw = new FileWriter(path); //���Ͽ� �� ����
			fw.write(result+"");
			fw.close();
		} catch(Exception e){
			
		}
	}
	
	
}
